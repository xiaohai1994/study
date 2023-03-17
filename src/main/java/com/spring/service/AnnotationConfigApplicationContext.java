package com.spring.service;

import com.spring.NativeLogger;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationConfigApplicationContext {

    Class clazz;
    List<String> absluotClassUrl = new ArrayList<>(300);
    Map<String,DeFinition> DeFinitionMap = new HashMap<>();
    Map<String,Object> singletonMap = new HashMap<>();
    List<BeanPostProcessor> beanPostProcessorsLists = new ArrayList<>(30);
    public AnnotationConfigApplicationContext(Class clazz) {
        this.clazz = clazz;
        //扫描文件
        scanner(clazz);
        //创建对应扫描的对象
        initCreateObject();

    }

    //初始化启动的时候整个容器创建对象初始化
    private void initCreateObject() {
        for (Map.Entry<String, DeFinition> stringDeFinitionEntry : DeFinitionMap.entrySet()) {
            //开始初始化构造对象
            if (stringDeFinitionEntry.getValue().getType().equals("singleton")) {
                Object o = createObject(stringDeFinitionEntry.getValue().getClazz(),stringDeFinitionEntry.getKey());
                singletonMap.put(stringDeFinitionEntry.getKey(),o);
            }else{
                getBean(stringDeFinitionEntry.getKey());
            }
        }

//        //依赖注入
//        for (Map.Entry<String, DeFinition> stringObjectEntry : DeFinitionMap.entrySet()) {
//            autowiredObject(stringObjectEntry.getValue().getClazz(),stringObjectEntry.getKey());
//        }

    }


    /**
     * @param o 需要注入的对象
     *        实现将对象注入到o中
     */
    private void autowiredObject(Object o){
        for (Field declaredField : o.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Autowired.class)){
                try {
                    String name = getClassName(declaredField.getType());
                    declaredField.setAccessible(true);
                    if (singletonMap.containsKey(name)){
                      declaredField.set(o,singletonMap.get(name));
                    }else {
                        declaredField.set(o,get_Constructor(declaredField.getType()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 创建单个对象
     * @param clazz
     */
    private Object createObject(Class clazz,String name) {

        Object o = get_Constructor(clazz);

        if (o instanceof InitializingBean){
            try {
                ((InitializingBean) o).afterPropertiesSet();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (BeanPostProcessor beanPostProcessorsList : beanPostProcessorsLists) {
            beanPostProcessorsList.postProcessBeforeInitialization(o,name);
        }
        //依赖注入
        autowiredObject(o);

        for (BeanPostProcessor beanPostProcessorsList : beanPostProcessorsLists) {
            beanPostProcessorsList.postProcessAfterInitialization(o,name);
        }

        return o;
    }

    /**
     * 根据构造方法进行相对处理
     * @param clazz
     * @return
     */
    private Object get_Constructor(Class clazz) {
        Object o = null;
        try {
            o = clazz.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            NativeLogger.logger("没有空的构造函数" + clazz.getName());
        }
        return o;
    }


    //拿到所有的被注解的类
    public void scanner(Class clazz){
        if (clazz.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan annotation = (ComponentScan) clazz.getAnnotation(ComponentScan.class);
            String path = annotation.value();
            String clazzPath = path.replace("." ,"/");
            //使用类加载器拿到class地址
            ClassLoader classLoader = this.getClass().getClassLoader();
            URL resource = classLoader.getResource(clazzPath);
            File file = new File(resource.getFile());
            scannerFileCLass(file);
            for (String absloultUrl : absluotClassUrl) {
                //加载 兼容
                String s = SystemCompatible(absloultUrl);
                try {
                    Class<?> aClass = classLoader.loadClass(s);
                    //加载Autowired // spring是没有这个的，如果没有注释为Bean 那就不给构建
//                    addAutowired(aClass);
                    if (aClass.isAnnotationPresent(Component.class)){
                        //拿到每一个类的class // 查看是否有Component注解
                        DefintionMapPut(aClass);
                    }

                } catch (ClassNotFoundException e) {
                    NativeLogger.logger("当前路径错误不能进行预处理 类加载" + s);
                    e.printStackTrace();
                }

            }
        }
    }


    /**
     * 扫描的时候查看是否有class 实现了 beanPostProcess
     * @param clazz
     */
    public boolean beanPostProcessList(Class clazz) {
        boolean add = false;
        if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
            try {
                add = beanPostProcessorsLists.add((BeanPostProcessor) clazz.getConstructor().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return add;
    }

    /**
     * 根据注解规则 将当前对象属性进行存储
     * @param clazz
     */
    public void DefintionMapPut(Class clazz){
        DeFinition deFinition = new DeFinition();
        //添加前置后置对象 beanPostProcess
        if (!beanPostProcessList(clazz)){
            //当前对象要进行加载
            Component annotation = (Component) clazz.getAnnotation(Component.class);
            //设置属性
            deFinition.setClazz(clazz);

            if (clazz.isAnnotationPresent(Scope.class)){
                //设置是否为单例
                Scope scope = (Scope) clazz.getAnnotation(Scope.class);
                if (scope.type().equals("")){
                    //单例Singleton
                    deFinition.setType("singleton");
                }else if (scope.type().equals("singleton")){
                    //单例
                    deFinition.setType("singleton");
                }else if (scope.type().equals("prototype")){
                    //多
                    deFinition.setType("prototype");
                }
            }else {
                deFinition.setType("singleton");
            }

            //如果当前没有设置名字 用首字母小写代替
            if (annotation.name().equals("")){
                //大小写转换规则 加减 32
                //获取首字母
                String name = getClassName(clazz);
                deFinition.setName(name);
                DeFinitionMap.put(name,deFinition);
            }else {
                deFinition.setName(annotation.name());
                DeFinitionMap.put(annotation.name(),deFinition);
            }
        }
    }

    public String getClassName(Class clazz){
        String name = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
        char[] chars = name.toCharArray();
        if ((int)chars[0] < 97){
            chars[0] += 32;
        }
       return  String.valueOf(chars);
    }

    public void addAutowired(Class clazz){
        //处理@Autowired 将这个也加入进去 方便注入
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Autowired.class)) {
                //拿到当前这个类
                Class<?> typeClazz = declaredField.getType();
                //大小写转换规则 加减 32
                //获取首字母
                String name = getClassName(clazz);
                DeFinition deFinition = new DeFinition();
                if (!DeFinitionMap.containsKey(name)){
                    deFinition.setType("prototype");
                    deFinition.setName(name);
                    deFinition.setClazz(typeClazz);
                    DeFinitionMap.put(name,deFinition);
                }
            }
        }
    }


    /**
     * 根据 系统兼容当前类加载器
     * @return
     */
    public String SystemCompatible(String url){
        String property = System.getProperty("os.name");
        if (property.contains("Linux")){
            String replace = url.replace("/", ".");
            replace = replace.substring(replace.indexOf("com"),replace.lastIndexOf(".class"));
            return replace;
        }

        //windos平台
        if (property.contains("Win")){

        }

        NativeLogger.logger("****************路径不兼容*****************");
        return null;

    }


    /**
     * 深度遍历文件
     * @param file
     */
    public void scannerFileCLass(File file){
        if (file != null) {
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (null!=file1 && file1.isDirectory()){
                        scannerFileCLass(file1);
                    }else {
                        absluotClassUrl.add(file1.getAbsolutePath());
                        continue;
                    }
                }
            }else {
                    absluotClassUrl.add(file.getAbsolutePath());
                    return;
            }
        }else{
            NativeLogger.logger("文件夹为空 " +this.clazz);
        }
    }


    public Object getBean(String name){
        if (singletonMap.containsKey(name)){
            return singletonMap.get(name);
        }else {
            return createObject(DeFinitionMap.get(name).getClazz(),name);
        }
    }
}

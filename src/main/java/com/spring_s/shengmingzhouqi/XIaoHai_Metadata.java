package com.spring_s.shengmingzhouqi;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Hai
 * @date 2023/3/26 下午4:05
 *
 * 元数据读取 用法 asm 底层使用asm技术
 */
public class XIaoHai_Metadata {

    static List<String> urlList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = null;
        String clazzUrl = "com.spring_s".replace(".","/");
        URL resource = simpleMetadataReaderFactory.getClass().getClassLoader().getResource(clazzUrl);
        File file = new File(resource.getFile());
        initUrlList(file);




        for (String s : urlList) {
            metadataReader = simpleMetadataReaderFactory.getMetadataReader(s);
            ClassMetadata classMetadata = metadataReader.getClassMetadata();
            AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
            //获取当前所有class名称
            System.err.println("获取class名称    --------------"+classMetadata.getClassName());
            for (String interfaceName : classMetadata.getInterfaceNames()) {
                System.err.println("获取接口名称   iiiiiiiiiiiii" + interfaceName);
            }
            //内部类
            for (String memberClassName : classMetadata.getMemberClassNames()) {
                System.err.println("   " + memberClassName);
            }
            Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
            for (String annotationType : annotationTypes) {
                System.err.println("回去当前类型中的所有注解的类型"  +annotationType);
            }
        }



    }


    public static void initUrlList(File file){
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()){
                initUrlList(listFile);
            }else {
                String str = listFile.getAbsolutePath();
                str = str.substring(str.indexOf("com"),str.length()-6).replace("/",".");
                urlList.add(str);
            }
        }
    }
}

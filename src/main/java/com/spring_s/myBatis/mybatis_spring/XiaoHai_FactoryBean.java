package com.spring_s.myBatis.mybatis_spring;

import com.spring_s.myBatis.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Hai
 * @date 2023/3/28 上午8:09
 */
@Component
public class XiaoHai_FactoryBean implements FactoryBean {

    private Class clazz;

    private SqlSession sqlSession;

    public XiaoHai_FactoryBean(Class clazz) {
        this.clazz = clazz;
    }


    public XiaoHai_FactoryBean() {
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory){
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {
//        Object o = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{User.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                //代理对象
//                return null;
//            }
//        });
        sqlSession.getConfiguration().addMapper(clazz);
        return sqlSession.getMapper(clazz);
//        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }
}

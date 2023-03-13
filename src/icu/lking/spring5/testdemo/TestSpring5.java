package icu.lking.spring5.testdemo;

import icu.lking.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 测试类
 */
public class TestSpring5 {
    /**
     * @Test : Junit4 单元测试
     */
    @Test
    public void testUserBeanAdd(){
        // 1. 加载spring配置文件（xml文件）:默认src下相对路径
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //如果不在src文件夹(即classpath)下可以采用
        //ApplicationContext context = new FileSystemXmlApplicationContext("");


        // 2. 获取spring创建的对象 : 通过id获取
        User myUser = context.getBean("my_user", User.class);
        // 测试User的add方法
        myUser.add();
    }
}

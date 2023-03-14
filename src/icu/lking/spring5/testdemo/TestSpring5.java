package icu.lking.spring5.testdemo;

import icu.lking.spring5.Book;
import icu.lking.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试类
 */
public class TestSpring5 {
    /**
     * @Test : Junit4 单元测试
     */
    @Test
    public void testUserBeanAdd(){
        /**
         * IOC的思想就是基于IOC容器完成，IOC的底层就是对象工厂。
         * **Spring提供了两个IOC容器实现的方式（两个接口）。**
         * - **BeanFactory**：IOC容器的基本实现，一般是Spring内部使用，不建议开发人员使用。
         * 	- ==在加载配置文件时不会创建容器中的对象，只有获取时才创建==。
         * - **ApplicationContext**：BeanFactory的子接口，提供更多更强大的功能。一般由开发人员使用。
         * 	- ==在加载配置文件时会同时创建容器中的对象==。
         *
         * *注：推荐使用`ApplicationContext`接口，因为项目使用中，一般把耗时的操作放在项目启动时。*
         */
        // IOC容器接口：父接口 BeanFactory（spring内部使用） & 子接口 ApplicationContext（推荐）
        // 1. 加载spring配置文件（xml文件）:默认src下相对路径 ：加载配置文件的同时创建所有容器内对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        // 加载配置文件的同时不创建容器内对象，只有获取的时候创建
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean1.xml");
        //如果不在src文件夹(即classpath)下可以采用，绝对路径
        //ApplicationContext context = new FileSystemXmlApplicationContext("");


        // 2. 获取spring创建的对象 : 通过id获取
        User myUser = context.getBean("my_user", User.class);
        // 测试User的add方法
        myUser.add();
    }
    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 加载解析xml
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("my_user",User.class);

        // ---- 反射练习 ----
        // 1. 获取Class对象
        // 方式一
        Class<?> aClass = Class.forName("icu.lking.spring5.User");
        // 方式二
        Class bClass = User.class;
        // 方式三
        Class<? extends User> cClass = user.getClass();

        // 2. 判断是否为某个类的实例
        System.out.println("判断是否为某个类的实例");
        // isInstance 方法
        System.out.println(aClass.isInstance(user));
        // instanceof 关键字
        System.out.println(user instanceof User);

        // 2. 实例对象
        // 2.1 直接通过newInstance创建
        Object aObject = aClass.newInstance();
        // 2.2 通过构造方法创建 - 这里获取的无参构造方法
        Constructor<?> constructor = aClass.getConstructor();
        // 根据构造方法实例化对象
        Object bObject = constructor.newInstance();

        // 获取方法
        Method method = aClass.getMethod("add");
        // 调用无参方法
        method.invoke(aObject);


    }
    /**
     * test DI by setting method
     */
    @Test
    public void testBookDIBySettingMethod(){
        //  根据加载和解析的Spring XML配置文件, 创建IOC容器对象 : ApplicationContext 加载配置后创建容器内全部对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        // 获取bean
        Book bookDiProperty = context.getBean("book_di_property", Book.class);
        // 输出
        System.out.println(bookDiProperty);

    }
}

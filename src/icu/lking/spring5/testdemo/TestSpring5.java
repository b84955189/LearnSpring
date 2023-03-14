package icu.lking.spring5.testdemo;

import icu.lking.spring5.User;
import org.junit.Test;
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
        // 1. 加载spring配置文件（xml文件）:默认src下相对路径
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //如果不在src文件夹(即classpath)下可以采用
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
}

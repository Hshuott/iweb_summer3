package com.iweb.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        //约定优于配置  配置优于实现
        //类对象的获取方式 三种
        //1.通过.class直接获取
    //    Class<Student>sClass1 =Student.class;
        //2.通过类的路径获取
        Class<Student>sClass2 =(Class<Student>) Class.forName("com.iweb.Test.Student");
        //3.通过该类对象所对应的类的实例获取
      //  Class sClass3 = new Student().getClass();
        //在ivm中 类在运行之前 需要先借助CLassLoader类进行类加载 想加载哪一个类 就必须
        //先加载这个类的类对象一个JVM对应一个ClassLoader类 每一个类在一个JVM中也只有一个
        //类对象

        //无论你用何种方法 获取同一个类的类对象多少次 获取的类对象一定是同一个
//        System.out.println(sClass1==sClass2);
//        System.out.println(sClass2==sClass3);
        //获取学生类的物产构造方法
        //如果构造方法无参 getConstructor 方法不需要传入任何参数
        Constructor<Student> c1 = sClass2.getConstructor();
        //借助构造器对象完成Student对象的创建
        Student s =c1.newInstance();
        //访问对象
        System.out.println(s);
        //获取学生的有参构造方法 如果获取的是有参构造方法需要提供参数类型所对应的反射对象
        Constructor<Student> c2 =sClass2.getConstructor(String.class);
        //借助有参构造方法完成对象的实例化
        Student s1 = c2.newInstance("韩硕");
        //访问对象
        System.out.println(s1);
        //创建方法所对应的反射对象
        Method getNameMethod = sClass2.getMethod("getName");
        //借助方法的反射对象调用方法
        String result =(String) getNameMethod.invoke(s1);
        System.out.println("通过反射获取的结果为:"+result);
        //借助方法的反射对象 调用有参方法
        Method setNameMethod = sClass2.getMethod("setName", String.class);
        //调用方法
        setNameMethod.invoke(s1,"韩硕123");
        System.out.println(s1);

    }
}

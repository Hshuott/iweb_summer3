package com.iweb.Test.Test1;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    @SneakyThrows
    public static void main(String[] args)  {
//        UserService service = new UserServicelmpl1();
//        service.register();
//        service.login();
        File userProperties = new File("C:\\Users\\韩硕\\IdeaProjects\\d0715_java16Maven_342\\src\\main\\java\\com\\iweb\\User.properties");
        Properties config = new Properties();
        config.load(new FileInputStream(userProperties));
         String className = (String)config.get("class");
        String methodName = (String)config.get("method");
        Class uClass = Class.forName(className);
        Constructor<UserService> c = uClass.getConstructor();
        UserService service = c.newInstance();
        Method m = uClass.getMethod(methodName);
        m.invoke(service);
    }
}

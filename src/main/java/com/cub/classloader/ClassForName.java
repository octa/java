package com.cub.classloader;

import java.lang.reflect.InvocationTargetException;

public class ClassForName {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> classF = Class.forName("com.cub.classloader.ClassIWannaLoad");
        Object object = classF.newInstance();
        classF.getDeclaredField("name").set(object, "Hi");
        System.out.println(classF.getDeclaredField("name").get(object));

        String f = (String) classF.getMethod("getName").invoke(object);
        System.out.println(f);
    }

}

package com.cub.classloader;

public class ClassLoaderF extends ClassLoader {

    public ClassLoaderF(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("Inside custom class loader");
        return super.loadClass(name);
    }
}

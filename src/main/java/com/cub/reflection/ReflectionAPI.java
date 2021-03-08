package com.cub.reflection;

import java.lang.reflect.*;

public class ReflectionAPI {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        ModelClass modelClass = new ModelClass(10, "Hi");

        // Get Class name
        String className = modelClass.getClass().getName();
        String className2 = ModelClass.class.getName();

        // Get reference for a class
        Class clazz = ModelClass.class;

        // Check Class modifier
        int classModifier = clazz.getModifiers();
        Modifier.isPublic(classModifier);
        Modifier.isPrivate(classModifier);
        Modifier.isProtected(classModifier);

        // Get Interfaces
        Class[] interfaces = clazz.getInterfaces();

        // Get Constructor and its arguments
        Constructor[] constructors = clazz.getConstructors();

        for(Constructor constructor: constructors) {
            Class[] constructorArguments = constructor.getParameterTypes();
            for(Class constructorArgument: constructorArguments) {
                //System.out.println(constructorArgument.getName());
            }
        }

        Constructor singleConstructor = clazz.getConstructor(new Class[]{int.class, String.class});
        Constructor singleConstructor2 = clazz.getConstructor(int.class, String.class);

        // Create new instance from a Constructor
        ModelClass modelClassFromConstructor = (ModelClass) singleConstructor.newInstance(10, "Hi");

        // Get Methods and its arguments

        Method[] allMethods = clazz.getMethods();

        Method methodGetId = clazz.getMethod("getId", new Class[]{});
        Method methodSetId = clazz.getMethod("setId", new Class[]{int.class});
        Method methodSetId1 = clazz.getMethod("setId", int.class);

        Method methodGetId1 = clazz.getDeclaredMethod("getId", null);
        Method methodSetId2 = clazz.getDeclaredMethod("setId", int.class);

        Class[] methodArguments = methodSetId.getParameterTypes();

        // Change access specifier
        methodGetId.setAccessible(true);

        // Invoke methods
        ModelClass modelClass1 = new ModelClass(10, "Hi");
        Method methodGetName = clazz.getMethod("getName", new Class[]{});
        String name = (String) methodGetName.invoke(modelClass1,null);

        Method methodSetName = clazz.getDeclaredMethod("setName", String.class);
        methodSetName.invoke(modelClass1, new String("Hi"));
        methodSetName.invoke(modelClass1, new Object[]{new String("Hi")});

        // Get Fields
        Field field = clazz.getDeclaredField("id");
        Field field1 = clazz.getDeclaredField("name");

        // Change access specifier
        field.setAccessible(true);

        // Get the value of a Field
        ModelClass modelClass2 = new ModelClass(10, "Hi");
        int value = Integer.valueOf((Integer) field.get(modelClass2));
        String value1 = (String) field1.get(modelClass2);

        // Set the value of a Field
        field1.set(modelClass2, "Hi");


    }

}

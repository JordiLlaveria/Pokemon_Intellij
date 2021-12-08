package edu.upc.dsa.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }

    private static String setMethodName(String property){
        return "set"+property.substring(0,1).toUpperCase() + property.substring(1);
    }

    public static void setter(Object object, String property, Object value){

        try {
            Class theClass = object.getClass();
            String m = setMethodName(property);
            Method m1 = theClass.getMethod(m, value.getClass());
            Object e1 = m1.invoke(object, value);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static String getMethodName(String property){
        return "get"+property.substring(0,1).toUpperCase() + property.substring(1);
    }

    public static Object getter(Object object, String property){
        Object e1=null;
        try{
            Class theClass = object.getClass();
            String m = getMethodName(property);
            Method m1 = theClass.getMethod(m,null);
            e1 = m1.invoke(object,null);
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return e1;
    }
}

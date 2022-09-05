package com.test.vnay.cucumber;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectUtil implements Serializable{
	
	private static final long serialVersionUID = 8608121170035103863L;
	public static void callSetter(Object obj, String propertyName, Object variableValue) {
		PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(propertyName, obj.getClass());
            Method setter = pd.getWriteMethod();
            try {
                setter.invoke(obj,variableValue);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
		
	}
public static void callGetter(Object obj, String propertyName) {
	 try {
         PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
         Method getter = pd.getReadMethod();
         Object f = getter.invoke(obj);
         System.out.println(f);
     } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
         e.printStackTrace();
     }
		
	}

public static Object callGetterType(Object obj, String propertyName) {
	Method getter = null;
	 try {
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, obj.getClass());
        getter = pd.getReadMethod();
    } catch (IllegalArgumentException | IntrospectionException e) {
        e.printStackTrace();
    }
	  return getter.getReturnType();
		
	}

}

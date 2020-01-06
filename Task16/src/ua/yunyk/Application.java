package ua.yunyk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		
		Book book = new Book("����� ��������", "������");
		Class bc = book.getClass();
		
		System.out.println("����� ��'� ����� " + bc.getCanonicalName());
		System.out.println("������ ��'� ����� " + bc.getSimpleName());
		System.out.println("����� ����� " + bc.getPackage());
		System.out.println("������������ ����� " + Modifier.toString(bc.getModifiers()));
		System.out.println("��������� ���������� " + Arrays.toString(bc.getInterfaces()));
		System.out.println("������� ���� " + bc.getSuperclass());
		System.out.println("������������ ");
		for(Constructor constructor: bc.getConstructors()) {
			System.out.println(constructor);
		}
		System.out.println("������ ");
		for(Method method: bc.getMethods()) {
			System.out.println(method);
		}
		System.out.println("���� ");
		for (Field field : bc.getFields()) {
			System.out.println(field);
		}
		
		Field field = bc.getFields()[0];
		System.out.println("���� �� ���������� " + field.getName() + " = " + field.get(book));
		field.set(book, "���� ������");
		System.out.println("���� ���� ���������� " + field.getName() + " = " + field.get(book) );
		
		Method method = bc.getMethod("myMethod", String.class);
		method.invoke(book, "str");
		method = bc.getMethod("myMethod", String.class, int.class);
		method.invoke(book, "str", 5 );
	}
	
}

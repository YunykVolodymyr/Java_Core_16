package ua.yunyk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		
		Book book = new Book("Тарас Шевченко", "Кобзар");
		Class bc = book.getClass();
		
		System.out.println("Повне ім'я класу " + bc.getCanonicalName());
		System.out.println("Просте ім'я класу " + bc.getSimpleName());
		System.out.println("Пакет класу " + bc.getPackage());
		System.out.println("Модифікатори класу " + Modifier.toString(bc.getModifiers()));
		System.out.println("Реалізовані інтерфейси " + Arrays.toString(bc.getInterfaces()));
		System.out.println("Базовий клас " + bc.getSuperclass());
		System.out.println("Конструктори ");
		for(Constructor constructor: bc.getConstructors()) {
			System.out.println(constructor);
		}
		System.out.println("Методи ");
		for(Method method: bc.getMethods()) {
			System.out.println(method);
		}
		System.out.println("Поля ");
		for (Field field : bc.getFields()) {
			System.out.println(field);
		}
		
		Field field = bc.getFields()[0];
		System.out.println("Поле до перезапису " + field.getName() + " = " + field.get(book));
		field.set(book, "Іван франко");
		System.out.println("Поле після перезапису " + field.getName() + " = " + field.get(book) );
		
		Method method = bc.getMethod("myMethod", String.class);
		method.invoke(book, "str");
		method = bc.getMethod("myMethod", String.class, int.class);
		method.invoke(book, "str", 5 );
	}
	
}

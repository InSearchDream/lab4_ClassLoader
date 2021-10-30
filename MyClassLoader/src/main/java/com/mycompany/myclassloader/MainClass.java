package com.mycompany.myclassloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author InSearchDream
 */
public class MainClass {
	public static void main( String[] args )
    {
        try {
            Scanner in = new Scanner(System.in);
 
            System.out.print("Введите полное имя загружаемого класса: ");
            String prCl = in.next();
            String[] argsForWorkCl = {String.format ("%.2f", Math.random()*10), String.format ("%.2f", Math.random()*10),  MainClass.class.getSimpleName()};

			MyClassLoader ccl = new MyClassLoader(MainClass.class.getClassLoader());
			Class clas = ccl.loadClass(prCl);
			Class[] mainArgsType = { (new String[0]).getClass() };
			Method mainMethod = clas.getMethod("main", mainArgsType);
			
			Object[] argsArray = {argsForWorkCl}; 
			
			mainMethod.invoke(null, argsArray);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

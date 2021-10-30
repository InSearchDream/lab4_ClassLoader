package com.mycompany.myclassloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author InSearchDream
 */
public class MyClassLoader extends ClassLoader {
	public MyClassLoader(ClassLoader parent) {
		super(parent);
	}

	private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte[] b = null;
        try {
            b = loadClassFileData(file);
            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Class loadClass(String name) throws ClassNotFoundException {
        System.out.println("Обычная загрузка класса '" + name + "'");
        if (name.startsWith("com.mycompany.myclassloader")) {
            System.out.println("Загрузка класса при помощи MyClassLoader");
            return getClass(name);
        }
        return super.loadClass(name);
    }  
    private byte[] loadClassFileData(String name) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(
                name);
        int size = stream.available();
        byte buff[] = new byte[size];
        DataInputStream in = new DataInputStream(stream);
        in.readFully(buff);
        in.close();
        return buff;
    }
}

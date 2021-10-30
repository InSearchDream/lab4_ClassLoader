package com.mycompany.myclassloader;

/**
 *
 * @author InSearchDream
 */
public class WorkingClass {
    static public void main(String args[]) throws Exception {
    	WCMethod1 (args[0], args[1]);
    	WCMethod2(args[2]);
    	printCL();
    }
    	 
    public static void printCL() {
    	 System.out.println("Вывод WorkingClass ClassLoader: "+WorkingClass.class.getClassLoader());
    }
    	    
     public static void WCMethod1(String r1, String r2) {
    	 System.out.println("Переданные случайные числа: " + r1 + " и " + r2);
     }
     
     public static void WCMethod2(String r2) {
    	 System.out.println(r2 + " работает с классом WorkingClass");
     }
    	        
}


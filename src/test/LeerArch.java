package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerArch {

	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        List<String> l = new ArrayList<String>(); 
		String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
//            System.out.println(cadena);
            l.add(cadena);
        }
        b.close();
        
        for(String s : l)
        	System.out.println(s);
        
    }
	
	public static void main(String[] args) throws IOException {
        muestraContenido("C:\\desarrollo\\properties\\adm_dnp.properties");
    }
}

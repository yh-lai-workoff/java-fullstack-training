package com.accenture.example.FileHandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class TestExample {
	final static String INPUT = "C:\\Users\\icych\\eclipse-workspace\\AvensysTraining\\src\\FileHandling\\FileInput.txt";
	final static String OUTPUT = "C:\\Users\\icych\\eclipse-workspace\\AvensysTraining\\src\\FileHandling\\FileOutput.txt";
	
	public static void main(String[] args) {
		try {
//			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(INPUT));
//			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(OUTPUT));
//			int x = 0;
//			while ((x=bis.read())!=-1) {
//				System.out.println(x);
//				bos.write(x);
//			}
//			bis.close();
//			bos.close();
			
			BufferedReader br = new BufferedReader( new FileReader(INPUT));
			BufferedWriter bw = new BufferedWriter( new FileWriter(OUTPUT));
			String y ;
			while ((y=br.readLine()) != null) {
				System.out.println(y);
				bw.write(y);
			}
			bw.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

package com.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteDataCSV {
	
	String CREDIT_PATH = "E:\\MIIT_JAVA\\Credit.csv";
	String TRANS_PATH = "E:\\MIIT_JAVA\\Transaction.csv";

	public void writeCSV() {
		try {
			FileWriter fw = new FileWriter(CREDIT_PATH);
			Scanner read = new Scanner(new File(TRANS_PATH));
			read.useDelimiter(",");

			while (read.hasNext()) {

				/*
				 * if (read.hasNext("credit")) {
				 * 
				 * fw.write(read.nextLine());
				 * 
				 * }
				 */
				
				System.out.println(read.hasNext());

			}
			read.close();

			// System.out.print(read.next()); // finding value and printing it in console

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package com.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataCSV {
	String CREDIT_PATH = "E:\\MIIT_JAVA\\Credit.csv";
	String TRANS_PATH = "E:\\MIIT_JAVA\\Transaction.csv";
	String DEBIT_PATH = "E:\\MIIT_JAVA\\Debit.csv";
	String ERROR_PATH = "E:\\MIIT_JAVA\\Error.csv";
	
	
	public void readCSV (){
		//parsing file into scanner class
		try {
			Scanner read = new Scanner(new File("E:\\MIIT_JAVA\\Transaction.csv"));
			read.useDelimiter(",");
			FileWriter fw = new FileWriter("E:\\MIIT_JAVA\\Credit.csv");
			
			
			while (read.hasNext()) {//checking that scanner has value if true it will go forward
				
			
				String header =read.nextLine().toString();
				System.out.println(header);
				
				break;
			//System.out.println(read.nextLine()); //finding value and printing it in console
			}
			read.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	public void createCSV () {
		
		
		try {
			File credit = new File(CREDIT_PATH);
			credit.createNewFile();
			credit.setWritable(true);
			System.out.println(credit.canWrite());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			File debit = new File(DEBIT_PATH);
			debit.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			File error = new File(ERROR_PATH);
			error.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writeCSV() {
		try {
			
			FileWriter fw = new FileWriter(CREDIT_PATH);
			Scanner read = new Scanner(new File(TRANS_PATH));
			read.useDelimiter(",");

			while (read.hasNext() ) {

				
				if (read.hasNext("credit")) {

					fw.write(read.nextLine());
					//System.out.println("success");

				}
				

			}
			read.close();
			fw.close();

			// System.out.print(read.next()); // finding value and printing it in console

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		ReadDataCSV r = new ReadDataCSV();
		r.createCSV();
		r.readCSV();
		//r.writeCSV();
	
	}

	

}

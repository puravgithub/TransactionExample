package com.transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Credit extends Thread{
	String transactionType;
	List<String> tCredit;
	String CREDIT_PATH = "E:\\MIIT_JAVA\\Credit.csv";
	
	public Credit(String  transactionType , List<String> tCredit ) {
		
		this.transactionType = transactionType ;
		this.tCredit = tCredit ;
		
	}
	
	public void run() {
		//System.out.println(Thread.currentThread().getState());
		
		try(FileWriter creditfile = new FileWriter(CREDIT_PATH)){
			
			for (String transaction : tCredit) {
			creditfile.write(transaction + "\n");
			}
			
		
			
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}

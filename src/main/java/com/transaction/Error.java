package com.transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Error extends Thread {
	String ERROR_PATH = "E:\\MIIT_JAVA\\Error.csv";
	
	List<String> tError;
	String transactionType;

	public Error(String transactionType, List<String> tError) {

		this.transactionType = transactionType;
		this.tError = tError;

	}

	public void run() {
		
		try (FileWriter creditfile = new FileWriter(ERROR_PATH)) {

			for (String transaction : tError) {
				creditfile.write(transaction + "\n");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

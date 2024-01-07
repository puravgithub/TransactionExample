package com.transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Debit extends Thread {
	String DEBIT_PATH = "E:\\MIIT_JAVA\\Debit.csv";
	String transactionType;
	List<String> tDebit;

	public Debit(String transactionType, List<String> tDebit) {

		this.transactionType = transactionType;
		this.tDebit = tDebit;

	}

	public void run() {
		try (FileWriter creditfile = new FileWriter(DEBIT_PATH)) {

			for (String transaction : tDebit) {
				creditfile.write(transaction + "\n");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

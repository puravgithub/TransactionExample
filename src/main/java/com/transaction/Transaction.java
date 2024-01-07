package com.transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {

	static String CREDIT_PATH = "E:\\MIIT_JAVA\\Credit.csv";
	static String TRANS_PATH = "E:\\MIIT_JAVA\\Transaction.csv";
	static String DEBIT_PATH = "E:\\MIIT_JAVA\\Debit.csv";
	static String ERROR_PATH = "E:\\MIIT_JAVA\\Error.csv";

	public static void main(String[] args) {

		ArrayList<String> creditTransaction = new ArrayList<>();
		ArrayList<String> debitTransaction = new ArrayList<>();
		ArrayList<String> errorTransaction = new ArrayList<>();
		File file = new File(TRANS_PATH);
		try {
			Scanner scanner = new Scanner(file);
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(",");
				if (parts.length == 6) {
					String tType = parts[5];
					if ("credit".equalsIgnoreCase(tType)) {

						creditTransaction.add(line);
					} else if ("debit".equalsIgnoreCase(tType)) {
						debitTransaction.add(line);
					} else {
						errorTransaction.add(line);
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Credit creditT = new Credit(CREDIT_PATH, creditTransaction);
		creditT.start();
		Debit debitT = new Debit(DEBIT_PATH, debitTransaction);
		debitT.start();
		Error errorT = new Error(ERROR_PATH, errorTransaction);
		errorT.start();

	}

}

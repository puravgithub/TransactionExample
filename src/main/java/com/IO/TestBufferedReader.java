package com.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader {
	
	public String searchCsvLine(int searchColumnIndex, String searchString) throws IOException {
		String resultRow = null;
		BufferedReader br = new BufferedReader(new FileReader("somefile.csv"));
		String line;
		while ((line = br.readLine()) != null) {
			String[] values = line.split(",");
			if (values[searchColumnIndex].equals(searchString)) {
				resultRow = line;
				break;
			}
		}
		br.close();
		return resultRow;
	}

	public static void main(String[] args) throws FileNotFoundException {

		BufferedReader csvReader = new BufferedReader(new FileReader("E:\\MIIT_JAVA\\Transaction.csv"));
		String row = "";
		try {
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				for (int i = 0; i < row.length(); i++) {
					System.out.println(data[i]);
				}
				// do something with the data
				csvReader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

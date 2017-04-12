package com.gmail.s12348.evgen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileContentFilter {

	public FileContentFilter() {
	}

	public static void fileContentFilter() {
		File fileOne = new File("FileOne.txt");
		File fileTwo = new File("FileTwo.txt");
		File fileTree = new File("FileTree.txt");
		try (BufferedReader bfrOne = new BufferedReader(new FileReader(fileOne));
				BufferedReader bfrTwo = new BufferedReader(new FileReader(fileTwo));
				BufferedWriter bfwOne = new BufferedWriter(new FileWriter(fileTree))) {
			if (fileTree.exists() == false) {
				fileTree.createNewFile();
			}
			String[] masOne = bfrOne.readLine().split("[ ,.!?]");
			String[] masTwo = bfrTwo.readLine().split("[ ,.!?]");
			for (int i = 0; i < masOne.length; i++) {
				for (int j = 0; j < masTwo.length; j++) {
					if (masOne[i].compareToIgnoreCase(masTwo[j]) == 0) {
						bfwOne.write(masOne[i] + " ");
					}
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}

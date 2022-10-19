package hw6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class analyzer {
	PrintWriter writer;
	public static int countLines(File file) throws FileNotFoundException {
		int count = 0;
		Scanner counter = new Scanner(file);
		Pattern comment = Pattern.compile("/\\*.*?\\*/");
		Matcher match = comment.matcher(counter.nextLine());

		while (counter.hasNextLine()) {
			counter.nextLine();
			if (!match.find()) {
				count++;
			}
		}
		return count;

	}

	public static int countFor(File file) throws FileNotFoundException {
		int count = 0;
		Scanner counter = new Scanner(file);

		while (counter.hasNextLine()) {
			String driver = counter.nextLine();
			if (driver.contains("for (") || driver.contains("for(")) {
				count++;
			}
		}
		counter.close();
		return count;
	}

	public static int countWhile(File file) throws FileNotFoundException {
		int count = 0;
		Scanner counter = new Scanner(file);
		while (counter.hasNextLine()) {
			String driver = counter.nextLine();
			if (driver.contains("while (") || driver.contains("while(")) {
				count++;
			}
		}
		counter.close();
		return count;
	}

	public static int countIf(File file) throws FileNotFoundException {
		int count = 0;
		Scanner counter = new Scanner(file);
		while (counter.hasNextLine()) {
			String driver = counter.nextLine();
			if (driver.contains("if (") || driver.contains("if(")) {
				count++;
			}
		}
		counter.close();
		return count;
	}

	public static int countElse(File file) throws FileNotFoundException {
		int count = 0;
		Scanner counter = new Scanner(file);
		while (counter.hasNextLine()) {
			String driver = counter.nextLine();
			if (driver.contains("else (") || driver.contains("else(")) {
				count++;
			}
		}
		counter.close();
		return count;
	}

	public static int countElseIf(File file) throws FileNotFoundException {
		int count = 0;
		Scanner counter = new Scanner(file);
		while (counter.hasNextLine()) {
			String driver = counter.nextLine();
			if (driver.contains("else if(") || driver.contains("else if(")) {
				count++;
			}
		}
		counter.close();
		return count;
	}

}

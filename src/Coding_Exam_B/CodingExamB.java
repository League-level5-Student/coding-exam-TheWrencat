package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class CodingExamB {
	/*
	 * This is a logging program for collecting TODO comments in a program. The
	 * program will scan Through all the files in the Coding_Exam_B/classes package,
	 * and collect all the comments that start with //TODO: and write them to their
	 * own file. See the TODO_Log_example.txt file for an idea of what the final
	 * file output will look like.
	 */

	public static String getLoggingInfo(String fileName) {
		/*
		 * 1. Complete the getLoggingInfoMethod. The method takes in a String for a file
		 * and returns a String. The method will open the file a read through it. It
		 * will then take all the comments that begin with //TODO: and combine them into
		 * one large String. The string will also state the file name and the line
		 * number for where each TODO was found.
		 */
		String log = "File: " + fileName + "\n";
		int ctr = 0;
		String line = "";
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(reader);
			
			line = br.readLine() + "";
			while ( line != null ){
//				System.out.println(line);
				
				
				
				ctr++;
				
				//something is wrong with substring
				for (int i = 0; i < line.length() - 8; i++) {
					
					String sectionCheck = line.substring(i, i + 1);
					if (sectionCheck.equals("//TODO:")) {
						System.out.println("hey");
						log += ctr + ": " + line + "\n";
					}
					System.out.println("loop:" +i);
					
					
				}
				line = br.readLine();
			}
			System.out.println(log);
			br.close();
		} catch (

		Exception e) {
			// TODO: handle exception
		}

		return log;
	}

	public static void main(String[] args) {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java");
//		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java");
//		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java");
//		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java");

		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should
		 * match TODO_Log_example.txt.
		 */
		try {
			FileWriter writer = new FileWriter("TODO_Log.txt");
			writer.append(finalLogString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

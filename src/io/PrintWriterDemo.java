package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 打印字符流
 */
public class PrintWriterDemo {

	public static void main(String[] args) {

		write();
	}

	public static void write() {
		try {
			FileWriter fw = new FileWriter(new File("d:\\test.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			// 将缓冲字符输出流转换成打印字符流
			PrintWriter pw = new PrintWriter(bw);

			pw.write("Hello PrintWriter!");
			
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

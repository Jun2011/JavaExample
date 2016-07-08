package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 缓冲字符输出流
 */
public class BufferedWriterDemo {

	public static void main(String[] args) {

		write();
	}

	public static void write() {
		try {
			Writer writer = new FileWriter(new File("d:/test.txt"));
			// 将字符输出流转换成缓冲字符输出流
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("Hello BufferedWriter!");
			bw.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

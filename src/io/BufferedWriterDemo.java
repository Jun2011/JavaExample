package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �����ַ������
 */
public class BufferedWriterDemo {

	public static void main(String[] args) {

		write();
	}

	public static void write() {
		try {
			Writer writer = new FileWriter(new File("d:/test.txt"));
			// ���ַ������ת���ɻ����ַ������
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("Hello BufferedWriter!");
			bw.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

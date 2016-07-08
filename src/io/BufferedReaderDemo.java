package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * �����ַ�������
 */
public class BufferedReaderDemo {

	public static void main(String[] args) {

		read();
	}

	public static void read() {
		try {
			Reader reader = new FileReader(new File("d:/test.txt"));
			// ���ַ�������ת���ɻ����ַ�������
			BufferedReader br = new BufferedReader(reader);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			reader.close();
			System.out.println(sb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

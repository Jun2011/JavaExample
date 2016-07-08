package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * ��������ַ���ת��Ϊ�ֽ����������ʽ
 */
public class OutputStreamWriterDemo {

	public static void main(String[] args) {

		try {
			OutputStream out = new FileOutputStream(new File("d:/test.txt"));

			write(out);

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write(OutputStream out) {

		try {
			// ���ֽ������ת���ַ������
			Writer writer = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(writer);
			
			bw.write("Hello OutputStreamWriter!");
			
			bw.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �ļ��ַ���������ӳ������ļ��������
 */
public class FileWriterDemo {

	public static void main(String[] args) {
		write();
	}
	
	public static void write(){
		
		File file=new File("d:\\test.txt");
		
		try {
			Writer writer=new FileWriter(file);
			
			String info="Hello IO!";
			
			writer.write(info);
			// ע�⣺Ҫ��\r�س�����\n���ţ��������ܻ��гɹ���
			writer.write("\r\n");
			writer.write("Hello FileWriter!");
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

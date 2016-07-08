package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * ��������ֽ���ת��Ϊ�ַ�����������ʽ
 */
public class InputStreamReaderDemo {

	public static void main(String[] args) {

		try {
			InputStream in = new FileInputStream(new File("d:/test.txt"));

			read(in);

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void read(InputStream in) {
		try {
			// ���ֽ�������ת���ַ�������
			Reader reader = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(reader);
			
			StringBuilder builder=new StringBuilder();
			String line;
			while((line=br.readLine())!=null){
				builder.append(line);
			}
			br.close();
			reader.close();
			
			System.out.println(builder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

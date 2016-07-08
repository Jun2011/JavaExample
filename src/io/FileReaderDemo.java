package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 文件字符输入流，向程序输入文件中的数据
 */
public class FileReaderDemo {

	public static void main(String[] args) {
		read();
	}

	public static void read(){
		
		File file = new File("d:/test.txt");
		
		try {
			Reader reader = new FileReader(file);
			
			char[] chars = new char[2];
			int len = -1;
			StringBuffer sb=new StringBuffer();
			while((len=reader.read(chars))!=-1){
				sb.append(chars,0,len);
			}
			
			reader.close();
			
			System.out.println(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

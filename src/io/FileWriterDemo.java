package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件字符输出流，从程序向文件输出数据
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
			// 注意：要先\r回车，再\n换号，这样才能换行成功。
			writer.write("\r\n");
			writer.write("Hello FileWriter!");
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

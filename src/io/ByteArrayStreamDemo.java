package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

// 字节数组流
public class ByteArrayStreamDemo {

	public static void main(String[] args) {
		
		readAndWrite();
	}

	public static void readAndWrite() {
		
		String info = "Hello ByteArrayOutputStream!";
		// 字节数组输入流
		ByteArrayInputStream bais = new ByteArrayInputStream(info.getBytes());
		// 字节数组输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		while ((len = bais.read()) != -1) {
			baos.write(len);
		}
		// 完成之后不需要关闭流，因为这两个流关闭无效。
		System.out.println(baos.toString());
	}
}

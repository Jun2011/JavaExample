package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 缓存字节输入流
 */
public class BufferedInputStreamDemo {

	public static void main(String[] args) {

		read();
	}

	public static void read() {
		try {
			InputStream in = new FileInputStream(new File("d:/test.txt"));
			// 将字节输入流转成缓存字节输入流
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bytes = new byte[1024];
			int len = -1;
			StringBuilder sb = new StringBuilder();
			while ((len = bis.read(bytes)) != -1) {
				sb.append(new String(bytes, 0, len));
			}
			bis.close();
			in.close();
			System.out.println(sb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

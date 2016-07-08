package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 打印字节流
 */
public class PrintStreamDemo {

	public static void main(String[] args) {

		write();
	}

	public static void write() {
		try {
			OutputStream out = new FileOutputStream("d:\\test.txt");
			// 使用缓冲提供性能
			BufferedOutputStream bos = new BufferedOutputStream(out);
			// 将缓冲字节输出流转换成打印字节流
			PrintStream ps = new PrintStream(bos);

			ps.print("Hello PrintStream!\n");
			ps.print('a');
			ps.println();
			ps.println(12);
			ps.println(1.18);
			ps.println(20d);
			ps.println(20l);

			ps.close();
			bos.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节输入流
 */
public class FileInputStreamDemo {

	public static void main(String[] args) {

		read();
	}

	// 读取数据
	public static void read() {

		File file = new File("d:" + File.separator + "test.txt");

		try {
			// 针对文件创建一个字节输入流
			InputStream in = new FileInputStream(file);

			// 创建一个10KB的字节数组，表示每次最大读取的长度
			byte[] bytes = new byte[10 * 1024];

			// 每次实际读取的长度
			int len = -1;

			// 创建一个StringBuffer用于保存每次读取的数据
			StringBuffer stringBuffer = new StringBuffer();

			// 开始读取数据
			while ((len = in.read(bytes)) != -1) {
				stringBuffer.append(new String(bytes, 0, len));
			}

			// 最后记得要关闭字节输入流释放资源
			in.close();

			// 打印出读取出来的数据
			System.out.println(stringBuffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

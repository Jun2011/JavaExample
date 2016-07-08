package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件字节输出流
 */
public class FileOutputStreamDemo {

	public static void main(String[] args) {

		write();
	}

	// 写入数据
	public static void write() {

		// 创建一个文件
		File file = new File("d:" + File.separator + "test.txt");

		try {
			// 针对文件创建一个字节输出流
			OutputStream out = new FileOutputStream(file);
//			// 第2个参数表示写入的模式，默认为false表示覆盖，而true表示追加。
//			FileOutputStream out1 = new FileOutputStream(file, true);

			// 创建要写入的数据
			String info = "Hello IO!";

			// 注意：outputStream.write()方法接收的是字节类型，
			// 所以要通过string.getBytes()方法获取字符串对应的字节。
			out.write(info.getBytes());

			// 最后要记得关闭字节输出流释放资源
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

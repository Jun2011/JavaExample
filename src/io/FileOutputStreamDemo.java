package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * �ļ��ֽ������
 */
public class FileOutputStreamDemo {

	public static void main(String[] args) {

		write();
	}

	// д������
	public static void write() {

		// ����һ���ļ�
		File file = new File("d:" + File.separator + "test.txt");

		try {
			// ����ļ�����һ���ֽ������
			OutputStream out = new FileOutputStream(file);
//			// ��2��������ʾд���ģʽ��Ĭ��Ϊfalse��ʾ���ǣ���true��ʾ׷�ӡ�
//			FileOutputStream out1 = new FileOutputStream(file, true);

			// ����Ҫд�������
			String info = "Hello IO!";

			// ע�⣺outputStream.write()�������յ����ֽ����ͣ�
			// ����Ҫͨ��string.getBytes()������ȡ�ַ�����Ӧ���ֽڡ�
			out.write(info.getBytes());

			// ���Ҫ�ǵùر��ֽ�������ͷ���Դ
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

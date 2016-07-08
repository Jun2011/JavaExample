package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ��ֽ�������
 */
public class FileInputStreamDemo {

	public static void main(String[] args) {

		read();
	}

	// ��ȡ����
	public static void read() {

		File file = new File("d:" + File.separator + "test.txt");

		try {
			// ����ļ�����һ���ֽ�������
			InputStream in = new FileInputStream(file);

			// ����һ��10KB���ֽ����飬��ʾÿ������ȡ�ĳ���
			byte[] bytes = new byte[10 * 1024];

			// ÿ��ʵ�ʶ�ȡ�ĳ���
			int len = -1;

			// ����һ��StringBuffer���ڱ���ÿ�ζ�ȡ������
			StringBuffer stringBuffer = new StringBuffer();

			// ��ʼ��ȡ����
			while ((len = in.read(bytes)) != -1) {
				stringBuffer.append(new String(bytes, 0, len));
			}

			// ���ǵ�Ҫ�ر��ֽ��������ͷ���Դ
			in.close();

			// ��ӡ����ȡ����������
			System.out.println(stringBuffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

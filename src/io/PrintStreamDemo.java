package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * ��ӡ�ֽ���
 */
public class PrintStreamDemo {

	public static void main(String[] args) {

		write();
	}

	public static void write() {
		try {
			OutputStream out = new FileOutputStream("d:\\test.txt");
			// ʹ�û����ṩ����
			BufferedOutputStream bos = new BufferedOutputStream(out);
			// �������ֽ������ת���ɴ�ӡ�ֽ���
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

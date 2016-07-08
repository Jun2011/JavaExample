package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * �����ֽ������
 */
public class BufferedOutputStreamDemo {

	public static void main(String[] args) {
		
		write();
	}

	public static void write() {
		try {
			OutputStream out = new FileOutputStream(new File("d:/test.txt"));
			// ���ֽ������ת�ɻ����ֽ������
			BufferedOutputStream bos=new BufferedOutputStream(out);		
			bos.write("Hello BufferedOutputStream!".getBytes());
			bos.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

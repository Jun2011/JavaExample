package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

// �ֽ�������
public class ByteArrayStreamDemo {

	public static void main(String[] args) {
		
		readAndWrite();
	}

	public static void readAndWrite() {
		
		String info = "Hello ByteArrayOutputStream!";
		// �ֽ�����������
		ByteArrayInputStream bais = new ByteArrayInputStream(info.getBytes());
		// �ֽ����������
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len = -1;
		while ((len = bais.read()) != -1) {
			baos.write(len);
		}
		// ���֮����Ҫ�ر�������Ϊ���������ر���Ч��
		System.out.println(baos.toString());
	}
}

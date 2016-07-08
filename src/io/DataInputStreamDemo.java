package io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ����������
 */
public class DataInputStreamDemo {

	public static void main(String[] args) {

		dataIn();
	}
	
	public static void dataIn(){
		try {
			InputStream in=new FileInputStream("d:\\test.txt");
			// ���ֽ�������ת��������������
			DataInputStream dis=new DataInputStream(in);
			
			int i=dis.readInt();
			String s=dis.readUTF();
			long l=dis.readLong();
			
			dis.close();
			in.close();
			
			System.out.println(i);
			System.out.println(s);
			System.out.println(l);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

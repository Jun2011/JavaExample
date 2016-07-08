package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ���������
 */
public class DataOutputStreamDemo {

	public static void main(String[] args) {
		
		dataOut();
	}

	public static void dataOut() {
		try {
			OutputStream out = new FileOutputStream("d:\\test.txt");
			// ���ֽ������ת�������������
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeInt(10);
			dos.writeUTF("DataOutputStream");
			dos.writeLong(123456);
			
			dos.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

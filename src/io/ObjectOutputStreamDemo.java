package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * �����ֽ������
 */
public class ObjectOutputStreamDemo {

	public static void main(String[] args) {
		
		objectOut();
	}

	public static void objectOut() {
		Cat cat = new Cat("Mimi", 3);
		try {
			OutputStream os = new FileOutputStream(
					new File("d:" + File.separator + "test.txt"));
			BufferedOutputStream bos=new BufferedOutputStream(os);
			// �������ֽ������ת���ɶ����ֽ������
			ObjectOutputStream oos=new ObjectOutputStream(bos);
			
			// д�����
			oos.writeObject(cat);
			
			oos.close();
			bos.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

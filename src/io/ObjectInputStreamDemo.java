package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * �����ֽ�������
 */
public class ObjectInputStreamDemo {

	public static void main(String[] args) {

		objectIn();
	}

	public static void objectIn() {
		try {
			InputStream is = new FileInputStream(
					new File("d:" + File.separator + "test.txt"));
			BufferedInputStream bis = new BufferedInputStream(is);
			// �������ֽ�������ת���ɶ����ֽ�������
			ObjectInputStream ois = new ObjectInputStream(bis);

			// ��ȡ����
			Cat cat = (Cat) ois.readObject();

			ois.close();
			bis.close();
			is.close();

			System.out.println(cat.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package io;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * ×Ö·û´®Á÷
 */
public class StringStreamDemo {

	public static void main(String[] args) {

		writeAndRead();
	}

	public static void writeAndRead() {
		String info = "StringStream";

		StringWriter sw = new StringWriter();
		sw.write(info);

		StringReader sr = new StringReader(info);
	}
}

package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// ����ServerSocketʵ�����󶨶˿ںţ�12345
					ServerSocket serverSocket = new ServerSocket(12345);
					
					// ��ȡInetAddressʵ��
					InetAddress inetAddress = InetAddress.getLocalHost();
					// ��ȡ������IP��ַ
					String ip = inetAddress.getHostAddress();

					// �����ͻ��˵ķ���
					Socket socket = null;
					System.out.println("������Ѿ������ȴ��ͻ��˽��룻�����IP��ַΪ��" + ip);
					socket = serverSocket.accept();

					BufferedReader reader = new BufferedReader(
							new InputStreamReader(
									socket.getInputStream(), "utf-8"));
					StringBuilder sb = new StringBuilder();
					String line = null;
					while ((line = reader.readLine()) != null) {
						sb.append(line);
					}
					reader.close();
					String clientData = sb.toString();
					System.out.println("�ͻ��˷����������ݣ�" + clientData);

					socket.shutdownInput();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
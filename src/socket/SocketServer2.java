package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer2 {

	private ServerSocket serverSocket;
	private ExecutorService executorService;
	private List<Socket> socketList;

	public static void main(String[] args) {

		new SocketServer2();
	}

	public SocketServer2() {
		try {
			// ����ServerSocketʵ�����󶨶˿ںţ�12345
			serverSocket = new ServerSocket(12345);

			// �����̳߳�
			executorService = Executors.newCachedThreadPool();

			System.out.println("�����������...\n");
			Socket socket = null;
			socketList = new ArrayList<Socket>();
			while (true) {
				socket = serverSocket.accept();
				socketList.add(socket);
				executorService.execute(new Service(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class Service implements Runnable {

		private Socket socket;
		private BufferedReader reader = null;
		private String message = "";

		public Service(Socket socket) {

			this.socket = socket;

			try {
				reader = new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
				message = "�û���" + this.socket.getInetAddress() + "������������\n" 
				+ "��ǰ����������" + socketList.size();
				this.sendMessage();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (true) {
				try {
					if ((message = reader.readLine()) != null) {
						if (message.equals("bye")) {
							System.out.println("--------------------");
							socketList.remove(socket);
							reader.close();
							message = "�û���" + socket.getInetAddress() + "�˳�\n" 
							+ "��ǰ����������" + socketList.size();
							socket.close();
							this.sendMessage();
							break;
						} else {
							message = socket.getInetAddress() + "˵��" + message;
							this.sendMessage();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// �������Ϸ���˵�ÿ���ͻ��˷�����Ϣ
		public void sendMessage() {

			System.out.println(message);

			int account = socketList.size();
			for (int i = 0; i < account; i++) {

				Socket socket = socketList.get(i);
				try {
					PrintWriter writer = new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(
											socket.getOutputStream(), "UTF-8")), true);
					writer.println(message);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

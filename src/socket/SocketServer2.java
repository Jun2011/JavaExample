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
			// 创建ServerSocket实例并绑定端口号：12345
			serverSocket = new ServerSocket(12345);

			// 创建线程池
			executorService = Executors.newCachedThreadPool();

			System.out.println("服务端运行中...\n");
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
				message = "用户：" + this.socket.getInetAddress() + "加入了聊天室\n" 
				+ "当前在线人数：" + socketList.size();
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
							message = "用户：" + socket.getInetAddress() + "退出\n" 
							+ "当前在线人数：" + socketList.size();
							socket.close();
							this.sendMessage();
							break;
						} else {
							message = socket.getInetAddress() + "说：" + message;
							this.sendMessage();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 给连接上服务端的每个客户端发送信息
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

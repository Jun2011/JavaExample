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
					// 创建ServerSocket实例并绑定端口号：12345
					ServerSocket serverSocket = new ServerSocket(12345);
					
					// 获取InetAddress实例
					InetAddress inetAddress = InetAddress.getLocalHost();
					// 获取本机的IP地址
					String ip = inetAddress.getHostAddress();

					// 监听客户端的访问
					Socket socket = null;
					System.out.println("服务端已就绪，等待客户端接入；服务端IP地址为：" + ip);
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
					System.out.println("客户端发过来的数据：" + clientData);

					socket.shutdownInput();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
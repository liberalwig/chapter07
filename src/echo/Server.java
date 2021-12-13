//2021.12.13(월)15:35수업 어려움
package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.56", 10001));

		System.out.println("<서버시작>");
		System.out.println("=======================================");
		System.out.println("[연결을 기다리고 있습니다.]");

		while (true) {

			Socket socket = serverSocket.accept();

			Thread thread = new ServerThread(socket);
			thread.start(); // 출장나가고, [선보강, 메세지 주고받기], 출장종료

		}

	}

}
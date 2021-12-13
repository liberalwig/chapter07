//2021.12.13(월)15:35수업 어려움

package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket();

		System.out.println("<클라이언트 시작>");
		System.out.println("=======================================");

		System.out.println("[서버에 연결을 요청합니다.]");

		socket.connect(new InetSocketAddress("192.168.0.56", 10001));

		System.out.println("[서버에 연결되었습니다.]");

		// 메세지 보내기 스트림
		OutputStream os = socket.getOutputStream(); // 주스트림
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 메세지 받기 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// Scanner (키보드 입력용)
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			
			if("/q".equals(str)) {
				System.out.println("[종료키 입력]");
				break;
			}

			// 메세지 보내기
			bw.write(str);
			bw.newLine();
			bw.flush();

			// 메세지 받기
			String reMsg = br.readLine();
			System.out.println("server:[" + reMsg + "]");

		}
		
		System.out.println("=======================================");
		System.out.println("<클라이언트종료>");
		sc.close();
		bw.close();
		socket.close();
	}

}
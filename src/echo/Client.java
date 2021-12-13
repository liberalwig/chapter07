//2021.12.13(월)17:00수업 어려움

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

public class Client {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket();

		System.out.println("<클라이언트 시작>");
		System.out.println("=======================================");

		System.out.println("[서버에 연결을 요청합니다.]");

		socket.connect(new InetSocketAddress("192.168.219.101", 10001));

		System.out.println("[서버에 연결되었습니다.]");

		// 메세지 보내기 스트림
		OutputStream os = socket.getOutputStream(); // 주스트림
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 메세지 받기 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		/*
		 * Scanner: 키보드 입력용. 세 번째 버퍼 이름 몰라서 아래 살리려고 여기 주석처리 Scanner sc = new
		 * Scanner(System.in);
		 */

		InputStream in = System.in;
		InputStreamReader sisr = new InputStreamReader(in, "UTF-8");
		BufferedReader sbr = new BufferedReader(sisr);

		while (true) {
			String str = sbr.readLine();

			if ("/q".equals(str)) {
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
		
		//System.out.println("<클라이언트종료>");
		OutputStream out = System.out;
		OutputStreamWriter posw = new OutputStreamWriter(out);
		BufferedWriter pbw = new BufferedWriter(posw);
		
		pbw.write("<클라이언트 종료> 스트림 사용 구현");
		pbw.newLine();
		pbw.flush();
				
		bw.close();
		socket.close();
	}

}
package network;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPIPMultiChatClient {

	public static void main(String[] args) {
		
		// 소켓 연결
		try {
			// localhost -> 호스트 자신의 주소 
			//String serverIp = "127.0.0.1";
			String serverIp = "192.168.0.24";
			
			Socket socket = new Socket(serverIp, 7777);
			
			// 메시지를 받은 쓰레드
			Thread receiver = new ClientReceiver(socket);
			
			// 메시지를 전송하는 쓰레드
			Thread sender = new ClientSenderThread(socket, "이수진");
			
			sender.start();
			receiver.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

class ClientSenderThread extends Thread{
	// 보내기 쓰레드는 socket, ouputstream, name필요 
	Socket socket;
	DataOutputStream out;
	String name;
	
	// 셍상지
	ClientSenderThread(Socket s, String name){
		this.socket = s;
		try {
			out = new DataOutputStream(s.getOutputStream());
			this.name = name;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		// 접속하면 바로 이름을 서버에 전송
		if(out != null) {
			try {
				out.writeUTF(name);
				
				while(out != null) {
					out.writeUTF("[" + name + "]" + sc.nextLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}

class ClientReceiver extends Thread{
	// 메시지를 받아서 콘솔에 출력
	// socket, inputstream
	Socket socket;
	DataInputStream in;
	
	public ClientReceiver(Socket socket) {
		this.socket = socket;
		
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(in != null){
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
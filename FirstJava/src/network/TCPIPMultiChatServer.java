package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TCPIPMultiChatServer {
	// 접속 사용자 정보를 저장 : 메시지를 전체에게 보내기 위해서 
	// 저장정보 : name, OutputStream
	// Map<String, Object>
	HashMap<String, Object> clients;
	
	public TCPIPMultiChatServer() {
		clients = new HashMap<String, Object>();
		
		// 동기화 해줄수 있는 클래스 
		Collections.synchronizedMap(clients); // 쓰레드 동기화에 안전하게 사용하도록 해주는 메서드
	}
	
	public static void main(String[] args) throws IOException {
		new TCPIPMultiChatServer().start();

	}
	
	public void start() throws IOException {
		// ServerSocket 실행 
		// 사용자의 요청이 있으면 socket 생성해서 연결
		// 연결 -> clients 사용자 정보를 저장, 쓰레드로 처리
		
		// 서버 소켓 생성 
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println("Chatting Server Start .............!!");
		
		Socket socket = null;
			
		while(true) {
			// accept() : 요청이 들어올 때 까지 대기 하다가 요청이 들어오면 새로운 socket 을 생성해서 반환 
			socket = serverSocket.accept();
			
			// map에 정보저장, 접속한 사용자들에게 메시지를 전송 
			
			// 사용자 접속 정보 출력 
			System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]");
			
			ServerReceiver receiver = new ServerReceiver(socket);
			receiver.start();
		}
		
	}
	
	// 전체에게 메시지 보내기 
	void sendtoAll(String msg) {
		// 일괄 처리,  map은 순서가 없다 -> map이 가지고 있는 key를 -> set으로 변경 (set은 iterator로 줄을 세울 수 있다. )
		Set<String> keys = clients.keySet();
		
		// iterator로 줄세우기 
		Iterator<String> itr = keys.iterator();
		
		while(itr.hasNext()) {
			DataOutputStream out = (DataOutputStream) clients.get(itr.next());
			try {
				out.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// 내부 클래스 만들기 : 데이터 받아서 저장하고 메시지 전체발송 
	class ServerReceiver extends Thread{
		// Socket, InputStream, OutputStream 
		Socket socket;
		DataOutputStream out;
		DataInputStream in;
		
		// 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Override 
		public void run() {
			String name = null;  //접속한 사용자의 이름
			
			try {
				name = in.readUTF();      // 이름을 스트림을 통해 받는다. 
				clients.put(name, out);  // map에 사용자 정보 저장 
				sendtoAll(">>>>>>>> " + name + " 님이 접속하셨습니다. ");  // 내부 클래스에서는 아우터 클래스의 멤버를 참조할 수 있다. 
				
				while(in != null) {
					sendtoAll(in.readUTF());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// 소켓에 문제가 있을때 
				clients.remove(name);
				System.out.println("접속이 종료되었습니다.");
			}
		}
		
		
	}

}

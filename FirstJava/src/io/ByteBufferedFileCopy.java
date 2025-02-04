package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufferedFileCopy {
	
	public static void main(String[] args) throws Exception {
		
		// 읽어올 대상 파일의 InputStream 인스턴스 생성 
		InputStream in = new FileInputStream("org.pdf");
		// 출력 대상 파일의 OutputStream 인스턴스 생성 
		// 해당 경로의 파일이 존재하지 않으면 파일을 생성해서 write 
		// 해당 겅로에 파일이 존재하면 덮어쓴다. 	
		OutputStream out = new FileOutputStream("org_copy.pdf"); 
				
		// 필터 스트림 인스턴스 생성 
		BufferedInputStream bin = new BufferedInputStream(in, 1024);
		BufferedOutputStream bout = new BufferedOutputStream(out, 1024);
				
		// 복사한 사이즈 
		int copyByte = 0;
		// 복사한 byte 사이즈의 데이터 
		int bData = 0;
		
		//byte[] buf = new byte[1024];	// 1kb 버퍼 생성
		//int readLength = 0;		
		System.out.println("복사를 시작합니다.");
		
		while(true) {
			bData = in.read();
			//readLength = in.read(buf);	// 더이상 가져올 데이터가 없으면 -1을 반환 
			
			if(bData==-1) {
			//if(readLength==-1) {	
				break;
			}
			bout.write(bData);
			//out.write(buf,0,readLength);
			//copyByte += readLength;			
			copyByte++;
		}
		bin.close();
		bout.close();
		
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 사이즈 : " + copyByte + "byte");
		
	}
	


}

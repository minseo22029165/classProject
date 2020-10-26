package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = new PrintWriter(new FileWriter("print.txt"));
		
		out.printf("안녕하세요 저는 %d살 %s입니다.", 12, "철수");
		out.println();
		out.print("저는 자바를 좋아합니다.");
		out.println();
		out.println("IO 재미있네요");
		out.close();		
		
		System.out.println("파일작성완료.");
	}

}

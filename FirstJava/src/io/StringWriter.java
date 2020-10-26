package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class StringWriter {

	public static void main(String[] args) throws Exception {
		// 필터 스트림 : BufferedWriter  기본 스트림  Writer 가 필요 
		Writer writer = new FileWriter("String.txt");
		
		BufferedWriter out = new BufferedWriter(writer);
		
		out.write("1");
		out.newLine();
		out.write("2");
		out.newLine();
		out.write("3");
		
		// 스트림 닫기 
		out.close();
		
		System.out.println("기사 작성 완료!");
	}

}

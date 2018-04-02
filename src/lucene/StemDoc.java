package lucene;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Scanner;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.util.Version;

public class StemDoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		File f = new File("D:/Study/IR/TrecData/FT922-401.txt");
		FileInputStream fis = new FileInputStream(f);
		InputStream inStreamObject = (InputStream) fis;
		Scanner sc = new Scanner( inStreamObject );
		String input = sc.nextLine();
		 byte fileContent[] = new byte[(int)f.length()];

		System.out.println(fileContent);
		BufferedReader r=new BufferedReader(new FileReader(f));
		int ch;
		int count1=0;
		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
		int count = 0;
		BufferedWriter bwr =null;
		FileWriter fw = null;	
		int cnt = 1;
		String s="";
		while((ch=r.read())!=-1 )
		{
			
				char c = (char) ch;	
				sb.append((char)ch);
			//	String s = sb.toString();
		
		
		
		 String dataDir =  "D:\\Study\\IR\\TrecData";
		 Analyzer analyzer = new StopAnalyzer(Version.LUCENE_36);
		 
         TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(s));
         TermAttribute term  = tokenStream.addAttribute(TermAttribute.class);
        // StringBuffer sb = new StringBuffer();
         while(tokenStream.incrementToken())
         {
        	 sb1.append(term.term()+" ");
         }
         
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
         
	}

}

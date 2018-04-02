package lucene;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.Scanner;

public class ExtractParagraph {

	public static void main(String[] args) {
		File f = new File("D:/Study/IR/TrecData/Training/sample.txt");
		
		try {
			
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
			int count = 0;
			BufferedWriter bwr =null;
			FileWriter fw = null;	
			int cnt = 1;
			while((ch=r.read())!=-1 )
			{
				
					char c = (char) ch;	
					sb.append((char)ch);
					String s = sb.toString();
					
				
				
				if((char)ch == '.')
				{
					count1++;                                        
				
					//sb = new StringBuffer();
					if(count1%5==0)
					{	
						
						
					bwr = new BufferedWriter(new FileWriter(new File("D:/Study/IR/TrecData/Training/sample"+cnt	+".txt")));
					cnt++;
					bwr.write(s);
					sb= new StringBuffer();
					bwr.close();
					}
					count++;
				}
				
				System.out.print((char)ch);
			}
			
			r.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
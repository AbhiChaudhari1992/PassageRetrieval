package lucene;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Scanner;

public class ExtractParagraphDirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File directory = new File("D:/Study/IR/TrecData/Training/toDivide/");
		 File[] fList = directory.listFiles();
		 
	    for(File file : fList)	
	    {
	    	if(file.getName().startsWith("FT")){
	    		try {
	    			
	    			FileInputStream fis = new FileInputStream(file);
	    			InputStream inStreamObject = (InputStream) fis;
	    			Scanner sc = new Scanner( inStreamObject );
	    			String input = sc.nextLine();
	    			 byte fileContent[] = new byte[(int)file.length()];

	    			System.out.println(fileContent);
	    			BufferedReader r=new BufferedReader(new FileReader(file));
	    			int ch;
	    			int count1=0;
	    			StringBuffer sb = new StringBuffer();
	    			int count = 0;
	    			String s = null;
	    			BufferedWriter bwr =null;
	    			FileWriter fw = null;	
	    			while((ch=r.read())!=-1 )
	    			{
	    				
	    					char c = (char) ch;	
	    					sb.append((char)ch);
	    					s = sb.toString();
	    					
	    				
	    				
	    				if((char)ch == '.')
	    				{
	    					count1++;                                        
	    				
	    					//sb = new StringBuffer();
	    					    						
	    					if(count1%5==0)
	    					{
	    						count++;
	    					bwr = new BufferedWriter(new FileWriter(new File("D:/Study/IR/TrecData/Training/toIndex/"+file.getName()+""+count+".txt")));
	    					
	    					bwr.write(s);
	    					sb= new StringBuffer();
	    					bwr.close();
	    					}
	    					
	    				}
	    				
	    				
	    				System.out.print((char)ch);
	    			}
	    			if(count1 < 5)
    				{
    					bwr = new BufferedWriter(new FileWriter(new File("D:/Study/IR/TrecData/Training/toIndex/"+file.getName()+".txt")));
    					bwr.write(s);
    					sb= new StringBuffer();
    					bwr.close();
    				}
	    			
	    			r.close();
	    			 
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    		
	    	}
	    }
	}

}

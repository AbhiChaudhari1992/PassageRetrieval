package lucene;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;

public class LuceneTester {
	
   String indexDir = "D:\\Study\\IR\\TrecData\\training\\indexedfiles";
   String dataDir =  "D:\\Study\\IR\\TrecData\\training\\toIndex";
   Indexer indexer;
   Searcher searcher;
	   static String question;
	   public static void main(String[] args) {
      LuceneTester tester; 
      try {		
    	  //Scanner sc=new Scanner(System.in);
         tester = new LuceneTester();
          //tester.createIndex();
    	  Scanner sc=new Scanner(System.in);
         System.out.println("Enter your question");
         question = sc.nextLine();
         Analyzer analyzer = new StopAnalyzer(Version.LUCENE_36);
         TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(question));
         TermAttribute term  = tokenStream.addAttribute(TermAttribute.class);
         StringBuffer sb = new StringBuffer();
         while(tokenStream.incrementToken())
         {
        	 sb.append(term.term()+" ");
         }
         
      //   System.out.println(sb.toString());
         Query q = new QueryParser(Version.LUCENE_CURRENT, "title", analyzer).parse(question);
       //  System.out.println("query is "+);
         
       tester.search(question);
      } catch (Exception e) {
         e.printStackTrace();
      
      }
   }

   private void createIndex() throws IOException {
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }

   private void search(String searchQuery) throws IOException, ParseException {
      searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
      
      System.out.println(hits.getMaxScore());
 
      System.out.println(hits.totalHits +    
         " documents found. Time :" + (endTime - startTime));
      System.out.println("\n Extracted information is........... \n");
      //System.out.println("score documents are "+hits.scoreDocs);
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "
            + doc.get(LuceneConstants.FILE_PATH));
     /*   Analyzer a ;
		QueryParser qp = new QueryParser(3.6, question, a ) */
            	
            
      }
      searcher.close();
   }
}

package BinaryTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {    
    public static void main(String args[]) throws IOException{  
        BinaryTree bTree;
        Scanner in = new Scanner(System.in);
        int n=-1;
        while(n<1||n>1000)
		{    
		    try
		    {
		        n=in.nextInt();
		     }
		    catch(Exception e)
		    {
		         System.out.println("请输入1~1000以内的数字");
		         in.next();
		         n=-1;
		     }
		    if((n<1||n>1000)&&n!=-1)
		         System.out.println("请输入1~1000以内的数字");
		}      
        String str="result.txt";
		String str1="201571030133";
        BufferedWriter bw = new BufferedWriter(new FileWriter(str));
        writeToFile(str,str1+'\n');
        for(int i = 0; i < n; i++){  
            bTree = new BinaryTree(2);  
            bTree.createBTree();  
            String result = bTree.CalAndVal();
            if(Integer.parseInt(result)<0)
            {
            	i--;
            }
            else
            {
            	writeToFile(str,bTree.toString() + "=" + result+'\n'); 
            }
             
        }  
    }  
    public static void writeToFile(String filePath, String content) {

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath),true));
            writer.write(content);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}  
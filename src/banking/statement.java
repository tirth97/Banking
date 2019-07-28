package banking;
import java.io.*;
import java.util.*;
public class statement {
   public void generate_stat()
   {
    File file=new File("statement.txt");
    try
    {    
     Scanner input=new Scanner(file);
     String a1=input.nextLine();
     String a=input.nextLine();
     System.out.println("acc no.: "+a1+" "+a);
    }catch(IOException e){System.out.println();}
   }
    
}


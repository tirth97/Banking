package banking;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class stat {
    public void generate_stat(String n)
   {
    File file=new File("statement.txt");
    System.out.println("ACC. NUM -"+n+": TRANSACTION STATEMENT---");
    try
    {    
     Scanner input=new Scanner(file);
     while(input.hasNext())
     {    
      String a1=input.nextLine();
      String a=input.nextLine();
      if(a1==n)
        System.out.println(a);
     }
    }catch(IOException e){System.out.println();}
   }
   public void generate_all_stat()
   {
    File file=new File("statement.txt");
    System.out.println("----BANK TRANSACTION STATEMENT---");
    try
    {    
     Scanner input=new Scanner(file);
     while(input.hasNext())
     {    
      String a1=input.nextLine();
      String a=input.nextLine();
      System.out.println("ACC. NUM :"+a1+" : "+a);
     }
    }catch(IOException e){System.out.println();}
   }
    
}

package banking;
import java.io.*;
import java.util.*;
public class acc_read {
   public ArrayList<account> S=new ArrayList<account>();
   void rd()
   {        
    int flag=0;
    System.out.println("-------current status of database----");
    File file;
       file = new File("acc.bin");
    try{
        FileInputStream fs=new FileInputStream(file);
        ObjectInputStream in=new ObjectInputStream(fs);  
        while(true)
        {
         account s1=(account)in.readObject();
         flag++;
         s1.display_details();
         System.out.println();
        }
       }
    catch(Exception e){}
    if(flag==0)
            System.out.println("file is empty \n"+flag+" records in file");
    else
            System.out.println(flag+" records in file");
   }
   void rd1(long r)
   {     
    int flag=0;
    File file;
       file = new File("acc.bin");
    try{
        FileInputStream fs=new FileInputStream(file);
        ObjectInputStream in=new ObjectInputStream(fs);  
        while(true)
        {
         account s1=(account)in.readObject();
         if(s1.acc_num==r)
         { 
          flag++;
          System.out.println("-------REQUIRED ACCOUNT DETAILS-------");
          s1.display_details();
         }
         System.out.println();
        }
    }catch(Exception e){}
    if(flag==0)
        System.out.println("FILE NOT FOUND!!!");
     }   

    }
           
   
package banking;
import java.io.*;
import java.util.ArrayList;
public class trans_details implements Serializable {
         long acc;
         long trans_cash;
         int td,tm,ty,th,tmm; 
         String mode; 
   trans_details()
   {}       
   trans_details(long a,long tc,int td,int tm,int ty,int th,int tmm,String m)
   {
    acc=a;
    trans_cash=tc;
    this.td=td;
    this.tm=tm;
    this.ty=ty;
    this.th=th;
    this.tmm=tmm;
    mode=m;
   }        
   void generate_stats(trans_details s) throws ClassNotFoundException 
   {
       ArrayList<trans_details> S3=new ArrayList<trans_details>(); 
       try{
          File file1=new File("stat1.txt");
          FileInputStream fi=new FileInputStream(file1);
          ObjectInputStream fin=new ObjectInputStream(fi);  
          while(true)
          {
          trans_details s1=(trans_details)fin.readObject();
          S3.add(s1);
          fin.close();
          }
         }
      catch(IOException e){System.out.println(e);}
      try{
         File file1=new File("stat1.txt");  
         FileOutputStream fo=new FileOutputStream(file1);
         ObjectOutputStream fout=new ObjectOutputStream(fo);  
         S3.add(s);
         for(trans_details x: S3)
           fout.writeObject(x);
           System.out.println("statement written to file"); 
        }
       catch(Exception e){}
    }
   void get_statements() 
   {
    try{
        File file=new File("stat1.txt");
        FileInputStream fi=new FileInputStream(file);
        ObjectInputStream fin=new ObjectInputStream(fi);  
        while(true)
        {
         trans_details s1=(trans_details)fin.readObject();
         s1.display(s1);
        }
      }
     catch(Exception e){System.out.println(e);}
   }
   void display(trans_details s)
   {        
    System.out.println("acc no."+acc+" : ");
    System.out.println("Rs "+trans_cash+" ");
    System.out.print(mode);
    System.out.print(" on"+td+"-"+tm+"-"+ty+" at "+th+" : "+tmm);
   }
}
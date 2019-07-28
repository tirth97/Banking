package banking;
import java.io.*;
public class delete {
  public void remove(long n)
  {
     acc_write w=new acc_write();
     int flag=0;
     w.retarr();
     File file=new File("acc.bin");
     try{
        FileOutputStream fo=new FileOutputStream(file);
        ObjectOutputStream fout=new ObjectOutputStream(fo);  
        for(account x: w.S2)
        {
         if(x.acc_num!=n)
           fout.writeObject(x);
         else
           flag=1;
        }
        fout.close();
       }
       catch(Exception e){}
       if(flag==1)
       System.out.println("ACCOUNT DELETED !!!");
       else
       System.out.println("ACCOUNT DOESN'T EXIST !!!!");
      
  }    
}

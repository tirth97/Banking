package banking;
import java.io.*;
public class acc_modify {
    void modify(long n)
    {
     int flag=0;
     acc_write wr=new acc_write();
     wr.retarr();
     for(account x: wr.S2)
     {
      if(x.acc_num==n)
          flag=1;
     }
     if(flag==1)
     {    
      account p=new account();
      p.get_details();
      for(account x :wr.S2)
     {
      if(x.acc_num==n)
      {
       x.name=p.name;
       x.address=p.address;
       x.acc_type=p.acc_type;
       x.balance=p.balance;
       x.interest_rate=p.interest_rate;
       x.contact_num=p.contact_num;
       flag=1;
      }    
     }
     File file=new File("acc.bin");
     try{
        FileOutputStream fo=new FileOutputStream(file);
        ObjectOutputStream fout=new ObjectOutputStream(fo);  
        for(account x: wr.S2)
           fout.writeObject(x);
           fout.close();
        }
       catch(Exception e){}
       System.out.println("ACCOUNT DETAILS MODIFIED !!!!");
     }
     else
       System.out.println("ACCOUNT DOESNOT EXIST !!!!");
    }
}
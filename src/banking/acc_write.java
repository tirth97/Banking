package banking;
import java.io.*;
import java.util.ArrayList;
public class acc_write {
    public ArrayList<account> S2=new ArrayList<account>();
    public void retarr()
    {
     account a=new account();
      try{
        File file=new File("acc.bin");
        FileInputStream fi=new FileInputStream(file);
        ObjectInputStream fin=new ObjectInputStream(fi);  
        while(true)
        {
         account s1=(account)fin.readObject();
         S2.add(s1);
         a=s1;
        }
       }
      catch(Exception e){}
      
    } 
    void add(account s)
    {
     File file=new File("acc.bin");
     retarr();
     try{
        FileOutputStream fo=new FileOutputStream(file);
        ObjectOutputStream fout=new ObjectOutputStream(fo);  
        S2.add(s);
        for(account x: S2)
           fout.writeObject(x);
          System.out.println("ACCOUNT ADDED");
          System.out.println("YOUR ACCOUNT NO. IS :"+s.acc_num);
          fout.close();
        }
       catch(Exception e){}
     }
}
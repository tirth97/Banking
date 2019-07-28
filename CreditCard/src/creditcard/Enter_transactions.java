package creditcard;
import java.io.*;
import java.util.ArrayList;
public class Enter_transactions 
{
    public ArrayList<Transactions> C1=new ArrayList<>();
    public void retarr()
    {
        Transactions l=new Transactions();
        try
        {
            File file=new File("transcc_cu.bin");
            FileInputStream fi=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fi);
            while(true)
            {
                Transactions ld1=(Transactions)ois.readObject();
                C1.add(ld1);
                l=ld1;
            }
            
        }catch(Exception e){}
    }
    
    void add(Transactions ld)
    {
        retarr();
        try
        {
            File file=new File("lo_cu.bin");
            FileOutputStream fo=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fo);
            for(Transactions l:C1)
                oos.writeObject(l);
            System.out.println("ACCOUNT ADDED");
        }catch(Exception e){}
            
    }
}

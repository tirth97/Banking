package creditcard;
import java.util.*;
import java.io.*;
public class Write_Transactions 
{
    public ArrayList<Transactions> c1=new ArrayList<>();
    void read_transactions()
    {
        Transactions cd=new Transactions();
        try{
        File file=new File("transaction_cu.bin");
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois =new ObjectInputStream(fis);
        while(true)
        {
            Transactions t=(Transactions)ois.readObject();
            c1.add(t);
            cd=t;
        }
        }catch(Exception e)
        {
            System.out.println("Error --> "+e);
        }
    }
    
    void Transactions_read(Transactions t)
    {
        read_transactions();
        try
        {
            File file=new File("transaction_cu.bin");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            c1.add(t);
            for(Transactions ccd:c1)
                oos.writeObject(ccd);
            System.out.println("Details Added!!");
            
            oos.close();
            fos.close();
        }catch(Exception e){System.out.println("Error --> "+e);}
    }
}

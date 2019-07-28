package banking;
import java.util.*;
import java.io.*;
public class Enter_details implements Serializable
{
    public ArrayList<Loan_details> C1=new ArrayList<>();
    public void retarr()
    {
        Loan_details l=new Loan_details();
        try
        {
            File file=new File("lo_cu.bin");
            FileInputStream fi=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fi);
            while(true)
            {
                Loan_details ld1=(Loan_details)ois.readObject();
                C1.add(ld1);
                l=ld1;
            }
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    void add(Loan_details ld)
    {
        retarr();
        try
        {
            File file=new File("lo_cu.bin");
            FileOutputStream fo=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fo);
            C1.add(ld);
            for(Loan_details l:C1)
                oos.writeObject(l);
            System.out.println("ACCOUNT ADDED");
            System.out.println("Loan Account Number is: "+ld.loan_number());
        }catch(Exception e){e.printStackTrace();}
            
    }
}
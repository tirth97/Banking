package banking;
import java.io.*;
import java.util.*;
public class details_read
{
    public ArrayList<Loan_details>l=new ArrayList<>();
    void read()
    {
        int flag=0;
        System.out.println("-----Current Status of Database-----");
        File file=new File("lo_cu.bin");
        try
        {
            FileInputStream fi=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fi);
            while(true)
            {
                Loan_details ld=(Loan_details)ois.readObject();
                flag++;
                ld.display_details();
                System.out.println();
            }
        }catch(Exception e){}
        if(flag==0)
        {
            System.out.println("File is empty\n"+flag+"\n Records");
        }
        else
        {
            System.out.println(flag+"Records in file.");
        }
    }
    
    void read1(long r)
    {
        int flag=0;
        File file=new File("lo_cu.bin");
        try
        {
            FileInputStream fi=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fi);
            while(true)
            {
                Loan_details ld=(Loan_details)ois.readObject();
                if(ld.L_id==r)
                {
                    flag++;
                    System.out.println("------Required Details are:-------");
                    ld.display_details();
                }
            }
        }catch(Exception e){}
        if(flag==0)
        {
            System.out.println("FILE NOT FOUND!!!");
        }
    }
    
    double read_emi(long r)
    {
        int flag=0;
        double emi=0;
        File file=new File("lo_cu.bin");
        try
        {
            FileInputStream fi=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fi);
            while(true)
            {
                Loan_details ld=(Loan_details)ois.readObject();
                if(ld.L_id==r)
                {
                    flag++;
                    System.out.println("------EMI Details are:-------");
                    emi=ld.emi(ld);
                }
            }
        }catch(Exception e){}
        if(flag==0)
        {
            System.out.println("FILE NOT FOUND!!!");
        }
        return emi;
    }
}
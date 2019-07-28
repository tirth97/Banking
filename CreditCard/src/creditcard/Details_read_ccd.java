package creditcard;
import java.io.*;
import java.util.*;
public class Details_read_ccd
{
    public ArrayList<CreditCard_details>l=new ArrayList<>();
    void read()
    {
        int flag=0;
        System.out.println("-----Current Status of Database-----");
        File file=new File("ccd_cu.bin");
        try
        {
            FileInputStream fi=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fi);
            while(true)
            {
                CreditCard_details ccd=(CreditCard_details)ois.readObject();
                flag++;
                ccd.card_details();
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
        File file=new File("ccd_cu.bin");
        try
        {
            FileInputStream fi=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(fi);
            while(true)
            {
                CreditCard_details ccd=(CreditCard_details)ois.readObject();
                if(ccd.cc_num==r)
                {
                    flag++;
                    System.out.println("------Required Details are:-------");
                    ccd.card_details();
                }
            }
        }catch(Exception e){}
        if(flag==0)
        {
            System.out.println("FILE NOT FOUND!!!");
        }
    }
    
    /*double read_ccd(long r)
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
                CreditCard ccd=(CreditCard_details)ois.readObject();
                if(ccd.cc_num==r)
                {
                    flag++;
                    System.out.println("------EMI Details are:-------");
                    emi=ccd.emi(ccd);
                }
            }
        }catch(Exception e){}
        if(flag==0)
        {
            System.out.println("FILE NOT FOUND!!!");
        }
        return emi;
    }*/
}
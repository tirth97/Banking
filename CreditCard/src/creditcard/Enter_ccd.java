package creditcard;
import java.util.*;
import java.io.*;
public class Enter_ccd 
{
    public ArrayList<CreditCard_details> c1=new ArrayList<>();
    void read_ccd()
    {
        CreditCard_details cd=new CreditCard_details();
        try{
        File file=new File("ccd_cu.bin");
        FileInputStream fis=new FileInputStream(file);
        ObjectInputStream ois =new ObjectInputStream(fis);
        while(true)
        {
            CreditCard_details ccd=(CreditCard_details)ois.readObject();
            c1.add(ccd);
            cd=ccd;
        }
        }catch(Exception e)
        {
            System.out.println("Error --> "+e);
        }
    }
    
    void CreditCardDetails_read(CreditCard_details cc)
    {
        read_ccd();
        try
        {
            File file=new File("ccd_cu.bin");
            FileOutputStream fos=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            c1.add(cc);
            for(CreditCard_details ccd:c1)
                oos.writeObject(ccd);
            System.out.println("Details Added!!");
            
            oos.close();
            fos.close();
        }catch(Exception e){System.out.println("Error --> "+e);}
    }
}

package creditcard;
import java.io.*;
public class Modify_details_ccd {
    void Modify(long n)
    {
        int flag=0;
        Enter_ccd ec=new Enter_ccd();
        ec.read_ccd();
        for(CreditCard_details l:ec.c1)
        {
            if(l.cc_num==n)
            {
                flag=1;
            }
        }
        if(flag==1)
        {
            CreditCard_details ccd=new CreditCard_details();
            ccd.card_details();
            for(CreditCard_details cd1:ec.c1)
            {
                if(cd1.cc_num==n)
                {
                    cd1.name=ccd.name;
                    cd1.ph_no=ccd.ph_no;
                    cd1.addressline1=ccd.addressline1;
                    cd1.addressline2=ccd.addressline2;
                    cd1.cc_limit=ccd.cc_limit;
                }
            }
            File file=new File("ccd_cu.bin");
            try
            {
                FileOutputStream fo=new FileOutputStream(file);
                ObjectOutputStream oos=new ObjectOutputStream(fo);
                for(CreditCard_details cd1:ec.c1)
                {
                    oos.writeObject(cd1);
                    oos.close();
                }
            }catch(Exception e){}
            System.out.println("Account is Modified");
        }
        else
        {
            System.out.println("Account doesn't exist!!!");
        }
    }
    
}

package banking;
import java.io.*;
public class Modify_details
{
    void Modify(long n)
    {
        int flag=0;
        Enter_details ed=new Enter_details();
        ed.retarr();
        for(Loan_details l:ed.C1)
        {
            if(l.L_id==n)
            {
                flag=1;
            }
        }
        if(flag==1)
        {
            Loan_details ld=new Loan_details();
            ld.details();
            for(Loan_details l1:ed.C1)
            {
                if(l1.L_id==n)
                {
                    l1.name=ld.name;
                    l1.phNo=ld.phNo;
                    l1.addressline1=ld.addressline1;
                    l1.interest_rate=ld.interest_rate;
                    l1.principle=ld.principle;
                    l1.years=ld.years;
                }
            }
            File file=new File("lo_cu.bin");
            try
            {
                FileOutputStream fo=new FileOutputStream(file);
                ObjectOutputStream oos=new ObjectOutputStream(fo);
                for(Loan_details l:ed.C1)
                {
                    oos.writeObject(l);
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

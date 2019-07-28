package banking;
import java.io.*;
public class Delete_details
{
    public void delete(long n)
    {
        int flag=0;
        Enter_details ed=new Enter_details();
        ed.retarr();
        File file=new File("lo_cu.bin");
        try
        {
            FileOutputStream fo=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(fo);
            for(Loan_details ld:ed.C1)
            {
                if(ld.L_id!=n)
                {
                    oos.writeObject(ld);
                }
                else
                {
                    flag=1;
                }
            }
            oos.close();
            if(flag==1)
            {
                System.out.println("Account Deleted!!!");
            }
            else
            {
                System.out.println("Account Doesn't Exist!!");
            }
        }catch(Exception e){}
    }
}

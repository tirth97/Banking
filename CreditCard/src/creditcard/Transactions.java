package creditcard;
import java.util.*;
import java.io.*;
public class Transactions implements Serializable
{
    Scanner in=new Scanner(System.in);
    String company;
    long amount;
    int limit;
    short dd, mm, yyyy;
    public void transcation_details()
    {
        System.out.println("Enter the Credit Card Number: ");
        System.out.println("Enter the name of the company to which payment was done: ");
        company=in.nextLine();
        System.out.println("Enter the amount paid to the company: ");
        amount=in.nextInt();
        System.out.println("Enter date of payment: ");
        System.out.println("dd: ");
        dd=in.nextShort();
        System.out.println("mm: ");
        mm=in.nextShort();
        System.out.println("yyyy: ");
        yyyy=in.nextShort();
    }
    
    public void display_details()
    {
        System.out.println("Amount paid to: "+company);
        System.out.println("Amount: "+amount);
        System.out.print("Date of payment: "+dd+"/"+mm+"/"+yyyy);
    }
    
    public void transaction(long cc)
    {
        boolean flag=false;
        File file=new File("transaction_cu")
            Transactions t=new Transactions();
            t.transcation_details();
            Write_Transactions wt=new Write_Transactions();
            wt.Transactions_read(t);
    }
    
    public void transactions_display()
    {
        
    }
    
}    

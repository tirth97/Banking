package banking;
import java.util.*;
import java.io.*;
public class Loan_Payment
{
    Scanner in=new Scanner(System.in);
    double amount;
    int dd,mm,yy;
    void payment_details()
    {
        System.out.println("------Payment Zone-------");
        System.out.println("Enter Amount Paid: ");
        this.amount=in.nextLong();
        System.out.println("Today's Date:");
        System.out.println("dd: ");
        this.dd=in.nextInt();
        System.out.println("mm: ");
        this.mm=in.nextInt();
        System.out.println("yy: ");
        this.yy=in.nextInt();
    }
    
    void payment()
    {
        
    }
}

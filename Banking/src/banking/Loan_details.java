package banking;
import java.io.*;
import java.util.*;
public class Loan_details implements Serializable
{
    Scanner in=new Scanner(System.in);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String name;
    int phNo,years,dd,mm,yy;
    String addressline1;
    String addressline2;
    long principle;
    long down_payment;
    long L_id=1345;
    double interest_rate;
    double emi;
    void details()
    {
        try
        {
            System.out.println("Name: ");
            this.name=br.readLine();
            System.out.println("Address Line 1: ");
            this.addressline1=br.readLine();
            System.out.println("Address Line 2: ");
            this.addressline2=br.readLine();
            this.addressline1=addressline1.concat(addressline2);
            System.out.println("Principle Amount: ");
            this.principle=in.nextLong();
            System.out.println("Down Payment");
            this.down_payment=in.nextLong();
            System.out.println("Interest Rate: ");
            this.interest_rate=in.nextDouble();
            System.out.println("Number of years: ");
            this.years=in.nextInt();
            System.out.println("Phone Number: ");
            this.phNo=in.nextInt();
            System.out.println("Enter the Date: ");
            System.out.println("dd:");
            this.dd=in.nextInt();
            System.out.println("mm:");
            this.mm=in.nextInt();
            System.out.println("yy:");
            this.dd=in.nextInt();
            String i=in.nextLine();
            this.emi=emi_noC(principle,down_payment,interest_rate,years);
        }catch(Exception e){}   
    }
    void display_details()
    {
        System.out.println("Name: "+name);
        System.out.println("Address: "+addressline1+"\n"+addressline2);
        System.out.println("Phone Number: "+phNo);
        System.out.println("Priciple Amount: "+principle);
        System.out.println("Years: "+years);
        System.out.println("Interest Rate: "+interest_rate);
        System.out.println("Down Payment: "+down_payment);
        System.out.println("EMI: "+emi);
    }
    void create()
    {
        Loan_details l1=new Loan_details();
        l1.details();
        Enter_details l2=new Enter_details();
        l2.add(l1);
    }
    
    void delete()
    {
        System.out.println("Ente the number to be deleted: ");
        long n=in.nextLong();
        Delete_details dd=new Delete_details();
        dd.delete(n);
    }
    
    void modify()
    {
        System.out.println("Enter the Loan ID you want to modify account of: ");
        Long n=in.nextLong();
        Modify_details md=new Modify_details();
        md.Modify(n);
    }

    public double emi_noC(long principle,long down_payment,double interest_rate,int years)
    {
        double eyi=((principle-down_payment)*(1+(interest_rate/100))/years);
        return (eyi/12.0);
    }
    
    double emi(Loan_details l)
    {
        double eyi=((l.principle-l.down_payment)*(1+(l.interest_rate/100))/l.years);
        return (eyi/12.0);
    }
    
    void emi_search(long n)
    {
        details_read dr=new details_read();
        double emi=dr.read_emi(n);
        System.out.println("EMI: "+emi);
    }
    
    void readall()
    {
        details_read dr=new details_read();
        dr.read();
    }
    
    void read()
    {
        details_read dr=new details_read();
        System.out.println("Enter the Loan ID: ");
        long n=in.nextLong();
        dr.read1(n);
    }
    
    public int randInt(int min,int max)
    {
        Random rand=new Random(); 
        int randomNum=rand.nextInt(max-min+1)+min;
        return randomNum;
    }
    
    long loan_number()
    {
        int i;
        int n;
        for(i=4;i<=13;i++)
        {
            n=randInt(0,9);
            L_id=L_id*10+n;
        }   
        return L_id;
    }
    
}

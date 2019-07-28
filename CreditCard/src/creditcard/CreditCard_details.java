package creditcard;
import java.util.*;
import java.io.*;
public class CreditCard_details implements Serializable
{
    Scanner in=new Scanner(System.in);
    String name;
    public String address,addressline1,addressline2,cc_type,b;
    public int cc_num,ph_no,cc_limit;
    public void card_details()
    {
        System.out.print("Name: ");
        name=in.nextLine();
        System.out.print("\nAddress Line 1: ");
        addressline1=in.nextLine();
        System.out.print("\nAddress Line 2: ");
        addressline2=in.nextLine();
        address=addressline1+addressline2;
        System.out.print("\nPhone Number: ");
        ph_no=in.nextInt();
        b=in.nextLine();
        System.out.println("\nEnter the type of credit card: ");
        cc_type=in.nextLine();
        setlimit();
        cc_number();
        System.out.println("Credit Card Number is: "+cc_num);
    }
    
    void display_ccd()
    {
        System.out.println("Name: "+name);
        System.out.println("Address: "+addressline1+"\n"+addressline2);
        System.out.println("Phone Number: "+ph_no);
        System.out.println("Credit Card Type: "+cc_type);
        System.out.println("Credit Card Number: "+cc_num);
    }
    
    void read_ccd()
    {
        Details_read_ccd drc=new Details_read_ccd();
        System.out.println("Please enter the credit card number: ");
        long num=in.nextLong();
        drc.read1(num);
    }
    
    void ccdetails()
    {
        CreditCard_details cc=new CreditCard_details();
        cc.card_details();
        Enter_ccd ec=new Enter_ccd();
        ec.CreditCardDetails_read(cc);
    }
    
    void validate()
    {
        System.out.println("Enter monthly Income of the person: ");
        int income=in.nextInt();
        
    }
    
    public void setlimit()
    {
        if(cc_type=="platinum"||cc_type=="Platinum"||cc_type=="PLATINUM"||cc_type=="PLatinum")cc_limit=300000;
        else if(cc_type=="gold"||cc_type=="Gold"||cc_type=="GOLD"||cc_type=="GOld") cc_limit=200000;
        else if(cc_type=="silver"||cc_type=="Silver"||cc_type=="SILVER"||cc_type=="SIlver")cc_limit=100000;
        else if(cc_type=="premium"||cc_type=="Premium"||cc_type=="PREMIUM"||cc_type=="PRemium")cc_limit=25000;
    }
    
    
    
    void modify_ccd()
    {
        System.out.println("Enter the Credit Card Number: ");
        long num=in.nextLong();
        Modify_details_ccd mdc=new Modify_details_ccd();
        mdc.Modify(num);
    }
    
    public int randInt(int min,int max)
    {
        Random rand=new Random(); 
        int randomNum=rand.nextInt(max-min+1)+min;
        return randomNum;
    }
    
    void cc_number()
    {
        int i,n;
        cc_num=0;
        for(i=0;i<13;i++)
        {
            cc_num=cc_num*10+randInt(0,9);
        }
    }
}
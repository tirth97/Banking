package banking;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class account implements Serializable{
   long acc_num;
   long contact_num;
   long balance;
   int acc_type;
   double interest_rate;
   int dd,mm,yy;
   String name;
   String address1;
   String address2;
   String address;
   String account_type;
   //-----------------------------------------
   public void get_details()
   {        
     Scanner tk=new Scanner(System.in);
     System.out.println("----ENTER YOUR DETAILS------");
     System.out.println("ENTER YOUR FULL NAME           :");
     name=tk.nextLine();
     System.out.println("ENTER YOUR RESIDENTIAL ADDRESS : ");
     System.out.println("address line 1 :");
     address1=tk.nextLine();
     System.out.println("address line 2 :");
     address2=tk.nextLine();
     address=address1+" "+address2;
     System.out.println("ENTER YOUR CONTACT NUMBER :");
     contact_num=tk.nextLong();
     System.out.println("ENTER DATE OF OPENING     :" );
     System.out.println("dd : ");
     dd=tk.nextInt();
     System.out.println("mm : ");
     mm=tk.nextInt();
     System.out.println("yy : ");
     yy=tk.nextInt();
     acc_num=generate();
     System.out.println("ENTER THE ACCOUNT TYPE YOU WANT TO CREATE :");
     System.out.println("press 1 for savings account");
     System.out.println("press 2 for current account");
     System.out.println("press 3 for fixed deposit");
     System.out.println("ENTER HERE : ");
     acc_type=tk.nextInt();
     if(acc_type==1)
       {interest_rate=3.15;account_type="SAVINGS ACC.";}
     if(acc_type==2)
     {interest_rate=0;account_type="CURRENT ACC.";}
     if(acc_type==3)
       {
        account_type="FIXED DEPOSIT";
        System.out.println("enter the DURATION for FD : ");
        int FD_duration;         
        FD_duration=tk.nextInt();
        if(FD_duration==1)
            interest_rate=8.5;
        if(FD_duration==2)
            interest_rate=9.0;
        if(FD_duration==3)
            interest_rate=9.5;
        if(FD_duration==4)
            interest_rate=10.0;
        if(FD_duration==5)
            interest_rate=10.5;
       }
       System.out.println("ENTER THE INITIAL AMOUNT TO BE DEPOSITED ");
       balance=tk.nextLong();
       while(balance<1000 && acc_type==1)
       {
        System.out.println("REQUIRES A MINIMUM BALANCE OF RS. 1000");
        balance=tk.nextLong();      
       }
   } 
   public void display_details()
   {
    System.out.println("--------ACCOUNT DETAILS--------");
    System.out.println("OPENING DATE   : "+dd+"-"+mm+"-"+yy);
    System.out.println("ACCOUNT NUMBER : "+acc_num);
    System.out.println("ACCOUNT NAME   : "+name);
    System.out.println("ADDRESS        : "+address);
    System.out.println("CONTACT NUMBER : "+contact_num);
    System.out.println("ACCOUNT TYPE   : "+account_type);
    System.out.println("INTEREST RATE  : "+interest_rate+"% p.a.");
    System.out.println("BALANCE        : "+balance);
       
   }
   public void crt() throws IOException
   {
    account a1=new account();
    a1.get_details();
    acc_write a2=new acc_write();
    a2.add(a1);
   }
   public void viewall() throws IOException
   {
    acc_read r=new acc_read();
    r.rd();
   }     
   public void view() throws IOException
   {
    Scanner tk=new Scanner(System.in);
    acc_read r=new acc_read();
    long n;
    System.out.println("ENTER ACCOUNT NUMBER TO BE SEARCHED : ");
    n=tk.nextLong();
    r.rd1(n);
   }       
   public void del()
   {
    Scanner tk=new Scanner(System.in);
    System.out.println("ENTER ACCOUNT NUMBER TO BE DELETE : ");
    long n;
    n=tk.nextLong();
    delete d=new delete();
    d.remove(n);
   }
   public void mod() throws IOException
   {
    Scanner tk=new Scanner(System.in);
    System.out.println("ENTER ACCOUNT NUMBER TO BE MODIFIED : ");
    long n;
    n=tk.nextLong();
    acc_modify am=new acc_modify();
    am.modify(n);
   }        
   public int randInt(int min,int max)
   {
    Random rand=new Random(); 
    int randomNum=rand.nextInt(max-min+1)+min;
    return randomNum;
   }
   public long generate()
   {
    long i=0,num=1234;
    int n;
    for(i=4;i<=13;i++)
    {
     n=randInt(0,9);
     num=num*10+n;    
    }   
    return num;
   }        

}
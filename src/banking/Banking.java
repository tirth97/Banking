package banking;
import java.util.Scanner;
import java.io.IOException;
public class Banking {
   public static void main(String[] args) throws IOException, ClassNotFoundException {
       account a=new account();
       System.out.println("\t\t\t****************WELCOME TO BANK*******************");
       int ch,ch1;
       int pin=1234;
       int p;
       Scanner tk=new Scanner(System.in);
       do
       {    
        System.out.println("\t\t------------ACCOUNT ZONE--------------");
        System.out.println("\t\tPRESS :");
        System.out.println("\t\t1. CREATE ACCOUNT");
        System.out.println("\t\t2. GET ACCOUNT DETAILS OF ALL ACCOUNTS");
        System.out.println("\t\t3. GET ACCOUNT DETAILS OF REQUIRED ");
        System.out.println("\t\t4. TO DELETE ACCOUNT ");
        System.out.println("\t\t5. TO MODIFY ACCOUNT");
        System.out.println("\t\t---------TRANSACTION ZONE--------------");
        System.out.println("\t\t6. CASH DEPOSIT");
        System.out.println("\t\t7. CASH WITHDRAW");
        System.out.println("\t\t8. BALANCE TRANSFER");
        System.out.println("\t\t----------INTEREST ZONE----------------");
        System.out.println("\t\t9. CREDIT INTEREST");
        System.out.println("\t\t-----------STATEMENT ZONE--------------");
        System.out.println("\t\t10. GENERATE ALL TRANSACTION STATEMENT");
        System.out.println("\t\t11. GENERATE PARTICULAR TRANSACTION STATEMENT");
        System.out.print("ENTER CHOICE : ");
        ch=tk.nextInt();
        switch(ch)
        {
           case 1 : 
                    System.out.print("\n------CREATE ACCOUNT-----");
                    a.crt();break;
           case 2 : 
                    System.out.println("------ALL EXISTING ACCOUNTS-----");
                    a.viewall();break;
           case 3 : 
                    System.out.println("------REQUIRED ACCOUNT-----");
                    a.view();break;
           case 4 : 
                    System.out.println("------REQUIRED ACCOUNT-----");
                    a.del();break;
           case 5 : 
                    System.out.println("------MODIFY ACCOUNT-----");
                    a.mod();break;
           //deposit
           case 6:
               System.out.println("------DEPOSIT AMOUNT-----");
               transaction trans=new transaction();
               long n,c;
               System.out.println("ENTER ACCOUNT NUMBER FOR TRANSACTION    :");
               n=tk.nextLong();
               System.out.println("ENTER CASH AMOUNT NEED TO BE DEPOSITED  :");
               c=tk.nextLong();
               trans.w_d(n,1,c);
               break;
           //withdraw
           case 7:
               System.out.println("------WITHDRAW AMOUNT-----");
               transaction trans1=new transaction();
               long n1,c1;
               System.out.println("ENTER ACCOUNT NUMBER FOR TRANSACTION    :");
               n=tk.nextLong();
               System.out.println("ENTER CASH AMOUNT NEED TO BE WITHDRAWN  :");
               c=tk.nextLong();
               trans1.w_d(n,2,c);
               break;
           //transfer    
           case 8 :
               System.out.println("------TRANSFER AMOUNT-----");
               transaction trans2=new transaction();
               long M,N,C;
               System.out.println("ENTER THE ACCOUNT FROM WHICH TRANSACTION IS TO BE MADE ");
               M=tk.nextLong();
               System.out.println("ENTER THE ACCOUNT TO WHICH TRANSACTION IS TO BE MADE ");
               N=tk.nextLong();
               System.out.println("ENTER THE AMOUNT TO BE TRANSACTED");
               C=tk.nextLong();
               trans2.transfer(M,N,C);
               break;
           //interest 
           case 9 :
               System.out.println("------CREDIT INTEREST-----");
               give_interest interest=new give_interest();
               System.out.println("ENTER TODAYS DATE : ");
               int dd,mm,yy;
               System.out.println("dd :");
               dd=tk.nextInt();
               System.out.println("mm :");
               mm=tk.nextInt();
               System.out.println("yy :");
               yy=tk.nextInt();
               interest.g_i(dd,mm,yy);
               break;
           case 10 :
                trans_details t=new trans_details();
                t.get_statements();
                break;
           case 11 :
                stat s1=new stat();
                Scanner tk1=new Scanner(System.in);
                String p1=new String();
                System.out.println("ENTER THE ACC. NUM : ");
                p1=tk1.nextLine();
                s1.generate_stat(p1);
                break;    
           default :
               System.out.println("invalid choice!!!! TRY AGAIN");
        }
        System.out.println("PRESS 0 TO EXIT AND 1 TO RETURN TO MAIN MENU");
        ch1=tk.nextInt();  
        }while(ch1!=0);
        
        System.out.println("--------------BANK EXITED !!!!--------------");
}
}
package creditcard;
import java.util.*;
import java.io.*;
public class CreditCard
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        CreditCard_details ccd=new CreditCard_details();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i,j;
        do
        {
            //Main Menu
            System.out.println("Select the choice you want to transact in: ");
            System.out.println("1. Check if the customer can get credit card.");
            System.out.println("2. Enter new Credit Card Details.");
            System.out.println("3. View customer's credit card details.");
            System.out.println("4. Modify existing customer's details.");
            System.out.println("");
            System.out.println("Select anyone of the following choices: ");
            int choice=in.nextInt();
            //Choosing from the following
            switch(choice)
            {
                case 1:
                    System.out.println("------Validation Zone------");
                    ccd.validate();
                    break;
                case 2:
                    System.out.println("--------Creating new Credit Card Customer------");
                    ccd.ccdetails();
                    break;
                case 3:
                    System.out.println("--------Displaying Details-------");
                    ccd.read_ccd();
                    break;
                case 4:
                    System.out.println("--------Transactions---------");
                    break;
            }
            System.out.println("Enter 1 to continue to main menu or 0 to quit: ");
            i=in.nextInt();
        }while(i==1);
    }
    
}

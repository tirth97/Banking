package banking;
import java.io.*;
import java.util.*;
public class Banking 
{
    public static void main(String[] args) throws Exception
    {
        Loan_details L=new Loan_details();
        Loan_Payment lp=new Loan_Payment();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner in=new Scanner(System.in);
        boolean b=true;
        while(b)
        {
            System.out.println("--------Loan Details----------");
            System.out.println("1. Enter new loan detail.");
            System.out.println("2. Display exsisting loan Details.");
            System.out.println("3. Delete a loan detail");
            System.out.println("4. EMI Calculator");
            System.out.println("5. Modify Amount Paid.");
            System.out.println("6. Loan amount payment.");
            System.out.println();
            System.out.println("Enter anyone of the following choice: ");
            int choice=Integer.parseInt(br.readLine());

            switch (choice)
            {
                case 1:
                    System.out.println("------Creating Loan Details-------");
                    L.create();
                    break;
                case 2:
                    System.out.println("------Existing Loan Details-------");
                    System.out.println("1. Loan details of all Loan Holders.");
                    System.out.println("2. Loan Details of a specific Loan Holder.");
                    System.out.println("Choose anyone of the following option: ");
                    int choi=in.nextInt();
                    switch(choi)
                    {
                        case 1:
                            L.readall();
                            /*if(s.charAt(0)=='Y'||s.charAt(0)=='y')continue;
                            else
                            {
                                b=false;
                            }*/
                            break;
                        case 2:
                            L.read();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("-------Deleting Loan Detail-------");
                    L.delete();
                    break;
                case 4:
                    System.out.println("------EMI Calcualator------");
                    System.out.println("1. Calculate EMI by giving principle amount and interest rate.");
                    System.out.println("2. Calcualte EMI of an existing account.");
                    System.out.println("Select anyone of the following:");
                    choi=in.nextInt();
                    switch (choi)
                    {
                        case 1:
                            System.out.println("Interest Rate: ");
                            double interest_rate=in.nextDouble();
                            System.out.println("Principle Amount: ");
                            int principle=in.nextInt();
                            System.out.println("Down Payment:");
                            int down_payment=in.nextInt();
                            System.out.println("Years: ");
                            int years=in.nextInt();
                            double emi=L.emi_noC(principle,down_payment,interest_rate,years);
                            System.out.println("EMI: Rs "+emi);
                            break;
                        case 2:
                            System.out.println("Please Enter the Customer's Loan ID: ");
                            long l_id=in.nextLong();
                            L.emi_search(l_id);
                            break;
                    }
                    break;
                case 5:
                    System.out.println("----------Modify Account--------");
                    L.modify();
                    break;
                case 6:
                    lp.payment();
                    break;
            }
        }
    }
    
}

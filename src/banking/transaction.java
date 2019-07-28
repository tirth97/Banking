package banking;
import java.io.File;
import java.util.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
public class transaction {
    void w_d(long n,int t,long cash) throws ClassNotFoundException
   {
     int flag=0,f=1;
     String d_t; 
     Scanner tk=new Scanner(System.in);
     int d,m,y,h,mi;
     acc_write wr=new acc_write();
     wr.retarr();
     for(account x: wr.S2)
     {
      if(x.acc_num==n)
          flag=1;
     }
     if(flag==1)
     {    
      
      for(account x :wr.S2)
      {
       if((x.acc_num==n)&&(x.acc_type==3))
       {System.out.println("FIXED DEPOSITS CANNOT BE MODIFIED");break;}
       if((x.acc_num==n)&&(x.acc_type!=3))
       {
       System.out.println("ENTER CURRENT DATE ");
       System.out.println("dd :");
       d=tk.nextInt();
       System.out.println("mm :");
       m=tk.nextInt();
       System.out.println("yy :");
       y=tk.nextInt();
       System.out.println("ENTER CURRENT TIME :");
       System.out.println("hh :");
       h=tk.nextInt();
       System.out.println("mm :");
       mi=tk.nextInt();
       if(t==1)
       {
         System.out.println("TRANSACTION SUCCESSFUL !!!!");
           trans_details td;
           td = new trans_details(n,cash,d,m,y,h,mi,"deposit");
           td.generate_stats(td);
           x.balance+=cash;
           System.out.println("YOUR CURRENT BALANCE IS : "+x.balance);
          }
          else
          {
           if((x.acc_type==1) && (x.balance>cash) && (x.balance-cash>=1000)) 
           { 
            System.out.println("TRANSACTION SUCCESSFUL !!!!");
            x.balance-=cash;
            System.out.println("YOUR CURRENT BALANCE IS : "+x.balance);
           }
           else if(x.balance>cash && (x.acc_type!=1))
           {
            System.out.println("TRANSACTION SUCCESSFUL !!!!");
            x.balance-=cash;
            System.out.println("YOUR CURRENT BALANCE IS : "+x.balance);
           }
           else
           {
            System.out.println("TRANSACTION UNSUCCESSFUL !!!!");   
            System.out.println("INSUFFICIENCENT BALANCE !!!!");
           }   
          }    
       }
          
      } 
       File file=new File("acc.bin");
         try{
         FileOutputStream fo=new FileOutputStream(file);
         ObjectOutputStream fout=new ObjectOutputStream(fo);  
          for(account x: wr.S2)
           fout.writeObject(x);
           fout.close();
          }
          catch(Exception e){} 
         }
       else
       System.out.println("ACCOUNT DOES NOT EXIST !!!!");
    }
    void transfer(long n1,long n2,long cash)
    {
     int flag1=0,flag2=0,f=1;
     acc_write wr=new acc_write();
     wr.retarr();
     for(account x: wr.S2)
     {
      if(x.acc_num==n1)
          flag1=1;
      if(x.acc_num==n2)
          flag2=1;
     }
     if((flag1==1)&&(flag2==1))
     {    
      for(account x: wr.S2)
      {
       if((x.acc_num==n1)&&(x.acc_type!=3))
       {
        if(x.balance-cash>=1000 && x.acc_type==1)
        {
         x.balance-=cash;
        }    
        else if((x.balance>=cash)&&(x.acc_type !=1))
        {
        x.balance-=cash;
        }
        else
        {
          System.out.println("TRANSACTION UNSUCCESSFUL !!!!");
          System.out.println("INSUFFICIENT BALANCE !!!!");
          break;
        }  
       }
       if((x.acc_num==n1)&&(x.acc_type==3)) 
         {System.out.println("FD CAN'T BE MODIFIED");f=0;break;}
       if((x.acc_num==n2)&&(x.acc_type!=3))
       {
        x.balance+=cash;
       }
       if((x.acc_num==n2)&&(x.acc_type==3))
        {System.out.println("FD CAN'T BE MODIFIED");f=0;break;}
      }
      if(f==1)
       System.out.println("TRANSACTION SUCCESSFUL FROM ACCOUNT 1 TO ACCOUNT 2");
      File file=new File("acc.bin");
      try{
         FileOutputStream fo=new FileOutputStream(file);
         ObjectOutputStream fout=new ObjectOutputStream(fo);  
         for(account x: wr.S2)
           fout.writeObject(x);
           fout.close();
         }
       catch(Exception e){} 
     }
     else if((flag1==0)&&(flag2==0))
       System.out.println("ACCOUNT 1&2 DOES NOT EXIST !!!!");
     else if(flag2==0)
       System.out.println("ACCOUNT 2 DOES NOT EXIST !!!!");
     else
       System.out.println("ACCOUNT 1 DOES NOT EXIST !!!!");  
    }
   }        


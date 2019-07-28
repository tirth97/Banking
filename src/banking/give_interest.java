package banking;
import java.io.*;
public class give_interest {
    int cnt_days(int cd,int cm,int cy,int dd,int mm,int yy)
	 {
	  int d;
	  d=cd-dd;
	  if(mm>cm)
            {mm+=12;yy++;}
	  for(int i=mm;i<cm;i++)
	  {
	   if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12)
		d+=31;
	   else if(i==4 || i==6 || i==9 || i==11)
		d+=30;
	   else
		d+=28;
	   }
	  d+=(cy-yy)*365;
	  return d;
	 }
    void g_i(int cd,int cm,int cy)
    {
     acc_write w=new acc_write();
     w.retarr();
     for(account x :w.S2)
     {
      int d=cnt_days(cd,cm,cy,x.dd,x.mm,x.yy);
      int n=d/365;
      long p=x.balance;
      x.balance=p+(long)(p*(x.interest_rate)*n*.01);
     }
     File file=new File("acc.bin");
     try{
        FileOutputStream fo=new FileOutputStream(file);
        ObjectOutputStream fout=new ObjectOutputStream(fo);  
        for(account x: w.S2)
           fout.writeObject(x);
           fout.close();
        }
       catch(Exception e){}
       System.out.println("INTEREST CREDITED TO ALL ACCOUNTS !!!!");
     }
    }        
       


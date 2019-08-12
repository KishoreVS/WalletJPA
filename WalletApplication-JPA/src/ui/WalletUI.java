package ui;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import bean.Transactions;
import bean.WalletBean;
import service.WalletService;
import service.WalletServiceI;

public class WalletUI {
public static void main(String[] args) throws Exception {
	int ch;
	char c;
	
	WalletServiceI ws=new WalletService();
	do
	{
		
	System.out.println("************\tBANK WALLET APPLICATION\t*************");
	System.out.println("1.Create Account");
	System.out.println("2.Balance Enquiry");
	System.out.println("3.Deposit");
	System.out.println("4.Withdrawal");
	System.out.println("5.Fund Transfer");
	System.out.println("6.Print Transactions");
	System.out.println("Enter your choice");
	Scanner s=new Scanner(System.in);
	ch=s.nextInt();
	switch(ch)
	{
	case 1:
	{	
		System.out.println("Enter your name:");
		String name=ws.nameCheck(s.next());
		System.out.println("Enter your mobile number:");
		String num=ws.mobCheck(s.next());
		Integer r=getRandomNumberInRange(32312,525253);
		long accNo=r;
		System.out.println("Enter amount to create Account");
		double balance=s.nextDouble();
		System.out.println("Account Creation Complete ");
		System.out.println("Account Details\n_________________\nAccount Number:"+accNo);
		System.out.println("Account Holder Name:"+name);
		System.out.println("Balance:"+balance);
		ws.createAccount(accNo,name,num,balance);
		break;
	}
	case 2:
	{	
		System.out.println("Enter your Account Number:");
		long accNo=s.nextLong();
		double bal=ws.balanceEnquiry(accNo);
		System.out.println("Balance:"+bal);
		break;
	}
	case 3:
	{	
		System.out.println("Enter your Account Number:");
		long accNo=s.nextLong();
		System.out.println("Enter deposit Amount");
		double dep=s.nextDouble();
		double bal=ws.deposit(accNo,dep);
		System.out.println("Amount Deposited\nUpdated Balance:"+bal);
		break;
	}
	case 4:
	{	
		System.out.println("Enter your Account Number:");
		long accNo=s.nextLong();
		System.out.println("Enter Withdrawal Amount");
		double wAmt=s.nextDouble();
		double bal=ws.withdrawal(accNo,wAmt);
		System.out.println("Withdrawal Complete\nUpdated Balance:"+bal);
		break;
	}
	case 5:
	{	
		System.out.println("Enter your Account Number:");
		long accNo=s.nextLong();
		System.out.println("Enter Receipent's Account Number");
		String ran=s.next();
		System.out.println("Enter Transfer Amount");
		double tAmt=s.nextDouble();
		double bal=ws.transfer(accNo,ran,tAmt);
		System.out.println("Transaction Complete...\n"+tAmt+" transferred from "+accNo+" to "+ran+"\nUpdatedBalance:"+bal);
		break;
	}
	case 6:
	{	
		System.out.println("Enter your Account Number:");
		String accNo=s.next();
		List<?> l=ws.miniStatement(accNo);
		Iterator<?> i=l.iterator();
		{
			while(i.hasNext())
			{
				Transactions ts=(Transactions) i.next();
				System.out.println("Transaction ID:"+ts.getTransId());
				System.out.println("Account From:"+ts.getAccNoFrom());
				System.out.println("Account To:"+ts.getAccNoTo());
				System.out.println("Transaction Type:"+ts.gettType());
				System.out.println("Amount:"+ts.getAmt());
				System.out.println("Balance:"+ts.getBalance());
			}
		}
		break;
	}
	default:
		System.out.println("Exitting Application");
		System.exit(0);
	}
	System.out.println("Do you want to continue(y/n)");
	c=s.next().charAt(0);
	if(c=='y'||c=='Y')
		continue;
	else if(c=='n'||c=='N')
		System.out.println("Exiting from Wallet Application");
		break;
		
}while(ch!=6);

}

private static int getRandomNumberInRange(int min, int max) 
{

	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
}

}

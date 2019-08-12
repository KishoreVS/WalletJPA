package service;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.login.AccountNotFoundException;

import bean.Transactions;
import bean.WalletBean;
import dao.WalletDao;

public class WalletService implements WalletServiceI {

	WalletDao wd=new WalletDao();

	@Override
	public long createAccount(long accNo, String name, String num, double balance) {
		WalletBean wb = new WalletBean(accNo,name,num, balance);
		long acc=wd.createAccount(wb);
		return acc;
	}

	@Override
	public double balanceEnquiry(long accNo) {
		return wd.balanceEnquiry(accNo);
	}

	@Override
	public double deposit(long accNo, double dep){
		return wd.deposit(accNo, dep);
	}

	@Override
	public double withdrawal(long accNo, double wAmt){
		return wd.withdrawal(accNo, wAmt);
	}

	@Override
	public double transfer(long accNo, String ran, double tAmt){
		return wd.transfer(accNo, ran, tAmt);
	}

	@Override
	public ArrayList<Transactions> miniStatement(String accNo) {
		return wd.miniStatement(accNo);
	
	}

	public String nameCheck(String name) {
			if(name.matches("([A-Za-zA-Z])*"))
				return name;
			
			else 
				System.out.println("Name should only have alphabets.");
				System.out.println("Enter again: ");
				Scanner s=new Scanner(System.in);
				return name=s.next();
	}
	
	//	METHOD TO CHECK THE LENGTH OF MOBILE NUMBER
	public String mobCheck(String num) { 
		while(true) {
			if(String.valueOf(num).length() == 10) {
				return num;
				
			}
			
			else {
				System.out.println("Enter valid 10 digit mobile number.");
				Scanner s=new Scanner(System.in);
				num = s.next();
			}
		}
	}
}
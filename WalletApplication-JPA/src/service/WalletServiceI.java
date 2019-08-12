package service;

import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import bean.Transactions;
import bean.WalletBean;

public interface WalletServiceI {
	public double withdrawal(long accNo, double wAmt);
	public ArrayList<Transactions> miniStatement(String accNo);
	public String nameCheck(String name);
	public String mobCheck(String num);
	double balanceEnquiry(long accNo);
	double deposit(long accNo, double dep);
	double transfer(long accNo, String ran, double tAmt);
	public long createAccount(long accNo, String name, String num, double balance);
}

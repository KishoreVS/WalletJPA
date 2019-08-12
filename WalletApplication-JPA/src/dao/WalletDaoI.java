package dao;

import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import bean.Transactions;
import bean.WalletBean;

public interface WalletDaoI {
	public long createAccount(WalletBean wbCreateAccount);
	public double deposit(long accNo,double  dep);
	public ArrayList<Transactions> miniStatement(String accNo);
	double balanceEnquiry(long accNo);
	double withdrawal(long accNo, double wAmt);
	double transfer(long accNo, String ran, double tAmt);
}

package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import bean.Transactions;
import bean.WalletBean;

public class WalletDao implements WalletDaoI {
	EntityManager con;
	ConnectionDatabase cd=new ConnectionDatabase();
	WalletBean wb;

	@Override
	public long createAccount(WalletBean wbCreateAccount) {
		con=cd.getConnection();
		con.getTransaction().begin();
		con.persist(wb);
		con.getTransaction().commit();
		return wb.getAccNo();
		
	}   

	@Override
	public double balanceEnquiry(long accNo){
		con = cd.getConnection();
		con.getTransaction().begin();
		WalletBean wb=(WalletBean) con.find(WalletBean.class,new Long(accNo));
		con.getTransaction().commit();
		return wb.getBalance();
		
		
	}

	@Override
	public double deposit(long accNo, double dep){
		con.getTransaction().begin();
		WalletBean wb=(WalletBean) con.find(WalletBean.class,new Long(accNo));
		long str = wb.getAccNo();
	//	emp1.setTran(str);
		wb.setBalance(dep);
		con.merge(wb);con.getTransaction().commit();
		return wb.getBalance();
	}

	@Override
	public double withdrawal(long accNo, double wAmt) {
		con.getTransaction().begin();
		WalletBean wb=(WalletBean) con.find(WalletBean.class,new Long(accNo));
		long str = wb.getAccNo();
		wb.setBalance(wAmt);
		con.merge(wb);con.getTransaction().commit();
		return wb.getBalance();
		

	}

	@Override
	public double transfer(long accNo, String ran, double tAmt) {
		return wb.getBalance();

	}

	@Override
	public ArrayList<Transactions> miniStatement(String accNo) {
		return null;

	}

}

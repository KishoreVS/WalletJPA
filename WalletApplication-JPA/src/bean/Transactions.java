package bean;

import java.util.Random;

public class Transactions {
	private int transId;
	private String accNoFrom;
	private String accNoTo;
	private double amt;
	private double balance;
	private String tType;
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Transactions(int transId,String accNoFrom, String accNoTo, double amt, double balance,String tType) {
		this.accNoFrom=accNoFrom;
		this.accNoTo=accNoTo;
		this.transId=transId;
		this.amt=amt;
		this.balance=balance;
		this.tType=tType;
	}
	public Transactions() {
		// TODO Auto-generated constructor stub
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = rand(1000,9999);
	}
	public String getAccNoFrom() {
		return accNoFrom;
	}
	public void setAccNoFrom(String accNoFrom) {
		this.accNoFrom = accNoFrom;
	}
	public String getAccNoTo() {
		return accNoTo;
	}
	public void setAccNoTo(String accNoTo) {
		this.accNoTo = accNoTo;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	private static int rand(int min, int max) 
	{

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	public String toString()
	{
		return "AccNoFrom"+accNoFrom+"AccNoTo"+accNoTo+"Amount"+amt+"Transaction ID"+transId+"Balance"+balance;
		
	}
}

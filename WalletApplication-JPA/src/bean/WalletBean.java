package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name="WalletApplication")
public class WalletBean {

	@Column
	private String name;
	@Column
	private String num;
	@Column
	private double balance;
	@Column
	private double dep;
	@Column
	private double tAmt;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long accNo;
	public WalletBean(long accNo, String name, String num, double balance) {
		this.accNo=accNo;
		this.name=name;
		this.num=num;
		this.balance=balance;
	}
	public WalletBean() {
	}
	//setters and getters
	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


}

package BankApplication.DAO;

public class Customer {
	private  int Account_no;
	private String name;
	private long Mobile_no;
	private int Pin;
	private String Address;
	private double balnece;
	public Customer() {
		super();
	}
	public Customer(long mobile_no, String name, int pin, String address, double balnece) {
		super();
		Mobile_no = mobile_no;
		this.name = name;
		Pin = pin;
		Address = address;
		this.balnece = balnece;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile_no() {
		return Mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		Mobile_no = mobile_no;
	}
	public int getPin() {
		return Pin;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getBalnece() {
		return balnece;
	}
	public void setBalnece(double balnece) {
		this.balnece = balnece;
	}
	public int getAccount_no() {
		return Account_no;
	}
	public void setAccount_no(int account_no) {
		Account_no = account_no;
	}
	
}

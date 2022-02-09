package dp.websocket.server.socket;


public class Customer {
	private String accountID;
	String Name;
	String Address;
	double Balance;
	
	
	public Customer(String name, String address, String accountID, double balance) {
		super();
		Name = name;
		Address = address;
		this.accountID = accountID;
		Balance = balance;
	}
	
	public Customer() {
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
	
	public String Show() {
		return "Name "+this.getName()+"  Address "+this.getAddress()
				+" Account id "+this.getAccountID()+" balance "+this.getBalance();
	}

	
	  public void debitAmount(double balance){
	        this.Balance=this.Balance-balance;
	    }
	

}

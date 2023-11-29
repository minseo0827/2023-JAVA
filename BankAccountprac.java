class BankAccount {
	private String owner;
	private int accountNumber;
	private int balance;
	//생성자
//	BankAccount(String owner, int accountNumner, int balanace)
//	{this.owner=owner;
//		this.accountNumber=accountNumber;
//		this.balance=balance;}
//	생성자의미가없는것같어...
	
	public void deposit(int amount) {balance=balance+amount;}
	public void withdraw(int amount) {balance=balance-amount;}
	//겟이랑 셋을 내가따로지정헤줘야한다고??이렇게길지않았던것같은데?? 아니다..따로지정하는게맞앗다...
	public void setBalance(int balance){ this.balance=balance;}
	public int getBalance() {return balance;}
	
	public String getOwner() {return owner;}
	public void setOwner(String owner){this.owner=owner;}
	
	public int getAccountNumber() {return accountNumber;}
	public void setAccountNumer(int accountNumber){this.accountNumber=accountNumber;}
}
public class BankAccountprac {

	public static void main(String[] args) {

		 BankAccount myBank = new BankAccount();
		 
		//private이니까 get이나 set을 써줘야한다는거지...
		 myBank.setOwner("Amy");
		 myBank.setAccountNumer(12341234);
		 myBank.setBalance(10000);
		 System.out.println("the money in now is "+myBank.getBalance());
		 myBank.deposit(100);
		 System.out.println("the money in now is "+myBank.getBalance());
		 }

}
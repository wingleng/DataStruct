package leetcod._2043;

public class Solution {
	public static void main(String[] args) {
		Bank bank = new Bank(new long[] {10,100,20,50,30});
		System.out.println(bank.withdraw(3, 10)); 
		System.out.println(bank.transfer(5, 1, 20));
		System.out.println(bank.deposit(5, 20));
		System.out.println(bank.transfer(3, 4, 15));
		System.out.println(bank.withdraw(10, 50));
	}
}

class Bank {
	long[] balance;
    public Bank(long[] balance) {
    	this.balance = new long[balance.length];
    	this.balance = balance;
//    	for(int i=0;i<balance.length;i++) {
//    		this.balance[i] = balance[i];
//    	}
    }
    
    public boolean transfer(int account1, int account2, long money) {
    	if(account1 > balance.length || account2 > balance.length || balance[account1 -1] <money) {
    		return false;}
    		balance[account1-1]-=money;
    		balance[account2-1]+=money;
    		return true;
    }
    
    public boolean deposit(int account, long money) {
    		if(account > balance.length) {
    			return false;
    		}
    		balance[account -1 ]+=money;
    		return true;
    }
    
    public boolean withdraw(int account, long money) {
    	if(account > balance.length || balance[account -1] < money) {
    		return false;
    	}
    	balance[account -1 ]-=money;
    	return true;
    }
    

}

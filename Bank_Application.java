package SBI;
import java.util.Scanner;

public class Bank_Application {

	private String accno;
	private String name;
	private String acc_type;
	private long balance;
	Scanner sc=new Scanner(System.in);
	public void openAccount()
	{
		System.out.println("Enter Account Number:");
		accno=sc.nextLine();
		System.out.println("Enter Account holder name:");
		name=sc.nextLine();
		System.out.println("Enter Account type:");
		acc_type=sc.nextLine();
		System.out.println("Enter balance:");
		balance=sc.nextLong();
		
	}
	public void showAccount()
	{
		System.out.println("Name of Account holder is:"+name);
		System.out.println("Number of Account holder is:"+accno);
		System.out.println("Account type :"+acc_type);
		System.out.println("Balance is:"+balance);

	}
	public void deposit()
	{
		long amt;
		System.out.println("Enter how much amount do you want to deposit:");
		amt=sc.nextLong();
		balance=balance+amt;
		System.out.println("After deposit balance Is:"+amt);
	}
	public void withdrawl()
	{
		long amt;
		System.out.println("Enter how much amount do you want to withdrawl:");
		amt=sc.nextLong();
		if(balance>=amt)
		{
			balance=balance-amt;
			System.out.println("After withdrwal balnce is:"+balance);

		}
		else
		{
			System.out.println("your balabe is less than:"+amt+" Transaction failed!");
			
		}
		
	}
	public boolean search(String ac_no)
	{
		if(accno.equals(ac_no))
		{
			showAccount();
			return(true);
		}
		return false;
	}
}


class Bank_Form {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("How many number of accounts do you want enter:");
		int n=sc.nextInt();
		Bank_Application B[]=new Bank_Application[n];
		for(int i=0;i<B.length;i++)
		{
			B[i]=new Bank_Application();
			B[i].openAccount();
		}
		int ch;
		do
		{
			System.out.println("\n**Banking System Application**");
			System.out.println("1.Display all account details\n2.search by Account number\n3.Depost Amount\n4.Withdraw amount\n5.Exit");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				for(int i=0;i<B.length;i++)
				{
					B[i].showAccount();
				}
			break;
			case 2:
				System.out.println("Enter Account number you want to search:");
				String ac_no=sc.next();
				boolean found=false;
				for(int i=0;i<B.length;i++)
				{
					found=B[i].search(ac_no);
					if(found)
					{
						break;
					}
				}
				if(!found)
				{
					System.out.println("Serach failed account doesn't exist");
					
				}
			break;
			case 3:
				System.out.println("Enter Account number:");				ac_no=sc.next();
				found=false;
				for(int i=0;i<B.length;i++)
				{
					found=B[i].search(ac_no);
					if(found)
					{
						B[i].deposit();
						break;
					}
				}
				if(!found)
				{
					System.out.println("Serach failed account doesn't exist");
					
				}
			break;
			case 4:
				System.out.println("Enter Account number you want to withdraw:");
				ac_no=sc.next();
				found=false;
				for(int i=0;i<B.length;i++)
				{
					found=B[i].search(ac_no);
					if(found)
					{
						B[i].withdrawl();
						break;
					}
				}
				if(!found)
				{
					System.out.println("Serach failed account doesn't exist");
					
				}
			break;
			case 5:
				System.out.println("Thankyou for using See you soon exiting applivation...");
				break;
			}
		}
		while(ch!=5);

	}

}

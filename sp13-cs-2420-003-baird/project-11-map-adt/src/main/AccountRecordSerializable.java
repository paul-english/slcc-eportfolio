package main;

// Fig. 14.17: AccountRecordSerializable.java
// A class that represents one record of information.
// package com.deitel.jhtp7.ch14; // packaged for reuse

import java.io.Serializable;

@SuppressWarnings("serial")
public class AccountRecordSerializable implements Serializable,
		Comparable<AccountRecordSerializable>
{

	private int account;
	private double balance;
	private String firstName;
	private String lastName;

	// no-argument constructor calls other constructor with default values
	public AccountRecordSerializable()
	{
		this(0, "", "", 0.0);
	} // end no-argument AccountRecordSerializable constructor

	// four-argument constructor initializes a record
	public AccountRecordSerializable(int acct, String first, String last,
			double bal)
	{
		this.setAccount(acct);
		this.setFirstName(first);
		this.setLastName(last);
		this.setBalance(bal);
	} // end four-argument AccountRecordSerializable constructor

	@Override
	public int compareTo(AccountRecordSerializable o)
	{
		return this.getAccount() - o.getAccount();
	}

	// get account number
	public int getAccount()
	{
		return this.account;
	} // end method getAccount

	// get balance
	public double getBalance()
	{
		return this.balance;
	} // end method getBalance

	// get first name
	public String getFirstName()
	{
		return this.firstName;
	} // end method getFirstName

	// get last name
	public String getLastName()
	{
		return this.lastName;
	} // end method getLastName

	// set account number
	public void setAccount(int acct)
	{
		this.account = acct;
	} // end method setAccount

	// set balance
	public void setBalance(double bal)
	{
		this.balance = bal;
	} // end method setBalance

	// set first name
	public void setFirstName(String first)
	{
		this.firstName = first;
	} // end method setFirstName

	// set last name
	public void setLastName(String last)
	{
		this.lastName = last;
	} // end method setLastName

	@Override
	public String toString()
	{
		return this.getAccount() + ": " + this.getFirstName() + " "
				+ this.getLastName() + " - Balance: " + this.getBalance();
	}
} // end class AccountRecordSerializable

/*************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/

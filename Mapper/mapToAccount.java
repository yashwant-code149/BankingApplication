package com.example.demo.Mapper;

import com.example.demo.Convertor.AccountDto;
import com.example.demo.Entity.Account;

public class mapToAccount{

	  public static Account mapToAccount(AccountDto accountDto) {
		  
		  Account account = new Account(
				  accountDto.getId(),
				  accountDto.getAccountHolderName(),
				  accountDto.getBalance()
				  );
		  return account;
	  }
	  
	  public static AccountDto mapToAccountDto(Account account) {
		  
		  AccountDto accountDto = new AccountDto(
				  account.getId(),
				  account.getAccountHolderName(),
				  account.getBalance()
				  );
		return accountDto;
	  }
}
//mapToAccount
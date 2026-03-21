package com.example.demo.Service;

import java.util.List;

import com.example.demo.Convertor.AccountDto;

public interface AccountIService {
 
	
	   AccountDto createAccount (AccountDto accountDto);
	   
	   AccountDto getAccountById(Long id);
	   
	   AccountDto deposit(Long id, double amount);
	   
	   AccountDto withdraw(Long id, double amount);
	   
	   List<AccountDto> getAllAccounts();
	   
	   void deleteAccount(Long id);
}

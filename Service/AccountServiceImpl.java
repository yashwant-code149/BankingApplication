package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Convertor.AccountDto;
import com.example.demo.Entity.Account;
import com.example.demo.Mapper.mapToAccount;
import com.example.demo.Repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountIService {
@Autowired
AccountRepository accountRepository;
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account = mapToAccount.mapToAccount(accountDto);
		Account savedAccount = accountRepository.save(account);
		return mapToAccount.mapToAccountDto(savedAccount);
		
	
	}

	@Override
	public AccountDto getAccountById(Long id) {
	Account account = 	accountRepository.findById(id).orElseThrow(()-> new RuntimeException("account does not exist."));
		return mapToAccount.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
		double totalBalance = account.getBalance()+amount;
		account.setBalance(totalBalance);
		Account savedAccount = accountRepository.save(account);
		
		return mapToAccount.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("insufficient fund .");
		}
		double totalBalance = account.getBalance()-amount;
		account.setBalance(totalBalance);
		
		Account savedAccount = accountRepository.save(account);
		
		return mapToAccount.mapToAccountDto(savedAccount);
	}

	@Override
	public List<AccountDto> getAllAccounts() {
		
		return accountRepository.findAll()
				.stream()
				.map((account)-> mapToAccount.mapToAccountDto(account))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("account does not exists"));
		accountRepository.delete(account);
	}
	

	

}

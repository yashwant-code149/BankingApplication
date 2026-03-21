package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Convertor.AccountDto;
import com.example.demo.Service.AccountIService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountIService accountIService;

	  @PostMapping("/addaccount")
	 public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
	 
		return new ResponseEntity<>(accountIService.createAccount(accountDto),HttpStatus.CREATED); 
	   }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
			 
			AccountDto accountDto = accountIService.getAccountById(id);
			return ResponseEntity.ok(accountDto);
			
			
		   }
	  @PutMapping("/{id}/deposit")
	 public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request) {
		  Double amount = request.get("amount");
		  AccountDto accountDto = accountIService.deposit(id, amount);
		 // AccountDto accountDto = accountIService.deposit(id, request.get("amount"));
				  return ResponseEntity.ok(accountDto);
	  }
	  @PutMapping("/{id}/withdraw")
		 public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request) {
			  Double amount = request.get("amount");
			  AccountDto accountDto = accountIService.withdraw(id, amount);
			 // AccountDto accountDto = accountIService.deposit(id, request.get("amount"));
					  return ResponseEntity.ok(accountDto);
		  }
	  @GetMapping("/all")
	  public ResponseEntity<List<AccountDto>> getAllAcounts(){
			 
			List<AccountDto> accountDto = accountIService.getAllAccounts();
			return ResponseEntity.ok(accountDto);
			
			
		   }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<String> deleteAccount(@PathVariable Long id){
			 
			 accountIService.deleteAccount(id);
			return ResponseEntity.ok("Account deleted successfully");
			
			
		   }
	  
	 }


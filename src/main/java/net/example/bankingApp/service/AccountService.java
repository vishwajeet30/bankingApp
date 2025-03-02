package net.example.bankingApp.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeMBeanException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.example.bankingApp.entity.Account;
import net.example.bankingApp.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }
    
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccount(Long id){
        return accountRepository.findById(id);
    }
    public Account deposit(Long id, double amount){
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    } 

    public Account withdraw(Long id, double amount){
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account Not Found"));
        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient Funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }


}

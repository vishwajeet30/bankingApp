package net.example.bankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.example.bankingApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

}

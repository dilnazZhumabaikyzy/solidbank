package com.example.solidbanksb.model;


import com.example.solidbanksb.service.AccountListingService;
import com.example.solidbanksb.service.BankCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountBasicCli {
    CreateAccountOperationUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListingService;
    @Autowired
    public AccountBasicCli(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListingService) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.bankCore = bankCore;
        this.accountListingService = accountListingService;
    }

    public void createAccountRequest(AccountType accountType, String clientId){
        bankCore.createNewAccount(accountType, clientId);
    }

    public void getAccounts(String clientId){
        List<Account> accountsList = accountListingService.getClientAccounts(clientId);
        if(accountsList.isEmpty()){
            System.out.println("No accounts found for client " + clientId);
        } else {
           for(Account account: accountsList){
               System.out.println(account);
               System.out.println("-----------------------------------");
           }
        }
    }
}
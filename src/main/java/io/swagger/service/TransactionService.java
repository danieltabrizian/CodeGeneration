package io.swagger.service;

import io.swagger.model.Entity.Transaction;
import io.swagger.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction t) {
        return transactionRepository.save(t);
    }
}
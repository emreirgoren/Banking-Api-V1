package com.bankingapp.model.enums;

public enum TransactionType {

    WITHDRAW(1, "WithdrawalTransaction"),
    DEPOSIT(2, "DepositTransaction");

    private int code;
    private String transactionName;

    TransactionType(int code, String transactionName){
        this.code=code;
        this.transactionName=transactionName;
    }

    public int getCode(){
        return code;
    }

    public String getTransactionName(){
        return transactionName;
    }


}

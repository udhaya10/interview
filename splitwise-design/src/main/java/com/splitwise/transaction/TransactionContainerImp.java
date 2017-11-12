package com.splitwise.transaction;

public class TransactionContainerImp {
    public String from = "";
    public String To = "";
    public Integer Amount = 0;

    public TransactionContainerImp() {

    }

    public TransactionContainerImp(String from, String to, Integer amount) {
        this.from = from;
        To = to;
        Amount = amount;
    }
}

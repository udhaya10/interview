package com.splitwise.IOProcessing;

import com.splitwise.transaction.TransactionContainerImp;

import java.util.List;

public interface ProcessOutput {
    public abstract String constructOutput(TransactionContainerImp transactionContainer);

    public abstract List<String> constructOutput(List<TransactionContainerImp> transactions);
}

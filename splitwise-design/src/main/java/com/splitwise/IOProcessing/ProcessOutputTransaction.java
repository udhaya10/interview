package com.splitwise.IOProcessing;

import com.splitwise.transaction.TransactionContainerImp;

import java.util.ArrayList;
import java.util.List;

public class ProcessOutputTransaction implements ProcessOutput {

    public String constructOutput(TransactionContainerImp transactionContainer) {
        return transactionContainer.from + " give " + transactionContainer.To + " " + transactionContainer.Amount;
    }

    public List<String> constructOutput(List<TransactionContainerImp> transactions) {

        List<String> output = new ArrayList<String>();
        for (TransactionContainerImp transaction : transactions) {
            output.add(constructOutput(transaction));
        }
        return output;
    }
}
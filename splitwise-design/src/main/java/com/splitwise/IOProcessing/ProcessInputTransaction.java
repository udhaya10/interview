package com.splitwise.IOProcessing;

import com.splitwise.transaction.TransactionContainerImp;

import java.util.ArrayList;
import java.util.List;

public class ProcessInputTransaction implements ProcessInput {

    public TransactionContainerImp parseInput(String input) {
        TransactionContainerImp inputDataStructure = new TransactionContainerImp();

        String[] Input = input.split(" ");
        //Alex gives bob 80
        inputDataStructure.from = Input[0];
        inputDataStructure.To = Input[2];
        inputDataStructure.Amount = Integer.parseInt(Input[3]);

        return inputDataStructure;
    }

    public List<TransactionContainerImp> parseInput(List<String> inputs) {

        List<TransactionContainerImp> transactionContainer = new ArrayList<TransactionContainerImp>();
        for (String input : inputs) {
            transactionContainer.add(parseInput(input));
        }
        return transactionContainer;
    }
}
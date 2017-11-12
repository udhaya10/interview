package com.splitwise.IOProcessing;

import com.splitwise.transaction.TransactionContainerImp;

import java.util.List;

public interface ProcessInput {
    public abstract TransactionContainerImp parseInput(String input);

    public abstract List<TransactionContainerImp> parseInput(List<String> input);
}

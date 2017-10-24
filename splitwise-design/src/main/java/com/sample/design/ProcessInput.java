package com.sample.design;

import java.util.List;

public interface ProcessInput {
    public abstract TransactionContainerImp parseInput(String input);

    public abstract List<TransactionContainerImp> parseInput(List<String> input);
}

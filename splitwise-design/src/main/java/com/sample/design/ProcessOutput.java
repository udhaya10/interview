package com.sample.design;

import java.util.List;

public interface ProcessOutput {
    public abstract String constructOutput(TransactionContainerImp transactionContainer);

    public abstract List<String> constructOutput(List<TransactionContainerImp> transactions);
}

package com.sample.design;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> input = new ArrayList<String>();

        input.add("ajay give ravi 10");
        input.add("vani give ravi 200");
        input.add("ajay give vani 500");
        input.add("ravi give ajay 60");
        input.add("ajay give uday 100");
        input.add("uday give ravi 100");

        ProcessInput processInput = new ProcessInputTransaction();
        List<TransactionContainerImp> inputTransactionContainer = processInput.parseInput(input);

        TransactionStatusStore transactionStatusStore = new TransactionStatusStore(new UserStore());
        transactionStatusStore.processInputDataStructure(inputTransactionContainer);

        List<TransactionContainerImp> outputTransactionContainer = transactionStatusStore.processSettlements();

        ProcessOutput processOutput = new ProcessOutputTransaction();
        List<String> outputs = processOutput.constructOutput(outputTransactionContainer);

        for (String output : outputs) {
            System.out.println(output);
        }

    }
}

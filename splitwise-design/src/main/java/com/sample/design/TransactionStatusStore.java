package com.sample.design;

import java.util.ArrayList;
import java.util.List;

public class TransactionStatusStore {
    public List<List<Integer>> store = null;
    public Users user = null;

    public TransactionStatusStore(List<List<Integer>> store, Users user) {
        this.store = store;
        this.user = user;
    }

    public TransactionStatusStore(Users user) {
        this.store = new ArrayList<List<Integer>>();

        for (List<Integer> row : this.store) {
            row = new ArrayList<Integer>();
        }
        this.user = user;
    }

    public void processNewUser(String userName) {
        if (user.isNew(userName)) {
            user.addNewUser(userName);

            Integer userId = user.getUserId(userName);

            if (store.size() - 1 < userId) {
                store.add(new ArrayList<Integer>(store.size()));
            }
            for (List<Integer> row : store) {
                while (row.size() < userId + 1) {
                    row.add(0);
                }
            }
        }
    }

    public void processInputDataStructure(List<TransactionContainerImp> transactions) {
        for (TransactionContainerImp transaction : transactions) {
            updateTransactionState(transaction);
        }
    }

    public void updateTransactionState(TransactionContainerImp transaction) {

        if (user.isNew(transaction.from)) {
            this.processNewUser(transaction.from);
        }

        if (user.isNew(transaction.To)) {
            this.processNewUser(transaction.To);
        }

        Integer fromUserId = user.getUserId(transaction.from);
        Integer toUserId = user.getUserId(transaction.To);

        Integer value = store.get(fromUserId).get(toUserId);
        value += transaction.Amount;
        store.get(fromUserId).set(toUserId, value);
    }

    public List<TransactionContainerImp> processSettlements() {

        List<TransactionContainerImp> settlements = new ArrayList<TransactionContainerImp>();

        int[] users = new int[user.numberOfUsers()];

        int fromUserId = 0;
        for (List<Integer> from : store) {
            int toUserId = -1;
            for (Integer amount : from) {
                toUserId++;

                //This user is already processed.
                if (users[toUserId] == 1) continue;

                Integer transactionValue = store.get(fromUserId).get(toUserId) - store.get(toUserId).get(fromUserId);
                if (transactionValue != 0) {
                    TransactionContainerImp transaction = new TransactionContainerImp();
                    if (transactionValue > 0) {
                        transaction.from = user.getUserName(toUserId);
                        transaction.To = user.getUserName(fromUserId);
                        transaction.Amount = Math.abs(transactionValue);
                    } else {
                        transaction.from = user.getUserName(fromUserId);
                        transaction.To = user.getUserName(toUserId);
                        transaction.Amount = Math.abs(transactionValue);
                    }
                    settlements.add(transaction);
                }

            }
            users[fromUserId] = 1;
            fromUserId++;
        }

        return settlements;
    }
}

class Solution {
    
    private static final String DELIMITER = ",";
    private static final Integer MAX_AMOUNT = 1000;
    private static final Integer MAX_TIME = 60;
    
    private static class TransactionEntry{
        int id;
        String name;
        int time;
        int amount;
        String city;
        
        public TransactionEntry(int id, String name, int time, int amount, String city){
            this.id = id;
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
    
    
    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalidTransaction = new ArrayList<>();
        
        if(transactions == null) return invalidTransaction;
        
        Map<String, List<TransactionEntry>> transactionMap = new HashMap<>();
        
        for(int i = 0; i < transactions.length; i++){
            String[] splitTransaction = transactions[i].split(DELIMITER);
            TransactionEntry entry = new TransactionEntry(i, splitTransaction[0], Integer.parseInt(splitTransaction[1]),
                                    Integer.parseInt(splitTransaction[2]), splitTransaction[3]);
            List<TransactionEntry> transactionList = transactionMap.getOrDefault(entry.name, new ArrayList<>());
            transactionList.add(entry);
            transactionMap.put(entry.name, transactionList);
        }
        
        for(Map.Entry<String, List<TransactionEntry>> entry : transactionMap.entrySet()){
            checkInvalidTransaction(entry.getValue(), invalidTransaction, transactions);
        }
        
        return invalidTransaction;
    }
    
    private void checkInvalidTransaction( List<TransactionEntry> entries, List<String> invalidTransaction, String[] transactions){
        for(TransactionEntry entry1 : entries){
            if(entry1.amount > MAX_AMOUNT){
                invalidTransaction.add(transactions[entry1.id]);
                continue;
            }
             for(TransactionEntry entry2 : entries){
                 if(entry1.id != entry2.id && Math.abs(entry1.time - entry2.time) <= MAX_TIME && !entry1.city.equals(entry2.city)){
                     invalidTransaction.add(transactions[entry1.id]);
                     break;
                 }
             }
        }
        
       
    }
}
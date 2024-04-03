package models;

public enum ExpenseType {
    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENT("PERCENT");
    private final String type;

    ExpenseType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }

    public static ExpenseType fromString(String type){
        for(ExpenseType expenseType : ExpenseType.values()){
            if(expenseType.type.equalsIgnoreCase(type)){
                return expenseType;
            }
        }
        return null;
    }
}

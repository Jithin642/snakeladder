package models;

public enum ActionType {
    EXPENSE("EXPENSE"),
    SHOW("SHOW"),
    QUIT("QUIT");

    private final String type;

    ActionType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }

    public static ActionType fromString(String type){
        for(ActionType actionType : ActionType.values()){
            if(actionType.type.equalsIgnoreCase(type)){
                return actionType;
            }
        }
        return null;
    }
}

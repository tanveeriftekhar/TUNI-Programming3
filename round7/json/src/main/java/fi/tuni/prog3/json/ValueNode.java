package fi.tuni.prog3.json;

public class ValueNode extends Node{
    private Object value;

    public ValueNode(){
        this.value = null;
    }

    public ValueNode(double value){
        this.value = value;
    }

    public ValueNode(boolean value){
        this.value = value;
    }

    public ValueNode(String value){
        this.value = value;
    }

    
    public boolean isNumber(){
        return value instanceof Double;
    }

    public boolean isBoolean(){
        return value instanceof Boolean;
    }

    public boolean isString(){
        return value instanceof String;
    }

    public boolean isNull(){
        return value == null ;
    }

    public double getNumber(){

        if(isNumber()){
            return (Double)value ;
        }

        return 0.0;

    }

    public boolean getBoolean(){

        if(isBoolean()){
            return (Boolean)value ;
        }

        return false;

    }

    public String getString(){

        if(isString()){
            return (String)value ;
        }

        return "";

    }

    public Object getNull(){

        return value; 

    }


    
}

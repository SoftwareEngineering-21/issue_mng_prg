package com.example.its.dataClass;

public class EnumUtility {
    public static <T extends Enum<T>> T fromValue(Class<T> enumClass, int value){
        for(T e : enumClass.getEnumConstants()){
            if(e.ordinal() == value){
                return e;
            }
        }
        return null;
    }

}

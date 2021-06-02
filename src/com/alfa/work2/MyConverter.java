package com.alfa.work2;

public interface MyConverter {
    String convertStr(String str);
    public static boolean isnull(String str){

        return str == null ? true : str.trim().equals("") ;
    }

}

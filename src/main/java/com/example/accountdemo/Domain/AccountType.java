package com.example.accountdemo.Domain;

public enum AccountType {
    CHECKING("CHK"),
    SAVING("SAV");
    private String _code;
     AccountType (String code){
        this._code = code;
    }
    public static AccountType getAccountType(String code){
         for(AccountType acct: values()){
             if (acct._code.equals(code)){
                 return acct;
             }
         }
         return null;
    }
}

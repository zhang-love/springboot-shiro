package com.zl.springboot.enumeration;


public enum testEnum {
    /*
    登陆
     */
    LOGIN(1,"login"),
    /*
    登出
     */
    LOGOUT(2,"logout");

     int key ;

     String value ;
    private testEnum(int key , String value){
        this.key = key ;
        this.value = value ;
    }
    public static testEnum enumFromType(int key){
        for(testEnum status : values()){
            if(status.getKey()==key){
                return status;
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "testEnum{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}

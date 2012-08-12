package ru.drfaust.alphabet;


public class MyProperties {
    private static MyProperties mInstance= null;

    public int gameSpeed = 0;
    public int gameTime = 4;

    protected MyProperties(){}

    public static synchronized MyProperties getInstance(){
        if(null == mInstance){
            mInstance = new MyProperties();
        }
        return mInstance;
    }
}
package com.ankitjava.springbatch;

public class SingletonW {
    private static SingletonW singletonW;

    private SingletonW(
    ){
        System.out.println("Hello Singleton");
    }
    public static SingletonW getSingleInstance(){

        if(singletonW == null){
             singletonW = new SingletonW();
             return singletonW;
        }
        else
            return singletonW;
    }
}
//.map(i->i*i)
class ImplementationS{
    public static void main(String[] args) {
        //SingletonW s = new SingletonW();
        SingletonW s = SingletonW.getSingleInstance();
        SingletonW S2 = SingletonW.getSingleInstance();
    }
}

package com.ankitjava.springbatch.interview;

public class InterviewbitTest {

    private String name;
    private static int counter = 0;
    void InterviewbitTest() {
        counter = 20;
    }
    InterviewbitTest(int x){
        counter = x;
    }
    public static void main(String[] args) {

        new InterviewbitTest(10);
        System.out.println(counter);

        String s1 =  new String("Wipro");
        String s2 =  new String("Wipro");
        StringBuffer s3 =  new StringBuffer("Wipro");
        StringBuffer s4 =  new StringBuffer("Wipro");

        System.out.println(s1.equals(s2));  //true
        System.out.println(s1==s2);  // false
        System.out.println(s3.equals(s4));  //false
        System.out.println(s3==s4); //false

    }
}

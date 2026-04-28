package com.ankitjava.springbatch.interview;


public class Photon {

    public static void main(String[] args) {
        String s = "Ankit100";

     StringBuilder br = new StringBuilder(s);



//        System.out.println(br.reverse());
          char[] chars = s.toCharArray();
       // System.out.println(chars);
           for(int i=s.length()-1;i >=0;i--){

               System.out.print(chars[i]);
           }
    }
}



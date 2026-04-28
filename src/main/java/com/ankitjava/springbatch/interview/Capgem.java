package com.ankitjava.springbatch.interview;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;



public class Capgem {
    public static void main(String[] args) {//ACD =2 and BZ =1
        String s = "aaa"; // "a", "a", "a", "aa", "aa", "aaa";
        System.out.println(countPalindrome(s)); //aaa
    }

    public static int countPalindrome(String s) {  //aaa
        int count = 0;
        //System.out.println(s.length());
        for(int i = 0;i<s.length();i++){ //

            count+= expand(s,i,i);
            count += expand(s,i,i+1);

        }
        return count;
    }
private static int expand( String s, int left, int right){
        int count = 0;
        while (left>=0&& right<s.length()&&s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
}

}



package com.company;

import java.util.HashMap;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
/*输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*/
public class Main {
    public static int lengthOfLongestSubstring(String s) {
                if(s.length()==0)
                {
                    int max=s.length();
                    return max;
                }
                HashMap<Character,Integer>map=new HashMap<Character, Integer>();
                int max=0;
                int left=0;
                for(int i=0;i<s.length();i++)
                {
                    if(map.containsKey(s.charAt(i))){
                        left=Math.max(left,map.get(s.charAt(i))+1);
                    }
                    map.put(s.charAt(i),i);
                    max=Math.max(max,i-left+1);
                }
                return max;
            }
    public static void main(String[] args) {
       String s="abcabcbb";
       int a=lengthOfLongestSubstring(s);
       System.out.println("最长"+a);
       char[] r=s.toCharArray();
       for(int i=0;i<s.length();i++)
       {
           System.out.println("r的每一个值输出"+r[i]);
       }
    }
}

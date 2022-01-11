package com.turnfly.algorithm.practice.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 寻找和digits[index]匹配的字母，获得digits[0 .. index]翻译的到的解
 * */
public class LetterCombinationsOfAPhoneNumber {
    //9个按键对应的字母
    String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> res = new ArrayList<>();

    //s保存了从digits[0 ... index-1]翻译得到的一个字母字符串
    void findCombination(String digits, int index, String s){
        if(index == digits.length()){
            //保存s
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        if(c >= '0' && c <= '9' && c != '1'){
            String letters = letterMap[c-'0'];
            for(int i = 0; i < letters.length(); i++)
                findCombination(digits,index++,s+letters.charAt(i));
        }

    }

    List<String> letterCombinations(String digits){
        res.clear();
        if(digits == "") return res;
        findCombination(digits,0,"");
        return  res;
    }


    public static void main(String[] args) {

    }

}

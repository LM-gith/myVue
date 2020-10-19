package com.lm.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luoming
 * @date 2020/8/3
 */
public class  MyRegularExpression {

    public static boolean regularPattern(String str,String pattern){
        return Pattern.matches(pattern,str);
    }

    public static  String regularMatcher(String str,String pattern){
       Pattern r = Pattern.compile(pattern);
       Matcher matcher = r.matcher(str);
       return matcher.group();
    }
}

package com.zimi.lib;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 */
public class RegexUtils {
    private static final String REGEX="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
    private static final String PHONE_NUM_REGEX="^1[3-9]\\d{9}$";

    public static boolean isMatche(String text){
        return Pattern.matches(REGEX, text);
    }

    public static boolean isPhoneNum(String phoneNum){
        return Pattern.matches(PHONE_NUM_REGEX, phoneNum);
    }

}

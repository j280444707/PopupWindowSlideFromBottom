package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/5/24.
 */
public class RegexTest {
    public static void main(String[] args) {
        System.out.println("***************************************");
        // testReplace1();
        // testUrl2();
        // testEmail();
        // testSplit();
        // testRepeat();
        // testSegment();
        // testOpen();
        testLookaheadGroup();
        testLookbehindGroup();
        System.out.println("***************************************");
    }

    private static void testLookbehindGroup() {
        Pattern pattern = Pattern.compile("(\\d+)\\s+(?<!s)(\\w+)");
        String source = "543543   streets";
        Matcher matcher = pattern.matcher(source);
        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("group(" + i + "):" + matcher.group(i));
            }
        }
    }

    private static void testLookaheadGroup() {
        Pattern p = Pattern.compile("(\\d+)\\s+(?=s)(\\w+)");
        String source = "543543   streets";
        Matcher m = p.matcher(source);
        if (m.matches()) {
            for (int i = 0; i <= m.groupCount() ; i++) {
                System.out.println("group(" + i + "):" + m.group(i));
            }
        }
    }

    private static void testOpen() {
        String testString = "<aa <bbb> <bbb> aa>";
        Pattern p = Pattern.compile("\\<[^\\<\\>]*(((\\?\\'Open\\'\\<)[^\\<\\>]*)+((\\?\\'-Open\\'\\>)[^\\<\\>]*)+)*(\\?(Open)(?!))\\>");
        Matcher m = p.matcher(testString);
        System.out.println(m.find());
    }

    private static void testSegment() {
        String testString = "hi 后面不远处跟着一个 Lucy";
        Pattern p = Pattern.compile("\\bhi\\b.*\\bLucy\\b");
        Matcher m = p.matcher(testString);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
    private static void testRepeat() {
        String testString = "Paris in in the the the t1he the spring the the";
        Pattern p = Pattern.compile("\\b(?<Word>\\w+)\\s+\\k<Word>\\b");
        Matcher m = p.matcher(testString);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
    private static void testSplit() {
        Pattern pattern = Pattern.compile("[, |]+");
        String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
        for (int i=0;i<strs.length;i++) {
            System.out.println(strs[i]);
        }
    }

    private static void testEmail() {
        String str="ceponline@yahoo.com.cn";
        Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }

    private static void testUrl2() {
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href='index.html'>test</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }

    private static void testUrl1() {
        Pattern pattern = Pattern.compile("href=\\'(.+?)\\'");
        Matcher matcher = pattern.matcher("<a href='index.html'>主页</a>");
        if(matcher.find())
            System.out.println(matcher.group(1));
    }

    private static void testUrl() {
        Pattern pattern = Pattern.compile("(http://|https:\\/\\/){1}[\\w\\.\\-\\/\\:]+");
        Matcher matcher = pattern.matcher("dsdsds<http://dsds//gfgffdfd>fdf");
        StringBuffer buffer = new StringBuffer();
        while(matcher.find()){
            buffer.append(matcher.group());
            buffer.append("\r\n");
            System.out.println(buffer.toString());
        }
    }

    private static void testReplace1() {
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
        StringBuffer sbr = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbr, "Java");
        }
        matcher.appendTail(sbr);
        System.out.println(sbr.toString());
    }

    private static void testReplace() {
        String str = "Java目前的发展史是由{0}年-{2}年";
        String[][] object={new String[]{"\\{0\\}","1995"},new String[]{"\\{1\\}","2007"}};
        System.out.println(replace(str,object));
    }

    private static String replace(final String src, Object[] object) {
        String temp = src;
        for (int i = 0; i < object.length; i++) {
            String[] result = (String[])object[i];
            Pattern pattern = Pattern.compile(result[0]);
            Matcher matcher = pattern.matcher(temp);
            temp = matcher.replaceAll(result[1]);
        }

        return temp;
    }
}

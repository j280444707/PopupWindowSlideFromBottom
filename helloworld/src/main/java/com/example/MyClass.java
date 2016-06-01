package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyClass {
    public static final String GOOD_IRI_CHAR =
            "a-zA-Z0-9\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF";
    private static final String IRI
            = "[" + GOOD_IRI_CHAR + "]([" + GOOD_IRI_CHAR + "\\-]{0,61}[" + GOOD_IRI_CHAR + "]){0,1}";
    private static final String GOOD_GTLD_CHAR =
            "a-zA-Z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF";
    private static final String GTLD = "[" + GOOD_GTLD_CHAR + "]{2,63}";
    private static final String HOST_NAME = "(" + IRI + "\\.)+" + GTLD;
    public static final Pattern DOMAIN_NAME
            = Pattern.compile(HOST_NAME);

    public static final Pattern WEB_URL1 = Pattern.compile(
            "(?:cmp:\\/\\/(?:[a-zA-Z0-9\\.]){1,128})" // host name
                    + "(\\/(?:(?:[" + GOOD_IRI_CHAR + "\\;\\/\\?\\:\\@\\&\\=\\#\\~"  // plus option query params
                    + "\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
                    // + "(?:\\b|$)"); // and finally, a word boundary or end of

    public static final Pattern WEB_URL2 = Pattern.compile(
            "(^cmp:\\/\\/[a-zA-Z0-9\\.]{1,64})"); // and finally, a word boundary or end of
    // input.  This is to stop foo.sure from
    // matching as foo.su
    /**
     *  Regular expression pattern to match most part of RFC 3987
     *  Internationalized URLs, aka IRIs.  Commonly used Unicode characters are
     *  added.
     */
    public static final Pattern WEB_URL = Pattern.compile(
            "((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)"
                    + "\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_"
                    + "\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?"
                    + "(?:" + DOMAIN_NAME + ")"
                    + "(?:\\:\\d{1,5})?)" // plus option port number
                    + "(\\/(?:(?:[" + GOOD_IRI_CHAR + "\\;\\/\\?\\:\\@\\&\\=\\#\\~"  // plus option query params
                    + "\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?"
                    + "(?:\\b|$)"); // and finally, a word boundary or end of
    // input.  This is to stop foo.sure from
    // matching as foo.su"[^\\[\\]\\#\\{\\};\\>\\<@\\-/\\(\\)$\\\\]{1,40}"
    public static final Pattern WEIBO = Pattern.compile("(?:\\<M\\s(\\d+)\\>)(\\@[\\w\\W]+?)(?:\\<\\/M\\>)|(?:\\#)([\\w\\W]{1,40}?)(?:\\#)");
    public static final Pattern WEIBO1 = Pattern.compile("(?:\\<M\\s(\\d+)\\>)(\\@[\\p{N}\\p{L}\\p{S}]+)(?:\\<\\/M\\>)|(?:\\#)([\\p{N}\\p{L}\\p{S}]+)(?:\\#)");

    public static void main(String[] args) {
        //String regex = "^cmp:\\/\\/([a-zA-Z0-9.]+)(\\/[0-9a-zA-Z\\!\\?\\=\\&\\%]*)$";
        String regex = "((?:cmp:\\/\\/(?:(?:[a-zA-Z0-9\\.]){1,64}?)?))"
                + "(\\/(?:(?:[" + GOOD_IRI_CHAR + "\\;\\/\\?\\:\\@\\&\\=\\#\\~"  // plus option query params
                + "\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?"
                + "(?:\\b|$)"; // and finally, a word boundary or end of
        // input.  This is to stop foo.sure from
        // matching as foo.su

        // Pattern p = Pattern.compile(WEB_URL);
        //cmp://com.nd.hy.elearning/trainInfo?targetI d=2120&targetType=2&targetName=%E4%B8%8
        String testString = "cmp://test/test我是只个股以人";
        //Matcher m = WEB_URL1.matcher(testString);
        String testString1 = "#扶摇直+上壹#h#九千dd里#http://www.qq.com<S 12>@1</1S>是<M 290930>@$@2L^9_0930</M><M 234653>@粉丝ゥ2346$53</M>tes的 的t<M 1>@jer ry</M>   <M 2>@）3#@ア</M>";
        Matcher m = WEIBO.matcher(testString1);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            System.out.println(m.groupCount());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
            System.out.println(testString1.substring(start, end));
        }
    }
}

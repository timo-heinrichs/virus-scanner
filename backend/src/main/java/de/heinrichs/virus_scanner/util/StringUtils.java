package de.heinrichs.virus_scanner.util;

public class StringUtils {

    /**
     * A Util Method to join two pieces of Strings together,
     * trying to maintain a valid URL without having to worry about the state of slashes on both parts. (I really can't write comments omg)
     */
    public static String joinURLs(String baseURL, String childURL) {
        if (baseURL.endsWith("/")) {
            baseURL = baseURL.substring(0, baseURL.length() - 1);
        }
        if (childURL.startsWith("/")) {
            childURL = childURL.substring(1);
        }
        return baseURL + "/" + childURL;
    }

}

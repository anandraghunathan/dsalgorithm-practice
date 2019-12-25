package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/encode-and-decode-tinyurl
 *
 1. Idea is to have a charSet containing lowercase, uppercase alphabets and then numbers from 0 to 9
 2. Randomize the charSet using Math.random() fn and the * that with length of the charSet
 3. Take 6 characters from the charSet to store the randomized url part and add it to the BASE_URL
 4. Store this short url to the encoded map, with the key as the new charSet that we randomized and value as the longUrl
 5. Again, store the reverse of what we store in the encoded map to the decoded map to get the longUrl back for the shortUrl

 It's possible that a randomly generated code has already been generated before. In that case, another random code is
 generated instead. Repeat until we have a code that's not already in use. How long can this take? Well, even if we get
 up to using half of the code space, which is a whopping 626/2 = 28,400,117,792 entries, then each code has a 50% chance
 of not having appeared yet. So the expected/average number of attempts is 2, and for example only one in a billion URLs
 takes more than 30 attempts. And if we ever get to an even larger number of entries and this does become a problem,
 then we can just use length 7. We'd need to anyway, as we'd be running out of available codes.

 */
public class EncodeAndDecodeTinyURL {
    // Declare two maps, one for storing the encoded short URL for the longUrl, the other for the decoded long URL for the shortUrl
    Map<String, String> encoded = new HashMap<>();
    Map<String, String> decoded = new HashMap<>();
    static String BASE_URL = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // First check if the decoded map already has this mapping
        if(decoded.containsKey(longUrl))
            return BASE_URL + decoded.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null; // Key that we use to store the shortUrl part
        StringBuilder sb = new StringBuilder();
        /**
         * do while is to handle collisions in the hashmap. Since our loop the controlling condition appears at the end of the loop.
         *
         * This basically generates a key that's unique and if a key generated already exists, meaning - if the while
         * condition check at the bottom returns true, the loop will run again to regenerate a new key, this process
         * is repeayed until the key generated is not already present in the encoded map.
         */
        do {
            for(int i = 0; i < 6; i++) {
                // Pick a random index of the charSet
                int index = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(index));
            }
        } while(encoded.containsKey(key));
        key = sb.toString();
        encoded.put(key, longUrl);
        decoded.put(longUrl, key);
        return BASE_URL + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        /*
            Replace of String class replaces the character sequence of first parameter with the second parameter from the beginning
            S = "aaa", ToReplace = "aa" Replace = "b", then "aaa" will be modified as "ba", and not "ab"
        */
        return encoded.get(shortUrl.replace(BASE_URL, ""));
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL obj = new EncodeAndDecodeTinyURL();
        String encoded = obj.encode("https://leetcode.com/");
        System.out.println("Encoded: "+encoded);
        String decoded = obj.decode(encoded);
        System.out.println("Decoded : "+decoded);
        //System.out.println(obj.decode(obj.encode("https://leetcode.com/")));
    }
}

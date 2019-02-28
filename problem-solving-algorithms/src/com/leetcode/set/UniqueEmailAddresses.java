package com.leetcode.set;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println("Unique email addresses : " +numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for(String email : emails) {
            // Separate the local and domain parts before and after '@' symbol
            int i = email.indexOf("@");
            String localPart = email.substring(0, i);

            // Ignore period in the email
            localPart = localPart.replace(".", "");

            // Only consider what's before the "+" symbol
            if(localPart.contains("+")) {
                localPart = localPart.substring(0, localPart.indexOf("+"));
            }

            // Add the local and domain parts of the email to the set to find the unique email count
            uniqueEmails.add(localPart + email.substring(i));
        }
        return uniqueEmails.size();
    }
}

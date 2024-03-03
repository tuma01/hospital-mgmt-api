package com.amachi.app.hospitalappservice.util;
import java.util.regex.*;
class GFG {

    // Function to validate URL
    // using regular expression
    public static boolean
    onlyDigits(String str)
    {
        // Regex to check string
        // contains only digits
//        String regex = "^[0-9]{2,4}";
        String regex = "^[a-zA-Z0-9]{1,4}+$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }

        // Find match between given string
        // and regular expressionData
        // using Pattern.matcher()
        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    // Driver Code
    public static void main(String args[])
    {
        // Given string str
        String str = "ddd-";

        // Function Call
        System.out.println(onlyDigits(str));
    }
}

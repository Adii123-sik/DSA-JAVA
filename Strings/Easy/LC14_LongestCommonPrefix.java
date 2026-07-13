package Strings.Easy;

public class LC14_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        // Agar array null ya empty hai
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Pehli string ko starting prefix maan lo
        String prefix = strs[0];

        // Baaki sabhi strings ke saath prefix compare karo
        for (int i = 1; i < strs.length; i++) {

            // Jab tak current string prefix se start nahi hoti
            while (!strs[i].startsWith(prefix)) {

                // Prefix ka last character remove karo
                prefix = prefix.substring(0, prefix.length() - 1);

                // Agar koi common prefix nahi bacha
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Sabhi strings ka longest common prefix return karo
        return prefix;
    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        String result = longestCommonPrefix(strs);

        System.out.println("Longest Common Prefix: " + result);
    }
}
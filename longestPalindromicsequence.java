public class LongestPalindromicSubstring {

    // Function to find the longest palindromic substring
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // Initialize variables to store the start and end indices of the longest palindrome found
        int start = 0;
        int end = 0;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Expand around center for odd length palindromes
            int len1 = expandAroundCenter(s, i, i);
            // Expand around center for even length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length between the two
            int len = Math.max(len1, len2);
            
            // If the found palindrome is longer than the current longest, update the indices
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }

    // Helper function to expand around the center
    private static int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;

        // Expand while the characters at the left and right pointers are the same
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        // Return the length of the palindrome
        return r - l - 1;
    }

    public static void main(String[] args) {
        String input = "babad";
        String result = longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}

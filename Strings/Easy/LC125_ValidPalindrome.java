package Strings.Easy;

public class LC125_ValidPalindrome {

    public static boolean isPalindrom(String s){

        int left=0;
        int right=s.length()-1;

        while (left<right) {

             // Left side ke spaces aur special characters skip karo
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                
            }
             // Right side ke spaces aur special characters skip karo
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                
            }

            char leftChar=Character.toLowerCase(s.charAt(left));
            char rightChar=Character.toLowerCase(s.charAt(right));

            if(leftChar!=rightChar){
                return false;
            }
            left++;
            right--;
            
        }
    return true;
    }

    public static void main(String[] args) {
        
      String  s = "A man, a plan, a canal: Panama";

      System.out.println(isPalindrom(s));
    }
    
}

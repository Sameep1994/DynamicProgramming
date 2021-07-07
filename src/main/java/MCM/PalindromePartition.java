package MCM;

public class PalindromePartition {
    public static void main(String[] args) {

        String s = "geek";
        //ans will be 2 since we need g,ee,k as min partitions
        System.out.println(solve(s,0,s.length()-1));
    }
    /*Divide a string into substring in such a way that all the partition is palindrome
    *
    * moving k from 0 to n-1 dividing the string into i to k, k+1 to j
    * if its palindrome counting min num of partition needed
    * */
    public static int solve(String s,int i,int j){
        if(i>=j)
            return 0;
        if(isPalindrome(s,i,j))
            return 0;
        int ans =Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=1+solve(s,i,k)+solve(s,k+1,j);
            if(temp<ans){
                ans=temp;
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {

            // If there is a mismatch
            if (s.charAt(i) != s.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }
}

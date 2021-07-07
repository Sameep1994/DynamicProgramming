package MCM;

public class PalindromePartitionMemo {
    public static int[][] t;
    public static void main(String[] args) {
        t=new int[1001][1001];
        for(int i=0;i<1001;i++){
            for(int j=0;j<1001;j++){
                t[i][j]=-1;
            }
        }

        String s="geek";
        System.out.println(solve(s,0,s.length()-1));
    }
    public static int solve(String s,int i,int j){
        if(i>=j)
            return 0;
        if(isPalindrome(s,i,j))
            return 0;
        if(t[i][j]!=-1){
            return t[i][j];
        }
        int ans =Integer.MAX_VALUE;
        int left,right;
        for(int k=i;k<=j-1;k++){
            if(t[i][k]!=-1){
                 left=t[i][k];
            }else{
                left=solve(s,i,k);
            }

            if(t[k+1][j]!=-1){
                right=t[k+1][j];
            }else{
                right=solve(s,k+1,j);
            }
            int temp=1+left+right;
            if(temp<ans){
                ans=temp;
            }
        }
        t[i][j]=ans;
        return t[i][j];
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

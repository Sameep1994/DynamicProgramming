package MCM;

public class ScrambledStringRec {
    public static void main(String[] args) {
        String a="great";
        String b="rgeat";
        boolean ans;
        if(a.length()!=b.length())
            ans =false;
        if(a.length()==0 && b.length()==0)
            ans= true;

        ans=solve(a,b);
        System.out.println(ans);

    }
    /*given string can be divided into a binary tree of non empty strings and the child of non leaf nodes can be swapped 0 or more times
    * after swapping if its same as the second string then its a scrambled string
    *
    * we will break string1 from 1 to n-1 since we cant divide it into non empty strings
    * for every break we can either swap the two halves or not
    *
    * if swapped we check first half of s1 and second half of s2 and see if they are scrambled
    * and vice versa with other halves
    *
    * similarly if not swapped we check frst half of s1 and frst half of s2 if they are scrambled and vice versa with other halves*/

    public static boolean solve(String a,String b){
        //same string in a and b
        if(a.compareTo(b)==0)
            return true;
        //so that it doesnt break into empty string
        if(a.length()<=1)
            return false;
        int n=a.length();
        boolean flag=false;
        for(int k=1;k<=n-1;k++){
            //case1 when swapped || case 2 when not swapped
            if (    // When Doing the Swap.
                    (solve(a.substring(0, k), b.substring(n - k))
                            &&
                            solve(a.substring(k, n), b.substring(0, n - k)))
                            ||
                            // When not doing the swap.
                            (solve(a.substring(0, k), b.substring(0, k))
                                    &&
                                    solve(a.substring(k, n), b.substring(k, n)))) {
                flag = true;
                break;
            }
        }
        return flag;

    }

}

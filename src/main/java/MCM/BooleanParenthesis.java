package MCM;

public class BooleanParenthesis {
    public static void main(String[] args) {
        String s="T^F&T";
        System.out.println(solve(s,0,s.length()-1,true));

    }
    /*Given a string example T or/and F etc etc..give the output either true or false*/
//todo revise logic
   public static int solve(String s,int i,int j,boolean isTrue){
       if(i>j)
           return 0;
       if(i==j)
       {
           if(isTrue==true){
               return s.charAt(i)=='T'?1:0;
           }else {
               return s.charAt(i)=='F'?1:0;
           }
       }
       int ans=0;
//since we have expression like T or F thatswhy moveing k=k+2
       for(int k=i+1;k<=j-1;k=k+2){
           int lt= solve(s,i,k-1,true);
           int lf=solve(s,i,k-1,false);
           int rt=solve(s,k+1,j,true);
           int rf=solve(s,k+1,j,false);
           if(s.charAt(k)=='&'){
               if(isTrue==true) {
                   ans += lt * rt;
               }else{
                   ans+=lf*rt+lf*rf+lf*rf;
               }
           }else if(s.charAt(i)=='|'){
               if(isTrue==true){
                   ans+=lt*rt+lt*rf+lf*rt;
               }else {
                   ans+=lf*rf;
               }

           }else if(s.charAt(k)=='^'){
               if(isTrue==true){
                   ans+=lf*rt+lt*rf;
               }else{
                   ans+=lt*rt;
               }

           }
       }
       return ans;
   }
}

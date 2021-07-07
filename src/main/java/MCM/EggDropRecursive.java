package MCM;

public class EggDropRecursive {
    public static void main(String[] args) {
        int egg=3,floor=5;
        System.out.println(solve(egg,floor));
    }
    /*Problem: Find the threshold floor(if eggs is dropped from above threshold eggs will break)
    * minimise the attempts in worst case(when the topmost floor is threshold)*/

    /**/
    public static int solve(int egg,int floor){
        if(egg==0){
            return floor;
        }
        if(floor==0||floor==1){
            return floor;
        }
        int min =Integer.MAX_VALUE;
        //checking every floor,if it breaks at k then above k will break so we will check below k
        //if it doesnt break threshold lies above k to floor so we check there
        for(int k=1;k<=floor;k++){
//we are using 1 for the current attempt and taking max of scenario when egg breaks(egg becomes eggs-1 since it broke and threshold lies from curr floor to 1 since above current it will break)
//and when doesnt break(eggs remains same, from current to top floor is checked), we are taking max because we are trying to find this for worst case
            int temp=1+Math.max(solve(egg-1,k-1),
                    solve(egg,floor-k));
            min=Math.min(min,temp);

        }
        return min;
    }
}

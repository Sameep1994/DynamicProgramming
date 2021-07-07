package UnboundedKnapSack;

public class RodCutting {
    public static void main(String[] args) {
        //this problem is just a different representation of unbounded knapsack
        int[] length ={1,2,3,4,5,6,7,8};
        int[] price={1,5,8,9,10,17,17,20};
        int N=8;
        KnapsackTopDown k = new KnapsackTopDown();
        System.out.println(k.ksack(price,length,N,price.length));


    }
}

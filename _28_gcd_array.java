import java.util.*;

public class _28_gcd_array {

    public static int array_GCD(int []arr){
        int result = arr[0];
        for(int i = 1; i < arr.length; i++){
            result = GCD(result, arr[i]);
            }
        
        return result;
    }

    public static int GCD(int a, int b){
        if (b==0) return a;
        return GCD(b, a%b);

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //gitString input = sc.nextLine();
        int [] arr={6,3};
        System.out.println(arr);
        sc.close();

    }
    
}

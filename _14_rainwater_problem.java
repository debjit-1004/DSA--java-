
import java.util.*;

/*
 * A container is given ...likw 1,4, 2, 7,44, 9,3 and it reprsen the height ..so i need to find the max rainwater it can hold between any teo bars so i need to find those bars
 */
public class _14_rainwater_problem {
    public static double  /*List<Integer>*/ indices(int arr[]){
        double val=0;
        List<Integer> res= Arrays.asList(0,0);
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
           
                double temp=Math.pow(Math.min(arr[i], arr[j]),2);
                System.out.println(temp+" "+i+" "+j);
                if (temp> val){res=Arrays.asList(i,j);val=temp;}
            }
        }

        return val;      
    }
    public static void main(String[]args){
        int arr[]={1,4,2,7,4,4,8};
        System.out.println(indices(arr));
    }
    
}

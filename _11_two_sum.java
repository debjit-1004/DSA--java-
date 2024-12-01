
import java.util.*;
public class _11_two_sum {
    public static List<Integer> twoSum(int[]arr, int target){
        int l= arr.length;
        for (int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if (arr[i]+arr[j]==target){
                    return Arrays.asList(i,j);
                }
            }
        }
        return Arrays.asList(null,null);
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        List<Integer> result = twoSum(nums, target);
        System.out.println((result));
    }
    
    
}

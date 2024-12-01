import java.util.Arrays;

public class _13_3Sum_closest {
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[n-1];
        
        for(int i = 0 ; i < n - 2 ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int low = i+1;
            int high = n-1;
            
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                //fucking most important line 
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum < target) low++;
                else high--;
            }
        }
        
        return res;
    }
        
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target= 12;
        System.out.println(threeSumClosest(nums,target));
    }
    }
    

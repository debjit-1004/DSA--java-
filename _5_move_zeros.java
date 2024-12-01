//https://leetcode.com/problems/move-zeroes/
import java.util.*;
class _5_move_zeros {
    public static void moveZeroes(int[] nums) {
        int cnt = 0; 
        int index = 0;
        for(int i=0 ; i < nums.length ; i++){
            if(nums[i] == 0) cnt++;
            else{
                nums[index] = nums[i];
                index++;
            }
            
        }
        
        for(int i=nums.length-1 ; i>=nums.length - cnt ; i--){
            nums[i] = 0;
        }
        
        for(int i=0 ; i < nums.length ; i++) System.out.print(nums[i]+" ");
    }

    public static void main(String [] args){
        try(Scanner sc= new Scanner(System.in);){
            System.out.println("Enter the number of elements in  array");
            int len=sc.nextInt();
            int[] array= new int[len];
            for (int i=0; i<len;i++){
                array[i]=sc.nextInt();
            }
            moveZeroes(array);
            

        }catch(Exception e){
            System.err.println(e);
        }
    }
}

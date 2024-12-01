import java.util.*;
public class _2_equilibrum_point{
    public static int equilibrum_point(long arr[]){
        int n = arr.length;
        int left=0, right=0, pivot =0;
        for (int i=1; i<n;i++){
            right+=arr[i];
        }

        while (pivot<n-1 && right!=left){
            pivot++;
            right-=arr[pivot];

            left+=arr[pivot-1];
        }
        //for 1 based index pivot +1  else pivot would have been returned only 
        return (left==right?pivot +1:-1);

    }
    public static void main(String [] args){
        try(Scanner sc= new Scanner(System.in);){
            System.out.println("Enter the number of elements in  array");
            int len=sc.nextInt();
            long[] array= new long[len];
            for (int i=0; i<len;i++){
                array[i]=sc.nextLong();
            }
            System.out.println(equilibrum_point(array));
            

        }catch(Exception e){
            System.err.println(e);
        }
    }
}


import java.util.*;

public class _6_transpose {
    public static void transpose(int[][] arr){
        int l=arr.length;
        for (int i=0;i<l-1;i++){
            for (int j = i+1;j<l;j++){
                int temp =arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }

    

    public static void print(int[][] arr, String str,int l){
        System.out.println(str);
        for (int i=0;i<l;i++){
            for (int j = 0;j<l;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    
    public static void main(String[] args) {

        //int arr[]={1,2,3,4,5};
        try(Scanner sc= new Scanner(System.in)){
            System.out.println("Enter the no. of rows of the square matrix");
            int l=sc.nextInt();
            int arr[][]={
                {1,2,3},
                {4,5,6},
                {7,8,9}
            };
            
            print(arr,"Matrix before transposing", l);
            transpose(arr);
            print(arr, "Matrix after transposition:", l);



        }catch(Exception e){
            System.err.println(e);

        }
        
    }  
    
}

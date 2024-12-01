import java.util.*;

public class _7_rotate_clockwise {
    public static void upside_down(int arr[][]){
        int l = arr.length;
        for (int i =0; i<=l/2; i++){
            for (int j=0;j<l;j++){
                int temp=arr[i][j];
                arr[i][j]= arr[l-i-1][j];
                arr[l-i-1][j]= temp;
                
            }
        }
    }
    public static void main(String[] args) {
        _6_transpose obj = new _6_transpose();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
            };
            upside_down(matrix);
            obj.transpose(matrix);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
            }
    }
}

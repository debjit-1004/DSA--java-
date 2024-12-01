import java.util.Scanner;

public class _3_hashing {
    public static void main(String args[]){
        Scanner sc=new Scanner((System.in));
        System.out.println("Enter the length of the array");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the arraay");
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int[] hashTable = new int[n+1];

        for (int  i = 0; i < n; i++) {
            int index = arr[i] % (n + 1);




        sc.close();
    }
}

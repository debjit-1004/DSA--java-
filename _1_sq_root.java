import java.util.Scanner;
public class _1_sq_root{
    public static void root(double x){
        double val = 0.0;
        while ((val+1)*(val+1)<=x){
            val+=1;
        }
        int c= 0;
        double diff=1.0;
        while (c<20){
            if ((val+diff/2)*(val+diff/2)<=x){
                val+=diff/2;
            }
            diff/=2;
            c++;
        }

        System.out.println("The square root of "+x+" is "+val);

    }

    public static void main(String [] args){
        try(Scanner sc = new Scanner(System.in);) {
            

            System.out.println("Enter a number to find te root.");
            double num = sc.nextDouble();
            if (num<0){
                System.out.println("The square root of a negaive number is undefined in real world ");
            }
            else{
                root(num);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        }
}
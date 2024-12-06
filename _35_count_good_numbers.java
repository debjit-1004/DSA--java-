 class _35_count_good_numbers {
    static final long MOD = 1_000_000_007;
    public static void main(String args[]){
        int n=50;
       
        System.out.println(countGoodNumbers(n));

    }
    static int countGoodNumbers(int n){
        long odd=n/2;
        long even=(n+1)/2;
        return (int)((pow(5,even)+ pow(4,odd))%MOD);

    }

    static long pow(long x, long n){
        if (n==0){
            return 1;
        }
        long temp = pow (x, n/2);
        if (n%2==0){
            return (temp * temp) % MOD;
        }
        else{
            return (temp * temp * x)%MOD;
        }
    }
    
}

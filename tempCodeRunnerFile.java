public static void main(String [] args){
        try(Scanner sc= new Scanner(System.in);){
            System.out.println("Enter the number of elements in  array");
            int len=sc.nextInt();
            int[] array= new int[len];
            for (int i=0; i<len;i++){
                array[i]=sc.nextInt();
            }
            System.out.println(firstMissingPositive(array));
            

        }catch(Exception e){
            System.err.println(e);
        }
    }
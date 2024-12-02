import java.util.*;
/*
 * how to take input in a method ...make afn ...input (Scanner sc){
 * int val= sc.nextInt();
 * }
 * 
 * main(){
 * Scanner sc= new Scanner(System.in);
 * sopln(input(sc))
 * 
 * }
 * 
 */
public class _16_create_print_ll {
        static class Node {
            int data;
            Node next;
    
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    
        Node head;
        
        // Method to add a new node
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }


    
        // Method to print the linked list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            _16_create_print_ll list = new _16_create_print_ll();
            String val ;
            System.out.println("Enter the Node values one by one: ");
            while (true){
                val =(sc.nextLine());
                if (val.isEmpty()){break;}
                try {
                    
                    list.add(Integer.parseInt(val));
                    
                } catch(NumberFormatException e) {
                    System.out.println("Invalid input...enter an integer of enter to exit");
                }
            }
            list.printList();  // Output: 10 -> 20 -> 30 -> null
            sc.close();
            
    }
}
    


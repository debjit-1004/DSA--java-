/* 
 * logic...
 * 
*/

public class _17_Reverse_a_linked_list {
        static class Node {
            int data;
            Node next;
    
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    
        Node head;
    
        // Add a new node to the list
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
    
        // Reverse the linked list
        public void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;
    
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
    
        // Print the linked list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    
        public static void main(String[] args) {
            _17_Reverse_a_linked_list list = new _17_Reverse_a_linked_list();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            System.out.print("Original List: ");
            list.printList();  // Output: 1 -> 2 -> 3 -> 4 -> null
    
            list.reverse();
            System.out.print("Reversed List: ");
            list.printList();  // Output: 4 -> 3 -> 2 -> 1 -> null
        }
    }
    
    


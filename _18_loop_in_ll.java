//floyd cycle 
//concept of fast pointer and slow pointer  

public class _18_loop_in_ll {
        static class Node {
            int data;
            Node next;
    
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    
        Node head;
    
        // Add a new node
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
    
        // Detect a loop in the linked list
        public boolean detectLoop() {
            Node slow = head;
            Node fast = head;
    
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
    
                if (slow == fast) {
                    return true; // Loop detected
                }
            }
            return false; // No loop
        }
    
        public static void main(String[] args) {
            _18_loop_in_ll list = new _18_loop_in_ll();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
    
            // Create a loop for testing
            list.head.next.next.next.next = list.head.next;
    
            if (list.detectLoop()) {
                System.out.println("Loop detected!");
            } else {
                System.out.println("No loop detected.");
            }
        }
    }
    
    
    


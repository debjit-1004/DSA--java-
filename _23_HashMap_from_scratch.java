//The angle brackets give freedom of any type of data inside ..k,v
//wrong code  class _23_HashMap_from_scratch <K, V> ..cant have space between classname and data types 
class _23_HashMap_from_scratch<K, V> {

    // Node class to represent key-value pairs ...basically for the linkedlist part for same hash
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node<K, V>[] buckets;  // Array of buckets which is of type Node having data of k , v 
    private int capacity;          // Initial capacity of the _23_HashMap_from_scratch
    private int size;              // Number of key-value pairs in the _23_HashMap_from_scratch

    public _23_HashMap_from_scratch(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % capacity); // Compute the index from the hash
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        // see how i r
        Node<K, V> head = buckets[index];

        // Check if key already exists, update the value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // Update existing value
                return;
            }
            head = head.next;
        }

        // Key does not exist, insert a new node at the head
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];

        // Search for the key in the linked list
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        // Key not found
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        // Search for the key in the linked list
        while (head != null) {
            if (head.key.equals(key)) {
                // Key found, remove the node
                if (prev == null) {
                    buckets[index] = head.next; // Remove head node
                } else {
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> head = buckets[i];
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + " : " + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        _23_HashMap_from_scratch<String, Integer> map = new _23_HashMap_from_scratch<>(5);

        // Add key-value pairs that cause collisions
        map.put("A", 1);  // Bucket 0
        map.put("F", 6);  // Bucket 0 (Collision with "A")
        map.put("K", 11); // Bucket 0 (Collision with "A" and "F")
        map.put("B", 2);  // Bucket 1
        map.put("C", 3);  // Bucket 2
        map.put("G", 7);  // Bucket 2 (Collision with "C")
        map.put("D", 4);  // Bucket 3
        map.put("E", 5);  // Bucket 4

        // Print the map
        map.printMap();

        // Get a value
        System.out.println("Value for key 'K': " + map.get("K"));

        // Remove a key and reprint
        map.remove("F");
        map.printMap();

        // Check size
        System.out.println("Size: " + map.size());
    }
}

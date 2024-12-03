//so LRU cache referes to the last recently used ...and it wokriks like...fixed capacity, the things that is not used recently i.i=e. very old is replaced in case of overflow .. and can take any value between for use and put in top...so stack and queue fail ...double linked list neededd and hasmap to store key value pair

//comeback again boy ..you need to pass or maybe top ..this is hard 

import java.util.LinkedHashMap;
import java.util.Map;

public class _22_LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public _22_LRUCache(int capacity) {
        super(capacity, 0.75f, true); // Access-order mode
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        _22_LRUCache<Integer, String> cache = new _22_LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println("Cache: " + cache);
        cache.get(1); // Access element 1
        cache.put(4, "D"); // Add new element, causing eviction

        System.out.println("Updated Cache: " + cache);
    }
}

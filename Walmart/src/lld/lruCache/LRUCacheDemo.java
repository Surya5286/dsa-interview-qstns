package lld.lruCache;

public class LRUCacheDemo {

    public static void main(String[] args) {

        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1,7);
        cache.put(3,7);

        // Case1 :- Make a get Call to update the Index Position
        cache.get(1);

        // Case2 :- Insert beyond the Cache capacity
        cache.put(2,7);

        // Test:- Print the availability of the key or Node - 3
        System.out.println("Value for the key - 3 is: " + cache.get(3));

        // Case3 :- Update the Node Value and move the Node occurrence to first.
        cache.put(2,9);
        System.out.println("The updated value of key - 2 is : " + cache.get(2));

        // Case4 :- Evaluate scenario whether if Capacity value equals 0
        try {
            LRUCache<Integer, Integer> dummyCache = new LRUCache<>(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Printing error - " + e.getMessage());
        }
    }
}

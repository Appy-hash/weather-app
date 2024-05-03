import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {

    Map<Integer, Node2> cache;
    int size;
    Node2 head;
    Node2 tail;

    public LeastRecentlyUsedCache(int capacity) {
        cache = new HashMap<>();
        size = capacity;
        head = new Node2(-1, -1);
        tail = new Node2(-1, -1);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        Node2 node = cache.get(key);

        if(node == null){
            return -1;
        }else{
            removeNode(node);
            addToHead(node);
            return node.val;
        }

    }

    private void addToHead(Node2 node){
        Node2 headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }

    private void removeNode(Node2 node){
        Node2 nextNode = node.next;
        Node2 prevNode = node.prev;
        node.next = null;
        node.prev = null;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;



    }

    private Node2 popFromTail(){
        Node2 tailPrev = tail.prev;
        removeNode(tailPrev);
        return tailPrev;

    }

    public void put(int key, int value) {

        if(!cache.containsKey(key)){
            Node2 node = new Node2(key, value);
            addToHead(node);

            cache.put(key,node);
            if(cache.size() > size){
                Node2 poppedNode = popFromTail();
                cache.remove(poppedNode.key);
            }
        }else{
            Node2 node = cache.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
            cache.put(key, node);
        }

    }


    public static void main(String[] args){
        LeastRecentlyUsedCache obj = new LeastRecentlyUsedCache(1);
        obj.put(2,1);
        int param_1 = obj.get(2);
        obj.put(3,2);
        int param_2 = obj.get(2);
        int param_3 = obj.get(3);



    }
}

class Node2{
    Node2 prev;
    Node2 next;
    int val;
    int key;

    Node2(int key, int val){
        this.val = val;
        this.key = key;
    }

    Node2(int key , int val, Node2 prev, Node2 next){
        this.val = val;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}

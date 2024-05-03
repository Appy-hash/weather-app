import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, DoublyLinkedList> map;
    DoublyLinkedList head;
    DoublyLinkedList tail;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.head = new DoublyLinkedList(-1);
        this.tail = new DoublyLinkedList(-1);
        this.size = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            moveToHead(map.get(key));
            return map.get(key).val;
        }
        return -1;

    }

    private void moveToHead(DoublyLinkedList node){
        removeNode(node);
        addNode(node);
    }

    private void addNode(DoublyLinkedList node){
        DoublyLinkedList headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(DoublyLinkedList node){
        DoublyLinkedList prev = node.prev;
        DoublyLinkedList next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private int popTailNode(){
        DoublyLinkedList tailPrev = tail.prev;
        removeNode(tailPrev);
        return tailPrev.val;

    }

    public void put(int key, int value) {
        DoublyLinkedList node = map.get(key);

        if(node == null){

            if(map.size() == size){
                int removedNode = popTailNode();
                map.remove(removedNode);

            }
            DoublyLinkedList newNode = new DoublyLinkedList(value);
            addNode(newNode);
            map.put(key,newNode);
        }else{
            moveToHead(node);
        }
    }



    public static void main( String[] args){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}


class DoublyLinkedList{

    int val;
    DoublyLinkedList prev;
    DoublyLinkedList next;

    public DoublyLinkedList(int val){
        this.val = val;
    }

}

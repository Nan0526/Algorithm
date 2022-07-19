package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	public static void main(String[] args) {
		//String exam = "LRUCache","put","put","get","put","get","put","get","get","get";
		//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
	}
	
	
    //Use Map & doubly linkedlist to maintain this structure
    private int capacity;
    private final Map<Integer, Node> map;
    Node head;
    Node tail;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(); 
    }
    
    public int get(int key) {
        //key exist?
        if(!map.containsKey(key)) {
            return -1;
        }else {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
    }
    
    public void put(int key, int value) {
        //key exist?
        if(map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            n.value = value;//sometimes this first 'remove(n)'
            setHead(n);
        }else {
            Node created = new Node(key, value);
            //meet capacity?
            if(map.size() >= capacity) {
                map.remove(tail.key); // tail.key
                remove(tail);
                setHead(created);
            }else {
                setHead(created);
            }
            map.put(key, created);
        }
    }
    
    //helper functions: setHead & remove(from list)
    private void setHead(Node n) {
        n.pre = null;
        n.next = head;
        if(head != null) {
            head.pre = n;
        }
        head = n;
        if(tail == null) {
            tail = head;
        }
    }
    
    private void remove(Node n) {
        if(n.pre != null) {
            n.pre.next = n.next;
        }else {
            head = n.next;
        }
        if(n.next != null) {
            n.next.pre = n.pre;
        }else {
            tail = n.pre;
        }
    }
    
}

class Node{
    int key;
    int value;
    Node pre;
    Node next;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


/*
    Map & Doubly LinkedList - 
    Map - store key & the reference of the node
        (for search in O(1) time)
    doubly linkedlist - maintain the order of LRU Cache
    
    Put:
    check whether the key is exist? - update value - remove node from list - setHead
    Create a node(have specific reference)
    To see whether the list is below or beyond the capacity - 
    Below: setHead + map.put
    Beyond: map.remove - remove(tail) - then with capacity - setHead & map.put

    Get:
    get the node from the list - then put it back and put it on the top
    find the key-value(node reference) in map
    then remove(tail) from list, but not map - setHead - return node's value
    doubly linkedlist - remove - O(1) - advantage- singly need to iterate the whole list then find the node and remove and preremember the previous node and next node, then connect them; but doubly can use map's node reference to find the node directly and then change the previous node's next and next node's pre.
    
    Helper functions:
    1. setHead:
    update new node: node.next = head & node.pre = null;
    update previous head: head.pre - not null situation
    set new head
    update tail - if there's just one node - tail=head
    
    2. remove:
    remove in the list - 
    check the node's pre & next - then update
    */    


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
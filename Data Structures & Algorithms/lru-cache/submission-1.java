class LRUCache {
    class Node{
        int key,val;
        Node prev,next;

        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

private HashMap<Integer,Node> map;
private int size;
private Node head;
private Node tail;

    public LRUCache(int capacity) {
        this.size=capacity;
        map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.next=head;
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insertAtFront(Node node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    
    public int get(int key) {
        int x=-1;

        if(!map.containsKey(key)) return -1;

        Node node=map.get(key);

        remove(node);
        insertAtFront(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            remove(node);
            insertAtFront(node);
        }else{
            Node newNode=new Node(key,value);
            if(map.size() == size){
               Node last=tail.prev;
               remove(last);
               map.remove(last.key);
            }
            insertAtFront(newNode);
            map.put(key,newNode);
        }
    }
}

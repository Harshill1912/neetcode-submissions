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
        tail.prev=head;

    }
    
    public  void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }

    public  void insertAtFront(Node node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public int get(int key) {
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
            if(map.size() == size){
                Node lastNode=tail.prev;
                map.remove(lastNode.key);
                remove(lastNode);
            }
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            insertAtFront(newNode);   
        }
    }
}

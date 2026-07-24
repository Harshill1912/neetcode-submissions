/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public  Node clone(Node node,HashMap<Node,Node> map){
        Node copy=new Node(node.val);
        map.put(node,copy);

        for(Node nbr : node.neighbors){
            if(map.containsKey(nbr)){
                copy.neighbors.add(map.get(nbr));
            }else{
                Node nbrCopy=clone(nbr,map);
                copy.neighbors.add(nbrCopy);
            }
        }
        return copy;
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node,Node> map=new HashMap<>();

        return clone(node,map);
    }
}
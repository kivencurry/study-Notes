/*
// Definition for a Node.
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
/*

方法一：BFS
*/

class Solution {
    public Node cloneGraph(Node node) {
        Node n=new Node();
        if(node==null)
            return n;
        Queue<Node> queue=new LinkedList<>();
        Map<Integer,Node> map=new HashMap<>();  
        n.val=node.val;
        n.neighbors=new ArrayList<Node>();
        map.put(n.val,n);
        queue.offer(node);
        while(!queue.isEmpty()){
            Node temp=queue.poll();
            for(Node curr:temp.neighbors){
                if(!map.containsKey(curr.val)){
                    n=new Node();
                    n.val=curr.val;
                    n.neighbors=new ArrayList<Node>();
                    map.put(n.val,n);
                    queue.offer(curr);   
                }
                map.get(temp.val).neighbors.add(map.get(temp.val));
                
            }  
        }
        return map.get(node.val);        
    }
}
/*
-------------
方法二：dfs

*/

 public Node cloneGraph(Node node) {
    if(node==null) return node;
    return NodeClone(node,new HashMap<>());
 }
 private Node NodeClone(Node node,HashMap<Integer,Node> map){
    if(map.containsKey(node.val)){
        return map.get(node.val);
    }
    Node n=new Node();
    n.val=node.val;
    n.neighbors=new ArrayList<>();
    map.put(n.val,n);
    for(Node temp:node.neighbors){
        map.get(node.val).neighbors.add(NodeClone(temp,map));
    }

    return n;

 }





















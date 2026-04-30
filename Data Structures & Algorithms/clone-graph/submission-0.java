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
    public Node cloneGraph(Node node) {
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        Node curr = node;
        q.add(curr);
        while(!q.isEmpty()) {
            Node currNode = q.poll();
            for (Node neighbor: currNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                map.get(currNode).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}
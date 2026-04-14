class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    public Node dfs(Node node, HashMap<Node,Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newnode = new Node(node.val);
        map.put(node, newnode);
        for(Node neighbor : node.neighbors){
            Node clonedneighbor = dfs(neighbor, map);
            newnode.neighbors.add(clonedneighbor);
        }
        return newnode;
    }
}
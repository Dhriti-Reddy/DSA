class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        while(current != null){
            Node newNode;
            newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        } 

        current = head;
        while(current != null){
            Node newNode;
            newNode = map.get(current);
            if(current.next != null){
                newNode.next = map.get(current.next);
            }
            else{
                newNode.next = null;
            }
            if(current.random != null){
                newNode.random = map.get(current.random);
            }
            else{
                newNode.random = null;
            }
            current = current.next;
        }
        return map.get(head);
    }
}
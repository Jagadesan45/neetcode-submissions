class LinkedList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void insertHead(int val) {
        Node first = new Node(val);
        first.next = head;
        head = first;
        size++;
    }

    public void insertTail(int val) {
        Node last = new Node(val);
        if (head == null) {
            head = last;
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            // Point the last node's 'next' to our new node
            curr.next = last;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            // Traverse to the node JUST BEFORE the one we want to remove
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            // Skip the next node
            curr.next = curr.next.next;
        }
        size--;
        return true;
    }
    

    public ArrayList<Integer> getValues() {
    ArrayList<Integer> result = new ArrayList<>();
    Node curr = head;
    while (curr != null) {
        result.add(curr.val);
        curr = curr.next;
    }
    return result;
}
}

package com.saurabh.lru;

class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFront(Node node) {

        remove(node);
        addFirst(node);
    }

    public Node removeLast() {

        if (head.next == tail) {
            return null;
        }

        Node lruNode = tail.prev;

        remove(lruNode);

        return lruNode;
    }
}

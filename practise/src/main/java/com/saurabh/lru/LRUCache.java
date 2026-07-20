package com.saurabh.lru;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;

    private final Map<Integer, Node> cache;

    private final DoublyLinkedList dll;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        this.cache = new HashMap<>();

        this.dll = new DoublyLinkedList();
    }

    public int get(int key) {

        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        dll.moveToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        Node existingNode = cache.get(key);

        if (existingNode != null) {

            existingNode.value = value;

            dll.moveToFront(existingNode);

            return;
        }

        if (cache.size() == capacity) {

            Node lruNode = dll.removeLast();

            cache.remove(lruNode.key);
        }

        Node newNode = new Node(key, value);

        dll.addFirst(newNode);

        cache.put(key, newNode);
    }
}
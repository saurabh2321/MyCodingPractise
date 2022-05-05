package com.saurabh.ds;

public class BasicHashTable<K, V> {

	private HashEntry[] entry;
	private int capacity;
	private int size;

	public BasicHashTable(int tablesize) {
		this.capacity = tablesize;
		this.size = 0;
		this.entry = new HashEntry[this.capacity];
	}

	private class HashEntry<K, V> {

		private K key;
		private V value;

		public HashEntry(K key, V value) {

			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

	public int size() {
		return this.size;
	}

	private int calculateHash(K key) {

		int hashIndex = (key.hashCode() % this.capacity);
		// this is necessary to deal with collisions
		while (entry[hashIndex] != null && !entry[hashIndex].getKey().equals(key)) {
			hashIndex = (hashIndex + 1) % this.capacity;
		}
		return hashIndex;
	}

	public V get(K key) {

		int hash = calculateHash(key);

		if (entry[hash] == null) {
			System.out.println("we don't have anything for the given key");
			return null;
		} else {
			// otherwise get the hashentry for the key and return its value
			return (V) entry[hash].getValue();
		}
	}

	public void put(K key, V value) {

		int hash = calculateHash(key);

		entry[hash] = new HashEntry<K, V>(key, value);
		size++;
	}

	public V delete(K key) {
		// first get the value for this key so it can be returned
		V value = get(key);
		// clear out the hashtable slot for the key and return the removed value
		if (value != null) {
			int hash = calculateHash(key);

			entry[hash] = null;
			size--;
			hash = (hash + 1) % this.capacity;

			// If the next slot isn't empty we should re add it so we can keep the hash
			// algorithms clean
			while (entry[hash] != null) {

				HashEntry hashEntry = entry[hash];
				entry[hash] = null;
				System.out.println("Rehashing: " + hashEntry.getKey() + " - " + hashEntry.getValue());
				put((K) hashEntry.getKey(), (V) hashEntry.getValue());
				// we repositioned the hash item and didn't really add a new one so back off the
				// size
				size--;
				hash = (hash + 1) % this.capacity;
			}
		}

		return value;
	}
	
	public boolean hasKey(K key) {
		
		int hash = calculateHash(key);
		
		if(entry[hash] == null) {
			return false;
		}
		else {
			if(entry[hash].getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}
	
public boolean hasValue(V value) {
	
	for(int i =0; i< this.capacity ; i++) {
		
		HashEntry hashEntry = entry[i];
		
		if(hashEntry != null && hashEntry.getValue().equals(value)) {
			return true;
		}
	}
	return false;
}


}
		
		

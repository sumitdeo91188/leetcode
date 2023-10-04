package mod04.hashTable.ex02;

import java.util.LinkedList;

public class designHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        map.get(1);
        map.get(3);
        map.put(2,1);
        map.get(2);
        map.remove(2);
        map.get(2);
    }

    private static class MyHashMap {
        private final Bucket[] buckets;
        private final int keyRange;

        public MyHashMap() {
            this.keyRange = 2069;
            this.buckets = new Bucket[this.keyRange];
            for (int i = 0; i < keyRange; i++) {
                this.buckets[i] = new Bucket();
            }
        }

        protected int _hash(int key) {
            return key % this.keyRange;
        }

        public void put(int key, int value) {
            int bucketIndex = _hash(key);
            this.buckets[bucketIndex].insert(key, value);
        }

        public int get(int key) {
            int bucketIndex = _hash(key);
            Pair<Integer, Integer> pair = this.buckets[bucketIndex].get(key);
            return pair == null ? -1 : pair.value;
        }

        public void remove(int key) {
            int bucketIndex = _hash(key);
            this.buckets[bucketIndex].remove(key);
        }

        private static class Pair<K, V> {
            public K key;
            public V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private static class Bucket {
            private final LinkedList<Pair<Integer, Integer>> bucket;

            public Bucket() {
                bucket = new LinkedList<>();
            }

            public void insert(Integer key, Integer value) {
                boolean found = false;
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.key.equals(key)) {
                        pair.value = value;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    this.bucket.add(new Pair<>(key, value));
                }
            }

            public Pair<Integer, Integer> get(Integer key) {
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.key.equals(key)) {
                        return pair;
                    }
                }
                return null;
            }

            public void remove(Integer key) {
                for (Pair<Integer, Integer> pair : this.bucket) {
                    if (pair.key.equals(key)) {
                        this.bucket.remove(pair);
                        break;
                    }
                }
            }
        }
    }
}

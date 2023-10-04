package mod04.hashTable.ex01;

import java.util.LinkedList;

public class designHashSet {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }

    private static class MyHashSet {
        private final Bucket[] buckets;
        private final int keyRange;

        public MyHashSet() {
            this.keyRange = 769;
            this.buckets = new Bucket[this.keyRange];
            for (int i = 0; i < keyRange; i++) {
                this.buckets[i] = new Bucket();
            }
        }

        protected int _hash(int key) {
            return key % this.keyRange;
        }

        public void add(int key) {
            int bucketIndex = this._hash(key);
            this.buckets[bucketIndex].insert(key);
        }

        public void remove(int key) {
            int bucketIndex = this._hash(key);
            this.buckets[bucketIndex].delete(key);
        }

        public boolean contains(int key) {
            int bucketIndex = this._hash(key);
            return this.buckets[bucketIndex].exists(key);
        }

        private static class Bucket {
            private final LinkedList<Integer> bucket;

            public Bucket() {
                bucket = new LinkedList<>();
            }

            public void insert(Integer key) {
                int index = bucket.indexOf(key);
                if (index == -1) {
                    bucket.addFirst(key);
                }
            }

            public void delete(Integer key) {
                bucket.remove(key);
            }

            public boolean exists(Integer key) {
                int index = bucket.indexOf(key);
                return index != -1;
            }
        }
    }
}

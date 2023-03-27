package Tests;

import Utils.ED.HashTable;

public class TestHashTable{
        public static void main(String[] args) {
            HashTable<String, Integer> hashTable = new HashTable<>(10);
    
            hashTable.Put("banana", 2);
            hashTable.Put("abacaxi", 5);
            hashTable.Put("maçã", 3);
            hashTable.Put("uva", 4);
    
            System.out.println(hashTable.get("banana")); // Output: 2
            System.out.println(hashTable.get("abacaxi")); // Output: 5
            System.out.println(hashTable.get("maçã")); // Output: 3
            System.out.println(hashTable.get("uva")); // Output: 4
    
            hashTable.remove("maçã");
    
            System.out.println(hashTable.get("maçã")); // Output: null
        }
    }
    

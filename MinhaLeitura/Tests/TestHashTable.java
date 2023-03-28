package Tests;

import Utils.ED.HashTable;

public class TestHashTable{
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();

        // Adicionando elementos na tabela
        table.put("A", 1);
        table.put("B", 2);
        table.put("C", 3);
        table.put("D", 4);
        
        // Verificando se a tabela contém a chave "A"
        System.out.println(table.containsKey("A")); // true
        
        // Verificando se a tabela contém o valor 3
        System.out.println(table.containsValue(3)); // true
        
        // Obtendo o valor associado à chave "D"
        System.out.println(table.get("D")); // 4
        table.put("D", 23);
        System.out.println(table.get("D")); // 23

        // Removendo o elemento com a chave "C"
        table.remove("C");
        System.out.println(table.get("C")); // null + mensagem de erro

        // Verificando se a tabela está vazia
        System.out.println(table.isEmpty()); // false

        // Removendo todos os elementos da tabela
        table.clear();
        System.out.println(table.isEmpty()); // true
    }
    }
    

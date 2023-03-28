package Utils.ED;

public interface HashTableInterface <K, V> {
    // Insere um par chave-valor na tabela hash
    void put(K key, V value);
    
    // Retorna o valor associado à chave especificada
    V get(K key);
    
    // Remove a entrada correspondente à chave especificada da tabela hash
    void remove(K key);
    
    // Verifica se a chave especificada está presente na tabela hash
    boolean containsKey(K key);
    
    // Verifica se o valor especificado está presente na tabela hash
    boolean containsValue(V value);
    
    // Verifica se a tabela hash está vazia
    boolean isEmpty();
    
    // Retorna o número de entradas na tabela hash
    int size();
}

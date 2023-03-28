package Tests;

import Utils.ED.LinkedListDouble;
import Utils.Reading.ReadingLinkedDoubleList;

import java.io.IOException;

public class LeitorListDouble {
    public static void main(String[] args){
        // criar o leitor e ler a hashtable do arquivo
        String filePath = "E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/list_double.bin";
        ReadingLinkedDoubleList<Integer> reader = new ReadingLinkedDoubleList<>(filePath);
        LinkedListDouble<Integer> list;
        try {
            list = reader.read();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            list = null;
        }

        // percorrer a lista de entradas e imprimir chave e valor de cada entrada
        int i = list.search(10);
        System.out.println(i); // 10
    }
}

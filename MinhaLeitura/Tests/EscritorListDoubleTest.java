package Tests;

import Utils.ED.LinkedListDouble;
import Utils.Writer.LinkedDoubleListWriter;

public class EscritorListDoubleTest {
    public static void main(String[] args) {
        LinkedListDouble<Integer> list = new LinkedListDouble<>();
        list.addLast(10);
        list.addLast(10);
        
    
        LinkedDoubleListWriter<Integer> escritor = new LinkedDoubleListWriter<>();
        escritor.save(list, "E://Documentos/UFERSA/Disciplinas/ED1/MinhaLeitura/MinhaLeitura/Tests/Bin/list_double.bin");
    }
}

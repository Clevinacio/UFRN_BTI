package br.ufrn.imd.edb2;

import java.io.*;
import java.util.*;


public class Compressor {

    private HashMap<Character, Integer> mapFrequency;
    private HashMap<Character, String> mapCodeTable;
    private Node heapCode;
    private String fileName;

    public Compressor() {
        mapFrequency = new HashMap<Character, Integer>();
        mapCodeTable = new HashMap<Character, String>();
        heapCode = null;
    }

    public HashMap<Character, Integer> getMapFrequency() {
        return mapFrequency;
    }

    public Node getHeapCode() {
        return heapCode;
    }

    public void setHeapCode(Node heapCode) {
        this.heapCode = heapCode;
    }

    public HashMap<Character, Integer> characterFrequency(String text, int counter) {
        char[] strArray = text.toCharArray();
        int contado = 0;
        for (char caracter : strArray) {
            if (mapFrequency.containsKey(caracter)) {
                mapFrequency.put(caracter, mapFrequency.get(caracter) + 1);
            } else {
                mapFrequency.put(caracter, 1);
            }
        }

        //Verifica as quebras de linha e, se houver mais de uma, adiciona ao map
        if (counter > 1) {
            mapFrequency.put((char) 10, counter - 1);
        }

        //Ordena o map
        mapFrequency = sort(mapFrequency);

        return mapFrequency;
    }

    public HashMap<Character, Integer> characterFrequency(String fileName) throws IOException {
        this.fileName = fileName;

        String text = ""; //concatena linhas do arquivo
        int counterBreak = 0; //verifica quebras de linhas

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.ready()) {
            text = text.concat(br.readLine());
            counterBreak++;
        }

        return characterFrequency(text, counterBreak);
    }

    public MinHeap makeMinHeap() {
        if (mapFrequency.isEmpty()) {
            return null;
        }

        MinHeap fila = new MinHeap();
        for (Map.Entry entry : mapFrequency.entrySet()) {
            fila.addNode(new Node((Character) entry.getKey(), (int) entry.getValue()));
        }

        fila.addNode(new Node(300, 1)); //add EOF

        return fila;
    }

    public void heapCode() {
        if (mapFrequency.isEmpty()) {
            return;
        }

        MinHeap fila = makeMinHeap();

        while (fila.getSize() != 1) {
            Node left = fila.remove();
            Node right = fila.remove();

            int count = left.getCount() + right.getCount();
            Node current = new Node('\u0000', count);

            current.setLeft(left);
            current.setRight(right);

            fila.addNode(current);
        }

        setHeapCode(fila.peek());
    }

    public void CodificationTable() {
        if (mapFrequency.isEmpty()) {
            return;
        }

        if (heapCode.isLeaf()) {
            mapCodeTable.put((char) heapCode.getLetter(), "1");
            return;
        }

        //cria tabela de codificacao
        setCode(heapCode, "");
    }

    public void setCode(Node index, String code) {
        if (index.getLeft() == null && index.getRight() == null) {
            mapCodeTable.put((char) index.getLetter(), code);
            return;
        }

        setCode(index.getLeft(), code + "0");
        setCode(index.getRight(), code + "1");
    }

    public void codeText() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        BitSet txtCode = new BitSet();
        String code;
        int charCurrent = 0;
        int position = 0;

        while ((charCurrent = br.read()) != -1) {                    //leitura char - char no arquivo
            code = mapCodeTable.get((char) charCurrent);            //busca pelo codigo do caracter corrente

          /*Se náo encontrar o código no map, o retorno será null. Isso ocorre quando
            o SO reconhece o /r/n. Só está sendo adicionado o codigo do /n.*/
            if (code == null) {
                continue;
            }

            for (int i = 0; i < code.length(); i++) {       //percorre caracteres do codigo
                if (code.charAt(i) == '1') {
                    txtCode.set(position, true);            //atribui valor 1 no bitset
                }
                position++;
            }
        }

        code = mapCodeTable.get((char) 300);            //Busca EOF
        for (int i = 0; i < code.length(); i++) {       //Adiciona ao binario
            if (code.charAt(i) == '1') {
                txtCode.set(position, true);
            }
            position++;
        }

        while (position % 8 != 0) {                    //para que seja multiplo de 8, as posicioes que sobrarem depois do EOF sao preenchidas com 1
            txtCode.set(position, true);
            position++;
        }

        saveBinaryFile();

        OutputStream os = new FileOutputStream(new File("convert.edz"));
        os.write(convertBitSetToArray(txtCode));
        os.close();
    }

    public void saveBinaryFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("symbolTable.edt");
        for (Map.Entry entry : mapCodeTable.entrySet()) {
            writer.println(entry.getKey() + "" + entry.getValue());
        }
        writer.close();
    }

    public byte[] convertBitSetToArray(BitSet txtCode) {
        byte[] bytes = new byte[(txtCode.length() + 7) / 8];
        for (int i = 0; i < txtCode.length(); i++) {
            if (txtCode.get(i)) {
                bytes[i / 8] |= 1 << (7 - i % 8);
            }
        }

        return bytes;
    }


    public HashMap<Character, Integer> sort(HashMap<Character, Integer> map) {
        //Lista com as chaves de map
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());

        //Ordena chaves da maior para menor quantiade de repetições
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> v1, Map.Entry<Character, Integer> v2) {
                if (v1.getValue() > v2.getValue()) {
                    return -1;
                }
                if (v1.getValue() < v2.getValue()) {
                    return 1;
                }
                return 0;
            }
        });

        //Cria hashMap temporário para armazenar o ordenado
        HashMap<Character, Integer> ordered = new LinkedHashMap<Character, Integer>();

        //Salva dados da lista ordenada em ordered
        for (Map.Entry<Character, Integer> item : list) {
            ordered.put(item.getKey(), item.getValue());
        }

        map = ordered;

        return ordered;
    }
}
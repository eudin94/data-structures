package week3.model;

import java.util.Arrays;
import java.util.Scanner;

public class Vetor {

    private Integer[] array;
    private Integer validos = 0;
    private Scanner sc = new Scanner(System.in);

    public Vetor() {}

    public Vetor(Integer n) {
        array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer n) {
        array = new Integer[n];
    }

    public void povoaVetor() {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                validos++;
            }
            array[i] = (int)(Math.random() * array.length * 100);
        }
    }

    public void povoaVetorSequencial() {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                validos++;
            }
            array[i] = (int)(Math.random() * (array.length * 10 - 1) + 1);
        }
        Arrays.sort(array);
    }

    public void atribuiValor(Integer n) {
        System.out.print("Insira o valor que você deseja para a posição [" + n + "] do vetor; ");
        if (this.array[n] == 0) {
            validos++;
        }

        this.array[n] = lerNatural();
        if (this.array[n] == 0) {
            validos--;
        }
    }

    public void removeValorPorIndex(Integer n) {
        if (this.array[n] != 0) {
            validos--;
        }
        this.array[n] = 0;
        System.out.println("Valor na posição [" + n + "] apagado com sucesso!");
    }

    public void removeValor(Integer n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                array[i] = 0;
                validos--;
            }
        }

    }

    public void tamanho() {
        System.out.println("Tamanho total do vetor: " + array.length);
    }

    public void informaQuantosOcupados() {
        System.out.println("O vetor possui " + validos + " espaço(s) ocupado(s).");
    }

    public void maiorValor() {
        int maior = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > maior) {
                maior = array[i];
            }
        }
        if(maior == 0) System.out.println("Vetor vazio...");
        else System.out.println("Maior valor do vetor: " + maior);
    }

    public void menorValor() {
        int menor = -1;
        for(int i = 0; i < array.length; i++) {
            if(menor < 0 && array[i] != 0) {
                menor = array[i];
            }
            if(menor > array[i] && array[i] != 0) {
                menor = array[i];
            }
        }
        if(menor == -1) System.out.println("Vetor vazio...");
        else System.out.println("Menor valor do vetor: " + menor);
    }

    public void buscaSequencial() {
        System.out.print("Digite o valor para buscar; ");
        int n = lerNatural();
        int exists = 0;
        Vetor temp = new Vetor(array.length);
        for (int i = 0; i < array.length; i++) {
            if(n == array[i]) {
                temp.array[i] = array[i];
                exists ++;
            }
        }
        boolean firstDone = false;
        if (exists > 0) {
            System.out.print("O valor existe no vetor, index: ");
            for (int i = 0; i < temp.array.length; i++) {
                if (temp.array[i] != 0) {

                    if (firstDone) {
                        System.out.print(", ");
                    }
                    System.out.print(i);
                    firstDone = true;
                }
            }
            System.out.println(".");
        }
        else System.out.println("O valor não existe no vetor.");
    }

    public void buscaBinaria() {
        Arrays.sort(array);
        System.out.print("Digite o valor para buscar binariamente; ");
        int key = lerNatural();
        int first = 0;
        int last = array.length - 1;
        int n = buscaBinariaRecursiva(first, last, key);
        if(n == -1) System.out.println("O valor não existe no vetor.");
        else System.out.println("O valor existe no vetor.");
    }

    public int buscaBinariaRecursiva(int first, int last, int key) {
        if (last >= first) {
            int mid = first + (last - first) / 2;

            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] > key) {
                return buscaBinariaRecursiva(first, mid - 1, key);
            }
            else {
                return buscaBinariaRecursiva(mid + 1, last, key);
            }
        }
        return -1;
    }

    public void ordenaBubble() {
        int temp;
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public void ordenaInsert() {
        for (int i = 1; i < array.length; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public void ordenaSelect() {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }

    public void listarConteudo() {
        System.out.println();
        int counter = 0;
        for(int i = 0; i < array.length; i++) {
            System.out.print(String.format("%5d   ", array[i]));
            counter++;
            if (counter == 10) {
                System.out.println();
                counter = 0;
            }
        }
        System.out.println();
    }

    public Integer lerNatural() {
        int natural = 0;
        while(true) {
            System.out.print("Digite um valor inteiro e positivo: ");
            natural = sc.nextInt();
            if(natural >= 0) break;
            System.out.println("Valor inválido!");
        }
        return natural;
    }
}

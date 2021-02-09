package model;

import java.util.Arrays;
import java.util.Scanner;

public class Vetor {

    private Integer[] array;
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

    public void insereAleatorios() {
        for (int i = 0; i < array.length; i++) {
            array[i] =(int) (Math.random() * 10000);
        }
    }

    public void insere(Integer n) {
        System.out.print("Insira o valor que você deseja para a posição [" + n + "] do vetor; ");
        this.array[n] = lerNatural();
    }

    public void apaga(Integer n) {
        this.array[n] = 0;
        System.out.println("Valor na posição [" + n + "] apagado com sucesso!");
    }

    public void tamanho() {
        System.out.println("Tamanho total do vetor: " + array.length);
    }

    public void ocupados() {
        int counter = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                counter++;
            }
        }
        System.out.println("O vetor possui " + counter + " espaço(s) ocupado(s).");
    }

    public void maior() {
        int maior = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > maior) {
                maior = array[i];
            }
        }
        if(maior == 0) System.out.println("Vetor vazio...");
        else System.out.println("Maior valor do vetor: " + maior);
    }

    public void menor() {
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

    public void consulta() {
        System.out.print("Digite o valor para buscar; ");
        int n = lerNatural();
        boolean exists = false;
        for (int i = 0; i < array.length; i++) {
            if(n == array[i]) {
                exists = true;
                break;
            }
        }
        if (exists == true) System.out.println("O valor existe no vetor.");
        else System.out.println("O valor não existe no vetor.");
    }

    public void consultaBinariaRecursiva() {
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

    public void listar() {
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

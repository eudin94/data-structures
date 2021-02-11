package week3.application;

import week3.model.Vetor;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Escolha o tamanho desejado para o vetor; ");
        Vetor vetor = new Vetor(lerNatural());
        boolean on = true;
        int option = 0;

        while(on) {
            System.out.print("\n\n########## GERENCIADOR DE VETOR ##########"
                    + "\n01 - Povoar o vetor"
                    + "\n02 - Povoar o vetor em ordem crescente"
                    + "\n03 - Total de elementos válidos"
                    + "\n04 - Maior e menor elemento"
                    + "\n05 - Listar conteúdo"
                    + "\n06 - Inserir valor em posição específica"
                    + "\n07 - Apagar um valor específico"
                    + "\n08 - Apagar o valor de uma posição específica"
                    + "\n09 - Busca sequencial por valor"
                    + "\n10 - Busca binária por valor"
                    + "\n11 - Ordenar Bubblesort"
                    + "\n12 - Ordenar Insertsort"
                    + "\n13 - Ordenar Selectionsort"
                    + "\n00 - Encerra o gerenciador"
                    + "\n • - Escolha uma opção; ");

            option = lerNatural();

            switch (option) {

                case 0 :
                    on = false;
                    break;

                case 1 :
                    vetor.povoaVetor();
                    break;

                case 2 :
                    vetor.povoaVetorSequencial();
                    break;

                case 3 :
                    vetor.informaQuantosOcupados();
                    break;

                case 4 :
                    vetor.maiorValor();
                    vetor.menorValor();
                    break;

                case 5 :
                    vetor.listarConteudo();
                    break;

                case 6 :
                    System.out.print("Insira a posição a qual você deseja atribuir o valor; ");
                    vetor.atribuiValor(lerNatural());
                    break;

                case 7 :
                    System.out.print("Insira o valor que você deseja apagar do vetor; ");
                    vetor.removeValor(lerNatural());
                    break;

                case 8 :
                    System.out.print("Insira a posição a qual você deseja apagar o valor; ");
                    vetor.removeValorPorIndex(lerNatural());
                    break;

                case 9 :
                    System.out.println("Insira o valor a ser buscado; ");
                    vetor.buscaSequencial();
                    break;

                case 10 :
                    System.out.println("Insira o valor a ser buscado; ");
                    vetor.buscaBinaria();
                    break;

                case 11 :
                    vetor.ordenaBubble();
                    break;

                case 12 :
                    vetor.ordenaInsert();
                    break;

                case 13 :
                    vetor.ordenaSelect();
                    break;

                default :
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        System.out.println("########## ENCERRANDO APLICAÇÃO ##########");
    }

    public static Integer lerNatural() {
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

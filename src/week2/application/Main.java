package week2.application;

import week2.model.Vetor;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Vetor vetor = new Vetor(10000);

        vetor.insereAleatorios();

        vetor.apaga(36);
        vetor.apaga(72);

//        vetor.listar();

        vetor.consulta();
        vetor.consultaBinariaRecursiva();

        vetor.ocupados();
        vetor.maior();
        vetor.menor();

//        vetor.listar();
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

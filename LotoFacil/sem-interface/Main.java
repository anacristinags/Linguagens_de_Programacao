import java.util.Scanner;
import java.io.*;
import java.lang.Object;
import java.util.Random;
import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner snc = new Scanner(System.in);
        Random aleatorio = new Random();
        int i=9, num, par;
        char letra, sorte;
        do{
            System.out.println("*************************");
            System.out.println("Menu LOTOFÁCIL");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("*************************");
            try {
                i = snc.nextInt();
            } catch (InputMismatchException erro){
                System.err.println("Entrada Inválida, tente novamente");
                snc.nextLine();
            }
            switch (i){
                case 1:
                    System.out.println("Digite um número entre 0 a 100:");
                    try {
                        num = snc.nextInt();
                        if (num >=0 && num <=100){
                        int numero = aleatorio.nextInt(101);
                            if (num == numero){
                                System.out.println("Você ganhou R$ 1.000,00 reais");
                            } else System.out.println("Que pena!\nNúmero digitado: "+ num +"\nO número sorteado foi: "+numero);
                    } else System.err.println("Aposta inválida");
                    } catch (InputMismatchException erro){
                        System.err.println("Entrada Inválida, tente novamente");
                        snc.nextLine();
                    }
                    break;

                case 2:
                        System.out.println("Digite uma letra de A à Z");
                        try{
                            letra = (char) System.in.read();
                            if(Character.isLetter(letra)){
                                letra = Character.toUpperCase(letra);
                                sorte = 'A';
                                //sorte = (char) (aleatorio.nextInt(25) + 65); (caso queira sortear uma letra aleatória)
                                if (letra==sorte){
                                    System.out.println("Você ganhou R$ 500,00 reais");
                                } else System.out.println("Que pena!\nA letra digitada foi: "+letra+"\nA letra sorteada foi: "+sorte);
                            } else System.err.println("Aposta Inválida");
                        } catch (IOException e){
                            System.err.println("Entrada Inválida, tente novamente");
                            snc.nextLine();
                        }
                    break;

                case 3:
                    System.out.println("Digite um número (diferente de 0) para apostar em Par ou Ímpar");
                    try {
                        par = snc.nextInt();
                        if (par % 2 == 0 && par != 0) {
                            System.out.println("Você ganhou R$100,00 reais");
                        } else
                            System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                    }catch (InputMismatchException erro){
                        System.err.println("Entrada Inválida, tente novamente");
                        snc.nextLine();}
                    break;
            }
        }while (i!=0);

    }
}

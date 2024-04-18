
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MontyHall {
    public static void main(String[] args) {
        System.out.println("Escolha uma porta:\n[1] [2] [3]");
        Random aleatorio = new Random();
        Scanner scn = new Scanner(System.in);
        try {
            int porta = scn.nextInt();
            if (porta<1 || porta>3){System.err.println("Entrada inválida");
            } else {
                int portaSorteada = aleatorio.nextInt(3) + 1;
                int portaAberta;
                do { //loop para sortear uma porta diferente da porta sorteada e da que foi aberta pelo jogador
                    portaAberta = aleatorio.nextInt(3) + 1;
                } while (portaAberta == portaSorteada || portaAberta == porta);

                System.out.println("O apresentador abre a porta: " + portaAberta);
                System.out.println("\nGostaria de trocar de porta?" +
                        "\nDigite '1' para sim\nDigite '0' para não");
                try {
                    int i = scn.nextInt(2);  //limitando a entrada [0,1]
                    switch (i) {
                        case 1:
                            int porta2;
                            do { //loop para trocar de porta, deve sortear uma diferente da porta escolhida
                                porta2 = aleatorio.nextInt(3) + 1;  // e uma diferente da porta aberta
                            } while (porta2 == porta || porta2 == portaAberta);
                            System.out.println("\nA nova porta aberta é: " + porta2);

                            //comparando as portas para indicar a vitória ou derrota
                            if (porta2 == portaSorteada) {
                                System.out.println("Parabéns você ganhou!!\nA porta sorteada foi: "+portaSorteada);
                            } else {
                                System.out.println("Que pena! Você escolheu a porta:"+ porta2
                                        +"\nA porta sorteada foi: " + portaSorteada);
                            }
                            break;

                        case 0:
                            //comparando as portas para indicar a vitória ou derrota
                            if (porta == portaSorteada) {
                                System.out.println("Parabéns você ganhou!!\nA porta sorteada foi: "+portaSorteada);
                            } else {
                                System.out.println("Que pena! Você escolheu a porta: "+ porta
                                        + "\nA porta sorteada foi: " + portaSorteada);
                            }
                            break;

                    }
                } catch (InputMismatchException e) { //exceção pra entradas inválidas (letras ou != 1 e 0)
                    System.err.println("Entrada inválida, digite 0 ou 1");
                    scn.nextLine();
                }
            }
         } catch (InputMismatchException e){ //exceção pra entradas inválidas
            System.err.println("Entrada inaválida");}
    }
}

//o programa deve ser capaz de cadastrar, listar e remover as pessoas da agenda
//a classe "Pessoa" deve conter os seguintes atributos: nome, endereço e telefone

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ConcurrentModificationException;

public class Agenda {
    public static void main(String[] args) {
        ArrayList<Pessoa> infoAgenda = new ArrayList<>(); // -> ArrayList<NomeClasse> nomeObj
        Scanner scn = new Scanner(System.in);
        int opcao = -1;
        do {
            try {
                System.out.println("1) Cadastrar pessoa na agenda.");
                System.out.println("2) Listar pessoas da agenda.");
                System.out.println("3) Remover pessoa da agenda");
                System.out.println("0) Sair.");
                System.out.println("Digite a opção desejada ");
                opcao = scn.nextInt(4); //limitando as possiveis entradas [0,1,2,3]
                switch (opcao) {
                    case 1:
                        cadastrar(infoAgenda);
                        break;
                    case 2:
                        listar(infoAgenda);
                        break;
                    case 3:
                        remover(infoAgenda);
                        break;
                }
            } catch (InputMismatchException e) { //excecão para entrada de dados errada
                System.err.println("Digite um número entre 0 e 3");
                scn.nextLine(); //garantindo que não crie um loop
            }
        } while (opcao != 0);
    }

    //método cadastrar que recebe um ArrayList de "Pessoa"
    private static void cadastrar(ArrayList<Pessoa> infoAgenda) {
        Scanner scn = new Scanner(System.in);
        String nome, endereco, telefone;
        System.out.println("Digite o nome:");
        nome = scn.nextLine();
        System.out.println("Digite o endereço:");
        endereco = scn.nextLine();
        System.out.println("Digite o telefone:");
        telefone = scn.nextLine();
        Pessoa objPessoa = new Pessoa(nome, endereco, telefone);//obj que receberá os dados fornecidos pelo usuario
        infoAgenda.add(objPessoa); //add o objPessoa ao obj "infoAgenda" que é do tipo ArrayList
    }

    //método listar
    private static void listar(ArrayList<Pessoa> infoAgenda) {
        if (infoAgenda.isEmpty()) {
            System.err.println("A agenda já está vazia");
        } else {
            for (int i = 0; i < infoAgenda.size(); ++i) { //loop com o tamanho do array
                System.out.println((i + 1) + "º Contato: " + infoAgenda.get(i).toString());
            } //infoAgenda.get(posiçaõ do array).toString()
        } //Obs:toString já estava implicito por conta do '+', porém achei que devia colocar para ficar claro
    }

    //método remover
    private static void remover(ArrayList<Pessoa> infoAgenda) {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Digite o número do Contato que deseja remover");
            String telefone = scn.nextLine();
            for (Pessoa i : infoAgenda) { //for para percorrer arrays -> (Classe/Tipo nome(index) : coleção/array)
                if (i.getTelefone().equals(telefone)) { //get de "Pessoa" para comparar com a String lida telefone
                    infoAgenda.remove(i); //remove de infoAgenda o obj pessoa
                    System.out.println("Contato removido com sucesso");
                } else System.out.println("Número digitado está incorreto");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Agenda Vazia");
        } //exceção para não parar o programa quando zerar o array
    }
}
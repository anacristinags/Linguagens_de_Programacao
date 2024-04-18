// MontyHall com as mesmas regas, mas com interface

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class MontyHallGUI extends JFrame {

    // outros atributos
    Random aleatorio = new Random();

    // painel
    JPanel painel = new JPanel();
    JLabel men = new JLabel("Bem vindo(a) ao Monty Hall!");
    JLabel men0 = new JLabel("Escolha uma porta (1, 2 ou 3)");
    JButton bt1 = new JButton("Apostar");
    JTextField escolha = new JTextField(10);

    public MontyHallGUI (){
        this.setTitle("MontyHall");
        this.setSize(350,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 15));
        //FlowLayout serve para determinar que os componentes do painel estarão no centro com o ".CENTER"
        // depois a distância horizontal e a distância vertical entre os componentes
        this.add(painel);
        painel.setBackground(new Color(166, 234, 151));
        painel.add(men);
        painel.add(men0);
        painel.add(escolha);
        painel.add(bt1);

        escolha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e); //não é necessário caso não queira utilizar todos os componentes, mas é uma boa prática
                char porta = e.getKeyChar(); //o parâmetro "e" receberá a variavel, o "getKeyChar()": retorna o caractere que foi digitado

                //if para limitar a entrada, se for != de: número (.isDigit) e maior que 1 (.length()<1)
                //o ".consume" impede o processamento
                if (!(Character.isDigit(porta) && escolha.getText().length()<1)){
                    e.consume();
                } //obs: se eu quisesse diferente de letra utilizaria o .isLetter
            }
        });

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta1();}
        });

        this.getContentPane().add(painel); // permite que os componentes sejam add no painel
        this.setLocationRelativeTo(null); // ao abrir, o painel começará no centro da tela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // permite que a operação seja encerrada
        this.setVisible(true); // torna o painel visivel
    }

    public void aposta1() {
        try{ //exceção caso não aposte nada
            int portaAberta;
            int portaSorteada = aleatorio.nextInt(3) + 1;
            int portaApostada = Integer.parseInt(escolha.getText()); // o int portaApostada receberá o método da classe "Interger
            // o método ".parseInt" converterá o dado digitado do JTextField "escolha" para um tipo primitivo int

            if (portaApostada >= 1 && portaApostada <= 3) {

                //abrindo uma porta != de porta Sorteada e porta escolhida
                do {
                    portaAberta = aleatorio.nextInt(3) + 1;
                } while (portaAberta == portaSorteada || portaAberta == portaApostada);
                JOptionPane.showMessageDialog(null, "A porta aberta foi: " +  portaAberta,
                        "Porta Aberta", JOptionPane.INFORMATION_MESSAGE);

                try { //exceção caso cancele a posta no JOptionPane
                    //fznd um JOptionPane do tipo String para poder comparar com uma boolean (opcao.equalsIgnoreCase())
                    String opcao = JOptionPane.showInputDialog(null, "Gostaria de trocar de porta? (s/n) ",
                            "Escolha", JOptionPane.INFORMATION_MESSAGE);

                    //só será considerado o caracter "s/S"
                    boolean trocarPorta = opcao.equalsIgnoreCase("s");

                    //garantindo que ambas as variaveis sejam as mesmas (caso o jogador queira trocar)
                    int portaMudada = portaApostada;

                    if (trocarPorta) { //caso digite "s/S" "trocarPorta" será considerado

                        do { //trocando a porta diferente da que foi aberta e a escolhida 1º
                            portaMudada = aleatorio.nextInt(3) + 1;
                        } while (portaMudada == portaAberta || portaMudada == portaApostada);

                        JOptionPane.showMessageDialog(null, "Você Mudou para a porta: "
                                + portaMudada,"Porta Trocada", JOptionPane.INFORMATION_MESSAGE);
                    }

                    //comparando as portas para indicar a vitória ou derrota
                    if (portaMudada == portaSorteada) {
                        JOptionPane.showMessageDialog(null, "Parabéns você ganhou!" +
                                "\nA porta sorteada foi: " + portaSorteada, "Dia de Sorte!", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Que pena você perdeu!" +
                                "\nA porta sorteada foi: " + portaSorteada, "Não foi dessa vez!", JOptionPane.INFORMATION_MESSAGE);

                }catch (NullPointerException e){
                    JOptionPane.showMessageDialog(null, "Você cancelou a Aposta",
                            "Cancelamento", JOptionPane.CANCEL_OPTION);
                }


            } else {
                JOptionPane.showMessageDialog(null, "Digite um númeuro entre 1 e 3",
                        "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
            }
            escolha.setText(""); //limpando o TextField p/ uma nova aposta

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite uma entrada válida",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {new MontyHallGUI();}
}
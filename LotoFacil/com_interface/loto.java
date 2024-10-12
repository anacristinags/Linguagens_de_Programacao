
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.awt.Color;


public class Loto extends JFrame{
    Color verde = new Color(0, 100, 0); //definir cor para mensagem
    Color vermelho = new Color(231, 9, 9);
    int tempo = 3000; // temporizador para fechar paineis
    Random aleatorio = new Random();

    // add imagens
    ImageIcon ft1 = new ImageIcon(getClass().getResource("/imagens.java/lucky.png"));
    JLabel jLimagem1 = new JLabel(ft1);
    ImageIcon ft2 = new ImageIcon(getClass().getResource("/imagens.java/numeros100.jpg"));
    JLabel jLimagem2 = new JLabel(ft2);
    ImageIcon ft3 = new ImageIcon(getClass().getResource("/imagens.java/letras.jpg"));
    //new ImageIcon(getClass().getResource("/imagens.java/perdeu.png"));
    JLabel jLimagem3 = new JLabel(ft3);
    ImageIcon ft4 = new ImageIcon(getClass().getResource("/imagens.java/impar_par.jpg"));
    JLabel jLimagem4 = new JLabel(ft4);
    ImageIcon ft5 = new ImageIcon(getClass().getResource("/imagens.java/venceu.png"));
    JLabel jLimagem5 = new JLabel(ft5);
    ImageIcon ft6 = new ImageIcon(getClass().getResource("/imagens.java/perdeu.png"));
    JLabel jLimagem6 = new JLabel(ft6);

    //uso geral
    private JLabel perde1 = new JLabel("Que pena!");
    private JLabel mensagem1 = new JLabel("");
    private JLabel mensagem2 = new JLabel("");

    // painel do menu
    private JPanel painel = new JPanel();
    private JLabel lBMen = new JLabel("Menu LOTOFACIL");
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button0;
    private JLabel lBMen1 = new JLabel("1) Apostar de 0 a 100");;
    private JLabel lBMen2 = new JLabel("2) Apostar de A à Z");
    private JLabel lBMen3 = new JLabel("3) Apostar em par ou ímpar");;
    private JLabel lBMen0 = new JLabel("0) Sair");;

    // painel 1)
    //private JPanel panel1 = new JPanel();
    private JLabel aposta1 = new JLabel("Digite um número entre 0 e 100:");
    private JLabel vence1 = new JLabel("Parabéns você ganhou R$1000,00");
    private JTextField numero = new JTextField(3);
    private JButton botaoAposta1 = new JButton("Apostar");


    // painel 2)
    private JLabel aposta2 = new JLabel("Digite uma letra de A à Z");
    private  JLabel vence2 = new JLabel("Você ganhou R$ 500,00 reais");
    private JTextField letra = new JTextField("",1);
    private JButton botaoAposta2 = new JButton("Apostar");

    // painel 3)
    private JLabel aposta3 = new JLabel("Digite um número diferente de 0");
    private JLabel vence3 = new JLabel("Você ganhou R$100,00 reais");
    private JTextField par = new JTextField(10);
    private JButton botaoAposta3 = new JButton("Apostar");

    //Construtor
        public Loto (){
            this.setTitle("LOTOFÁCIL");
            this.setSize(400,250);

            //definido posições
            lBMen.setBounds(190, 0, 200,25);
            lBMen1.setBounds(190, 20, 200,25);
            lBMen2.setBounds(190,40, 200,25);
            lBMen3.setBounds(190,60, 200,25);
            lBMen0.setBounds(190,80, 200,25);
            button1.setBounds(190,115,60,30);
            button2.setBounds(270,115,60,30);
            button3.setBounds(190,160,60,30);
            button0.setBounds(270,160,60,30);
            jLimagem1.setBounds(0,0,200,200);
            painel.setLayout(null);
            button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button0.setCursor(new Cursor(Cursor.HAND_CURSOR));

            //add os atributos e config o painel menu
            painel.add(jLimagem1);
            painel.add(lBMen);
            painel.add(lBMen1);
            painel.add(lBMen2);
            painel.add(lBMen3);
            painel.add(lBMen0);
            painel.add(button1);
            painel.add(button2);
            painel.add(button3);
            painel.add(button0);
            this.getContentPane().add(painel);
            this.setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);

            //Acionamento do Botão 1
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //definido posições e conf do painel
                    Primeiro obj1 = new Primeiro();
                    obj1.setTitle("Aposta de 1 a 100");
                    obj1.setSize(400,250);
                    aposta1.setBounds(190,15,200,25);
                    numero.setBounds(220, 60, 100, 30);
                    botaoAposta1.setBounds(220, 100, 100,30);
                    jLimagem2.setBounds(8,10,180,190);
                    jLimagem5.setBounds(8,10,180,190);
                    jLimagem6.setBounds(8,10,180,190);
                    vence1.setBounds(190,70,200,200);
                    perde1.setBounds(240,45,200,200);
                    mensagem1.setBounds(190, 65,200,200);
                    mensagem2.setBounds(190,80, 200,200);
                    obj1.setLayout(null);
                    botaoAposta1.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    //add os atributos
                    obj1.add(jLimagem2);
                    obj1.add(jLimagem5);
                    obj1.add(jLimagem6);
                    obj1.add(aposta1);
                    obj1.add(numero);
                    obj1.add(botaoAposta1);
                    obj1.add(vence1);
                    obj1.add(perde1);
                    obj1.add(mensagem1);
                    obj1.add(mensagem2);

                    // definindo cor
                    vence1.setForeground(verde);
                    perde1.setForeground(vermelho);

                    // definindo visibilidade
                    jLimagem2.setVisible(true);
                    jLimagem5.setVisible(false);
                    jLimagem6.setVisible(false);
                    vence1.setVisible(false);
                    perde1.setVisible(false);
                    mensagem1.setVisible(false);
                    mensagem2.setVisible(false);
                    botaoAposta1.setEnabled(true); //reabilitando o botãoAposta

                    //limitando apenas números no textField "numero"
                    numero.addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            super.keyTyped(e);
                            char c = e.getKeyChar();
                            if (!(Character.isDigit(c) || c==KeyEvent.VK_DELETE)){
                                getToolkit().beep();
                                e.consume();}
                        }
                    });
                    numero.setText(""); //limpando textfield
                    obj1.setLocationRelativeTo(null);
                    obj1.setVisible(true);

                    //Acionamento do botão "Aposta1"
                    botaoAposta1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoAposta1.isEnabled()) {return;} // verificando se o botão não está habilitado
                            try {
                                int numApostado = Integer.parseInt(numero.getText());
                                if (numApostado >= 0 && numApostado <=100){
                                    int sorte = aleatorio.nextInt(101);
                                    if (numApostado==sorte){
                                        vence1.setVisible(true);
                                        jLimagem5.setVisible(true);
                                        jLimagem2.setVisible(false);
                                    } else {
                                        mensagem1.setText("O número digitado: "+numApostado);
                                        mensagem2.setText("O número sorteado foi: "+sorte);
                                        perde1.setVisible(true);
                                        mensagem1.setVisible(true);
                                        mensagem2.setVisible(true);
                                        jLimagem6.setVisible(true);
                                        jLimagem2.setVisible(false);}
                                } else JOptionPane.showMessageDialog(null,
                                        "Tente novamente!\nDigite um número entre 0 e 100");

                            }catch (NumberFormatException ex){
                                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                            }
                            Timer time = new Timer(tempo, new ActionListener(){ //criando um timer para fechar o painel
                                public void actionPerformed(ActionEvent e) {obj1.dispose();}
                            });
                            time.setRepeats(false); //garantindo que o timer não repita
                            time.start();
                            botaoAposta1.setEnabled(false); //desabilitando o botão de aposta
                        }
                    });
                }
            });

            // acionamento do botão 2)
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    //definindo posições e caracteristicas do painel
                    Segundo obj2 = new Segundo();
                    obj2.setTitle("Aposta de A à Z");
                    obj2.setSize(400,250);
                    aposta2.setBounds(210,-80,200,200);
                    letra.setBounds(240,50,100,30);
                    botaoAposta2.setBounds(240,100, 100,30);
                    jLimagem3.setBounds(5,5,200,200);
                    jLimagem5.setBounds(5,5,200,200);
                    jLimagem6.setBounds(5,5,200,200);
                    vence2.setBounds(210, 70,200,200);
                    perde1.setBounds(210, 45,200,200);
                    mensagem1.setBounds(210,60,200,200);
                    mensagem2.setBounds(210,75,200,200);
                    obj2.setLayout(null);
                    botaoAposta2.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    // add atributos
                    obj2.add(vence2);
                    obj2.add(perde1);
                    obj2.add(jLimagem3);
                    obj2.add(jLimagem5);
                    obj2.add(jLimagem6);
                    obj2.add(mensagem1);
                    obj2.add(mensagem2);
                    obj2.add(aposta2);
                    obj2.add(botaoAposta2);
                    obj2.add(letra);

                    //definindo cor do jlabel
                    vence2.setForeground(verde);
                    perde1.setForeground(vermelho);

                    //definindo visibilidade
                    vence2.setVisible(false);
                    perde1.setVisible(false);
                    jLimagem3.setVisible(true);
                    jLimagem5.setVisible(false);
                    jLimagem6.setVisible(false);
                    mensagem1.setVisible(false);
                    mensagem2.setVisible(false);

                    // limitando apenas uma letra no TextField "letra"
                    letra.addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            super.keyTyped(e);
                            char c = e.getKeyChar();
                            if (!(Character.isLetter(c) && c!= KeyEvent.VK_DELETE && letra.getText().length() <1)){
                                getToolkit().beep();
                                e.consume();
                            }
                        }
                    });
                    letra.setText(""); //limpando o textfield
                    botaoAposta2.setEnabled(true);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    obj2.setLocationRelativeTo(null);
                    obj2.setVisible(true);

                    // acionamento do Botão "Aposta2"
                    botaoAposta2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoAposta2.isEnabled()) {return;}
                            try{
                            char letraApostada = letra.getText().charAt(0);
                            letraApostada = Character.toUpperCase(letraApostada);
                            //char letraSorteada = (char) (aleatorio.nextInt(25) + 65);// (caso queira sortear sortear uma letra aleatória)
                            char letraSorteada ='A';
                            if (letraApostada == letraSorteada) {
                                vence2.setVisible(true);
                                jLimagem3.setVisible(false);
                                jLimagem5.setVisible(true);
                            } else {
                                mensagem1.setText("A letra digitada: "+letraApostada);
                                mensagem2.setText("A letra sorteada foi: "+letraSorteada);
                                jLimagem3.setVisible(false);
                                jLimagem6.setVisible(true);
                                perde1.setVisible(true);
                                mensagem1.setVisible(true);
                                mensagem2.setVisible(true);}

                            }catch (StringIndexOutOfBoundsException er){
                                JOptionPane.showMessageDialog(null, "Por favor, " +
                                        "insira uma letra válida.");
                            }
                            Timer time = new Timer(tempo, new ActionListener(){
                                public void actionPerformed(ActionEvent e) {obj2.dispose();}
                            });
                            time.setRepeats(false);
                            time.start();
                            botaoAposta2.setEnabled(false);
                        }
                    });
                }
            });
            // Acionando o botao3
            button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Terceiro obj3 = new Terceiro();
                    obj3.setTitle("Apostar em par ou ímpar");
                    obj3.setSize(400,250);
                    // definido posições
                    aposta3.setBounds(200,-80,200,200);
                    par.setBounds(230, 50, 100,30);
                    botaoAposta3.setBounds(230, 100, 100,30);
                    jLimagem4.setBounds(3,5,195,195);
                    jLimagem5.setBounds(3,5,195,195);
                    jLimagem6.setBounds(3,5,195,195);
                    vence3.setBounds(210, 60, 200,200);
                    perde1.setBounds(200, 45,200,200);
                    mensagem1.setBounds(200,60,200,200);
                    mensagem2.setBounds(200,75,200,200);
                    obj3.setLayout(null);
                    botaoAposta3.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    // add atributos
                    obj3.add(jLimagem4);
                    obj3.add(jLimagem5);
                    obj3.add(jLimagem6);
                    obj3.add(aposta3);
                    obj3.add(vence3);
                    obj3.add(perde1);
                    obj3.add(mensagem1);
                    obj3.add(mensagem2);
                    obj3.add(botaoAposta3);
                    obj3.add(par);

                    //definindo cor
                    vence3.setForeground(verde);
                    perde1.setForeground(vermelho);

                    //definindo visibilidade
                    jLimagem4.setVisible(true);
                    jLimagem5.setVisible(false);
                    jLimagem6.setVisible(false);
                    vence3.setVisible(false);
                    perde1.setVisible(false);
                    mensagem1.setVisible(false);
                    mensagem2.setVisible(false);

                    //limitando apenas números no textField "par"
                    par.addKeyListener(new KeyAdapter() {
                        public void keyTyped(KeyEvent e) {
                            super.keyTyped(e);
                            char c = e.getKeyChar();
                            if (!(Character.isDigit(c) || c==KeyEvent.VK_DELETE)){
                                getToolkit().beep();
                                e.consume();}
                        }
                    });
                    par.setText("");
                    botaoAposta3.setEnabled(true);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    obj3.setLocationRelativeTo(null);
                    obj3.setVisible(true);

                    botaoAposta3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if (!botaoAposta3.isEnabled()) {return;}
                            try {
                            int apostaPar = Integer.parseInt(par.getText());
                            if (apostaPar % 2 == 0 && apostaPar != 0){
                                vence3.setVisible(true);
                                jLimagem5.setVisible(true);
                                jLimagem4.setVisible(false);
                            } else if (apostaPar==0){
                                JOptionPane.showMessageDialog(obj3, "O número 0 não é considerado" +
                                        "\nPor favor, insira um número válido.");
                            } else{
                                mensagem1.setText("O número digitado é ímpar");
                                mensagem2.setText("Números premiados: pares");
                                jLimagem4.setVisible(false);
                                jLimagem6.setVisible(true);
                                perde1.setVisible(true);
                                mensagem1.setVisible(true);
                                mensagem2.setVisible(true);}

                            }catch (NumberFormatException ex){
                                JOptionPane.showMessageDialog(obj3, "Por favor, insira um número válido.");}

                            Timer time = new Timer(tempo, new ActionListener(){
                                public void actionPerformed(ActionEvent e) {obj3.dispose();}
                            });
                            time.setRepeats(false);
                            time.start();
                            botaoAposta3.setEnabled(false);
                        }
                    });
                }
            });

            button0.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {dispose();}
            });
        }

    public static void main(String[] args) {new Loto();}

}
// Classe do primeiro painel
class Primeiro extends JFrame{ }
// Classe do segundo painel
class Segundo extends JFrame{ }
// Classe do Terceiro painel
class Terceiro extends JFrame{ }


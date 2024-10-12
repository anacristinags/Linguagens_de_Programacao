import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/*  SUMARIO P/ NAVEGAÇÃO
 *  1 - Add imagens
 *  2 - Inicializa Componentes Painel Principal
 *  3 - Construtor
 *  4 - Add componentes
 *  5 - Config Componentes
 *  6 - Acionando Botões
 *  7 - Paineis secundários (Pizzas)
 *  8 - Paineis secundários (Hamburgueres)
 *  9 - Paineis secundários (Bebidas)
 *  10 - Painel Tela Carrinho de Pagamento
 * */

public class TelaPrincipal extends JFrame {

    // 1) Adicionando imagens
    ImageIcon img1 = new ImageIcon(getClass().getResource("/img/coca.jpg"));
    JLabel JLimg1 = new JLabel(img1);
    ImageIcon img2 = new ImageIcon(getClass().getResource("/img/hamburguer01.jpg"));
    JLabel JLimg2 = new JLabel(img2);
    ImageIcon img3 = new ImageIcon(getClass().getResource("/img/heineken.jpg"));
    JLabel JLimg3 = new JLabel(img3);
    ImageIcon img4 = new ImageIcon(getClass().getResource("/img/pizza_calabresa.jpg"));
    JLabel JLimg4 = new JLabel(img4);
    ImageIcon img5 = new ImageIcon(getClass().getResource("/img/pizza_frango.jpg"));
    JLabel JLimg5 = new JLabel(img5);
    ImageIcon img6 = new ImageIcon(getClass().getResource("/img/SmashBurger.jpg"));
    JLabel JLimg6 = new JLabel(img6);
    ImageIcon img7 = new ImageIcon(getClass().getResource("/img/logo.png"));
    JLabel JLimg7 = new JLabel(img7);
    ImageIcon img8 = new ImageIcon(getClass().getResource("/img/pizza_marguerita.jpg"));
    JLabel JLimg8 = new JLabel(img8);
    ImageIcon img9 = new ImageIcon(getClass().getResource("/img/ChickenBurger.jpg"));
    JLabel JLimg9 = new JLabel(img9);
    ImageIcon img10 = new ImageIcon(getClass().getResource("/img/coca2l.jpg"));
    JLabel JLimg10 = new JLabel(img10);


    // 2) Inicicializando componentes painel principal
    private JPanel painel = new JPanel();
    private JComboBox<String> categoria = new JComboBox<>();
    private JLabel texto1 = new JLabel("JAVA EATS");
    private JLabel texto2 = new JLabel("Pizzas");
    private JLabel texto3 = new JLabel("Hambúrgueres");
    private JLabel texto4 = new JLabel("Bebidas");
    private JLabel texto5 = new JLabel("Categoria: ");
    private JButton botaoPizzaC = new JButton("Calabresa");
    private JButton botaoPizzaF = new JButton("Frango com Catupiry");
    private JButton botaoPizzaM = new JButton("Marguerita");
    private JButton botaoTBurger = new JButton("Tradicional Burger R$ 36,99");
    private JButton botaoCBurger = new JButton("Chicken Burger R$ 33,99");
    private JButton botaoSBurger = new JButton("Smash Burger R$ 29,99");
    private JButton botaoCocaLata = new JButton("Coca-Cola 350ml R$ 6,00");
    private JButton botaoHeineken = new JButton("Heineken 330ml R$ 7,50");
    private JButton botaoCoca2l = new JButton("Coca-Cola 2l R$ 12,50");
    private JButton botaoCarrinhoCompra = new JButton("Ver Carrinho");

    // 3) Construtor
    public TelaPrincipal(){
        // Config do painel principal
        this.setTitle("Produtos");
        this.setSize(800,720);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painel.setLayout(null);
        this.setVisible(true);

        // Métodos
        configurarComponentes();
        adicionarComponentes();
    }

    // 4) Adicionando componentes
    private void adicionarComponentes(){
        painel.add(JLimg4); painel.add(JLimg5); painel.add(JLimg8); // pizzas
        painel.add(JLimg2); painel.add(JLimg6); painel.add(JLimg9); // burgers
        painel.add(JLimg1); painel.add(JLimg3); painel.add(JLimg10); // bebidas
        painel.add(JLimg7); //logo
        painel.add(texto1); painel.add(texto2); painel.add(texto3); painel.add(texto4); painel.add(texto5); //JLabels
        painel.add(botaoPizzaC); painel.add(botaoPizzaF); painel.add(botaoPizzaM); // btn pizzas
        painel.add(botaoTBurger); painel.add(botaoSBurger); painel.add(botaoCBurger); // btn burger
        painel.add(botaoCocaLata); painel.add(botaoHeineken); painel.add(botaoCoca2l); // btn bebidas
        painel.add(categoria); painel.add(botaoCarrinhoCompra); // itens "cabeçalho"
    }

    // 5) Configurar Componentes
    private void configurarComponentes(){
        configurarImagens();
        configurarComboBox();
        configurarJLabel();
        configurarJButton();
        acionarBotaoPizzaC(); acionarBotaoPizzaF(); acionarBotaoPizzaM(); // btn pizzas
        acionarBotaoTradicional(); acionarBotaoChicken(); acionarBotaoSmash(); // btn burgers
        acionarBotaoCocaLata(); acionarBotaoHeineken(); acionarBotaoCocaGarrafa(); // btn bebidas
        acionarBotaoCarrinho(); // btn carrinho de compras
    }

    // 5.1 Config Imagens
    private void configurarImagens(){
        JLimg4.setBounds(20, 145, 200, 116); // pizzas
        JLimg5.setBounds(270, 145, 200, 116);
        JLimg8.setBounds(525, 145, 200, 116);
        JLimg2.setBounds(20, 325, 200, 116); // burgers
        JLimg9.setBounds(270, 325, 200, 116);
        JLimg6.setBounds(525, 325, 200, 116);
        JLimg1.setBounds(20, 500, 200, 130); // bebidas
        JLimg3.setBounds(270, 500, 200, 130);
        JLimg10.setBounds(525, 500, 200, 130);
        JLimg7.setBounds(0,0, 200,86); // logo
    }

    // 5.2 Config ComboBox (Categoria)
    private void configurarComboBox(){
        texto5.setFont(new Font("Arial", Font.BOLD, 16));
        texto5.setBounds(205, 60, 110, 30);
        categoria.setFont(new Font("Arial", Font.PLAIN, 16));
        categoria.setBounds(290, 60, 140, 30);
        categoria.addItem("Todos"); categoria.addItem("Bebidas");
        categoria.addItem("Pizzas"); categoria.addItem("Hambúgueres");
        categoria.addActionListener(new ActionListener() {@Override
        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
            String itemSelecionado = (String) comboBox.getSelectedItem();
            atualizarPainelCB(itemSelecionado);}
        });
    }
    // 5.2.1 Atualiza painel de acordo com o ComboBox
    private void atualizarPainelCB(String itemSelecionado){
        if ("Pizzas".equals(itemSelecionado)){
            comboBoxPizza();
        } else if ("Hambúgueres".equals(itemSelecionado)){
            comboBoxBurger();
        } else if ("Bebidas".equals(itemSelecionado)){
            comboBoxBebidas();
        } else{comboBoxTodos();}
    }
    // 5.2.1.2
    private void comboBoxPizza(){
        // imagens [PIZZAS, burgers, bebidas]
        JLimg4.setVisible(true); JLimg5.setVisible(true); JLimg8.setVisible(true);
        JLimg2.setVisible(false); JLimg6.setVisible(false); JLimg9.setVisible(false);
        JLimg1.setVisible(false); JLimg3.setVisible(false); JLimg10.setVisible(false);
        // botões [PIZZAS, burgers, bebidas]
        botaoPizzaC.setVisible(true); botaoPizzaF.setVisible(true); botaoPizzaM.setVisible(true);
        botaoTBurger.setVisible(false); botaoCBurger.setVisible(false); botaoSBurger.setVisible(false);
        botaoCocaLata.setVisible(false); botaoHeineken.setVisible(false); botaoCoca2l.setVisible(false);
        // textos [TITULO, PIZZAS, burgeres, bebidas]
        texto1.setVisible(true); texto2.setVisible(true); texto3.setVisible(false); texto4.setVisible(false);
        //posições [titulos, botões, imagens]
        texto1.setBounds(350,10, 500,40); texto2.setBounds(15, 115, 200, 30);
        botaoPizzaC.setBounds(45, 265, 150, 30);
        botaoPizzaF.setBounds(290, 265, 160, 30);
        botaoPizzaM.setBounds(555, 265, 150, 30);
        JLimg4.setBounds(20, 145, 200, 116);
        JLimg5.setBounds(270, 145, 200, 116);
        JLimg8.setBounds(525, 145, 200, 116);
    }
    // 5.2.1.3
    public void comboBoxBurger(){
        // imagens [pizzas, BURGERS, bebidas]
        JLimg4.setVisible(false); JLimg5.setVisible(false); JLimg8.setVisible(false);
        JLimg2.setVisible(true); JLimg6.setVisible(true); JLimg9.setVisible(true);
        JLimg1.setVisible(false); JLimg3.setVisible(false); JLimg10.setVisible(false);
        // botões [pizzas, BURGERS, bebidas]
        botaoPizzaC.setVisible(false); botaoPizzaF.setVisible(false); botaoPizzaM.setVisible(false);
        botaoTBurger.setVisible(true);botaoCBurger.setVisible(true); botaoSBurger.setVisible(true);
        botaoCocaLata.setVisible(false); botaoHeineken.setVisible(false); botaoCoca2l.setVisible(false);
        // textos [TITULO, pizzas, BURGERS, bebidas]
        texto1.setVisible(true); texto2.setVisible(false); texto3.setVisible(true); texto4.setVisible(false);
        // posições [titulos, botões, imagens]
        texto1.setBounds(350,10, 500,40); texto3.setBounds(15, 115, 200, 30);
        botaoTBurger.setBounds(20, 265, 200, 30);
        botaoCBurger.setBounds(270, 265, 200, 30);
        botaoSBurger.setBounds(525, 265, 200, 30);
        JLimg2.setBounds(20, 145, 200, 116);
        JLimg9.setBounds(270, 145, 200, 116);
        JLimg6.setBounds(525, 145, 200, 116);
    }
    // 5.2.1.4
    public void comboBoxBebidas(){
        // imagens [pizzas, burgers, BEBIDAS]
        JLimg4.setVisible(false); JLimg5.setVisible(false); JLimg8.setVisible(false);
        JLimg2.setVisible(false); JLimg6.setVisible(false); JLimg9.setVisible(false);
        JLimg1.setVisible(true); JLimg3.setVisible(true); JLimg10.setVisible(true);
        // botões [pizzas, burgers, BEBIDAS]
        botaoPizzaC.setVisible(false); botaoPizzaF.setVisible(false); botaoPizzaM.setVisible(false);
        botaoTBurger.setVisible(false); botaoCBurger.setVisible(false); botaoSBurger.setVisible(false);
        botaoCocaLata.setVisible(true); botaoHeineken.setVisible(true); botaoCoca2l.setVisible(true);
        // textos [TITULO, pizzas, burgeres, BEBIDAS]
        texto1.setVisible(true); texto2.setVisible(false); texto3.setVisible(false); texto4.setVisible(true);
        //posições [titulos, botões, imagens]
        texto1.setBounds(350,10, 500,40); texto4.setBounds(15, 115, 200, 30);
        botaoCocaLata.setBounds(20, 265, 200, 30);
        botaoHeineken.setBounds(270, 265, 200, 30);
        botaoCoca2l.setBounds(525, 265, 200, 30);
        JLimg1.setBounds(20, 145, 200, 116);
        JLimg3.setBounds(270, 145, 200, 116);
        JLimg10.setBounds(525, 145, 200, 116);
    }
    // 5.2.1.5
    public void comboBoxTodos(){
        // imagens [pizzas, burgers, bebidas]
        JLimg4.setVisible(true); JLimg5.setVisible(true); JLimg8.setVisible(true);
        JLimg2.setVisible(true); JLimg6.setVisible(true); JLimg9.setVisible(true);
        JLimg1.setVisible(true); JLimg3.setVisible(true); JLimg10.setVisible(true);
        // botões
        botaoPizzaC.setVisible(true); botaoPizzaF.setVisible(true); botaoPizzaM.setVisible(true);
        botaoTBurger.setVisible(true); botaoCBurger.setVisible(true); botaoSBurger.setVisible(true);
        botaoCocaLata.setVisible(true); botaoHeineken.setVisible(true); botaoCoca2l.setVisible(true);
        // titulos [titulo, pizzas, hamburgueres, bebidas]
        texto1.setVisible(true); texto2.setVisible(true); texto3.setVisible(true); texto4.setVisible(true);
        // metodos
        configurarImagens(); configurarJLabel(); configurarJButton();
    }

    // 5.3 Config Textos
    private void configurarJLabel(){
        // JLabel Panel Principal
        texto1.setFont(new Font("Arial", Font.BOLD, 24));
        texto1.setBounds(350,10, 500,40);
        texto2.setFont(new Font("Arial", Font.BOLD, 16));
        texto2.setBounds(15, 115, 200, 30);
        texto3.setFont(new Font("Arial", Font.BOLD, 16));
        texto3.setBounds(15, 300, 200, 30);
        texto4.setFont(new Font("Arial", Font.BOLD, 16));
        texto4.setBounds(15, 475, 200, 30);
    }

    // 5.4 Config Botões
    private void configurarJButton(){
        botaoPizzaC.setBounds(45, 265, 150, 30);
        botaoPizzaF.setBounds(290, 265, 160, 30);
        botaoPizzaM.setBounds(555, 265, 150, 30);
        botaoTBurger.setBounds(20, 442, 200, 30);
        botaoCBurger.setBounds(270, 442, 200, 30);
        botaoSBurger.setBounds(525, 442, 200, 30);
        botaoCocaLata.setBounds(20, 635, 200, 30);
        botaoHeineken.setBounds(270, 635, 200, 30);
        botaoCoca2l.setBounds(525, 635, 200, 30);
        botaoCarrinhoCompra.setBounds(450, 60, 140, 30);
    }

    // 6) Acionamento de Botões
    // 6.1 Acionar botão Pizza Calabresa
    public void acionarBotaoPizzaC(){
        botaoPizzaC.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelCalabresa();}
        });
    }

    // 6.2 Acionar botão Pizza de Frango com Catupiry
    public void acionarBotaoPizzaF(){
        botaoPizzaF.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelFrango();}
        });
    }

    // 6.3 Acionar botão pizza de Marguerita
    public void acionarBotaoPizzaM(){
        botaoPizzaM.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelMarguerita();}
        });
    }

    // 6.4 Acionar botão tradicional burger
    public void acionarBotaoTradicional(){
        botaoTBurger.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelTradicional();}
        });
    }

    // 6.5 Acionar botão Chicken Burger
    public void acionarBotaoChicken(){
        botaoCBurger.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelChicken();}
        });
    }

    // 6.6 Acionar Botão Smash Burger
    public void acionarBotaoSmash(){
        botaoSBurger.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelSmash();}
        });
    }

    // 6.7 Acionar Botão Coca Lata
    public void acionarBotaoCocaLata(){
        botaoCocaLata.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelCocaLata();}
        });
    }

    // 6.8 Acionar Botão Heineken
    public void acionarBotaoHeineken(){
        botaoHeineken.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {new PainelHeineken();}
        });
    }

    // 6.9 Acionar Botão Coca Garrafa
    public void acionarBotaoCocaGarrafa(){
        botaoCoca2l.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            new PainelCocaGarrafa();}
        });
    }

    // 6.9 Acionar Botão Carrinho Compra
    public void acionarBotaoCarrinho(){
        botaoCarrinhoCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCarrinho();
            }
        });
    }

    public static void main(String[] args) {new TelaPrincipal();}

}
// --------- 7) PAINEIS SECUNDÁRIOS (PIZZAS) ---------
// 7.1 - Painel Pizza de Calabresa
class PainelCalabresa extends JFrame{
    // 7.1.1 Componentes básicos do painel
    private JLabel texto1PC = new JLabel("Calabresa:");
    private JLabel texto2PC = new JLabel("muçarela, calabresa e orégano");
    private JButton botaoPC1 = new JButton("Escolha a opção");
    private JLabel quantidadePC = new JLabel("1");
    private JButton botaoMaisPC = new JButton("+");
    private JButton botaoMenosPC = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);
    // RadioButton do Painel PC
    private JRadioButton pizzaCalabresaGG = new JRadioButton("Pizza Gigante - 8 Fatias + R$84,90");
    private JRadioButton pizzaCalabresaG = new JRadioButton("Pizza Grande - 6 Fatias + R$67,90");
    private JRadioButton pizzaCalabresaM = new JRadioButton("Pizza Média - 4 Fatias + R$50,90");
    private JLabel textoEscolhaPC = new JLabel("Escolha uma opção de tamanho:");
    ButtonGroup grupoPizzaCalabresa = new ButtonGroup();


    // 7.1.2 Construtor PC
    public PainelCalabresa(){
        // Config do painel
        setTitle("Pizza de Calabresa");
        setSize(400,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // metodos
        adicionarComponentes(); escolhaRadioButtonPC(); definirQuantidadePC();
    }

    // 7.1.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes(){
        // texto Pizza Calabresa [nome, descrição]
        add(texto1PC); add(texto2PC);
        texto1PC.setFont(new Font("Arial", Font.BOLD, 16));
        texto1PC.setBounds(15, 0, 400, 30);
        texto2PC.setFont(new Font("Arial", Font.PLAIN, 14));
        texto2PC.setBounds(15, 20, 400, 30);

        // RadioButton Pizza Calabresa
        add(pizzaCalabresaGG); add(pizzaCalabresaG); add(pizzaCalabresaM);
        pizzaCalabresaGG.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaCalabresaGG.setBounds(15,70,300,30);
        pizzaCalabresaG.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaCalabresaG.setBounds(15,110,300,30);
        pizzaCalabresaM.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaCalabresaM.setBounds(15,150,300,30);
        grupoPizzaCalabresa.add(pizzaCalabresaGG);
        grupoPizzaCalabresa.add(pizzaCalabresaG);
        grupoPizzaCalabresa.add(pizzaCalabresaM);

        // Botões
        add(quantidadePC); add(botaoMaisPC); add(botaoMenosPC);
        quantidadePC.setBounds(75,200,50,30);
        botaoMaisPC.setBounds(100,200,50,30);
        botaoMenosPC.setBounds(10,200, 50,30);
        quantidadePC.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosPC.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMaisPC.setFont(new Font("Arial", Font.BOLD, 14));
        add(botaoPC1);
        botaoPC1.setBounds(160, 200, 220,30);

        // JLabel p/ sessão de compra
        add(textoEscolhaPC);
        textoEscolhaPC.setFont(new Font("Arial", Font.BOLD, 14));
        textoEscolhaPC.setBounds(15, 45, 400, 30);
    }

    // 7.1.4  Configura RadioButton Pizza Calabresa public void configurarRadioButtonPC(){}

    // 7.1.4 Define valor unitário
    public double valorUnitarioPC(){
        if (pizzaCalabresaGG.isSelected()){return 84.90;
        } else if (pizzaCalabresaG.isSelected()){return 67.90;
        } else {return 50.90;}
    }

    // 7.1.5 Atualiza valor do botão "Adicionar ao Carrinho" (Pizza Calabresa)
    public void atualizarValorPC(){
        double precoPC = valorUnitarioPC();
        int quantidade = Integer.parseInt(quantidadePC.getText());
        double precoTotalPC = precoPC * quantidade;
        botaoPC1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalPC));
        botaoPC1.setEnabled(true); botaoMaisPC.setEnabled(true); botaoMenosPC.setEnabled(true);
    }

    // 7.1.6 Mudar valores de acordo com a escolha do RadioButton (Pizza Calabresa)
    public void escolhaRadioButtonPC(){
        botaoPC1.setEnabled(false); botaoMaisPC.setEnabled(false); botaoMenosPC.setEnabled(false);
        pizzaCalabresaGG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPC(); // atualiza valor
            adicionarAoCarrinhoPC(); // permitindo adicionar ao carrinho
            botaoMenosPC.setForeground(branco); botaoMenosPC.setBackground(vermelho); // mudando cores
            botaoMaisPC.setForeground(branco); botaoMaisPC.setBackground(vermelho);
            botaoPC1.setForeground(branco); botaoPC1.setBackground(vermelho);}
        });
        pizzaCalabresaG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPC(); // atualiza valor
            adicionarAoCarrinhoPC(); // permitindo adicionar ao carrinho
            botaoMenosPC.setForeground(branco); botaoMenosPC.setBackground(vermelho); // mudando cores
            botaoMaisPC.setForeground(branco); botaoMaisPC.setBackground(vermelho);
            botaoPC1.setForeground(branco); botaoPC1.setBackground(vermelho);}
        });
        pizzaCalabresaM.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPC(); // atualiza valor
            adicionarAoCarrinhoPC(); // permitindo adicionar ao carrinho
            botaoMenosPC.setForeground(branco); botaoMenosPC.setBackground(vermelho); // mudando cores
            botaoMaisPC.setForeground(branco); botaoMaisPC.setBackground(vermelho);
            botaoPC1.setForeground(branco); botaoPC1.setBackground(vermelho);}
        });
    }

    // 7.1.7 Aumenta ou diminui a quantidade de pizzas
    public void definirQuantidadePC(){
        botaoMaisPC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantidade = Integer.parseInt(quantidadePC.getText());
                if (quantidade < 10){quantidade++;
                    quantidadePC.setText(String.valueOf(quantidade));
                    atualizarValorPC();
                }
            }
        });
        botaoMenosPC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantidade = Integer.parseInt(quantidadePC.getText());
                if (quantidade > 1){quantidade--;
                    quantidadePC.setText(String.valueOf(quantidade));
                    atualizarValorPC();
                }
            }
        });
    }

    // 7.1.8 adiciona ao carrinho
    public void adicionarAoCarrinhoPC(){
        botaoPC1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tamanho = "";
                String observacao = null;
                if (pizzaCalabresaGG.isSelected()) {
                    tamanho = "Gigante";
                } else if (pizzaCalabresaG.isSelected()) {
                    tamanho = "Grande";
                } else if (pizzaCalabresaM.isSelected()) {
                    tamanho = "Média";
                }
                String nomePizza = "Pizza Calabresa " + tamanho;
                int quantidade = Integer.parseInt(quantidadePC.getText());
                double precoUnitario = valorUnitarioPC();
                ItemCarrinho item = new ItemCarrinho(nomePizza, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}

// 7.2 - Painel Pizza Frango com Catupiry
class PainelFrango extends JFrame{
    // 7.2.1 Componentes do painel Pizza de Frango c/ Catupiry
    private JLabel texto1PF = new JLabel("Frango com Catupiry");
    private JLabel texto2PF = new JLabel("muçarela, frango desfiado, catupiry e orégano.");
    private JButton botaoPF1 = new JButton("Escolha a opção");
    private JLabel quantidadePF = new JLabel("1");
    private JButton botaoMaisPF = new JButton("+");
    private JButton botaoMenosPF = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);
    // RadioButton do Painel PF
    private JRadioButton pizzaFrangoGG = new JRadioButton("Pizza Gigante - 8 Fatias + R$80,90");
    private JRadioButton pizzaFrangoG = new JRadioButton("Pizza Grande - 6 Fatias + R$62,90");
    private JRadioButton pizzaFrangoM = new JRadioButton("Pizza Média - 4 Fatias + R$48,90");
    private JLabel textoEscolhaPF = new JLabel("Escolha uma opção de tamanho:");
    ButtonGroup grupoPizzaFrango = new ButtonGroup();

    // 7.2.2 Construtor PF
    public PainelFrango(){
        // Config do painel
        setTitle("Pizza de Frango com Catupiry");
        setSize(400,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // metodos
        adicionarComponentes(); escolhaRadioButtonPF(); definirQuantidadePF();
    }

    // 7.2.3 adicionar e definir posições dos componentes
    public void adicionarComponentes(){
        // texto Pizza Frango [nome, descrição]
        add(texto1PF); add(texto2PF);
        texto1PF.setFont(new Font("Arial", Font.BOLD, 16));
        texto1PF.setBounds(15,0,400,30);
        texto2PF.setFont(new Font("Arial", Font.PLAIN, 14));
        texto2PF.setBounds(15,20,400,30);

        // RadioButton Pizza Frango
        add(pizzaFrangoGG); add(pizzaFrangoG); add(pizzaFrangoM);
        pizzaFrangoGG.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaFrangoGG.setBounds(15,70,300,30);
        pizzaFrangoG.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaFrangoG.setBounds(15,110,300,30);
        pizzaFrangoM.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaFrangoM.setBounds(15,150,300,30);
        grupoPizzaFrango.add(pizzaFrangoGG);
        grupoPizzaFrango.add(pizzaFrangoG);
        grupoPizzaFrango.add(pizzaFrangoM);

        // Botões
        add(quantidadePF); add(botaoMaisPF); add(botaoMenosPF);
        quantidadePF.setBounds(75,200,50,30);
        botaoMaisPF.setBounds(100,200,50,30);
        botaoMenosPF.setBounds(10,200, 50,30);
        quantidadePF.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMaisPF.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosPF.setFont(new Font("Arial", Font.BOLD, 14));
        add(botaoPF1);
        botaoPF1.setBounds(160, 200, 220,30);

        // JLabel p/ sessão de compra
        add(textoEscolhaPF);
        textoEscolhaPF.setFont(new Font("Arial", Font.BOLD, 14));
        textoEscolhaPF.setBounds(15, 45, 400, 30);
    }

    // 7.2.4 Configura RadioButton Pizza Frango
    //public void configurarRadioButtonPF(){}

    // 7.2.4 Define valor da unidade
    public double valorUnitarioPF(){
        if (pizzaFrangoGG.isSelected()){return 80.90;
        } else if (pizzaFrangoG.isSelected()){return 62.90;
        } else {return 48.90;}
    }

    // 7.2.5 Atualiza valor do botão "Adicionar ao Carrinho" (Pizza Frango)
    public void atualizarValorPF(){
        double precoPF = valorUnitarioPF();
        int quantidade = Integer.parseInt(quantidadePF.getText());
        double precoTotalPF = precoPF * quantidade;
        botaoPF1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalPF));
        botaoPF1.setEnabled(true); botaoMaisPF.setEnabled(true); botaoMenosPF.setEnabled(true);
    }

    // 7.2.6 Muda valores de acordo com a escolha do RadioButton (Pizza Frango)
    public void escolhaRadioButtonPF(){
        botaoPF1.setEnabled(false); botaoMaisPF.setEnabled(false); botaoMenosPF.setEnabled(false);
        pizzaFrangoGG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPF(); //atualizando valores
            adicionarAoCarrinhoPF(); // permitindo adicionar ao carrinho
            botaoMenosPF.setForeground(branco); botaoMenosPF.setBackground(vermelho); // mudando cores
            botaoMaisPF.setForeground(branco); botaoMaisPF.setBackground(vermelho);
            botaoPF1.setForeground(branco); botaoPF1.setBackground(vermelho);}
        });
        pizzaFrangoG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPF(); //atualizando valores
            adicionarAoCarrinhoPF(); // permitindo adicionar ao carrinho
            botaoMenosPF.setForeground(branco); botaoMenosPF.setBackground(vermelho); // mudando cores
            botaoMaisPF.setForeground(branco); botaoMaisPF.setBackground(vermelho);
            botaoPF1.setForeground(branco); botaoPF1.setBackground(vermelho);}
        });
        pizzaFrangoM.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPF(); //atualizando valores
            adicionarAoCarrinhoPF(); // permitindo adicionar ao carrinho
            botaoMenosPF.setForeground(branco); botaoMenosPF.setBackground(vermelho); // mudando cores
            botaoMaisPF.setForeground(branco); botaoMaisPF.setBackground(vermelho);
            botaoPF1.setForeground(branco); botaoPF1.setBackground(vermelho);}
        });
    }

    // 7.2.7 Aumenta ou diminui a quantidade de pizzas
    public void definirQuantidadePF(){
        botaoMaisPF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantidade = Integer.parseInt(quantidadePF.getText());
                if (quantidade < 10){quantidade++;
                    quantidadePF.setText(String.valueOf(quantidade));
                    atualizarValorPF();
                }
            }
        });botaoMenosPF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantidade = Integer.parseInt(quantidadePF.getText());
                if (quantidade > 1){quantidade--;
                    quantidadePF.setText(String.valueOf(quantidade));
                    atualizarValorPF();
                }
            }
        });
    }

    // 7.2.8 adiciona ao carrinho
    public void adicionarAoCarrinhoPF(){
        botaoPF1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tamanho = "";
                String observacao = null;
                if (pizzaFrangoGG.isSelected()) {
                    tamanho = "Gigante";
                } else if (pizzaFrangoG.isSelected()) {
                    tamanho = "Grande";
                } else if (pizzaFrangoM.isSelected()) {
                    tamanho = "Média";
                }
                String nomePizza = "Pizza Frango com Catupiry " + tamanho;
                int quantidade = Integer.parseInt(quantidadePF.getText());
                double precoUnitario = valorUnitarioPF();
                ItemCarrinho item = new ItemCarrinho(nomePizza, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}

// 7.3 - Painel Pizza Frango Marguerita
class PainelMarguerita extends JFrame{
    // 7.3.1 Componentes do painel Pizza Marguerita
    private JLabel texto1PM = new JLabel("Marguerita");
    private JLabel texto2PM = new JLabel("muçarela, tomate, azeitona, manjericão, cebola e orégano");
    private JButton botaoPM1 = new JButton("Escolha a opção");
    private JLabel quantidadePM = new JLabel("1");
    private JButton botaoMaisPM = new JButton("+");
    private JButton botaoMenosPM = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);
    // RadioButton do Painel PM
    private JRadioButton pizzaMargueritaGG = new JRadioButton("Pizza Gigante - 8 Fatias + R$82,90");
    private JRadioButton pizzaMargueritaG = new JRadioButton("Pizza Grande - 6 Fatias + R$64,90");
    private JRadioButton pizzaMargueritaM = new JRadioButton("Pizza Média - 4 Fatias + R$49,90");
    private JLabel textoEscolhaPM = new JLabel("Escolha uma opção de tamanho:");
    ButtonGroup grupoPizzaMarguerita = new ButtonGroup();

    // 7.3.2 Construtor PM
    public PainelMarguerita(){
        // definições básicas do painel
        setTitle("Pizza de Frango Marguerita");
        setSize(400,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //metodos
        adicionarComponentes(); escolhaRadioButtonPM(); definirQuantidadePM();
    }

    // 7.3.3 Adicionar e define posições dos componentes
    public void adicionarComponentes(){
        // texto Pizza Marguerita [nome, descrição]
        add(texto1PM); add(texto2PM);
        texto1PM.setFont(new Font("Arial", Font.BOLD, 16));
        texto1PM.setBounds(15, 0, 400, 30);
        texto2PM.setFont(new Font("Arial", Font.PLAIN, 14));
        texto2PM.setBounds(15, 20, 400, 30);

        // Configura RadioButton Pizza Marguerita
        add(pizzaMargueritaGG); add(pizzaMargueritaG); add(pizzaMargueritaM);
        pizzaMargueritaGG.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaMargueritaGG.setBounds(15,70,300,30);
        pizzaMargueritaG.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaMargueritaG.setBounds(15,110,300,30);
        pizzaMargueritaM.setFont(new Font("Arial", Font.PLAIN, 14));
        pizzaMargueritaM.setBounds(15,150,300,30);
        grupoPizzaMarguerita.add(pizzaMargueritaGG);
        grupoPizzaMarguerita.add(pizzaMargueritaG);
        grupoPizzaMarguerita.add(pizzaMargueritaM);

        // Botões
        add(quantidadePM); add(botaoMaisPM); add(botaoMenosPM);
        quantidadePM.setBounds(75,200,50,30);
        botaoMaisPM.setBounds(100,200,50,30);
        botaoMenosPM.setBounds(10,200, 50,30);
        quantidadePM.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosPM.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMaisPM.setFont(new Font("Arial", Font.BOLD, 14));
        add(botaoPM1);
        botaoPM1.setBounds(160, 200, 220,30);

        // JLabel p/ sessão de compra
        add(textoEscolhaPM);
        textoEscolhaPM.setFont(new Font("Arial", Font.BOLD, 14));
        textoEscolhaPM.setBounds(15, 45, 400, 30);

    }

    // 7.3.3 Define valor unitário
    public double valorUnitarioPM(){
        if(pizzaMargueritaGG.isSelected()){return 82.90;
        }else if (pizzaMargueritaG.isSelected()){return 64.90;
        }else {return 49.90;}
    }

    // 7.3.5 Atualiza valor do botão "Adicionar ao Carrinho" (Pizza Marguerita)
    public void atualizarValorPM(){
        double precoPM = valorUnitarioPM();
        int quantidade = Integer.parseInt(quantidadePM.getText());
        double precoTotalPM = precoPM * quantidade;
        botaoPM1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalPM));
        botaoPM1.setEnabled(true); botaoMaisPM.setEnabled(true); botaoMenosPM.setEnabled(true);
    }

    // 7.3.6 Mudar valores de acordo com a escolha do RadioButton (Pizza Marguerita)
    public void escolhaRadioButtonPM(){
        botaoPM1.setEnabled(false); botaoMaisPM.setEnabled(false); botaoMenosPM.setEnabled(false);
        pizzaMargueritaGG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPM(); // atualiza valor
            adicionarAoCarrinhoPM(); // permitindo adicionar ao carrinho
            botaoMenosPM.setForeground(branco); botaoMenosPM.setBackground(vermelho); // mudando cores
            botaoMaisPM.setForeground(branco); botaoMaisPM.setBackground(vermelho);
            botaoPM1.setForeground(branco); botaoPM1.setBackground(vermelho);}
        });
        pizzaMargueritaG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPM(); // atualiza valor
            adicionarAoCarrinhoPM(); // permitindo adicionar ao carrinho
            botaoMenosPM.setForeground(branco); botaoMenosPM.setBackground(vermelho); // mudando cores
            botaoMaisPM.setForeground(branco); botaoMaisPM.setBackground(vermelho);
            botaoPM1.setForeground(branco); botaoPM1.setBackground(vermelho);}
        });
        pizzaMargueritaM.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorPM(); // atualiza valor
            adicionarAoCarrinhoPM(); // permitindo adicionar ao carrinho
            botaoMenosPM.setForeground(branco); botaoMenosPM.setBackground(vermelho); // mudando cores
            botaoMaisPM.setForeground(branco); botaoMaisPM.setBackground(vermelho);
            botaoPM1.setForeground(branco); botaoPM1.setBackground(vermelho);}
        });
    }

    // 7.3.7 Aumenta ou diminui a quantidade de pizzas
    public void definirQuantidadePM(){
        botaoMaisPM.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadePM.getText());
            if (quantidade<10){quantidade++;
                quantidadePM.setText(String.valueOf(quantidade));
                atualizarValorPM();}
        }
        });
        botaoMenosPM.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadePM.getText());
            if (quantidade>1){quantidade--;
                quantidadePM.setText(String.valueOf(quantidade));
                atualizarValorPM();}
        }
        });
    }

    // 7.3.8 adiciona ao carrinho
    public void adicionarAoCarrinhoPM(){
        botaoPM1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tamanho = "";
                String observacao = null;
                if (pizzaMargueritaGG.isSelected()) {
                    tamanho = "Gigante";
                } else if (pizzaMargueritaG.isSelected()) {
                    tamanho = "Grande";
                } else if (pizzaMargueritaM.isSelected()) {
                    tamanho = "Média";
                }
                String nomePizza = "Pizza Marguerita " + tamanho;
                int quantidade = Integer.parseInt(quantidadePM.getText());
                double precoUnitario = valorUnitarioPM();
                ItemCarrinho item = new ItemCarrinho(nomePizza, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}

// --------- 8) PAINEIS SECUNDÁRIOS (HAMBURGUERES) ---------
// 8.1 - Tradicional Burger
class PainelTradicional extends JFrame{
    // 8.1.1 Componentes básicos do painel
    private JLabel texto1TB = new JLabel("Tradicional Burger - R$36.99");
    private JLabel texto2TB = new JLabel("<html> Pão brioche, burger 340g, duplo cheddar, " +
            "alface <br>americana, tomate, cebola, bacon em fatias e <br> molho especial.");
    private JButton botaoTB1 = new JButton("Escolha a opção");
    private JLabel quantidadeTB = new JLabel("1");
    private JButton botaoMaisTB = new JButton("+");
    private JButton botaoMenosTB = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);
    // RadioButton TB
    private JRadioButton carneAoPontoTB = new JRadioButton("Ao Ponto");
    private JRadioButton carneBemPassadaTB = new JRadioButton("Bem Passada");
    private JRadioButton carneMalPassadaTB = new JRadioButton("Mal Passada");
    private JLabel escolhaCarneTB = new JLabel("Escolha o ponto da Carne");
    ButtonGroup grupoCarneTB = new ButtonGroup();
    // mensagem cliente
    private JLabel comentarioTB = new JLabel("Algum comentário? (Ex: tirar cebola, alface etc.)");
    private JTextField mensagemTB = new JTextField(60);

    // 8.1.2 Construtor TB
    public PainelTradicional(){
        // Config do painel
        setTitle("Tradicional Burger");
        setSize(400,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // metodos
        adicionarComponentes(); escolhaPontoCarneTB(); definirQuantidadeTB();
    }

    // 8.1.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes(){
        // texto Burger Tradicional [nome, descricao]
        add(texto1TB); add(texto2TB);
        texto1TB.setFont(new Font("Arial", Font.BOLD, 16));
        texto1TB.setBounds(15, 0, 400, 30);
        texto2TB.setFont(new Font("Arial", Font.PLAIN, 16));
        texto2TB.setBounds(15, 15, 400, 90);

        // RadioButton TB
        add(carneAoPontoTB); add(carneBemPassadaTB); add(carneMalPassadaTB);
        carneAoPontoTB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneAoPontoTB.setBounds(15,115,300,30);
        carneBemPassadaTB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneBemPassadaTB.setBounds(15,140,300,30);
        carneMalPassadaTB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneMalPassadaTB.setBounds(15,165,300,30);
        grupoCarneTB.add(carneAoPontoTB);
        grupoCarneTB.add(carneBemPassadaTB);
        grupoCarneTB.add(carneMalPassadaTB);
        add(escolhaCarneTB); // texto para escolha do ponto
        escolhaCarneTB.setFont(new Font("Arial", Font.BOLD, 14));
        escolhaCarneTB.setBounds(15, 90, 400, 30);

        // botões
        add(quantidadeTB); add(botaoMaisTB); add(botaoMenosTB); add(botaoTB1);
        quantidadeTB.setBounds(75,250,50,30);
        botaoMaisTB.setBounds(100,250,50,30);
        botaoMenosTB.setBounds(10,250,50,30);
        botaoTB1.setBounds(160, 250, 220,30);
        quantidadeTB.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMaisTB.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosTB.setFont(new Font("Arial", Font.BOLD, 14));

        // mensagem cliente
        add(comentarioTB);
        comentarioTB.setFont(new Font("Arial", Font.BOLD, 12));
        comentarioTB.setBounds(15,200,300,20);
        add(mensagemTB);
        mensagemTB.setBounds(10,220,365,25);
    }

    // 8.1.4 Atualiza valor do botão "Adicionar ao Carrinho"
    public void atualizarValorTB(){
        double precoTB = 36.99;
        int quantidade = Integer.parseInt(quantidadeTB.getText());
        double precoTotalTB = precoTB * quantidade;
        botaoTB1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalTB));
        botaoTB1.setEnabled(true); botaoMaisTB.setEnabled(true); botaoMenosTB.setEnabled(true);
    }

    // 8.1.5 permitir que acione o botão apos escolher o ponto da carne
    public void escolhaPontoCarneTB(){
        botaoTB1.setEnabled(false);
        botaoMaisTB.setEnabled(false);
        botaoMenosTB.setEnabled(false);
        carneAoPontoTB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorTB(); // atualiza valor
            adicionarAoCarrinhoTB(); // permitindo adicionar ao carrinho
            botaoMaisTB.setForeground(branco); botaoMaisTB.setBackground(vermelho); // mudando cores
            botaoMenosTB.setForeground(branco);botaoMenosTB.setBackground(vermelho);
            botaoTB1.setBackground(vermelho);botaoTB1.setForeground(branco);}
        });
        carneMalPassadaTB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorTB(); // atualiza valor
            adicionarAoCarrinhoTB(); // permitindo adicionar ao carrinho
            botaoMaisTB.setForeground(branco); botaoMaisTB.setBackground(vermelho);
            botaoMenosTB.setForeground(branco);botaoMenosTB.setBackground(vermelho);
            botaoTB1.setBackground(vermelho);botaoTB1.setForeground(branco);}
        })
        ;carneBemPassadaTB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorTB(); // atualiza valor
            adicionarAoCarrinhoTB(); // permitindo adicionar ao carrinho
            botaoMaisTB.setForeground(branco); botaoMaisTB.setBackground(vermelho);
            botaoMenosTB.setForeground(branco);botaoMenosTB.setBackground(vermelho);
            botaoTB1.setBackground(vermelho);botaoTB1.setForeground(branco);}
        });
    }

    // 8.1.6 Aumenta ou diminui a quantidade
    public void definirQuantidadeTB(){
        botaoMaisTB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeTB.getText());
            if (quantidade < 10){quantidade++;
                quantidadeTB.setText(String.valueOf(quantidade));
                atualizarValorTB();}
        }
        });botaoMenosTB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeTB.getText());
            if (quantidade > 1){quantidade--;
                quantidadeTB.setText(String.valueOf(quantidade));
                atualizarValorTB();}
        }
        });
    }

    // 8.1.7 adiciona ao carrinho
    public void adicionarAoCarrinhoTB(){
        botaoTB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ponto = "";
                String observacao = mensagemTB.getText();
                if (carneBemPassadaTB.isSelected()){
                    ponto = "carne bem passada";
                } else if (carneMalPassadaTB.isSelected()) {
                    ponto = "carne mal passada";
                } else if (carneAoPontoTB.isSelected()) {
                    ponto = "carne ao ponto";
                }
                String nomeTB = "Tradicional Burger, " + ponto;
                int quantidade = Integer.parseInt(quantidadeTB.getText());
                double precoUnitario = 36.99;
                ItemCarrinho item = new ItemCarrinho(nomeTB, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}

// 8.2 - Chicken Burger
class PainelChicken extends JFrame{
    // 8.1.1 Componentes básicos do painel
    private JLabel texto1CB = new JLabel("Chicken Burger - R$33.99");
    private JLabel texto2CB = new JLabel("<html>Pão brioche, burger de frango empanado crocante  <br> 180g" +
            ", duplo queijo prato, alface-americana, tomate,<br> e molho especial.");
    private JButton botaoCB1 = new JButton("Escolha a opção");
    private JLabel quantidadeCB = new JLabel("1");
    private JButton botaoMaisCB = new JButton("+");
    private JButton botaoMenosCB = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);
    // RadioButton CB
    private JRadioButton carneAoPontoCB = new JRadioButton("Ao Ponto");
    private JRadioButton carneBemPassadaCB = new JRadioButton("Bem Passada");
    private JRadioButton carneMalPassadaCB = new JRadioButton("Mal Passada");
    private JLabel escolhaCarneCB = new JLabel("Escolha o ponto da Carne");
    ButtonGroup grupoCarneCB = new ButtonGroup();
    // mensagem cliente
    private JLabel comentarioCB = new JLabel("Algum comentário? (Ex: tirar cebola, alface etc.)");
    private JTextField mensagemCB = new JTextField(60);

    // 8.2.2 Construtor CB
    public PainelChicken(){
        // Config do painel
        setTitle("Chicken Burger");
        setSize(400,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Metodos
        adicionarComponentes(); escolhaPontoCarneCB(); definirQuantidadeCB();
    }

    // 8.2.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes(){
        // texto Burger Chicken [nome, descricao]
        // texto Burger Tradicional [nome, descricao]
        add(texto1CB); add(texto2CB);
        texto1CB.setFont(new Font("Arial", Font.BOLD, 16));
        texto1CB.setBounds(15, 0, 400, 30);
        texto2CB.setFont(new Font("Arial", Font.PLAIN, 16));
        texto2CB.setBounds(15, 15, 400, 90);

        // RadioButton TB
        add(carneAoPontoCB); add(carneBemPassadaCB); add(carneMalPassadaCB);
        carneAoPontoCB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneAoPontoCB.setBounds(15,115,300,30);
        carneBemPassadaCB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneBemPassadaCB.setBounds(15,140,300,30);
        carneMalPassadaCB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneMalPassadaCB.setBounds(15,165,300,30);
        grupoCarneCB.add(carneAoPontoCB);
        grupoCarneCB.add(carneBemPassadaCB);
        grupoCarneCB.add(carneMalPassadaCB);
        add(escolhaCarneCB); // texto para escolha do ponto
        escolhaCarneCB.setFont(new Font("Arial", Font.BOLD, 14));
        escolhaCarneCB.setBounds(15, 90, 400, 30);

        // botões
        add(quantidadeCB); add(botaoMaisCB); add(botaoMenosCB); add(botaoCB1);
        quantidadeCB.setBounds(75,250,50,30);
        botaoMaisCB.setBounds(100,250,50,30);
        botaoMenosCB.setBounds(10,250,50,30);
        botaoCB1.setBounds(160, 250, 220,30);
        quantidadeCB.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMaisCB.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosCB.setFont(new Font("Arial", Font.BOLD, 14));

        // mensagem cliente
        add(comentarioCB);
        comentarioCB.setFont(new Font("Arial", Font.BOLD, 12));
        comentarioCB.setBounds(15,200,300,20);
        add(mensagemCB);
        mensagemCB.setBounds(10,220,365,25);
    }

    // 8.2.4 Atualiza valor do botão "Adicionar ao Carrinho"
    public void atualizarValorCB(){
        double precoCB = 33.99;
        int quantidade = Integer.parseInt(quantidadeCB.getText());
        double precoTotalCB = precoCB * quantidade;
        botaoCB1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalCB));
        botaoCB1.setEnabled(true);
        botaoMaisCB.setEnabled(true);
        botaoMenosCB.setEnabled(true);
    }

    // 8.2.5 permitir que acione o botão apos escolher o ponto da carne
    public void escolhaPontoCarneCB(){
        botaoCB1.setEnabled(false);
        botaoMaisCB.setEnabled(false);
        botaoMenosCB.setEnabled(false);
        carneAoPontoCB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorCB(); // atualiza valor
            adicionarAoCarrinhoCB(); // permitindo adicionar ao carrinho
            botaoMaisCB.setForeground(branco); botaoMaisCB.setBackground(vermelho); // mudando cores
            botaoMenosCB.setForeground(branco);botaoMenosCB.setBackground(vermelho);
            botaoCB1.setBackground(vermelho);botaoCB1.setForeground(branco);}
        });
        carneMalPassadaCB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorCB(); // atualiza valor
            adicionarAoCarrinhoCB(); // permitindo adicionar ao carrinho
            botaoMaisCB.setForeground(branco); botaoMaisCB.setBackground(vermelho);
            botaoMenosCB.setForeground(branco);botaoMenosCB.setBackground(vermelho);
            botaoCB1.setBackground(vermelho);botaoCB1.setForeground(branco);}
        })
        ;carneBemPassadaCB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorCB(); // atualiza valor
            adicionarAoCarrinhoCB(); // permitindo adicionar ao carrinho
            botaoMaisCB.setForeground(branco); botaoMaisCB.setBackground(vermelho);
            botaoMenosCB.setForeground(branco);botaoMenosCB.setBackground(vermelho);
            botaoCB1.setBackground(vermelho);botaoCB1.setForeground(branco);}
        });
    }

    // 8.2.6 Aumenta ou diminui a quantidade
    public void definirQuantidadeCB(){
        botaoMaisCB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeCB.getText());
            if (quantidade < 10){quantidade++;
                quantidadeCB.setText(String.valueOf(quantidade));
                atualizarValorCB();}
        }
        });botaoMenosCB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeCB.getText());
            if (quantidade > 1){quantidade--;
                quantidadeCB.setText(String.valueOf(quantidade));
                atualizarValorCB();}
        }
        });
    }

    // 8.2.7 adiciona ao carrinho
    public void adicionarAoCarrinhoCB(){
        botaoCB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ponto = "";
                String observacao = mensagemCB.getText();
                if (carneBemPassadaCB.isSelected()){
                    ponto = "carne bem passada";
                } else if (carneMalPassadaCB.isSelected()) {
                    ponto = "carne mal passada";
                } else if (carneAoPontoCB.isSelected()) {
                    ponto = "carne ao ponto";
                }
                String nomeTB = "Chicken Burger, " + ponto;
                int quantidade = Integer.parseInt(quantidadeCB.getText());
                double precoUnitario = 33.99;
                ItemCarrinho item = new ItemCarrinho(nomeTB, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}

// 8.3 - Smash Burger
class PainelSmash extends JFrame{
    // 8.1.1 Componentes básicos do painel
    private JLabel texto1SB = new JLabel("Smash Burger - R$29.99");
    private JLabel texto2SB = new JLabel("<html> Pão brioche selado, quádruplo burger super smash<br> (80g cada), duplo cheddar, " +
            "cebola, bacon em fatias <br> e molho especial.");
    private JButton botaoSB1 = new JButton("Escolha a opção");
    private JLabel quantidadeSB = new JLabel("1");
    private JButton botaoMaisSB = new JButton("+");
    private JButton botaoMenosSB = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);
    // RadioButton SB
    private JRadioButton carneAoPontoSB = new JRadioButton("Ao Ponto");
    private JRadioButton carneBemPassadaSB = new JRadioButton("Bem Passada");
    private JRadioButton carneMalPassadaSB = new JRadioButton("Mal Passada");
    private JLabel escolhaCarneSB = new JLabel("Escolha o ponto da Carne");
    ButtonGroup grupoCarneSB = new ButtonGroup();
    // mensagem cliente
    private JLabel comentarioSB = new JLabel("Algum comentário? (Ex: tirar cebola, alface etc.)");
    private JTextField mensagemSB = new JTextField(60);

    // 8.3.2 construtor SB
    public PainelSmash(){
        // Config do painel
        setTitle("Smash Burger");
        setSize(400,350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // metodos
        adicionarComponentes(); escolhaPontoCarneSB(); definirQuantidadeSB();
    }

    // 8.3.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes(){
        // texto Burger Tradicional [nome, descricao]
        add(texto1SB); add(texto2SB);
        texto1SB.setFont(new Font("Arial", Font.BOLD, 16));
        texto1SB.setBounds(15, 0, 400, 30);
        texto2SB.setFont(new Font("Arial", Font.PLAIN, 16));
        texto2SB.setBounds(15, 15, 400, 90);

        // RadioButton TB
        add(carneAoPontoSB); add(carneBemPassadaSB); add(carneMalPassadaSB);
        carneAoPontoSB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneAoPontoSB.setBounds(15,115,300,30);
        carneBemPassadaSB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneBemPassadaSB.setBounds(15,140,300,30);
        carneMalPassadaSB.setFont(new Font("Arial", Font.PLAIN, 14));
        carneMalPassadaSB.setBounds(15,165,300,30);
        grupoCarneSB.add(carneAoPontoSB);
        grupoCarneSB.add(carneBemPassadaSB);
        grupoCarneSB.add(carneMalPassadaSB);
        add(escolhaCarneSB); // texto para escolha do ponto
        escolhaCarneSB.setFont(new Font("Arial", Font.BOLD, 14));
        escolhaCarneSB.setBounds(15, 90, 400, 30);

        // botões
        add(quantidadeSB); add(botaoMaisSB); add(botaoMenosSB); add(botaoSB1);
        quantidadeSB.setBounds(75,250,50,30);
        botaoMaisSB.setBounds(100,250,50,30);
        botaoMenosSB.setBounds(10,250,50,30);
        botaoSB1.setBounds(160, 250, 220,30);
        quantidadeSB.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMaisSB.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosSB.setFont(new Font("Arial", Font.BOLD, 14));

        // mensagem cliente
        add(comentarioSB);
        comentarioSB.setFont(new Font("Arial", Font.BOLD, 12));
        comentarioSB.setBounds(15,200,300,20);
        add(mensagemSB);
        mensagemSB.setBounds(10,220,365,25);
    }

    // 8.3.4 Atualiza valor do botão "Adicionar ao Carrinho"
    public void atualizarValorSB(){
        double precoSB = 29.99;
        int quantidade = Integer.parseInt(quantidadeSB.getText());
        double precoTotalSB = precoSB * quantidade;
        botaoSB1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalSB));
        botaoSB1.setEnabled(true); botaoMaisSB.setEnabled(true); botaoMenosSB.setEnabled(true);
    }

    // 8.3.5 permitir que acione o botão apos escolher o ponto da carne
    public void escolhaPontoCarneSB(){
        botaoSB1.setEnabled(false);
        botaoMaisSB.setEnabled(false);
        botaoMenosSB.setEnabled(false);
        carneAoPontoSB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorSB(); // atualiza valor
            adicionarAoCarrinhoSB(); // permitindo adicionar ao carrinho
            botaoMaisSB.setForeground(branco); botaoMaisSB.setBackground(vermelho); // mudando cores
            botaoMenosSB.setForeground(branco);botaoMenosSB.setBackground(vermelho);
            botaoSB1.setBackground(vermelho);botaoSB1.setForeground(branco);}
        });
        carneMalPassadaSB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorSB(); // atualiza valor
            adicionarAoCarrinhoSB(); // permitindo adicionar ao carrinho
            botaoMaisSB.setForeground(branco); botaoMaisSB.setBackground(vermelho);
            botaoMenosSB.setForeground(branco);botaoMenosSB.setBackground(vermelho);
            botaoSB1.setBackground(vermelho);botaoSB1.setForeground(branco);}
        });
        carneBemPassadaSB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            atualizarValorSB(); // atualiza valor
            adicionarAoCarrinhoSB(); // permitindo adicionar ao carrinho
            botaoMaisSB.setForeground(branco); botaoMaisSB.setBackground(vermelho);
            botaoMenosSB.setForeground(branco);botaoMenosSB.setBackground(vermelho);
            botaoSB1.setBackground(vermelho);botaoSB1.setForeground(branco);}
        });
    }

    // 8.3.6 Aumenta ou diminui a quantidade
    public void definirQuantidadeSB(){
        botaoMaisSB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeSB.getText());
            if (quantidade < 10){quantidade++;
                quantidadeSB.setText(String.valueOf(quantidade));
                atualizarValorSB();}
        }
        });botaoMenosSB.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeSB.getText());
            if (quantidade > 1){quantidade--;
                quantidadeSB.setText(String.valueOf(quantidade));
                atualizarValorSB();}
        }
        });
    }

    // 8.3.7 adiciona ao carrinho
    public void adicionarAoCarrinhoSB(){
        botaoSB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ponto = "";
                String observacao = mensagemSB.getText();
                if (carneBemPassadaSB.isSelected()){
                    ponto = "carne bem passada";
                } else if (carneMalPassadaSB.isSelected()) {
                    ponto = "carne mal passada";
                } else if (carneAoPontoSB.isSelected()) {
                    ponto = "carne ao ponto";
                }
                String nomeTB = "Smash Burger, " + ponto;
                int quantidade = Integer.parseInt(quantidadeSB.getText());
                double precoUnitario = 29.99;
                ItemCarrinho item = new ItemCarrinho(nomeTB, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}

// --------- 9) PAINEIS SECUNDÁRIOS (BEBIDAS) ---------
// 9.1 Coca lata
class PainelCocaLata extends JFrame{
    // 9.1.1 Componentes básicos do painel
    private JLabel texto1CL = new JLabel("Coca-Cola - R$6,00 (Unidade)");
    private JLabel texto2CL = new JLabel("Lata Coca-Cola 350ml, Bebida Gelada");
    private JLabel escolhaQuantidadeCL = new JLabel("Escolha a quantidade");
    private JButton botaoCL1 = new JButton("Escolha a quantidade");
    private JLabel quantidadeCL = new JLabel("0");
    private JButton botaoMaisCL = new JButton("+");
    private JButton botaoMenosCL = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);

    // 9.1.2 Construtor
    public PainelCocaLata(){
        // Config do painel
        setTitle("Coca-Cola 350ml");
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Metodos
        adicionarComponentes(); definirQuantidadeSB();
    }

    // 9.1.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes() {
        // texto coca lata [nome, descricao]
        add(texto1CL);add(texto2CL);
        texto1CL.setFont(new Font("Arial", Font.BOLD, 16));
        texto1CL.setBounds(15, 0, 250, 30);
        texto2CL.setFont(new Font("Arial", Font.PLAIN, 14));
        texto2CL.setBounds(15, 20, 250, 30);
        add(escolhaQuantidadeCL); // texto para escolha da quantidade
        escolhaQuantidadeCL.setFont(new Font("Arial", Font.BOLD, 14));
        escolhaQuantidadeCL.setBounds(15, 40, 400, 30);

        // botões
        add(quantidadeCL); add(botaoMaisCL); add(botaoMenosCL); add(botaoCL1);
        quantidadeCL.setBounds(80,75,50,30);
        botaoMaisCL.setBounds(100,75,50,30);
        botaoMenosCL.setBounds(15,75,50,30);
        botaoCL1.setBounds(15, 115, 220,30);
        botaoMaisCL.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosCL.setFont(new Font("Arial", Font.BOLD, 14));
        quantidadeCL.setFont(new Font("Arial", Font.BOLD, 14));

    }

    // 9.1.4 Atualiza valor do botão "Adicionar ao Carrinho"
    public void atualizarValorCL(){
        double precoCL = 6.00;
        int quantidade = Integer.parseInt(quantidadeCL.getText());
        double precoTotalCL = precoCL * quantidade;
        botaoCL1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalCL));
        botaoCL1.setEnabled(true); botaoMaisCL.setEnabled(true); botaoMenosCL.setEnabled(true);
        // mudando cores
        botaoMaisCL.setForeground(branco); botaoMaisCL.setBackground(vermelho); // mudando cores
        botaoMenosCL.setForeground(branco);botaoMenosCL.setBackground(vermelho);
        botaoCL1.setBackground(vermelho);botaoCL1.setForeground(branco);
    }

    // 9.1.5 Aumenta ou diminui a quantidade
    public void definirQuantidadeSB(){
        botaoCL1.setEnabled(false); botaoMaisCL.setEnabled(true); botaoMenosCL.setEnabled(false);
        botaoMaisCL.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeCL.getText());
            if (quantidade < 10){quantidade++;
                quantidadeCL.setText(String.valueOf(quantidade));
                atualizarValorCL();}
        }
        });botaoMenosCL.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeCL.getText());
            if (quantidade > 1){quantidade--;
                quantidadeCL.setText(String.valueOf(quantidade));
                atualizarValorCL();}
        }
        });
        adicionarAoCarrinhoCL(); // permite add ao carrinho
    }

    // 9.1.6 adiciona ao carrinho
    public void adicionarAoCarrinhoCL(){
        botaoCL1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String nome = "Coca-Cola 350ml";
                    String observacao = null;
                    int quantidade = Integer.parseInt(quantidadeCL.getText());
                    double precoUnitario = 6;
                    ItemCarrinho item = new ItemCarrinho(nome, quantidade, precoUnitario, observacao);
                    CarrinhoDeCompras.getInstance().adicionarItem(item);
                    JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                            "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
            }
        });
    }

}

// 9.2 Heineken Long Neck
class PainelHeineken extends JFrame{
    // 9.2.1 Componentes básicos do painel
    private JLabel texto1HN = new JLabel("Heinken - R$7,50 (Unidade)");
    private JLabel texto2HN = new JLabel("Long Neck Heineken 330ml, Bebida Gelada");
    private JLabel escolhaQuantidadeHN = new JLabel("Escolha a quantidade");
    private JButton botaoHN1 = new JButton("Escolha a quantidade");
    private JLabel quantidadeHN = new JLabel("0");
    private JButton botaoMaisHN = new JButton("+");
    private JButton botaoMenosHN = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);

    // 9.2.2 Construtor
    public PainelHeineken(){
        // Config do painel
        setTitle("Heineken 330ml");
        setSize(350,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Metodos
        adicionarComponentes(); definirQuantidadeHN();
    }

    // 9.2.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes() {
        // texto heineken [nome, descricao]
        add(texto1HN);add(texto2HN);
        texto1HN.setFont(new Font("Arial", Font.BOLD, 16));
        texto1HN.setBounds(15, 0, 250, 30);
        texto2HN.setFont(new Font("Arial", Font.PLAIN, 12));
        texto2HN.setBounds(15, 20, 250, 30);
        add(escolhaQuantidadeHN); // texto para escolha da quantidade
        escolhaQuantidadeHN.setFont(new Font("Arial", Font.BOLD, 14));
        escolhaQuantidadeHN.setBounds(15, 40, 400, 30);

        // botões
        add(quantidadeHN); add(botaoMaisHN); add(botaoMenosHN); add(botaoHN1);
        quantidadeHN.setBounds(80,75,50,30);
        botaoMaisHN.setBounds(100,75,50,30);
        botaoMenosHN.setBounds(15,75,50,30);
        botaoHN1.setBounds(15, 115, 220,30);
        botaoMaisHN.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosHN.setFont(new Font("Arial", Font.BOLD, 14));
        quantidadeHN.setFont(new Font("Arial", Font.BOLD, 14));
    }

    // 9.2.4 Atualiza valor do botão "Adicionar ao Carrinho"
    public void atualizarValorHN(){
        double precoHN = 7.50;
        int quantidade = Integer.parseInt(quantidadeHN.getText());
        double precoTotalHN = precoHN * quantidade;
        botaoHN1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalHN));
        botaoHN1.setEnabled(true); botaoMaisHN.setEnabled(true); botaoMenosHN.setEnabled(true);
        // mudando cores
        botaoMaisHN.setForeground(branco); botaoMaisHN.setBackground(vermelho); // mudando cores
        botaoMenosHN.setForeground(branco);botaoMenosHN.setBackground(vermelho);
        botaoHN1.setBackground(vermelho);botaoHN1.setForeground(branco);
    }

    // 9.2.5 Aumenta ou diminui a quantidade
    public void definirQuantidadeHN(){
        botaoHN1.setEnabled(false); botaoMaisHN.setEnabled(true); botaoMenosHN.setEnabled(false);
        botaoMaisHN.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeHN.getText());
            if (quantidade < 10){quantidade++;
                quantidadeHN.setText(String.valueOf(quantidade));
                atualizarValorHN();}
        }
        });botaoMenosHN.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeHN.getText());
            if (quantidade > 1){quantidade--;
                quantidadeHN.setText(String.valueOf(quantidade));
                atualizarValorHN();}
        }
        });
        adicionarAoCarrinhoHN(); // permite add ao carrinho
    }

    // 9.2.6 adiciona ao carrinho
    public void adicionarAoCarrinhoHN(){
        botaoHN1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = "Heineken 330ml";
                String observacao = null;
                int quantidade = Integer.parseInt(quantidadeHN.getText());
                double precoUnitario = 7.5;
                ItemCarrinho item = new ItemCarrinho(nome, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}

// 9.3 Coca-Cola Garrafa
class PainelCocaGarrafa extends JFrame{
    // 9.3.1 Componentes básicos do painel
    private JLabel texto1CG = new JLabel("Coca-Cola - R$12,50 (Unidade)");
    private JLabel texto2CG = new JLabel("Coca-Cola Garrafa 2l, Bebida Gelada");
    private JLabel escolhaQuantidadeCG = new JLabel("Escolha a quantidade");
    private JButton botaoCG1 = new JButton("Escolha a quantidade");
    private JLabel quantidadeCG = new JLabel("0");
    private JButton botaoMaisCG = new JButton("+");
    private JButton botaoMenosCG = new JButton("-");
    Color vermelho = new Color(218, 47, 47, 255);
    Color branco = new Color(255, 255, 255);


    // 9.3.2 construtor
    public PainelCocaGarrafa(){
        // Config do painel
        setTitle("Coca-Cola 2l");
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Metodos
        adicionarComponentes(); definirQuantidadeCG();
    }

    // 9.3.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes() {
        // texto coca 2l [nome, descricao]
        add(texto1CG);add(texto2CG);
        texto1CG.setFont(new Font("Arial", Font.BOLD, 16));
        texto1CG.setBounds(15, 0, 250, 30);
        texto2CG.setFont(new Font("Arial", Font.PLAIN, 14));
        texto2CG.setBounds(15, 20, 250, 30);
        add(escolhaQuantidadeCG); // texto para escolha da quantidade
        escolhaQuantidadeCG.setFont(new Font("Arial", Font.BOLD, 14));
        escolhaQuantidadeCG.setBounds(15, 40, 400, 30);

        // botões
        add(quantidadeCG); add(botaoMaisCG); add(botaoMenosCG); add(botaoCG1);
        quantidadeCG.setBounds(80,75,50,30);
        botaoMaisCG.setBounds(100,75,50,30);
        botaoMenosCG.setBounds(15,75,50,30);
        botaoCG1.setBounds(15, 115, 220,30);
        botaoMaisCG.setFont(new Font("Arial", Font.BOLD, 14));
        botaoMenosCG.setFont(new Font("Arial", Font.BOLD, 14));
        quantidadeCG.setFont(new Font("Arial", Font.BOLD, 14));
    }

    // 9.3.4 Atualiza valor do botão "Adicionar ao Carrinho"
    public void atualizarValorCG(){
        double precoCG = 12.50;
        int quantidade = Integer.parseInt(quantidadeCG.getText());
        double precoTotalCG = precoCG * quantidade;
        botaoCG1.setText("Adiconar ao Carrinho: R$" + String.format("%.2f", precoTotalCG));
        botaoCG1.setEnabled(true); botaoMaisCG.setEnabled(true); botaoMenosCG.setEnabled(true);
        // mudando cores
        botaoMaisCG.setForeground(branco); botaoMaisCG.setBackground(vermelho); // mudando cores
        botaoMenosCG.setForeground(branco);botaoMenosCG.setBackground(vermelho);
        botaoCG1.setBackground(vermelho);botaoCG1.setForeground(branco);
    }

    // 9.3.5 Aumenta ou diminui a quantidade
    public void definirQuantidadeCG(){
        botaoCG1.setEnabled(false); botaoMaisCG.setEnabled(true); botaoMenosCG.setEnabled(false);
        botaoMaisCG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeCG.getText());
            if (quantidade < 10){quantidade++;
                quantidadeCG.setText(String.valueOf(quantidade));
                atualizarValorCG();}
        }
        });botaoMenosCG.addActionListener(new ActionListener() {@Override
        public void actionPerformed(ActionEvent e) {
            int quantidade = Integer.parseInt(quantidadeCG.getText());
            if (quantidade > 1){quantidade--;
                quantidadeCG.setText(String.valueOf(quantidade));
                atualizarValorCG();}
        }
        });
        adicionarAoCarrinhoCG(); // permite add ao carrinho
    }

    // 9.3.6 adiciona ao carrinho
    public void adicionarAoCarrinhoCG(){
        botaoCG1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = "Coca-Cola 2l";
                String observacao = null;
                int quantidade = Integer.parseInt(quantidadeCG.getText());
                double precoUnitario = 12.5;
                ItemCarrinho item = new ItemCarrinho(nome, quantidade, precoUnitario, observacao);
                CarrinhoDeCompras.getInstance().adicionarItem(item);
                JOptionPane.showMessageDialog(null, "Produto(s) adicionado(s) ao carrinho!",
                        "Verifique o carrinho", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });
    }

}


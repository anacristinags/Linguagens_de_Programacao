import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TelaLogin extends JFrame {

    // Componentes da interface gráfica
    private JPanel painelPrincipal = new JPanel();
    private JPanel painelImg = new JPanel();
    private JLabel labelPainelImg = new JLabel();
    private JLabel labelPainelImg2 = new JLabel();
    private JLabel labelUsuario = new JLabel();
    private JLabel labelSenha = new JLabel();
    private JTextField textUsuario = new JTextField();
    private JTextField textSenha = new JTextField();
    private JButton buttonLogin = new JButton();
    private JButton buttonCadastrar = new JButton();
    private JButton buttonForgot = new JButton();

    // Construtor da classe
    public TelaLogin() {
        super("Login"); // Definir título da janela
        this.setLayout(null); // Definir layout como nulo
        this.setSize(600, 500); // Definir tamanho da janela
        this.setResizable(false); // Impedir redimensionamento da janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Fechar a aplicação ao fechar a janela
        this.setLocationRelativeTo(null); // Centralizar a janela
        this.setVisible(true); // Tornar a janela visível
        this.getContentPane().setBackground(new Color(0, 128, 255)); // Definir a cor de fundo do JFrame
        configurarComponentes(); // Configurar os componentes da interface
        this.getContentPane().add(painelImg); // Adicionar painel de imagem à janela
        this.getContentPane().add(painelPrincipal); // Adicionar painel principal à janela
    }

    // Método para configurar os componentes da interface
    private void configurarComponentes() {
        configurarPainelPrincipal(); // Configurar painel principal
        configurarPainelImg(); // Configurar painel de imagem
        configurarJlabels(); // Configurar rótulos
        configurarJtextfield(); // Configurar campos de texto
        configurarJbutton(); // Configurar botões
    }

    /**
     * Método para configurar as dimensões dos botões, fontes de escrita e adicionar
     * as ações de funcionalidade em cada um deles.
     */
    // Método para configurar os botões
    private void configurarJbutton() {
        buttonLogin.setFont(new Font("Arial", Font.BOLD, 16));
        buttonLogin.setText("LOGIN");
        buttonLogin.setBounds(20, 290, 200, 30);

        buttonCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        buttonCadastrar.setText("CADASTRAR");
        buttonCadastrar.setBounds(20, 340, 200, 30);

        buttonForgot.setFont(new Font("Arial", Font.BOLD, 10));
        buttonForgot.setText("Esqueceu sua senha?");
        buttonForgot.setBounds(70, 230, 150, 15);

        //Adicionar ação ao botão "Login"
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarLogin(); //Adiciona o método para verificar o login
            }
        });

        // Adicionar ação ao botão "Cadastrar"
        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro(); // Criar nova instância da tela de cadastro
                telaCadastro.setVisible(true); // Tornar a janela de cadastro visível
            }
        });

        // Adicionar ação ao botão "Esqueceu sua senha?"
        buttonForgot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaNovaSenha telaNovaSenha = new TelaNovaSenha();
                telaNovaSenha.setVisible(true); // Torna visível o painel de alterar a senha
            }
        });
    }

    // Método para configurar os campos de texto
    private void configurarJtextfield() {
        textUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        textUsuario.setBounds(20, 110, 200, 30);

        textSenha.setFont(new Font("Arial", Font.BOLD, 14));
        textSenha.setBounds(20, 190, 200, 30);
    }

    // Método para configurar os rótulos
    private void configurarJlabels() {
        labelUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        labelUsuario.setText("Email:");
        labelUsuario.setBounds(20, 70, 200, 30);

        labelSenha.setFont(new Font("Arial", Font.BOLD, 16));
        labelSenha.setText("Senha:");
        labelSenha.setBounds(20, 150, 200, 30);

        labelPainelImg.setFont(new Font("Arial", Font.BOLD, 21));
        labelPainelImg.setForeground(Color.white);
        labelPainelImg.setText("Seja bem vindo(a)!");
        labelPainelImg.setBounds(74, 160, 200, 30);

        labelPainelImg2.setFont(new Font("Arial", Font.BOLD, 16));
        labelPainelImg2.setForeground(Color.white);
        labelPainelImg2.setText("Faça login ou cadastre-se.");
        labelPainelImg2.setBounds(74, 230, 200, 50);
    }

    // Método para configurar o painel principal
    private void configurarPainelPrincipal() {
        painelPrincipal.setLayout(null);
        painelPrincipal.setBackground(new Color(255, 255, 255));
        painelPrincipal.setBounds(0, 0, 250, 500); // Ajustar altura para corresponder à altura do JFrame
        painelPrincipal.add(labelUsuario);
        painelPrincipal.add(textUsuario);
        painelPrincipal.add(labelSenha);
        painelPrincipal.add(textSenha);
        painelPrincipal.add(buttonLogin);
        painelPrincipal.add(buttonCadastrar);
        painelPrincipal.add(buttonForgot);
    }

    // Método para configurar o painel de fundo
    private void configurarPainelImg() {
        painelImg.setLayout(null);
        painelImg.setBounds(251, 0, 350, 500); // Ajustar altura para corresponder à altura do JFrame
        painelImg.setBackground(new Color(0x1616C0));
        painelImg.add(labelPainelImg);
        painelImg.add(labelPainelImg2);
        /*try {
            ImageIcon icon = new ImageIcon("TelaDeLogin/img/fundoazul.jpg");
            JLabel labelImg = new JLabel(icon);
            painelImg.add(labelImg);
        } catch (NullPointerException e) {
            System.out.println("Erro ao carregar imagem: " + e.getMessage());
        }
        */
    }

    /**
     * Método para fazer a verificação de login no BD sqlite. O sistema verifica se o login existe ou é enválido;
     * Caso exista, o login é concluído e o sistema abre a tela de pagamentos.
     */
    // Método para verificar login
    private void verificarLogin() {
        String usuario = textUsuario.getText();
        String senha = textSenha.getText();

        try {
            // Obter conexão com o banco de dados
            Connection conn = ConexaoBD.obterConexao();
            // Preparar consulta SQL
            String sql = "SELECT * FROM Usuários WHERE Email = ? AND Senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            // Executar consulta
            ResultSet rs = stmt.executeQuery();

            // Verificar se há resultados
            if (rs.next()) {
                // Login válido!
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                // Direciona para a próxima tela
                TelaPrincipal telaPrincipal = new TelaPrincipal(); // Instancia a nova tela
                telaPrincipal.setVisible(true); // Torna a nova tela visível
                //Fecha a tela de login
                dispose();
            } else {
                // Login inválido
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
            }

            // Fechar recursos
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao verificar login!");
        }
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        new TelaLogin();
    }
}

/**
 * Classe criada para configurar o sistema de "Forgot Password". Buscando os dados e alterando a senha no BD.
 */
class TelaNovaSenha extends JFrame {

    // Componentes da Interface Gráfica
    private JPanel painelNovaSenha;
    private JLabel labelEmail = new JLabel("Email:");
    private JLabel labelNovaSenha = new JLabel("Nova Senha:");
    private JTextField textEmail = new JTextField();
    private JTextField textNovaSenha = new JTextField();
    private JButton buttonRedefinir = new JButton("Redefinir");
    private JButton buttonCancelar = new JButton("Cancelar");

    /**
     * Construtor da classe.
     * Define as propriedades iniciais da janela e configura os componentes.
     */
    public TelaNovaSenha() {
        super("Redefinir Senha");
        configurarComponentes();
        setLayout(null);
        setSize(400, 250);
        getContentPane().setBackground(new Color(0, 128, 255));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Método para configurar os componentes da interface e adicionar as ações aos botões.
     */
    private void configurarComponentes() {
        painelNovaSenha = new JPanel();
        painelNovaSenha.setLayout(null);
        painelNovaSenha.setBounds(10, 10, 364, 194);
        painelNovaSenha.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        painelNovaSenha.setBackground(Color.WHITE);

        configurarLabel(labelEmail, 20, 20);
        configurarTextField(textEmail, 150, 20);
        configurarLabel(labelNovaSenha, 20, 70);
        configurarTextField(textNovaSenha, 150, 70);
        configurarButton(buttonRedefinir, 20, 120);
        configurarButton(buttonCancelar, 180, 120);

        // Adiciona ação ao botão "Redefinir"
        buttonRedefinir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionButtonRedefinir(); // Chama o método para redefinir a senha
            }
        });

        // Adiciona ação ao botão "Cancelar"
        buttonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
            }
        });

        add(painelNovaSenha);
    }

    // Método para configurar Labels
    private void configurarLabel(JLabel label, int x, int y) {
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(x, y, 120, 25);
        painelNovaSenha.add(label);
    }

    // Método para configurar TextFields
    private void configurarTextField(JTextField textField, int x, int y) {
        textField.setFont(new Font("Arial", Font.BOLD, 16));
        textField.setBounds(x, y, 200, 25);
        painelNovaSenha.add(textField);
    }

    // Método para configurar Buttons
    private void configurarButton(JButton button, int x, int y) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBounds(x, y, 138, 35);
        painelNovaSenha.add(button);
    }

    /**
     * Método para criar a validação do email e alteração de senha.
     * A alteração da senha só é disponível se o email já for cadastrado no sistema de BD.
     */
    private void actionButtonRedefinir() {
        String email = textEmail.getText();
        String novaSenha = textNovaSenha.getText();

        // Verifica se os campos estão preenchidos
        if (email.isEmpty() || novaSenha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        try {
            // Obtém conexão com o banco de dados
            Connection conn = ConexaoBD.obterConexao();
            // Prepara a consulta SQL para verificar se o email está cadastrado
            String sql = "SELECT * FROM Usuários WHERE Email = ?";
            // A variável 'stmt' é responsável por preparar e executar consultas SQL no banco de dados.
            PreparedStatement stmt = conn.prepareStatement(sql);
            // Define o valor do primeiro parâmetro da consulta SQL para o valor da variável 'email'.
            stmt.setString(1, email);
            // A variável 'rs' armazena os resultados da consulta SQL executada.
            ResultSet rs = stmt.executeQuery();

            // Verifica se o email existe no banco de dados
            if (rs.next()) {
                // Prepara a consulta SQL para atualizar a senha
                sql = "UPDATE Usuários SET Senha = ? WHERE Email = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, novaSenha);
                stmt.setString(2, email);
                int rowsUpdated = stmt.executeUpdate();

                // Verifica se a senha foi atualizada com sucesso
                if (rowsUpdated > 0) {
                    // Atualiza a consulta SQL para obter a nova senha
                    sql = "SELECT Senha FROM Usuários WHERE Email = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, email);
                    ResultSet updatedRs = stmt.executeQuery();

                    // Verifica se a nova senha foi recuperada
                    if (updatedRs.next()) {
                        JOptionPane.showMessageDialog(this, "Senha redefinida com sucesso!");
                        dispose(); // Fecha a janela atual
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao redefinir a senha.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao redefinir a senha.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Email não cadastrado.");
            }

            // Fecha os recursos
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao redefinir a senha.");
        }
    }
}

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.sql.*;

public class TelaCadastro extends JFrame {

    // Componentes da interface gráfica
    private JPanel painelCadastro;
    private JLabel labelCampos = new JLabel("Preencha os campos a seguir:");
    private JLabel labelNome = new JLabel("Nome:");
    private JTextField textNome = new JTextField();
    private JLabel labelEmail = new JLabel("Email:");
    private JTextField textEmail = new JTextField();
    private JLabel labelSenha = new JLabel("Senha:");
    private JTextField textSenha = new JTextField();
    private JLabel labelTelefone = new JLabel("Telefone:");
    private JLabel labelCPF = new JLabel("CPF:");
    private JLabel labelCidadeEstado = new JLabel("Cidade/Estado:");
    private JTextField textCidadeEstado = new JTextField();
    private JLabel labelPais = new JLabel("País:");
    private JTextField textPais = new JTextField();
    private JLabel labelRuaNumero = new JLabel("Rua/Número:");
    private JTextField textRuaNumero = new JTextField();
    private JLabel labelCEP = new JLabel("CEP:");
    private JButton buttonCadastrar = new JButton("CADASTRAR");
    private JButton buttonCancelar = new JButton("CANCELAR");

    private JFormattedTextField textTelefone;
    private JFormattedTextField textCPF;
    private JFormattedTextField textCEP;

    /**
     * Construtor da classe.
     * Define as propriedades iniciais da janela e configura os componentes.
     */
    public TelaCadastro() {
        super("Cadastro"); // Definir título da janela
        configurarComponentes(); // Configurar os componentes da interface
        setLayout(null); // Definir layout como nulo
        setSize(600, 540); // Definir tamanho da janela
        getContentPane().setBackground(new Color(0, 128, 255)); // Definir a cor de fundo do JFrame
        setLocationRelativeTo(null); // Centralizar a janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Fechar a janela ao invés de sair do programa
        setVisible(true); // Tornar a janela visível
    }

    // Método para configurar os componentes da interface
    private void configurarComponentes() {
        configurarPainelCadastro();
        configurarLabels();
        configurarTexts();
        configurarButtons();
        add(painelCadastro); // Adicionar painel de cadastro à janela
    }

    // Método para configurar os rótulos
    private void configurarLabels() {
        configurarLabel(labelCampos, 20, 20);
        configurarLabel(labelNome, 20, 60);
        configurarLabel(labelEmail, 20, 100);
        configurarLabel(labelSenha, 20, 140);
        configurarLabel(labelTelefone, 20, 180);
        configurarLabel(labelCPF, 20, 220);
        configurarLabel(labelCidadeEstado, 20, 260);
        configurarLabel(labelRuaNumero, 20, 300);
        configurarLabel(labelPais, 20, 340);
        configurarLabel(labelCEP, 20, 380);

        configurarFormattedTextField("(##) #####-####", 180, 180); // Formatação do Telefone
        configurarFormattedTextField("###.###.###-##", 180, 220); // Formatação do CPF
        configurarFormattedTextField("#####-###", 180, 380); // Formatação do CEP
    }

    // Método auxiliar para configurar um rótulo
    private void configurarLabel(JLabel label, int x, int y) {
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(x, y, 150, 25);
        labelCampos.setBounds(174, 20, 250, 25);
        painelCadastro.add(label);
    }

    // Método para configurar formatação de campos de texto
    private void configurarFormattedTextField(String mask, int x, int y) {
        try {
            MaskFormatter formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter('#'); // Definir o caractere de espaço reservado como #
            JFormattedTextField textField = new JFormattedTextField(formatter);
            textField.setFont(new Font("Arial", Font.BOLD, 16));
            textField.setBounds(x, y, 300, 25);
            painelCadastro.add(textField);

            if (mask.equals("(##) #####-####")) {
                textTelefone = textField;
            } else if (mask.equals("###.###.###-##")) {
                textCPF = textField;
            } else if (mask.equals("#####-###")) {
                textCEP = textField;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Método para configurar os campos de texto
    private void configurarTexts() {
        configurarTextField(textNome, 180, 60);
        configurarTextField(textEmail, 180, 100);
        configurarTextField(textSenha, 180, 140);
        configurarTextField(textCidadeEstado, 180, 260);
        configurarTextField(textRuaNumero, 180, 300);
        configurarTextField(textPais, 180, 340);
    }

    // Método auxiliar para configurar um campo de texto
    private void configurarTextField(JTextField textField, int x, int y) {
        textField.setFont(new Font("Arial", Font.BOLD, 16));
        textField.setBounds(x, y, 300, 25);
        painelCadastro.add(textField);
    }

    // Método para configurar os botões
    private void configurarButtons() {
        configurarButton(buttonCadastrar, 180, 420);
        configurarButton(buttonCancelar, 340, 420);
        // Adicionar ações aos botões
        buttonCadastrar.addActionListener(e -> actionButtonCadastrar());
        buttonCancelar.addActionListener(e -> actionButtonCancelar());
    }

    // Método auxiliar para configurar um botão
    private void configurarButton(JButton button, int x, int y) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBounds(x, y, 138, 35);
        painelCadastro.add(button);
    }

    // Método para configurar o painel de cadastro
    private void configurarPainelCadastro() {
        painelCadastro = new JPanel();
        painelCadastro.setLayout(null);
        painelCadastro.setBounds(10, 10, 564, 484);
        painelCadastro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Adicionar borda preta ao painel
        painelCadastro.setBackground(Color.WHITE); // Definir a cor de fundo do painel
    }

    /**
     * Método para lidar com o evento do botão "Cadastrar".
     * Valida os campos preenchidos e insere os dados no banco de dados.
     */
    private void actionButtonCadastrar() {
        if (camposPreenchidos()) {
            try {
                // Obter conexão com o banco de dados
                Connection conn = ConexaoBD.obterConexao();

                // Preparar a consulta SQL para inserir os dados do usuário
                String sql = "INSERT INTO Usuários (nome, email, senha, telefone, cpf, cidade_estado, rua_numero, pais, cep) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                // Setar os valores dos parâmetros da consulta
                stmt.setString(1, textNome.getText());
                stmt.setString(2, textEmail.getText());
                stmt.setString(3, textSenha.getText());
                stmt.setString(4, textTelefone.getText());
                stmt.setString(5, textCPF.getText());
                stmt.setString(6, textCidadeEstado.getText());
                stmt.setString(7, textRuaNumero.getText());
                stmt.setString(8, textPais.getText());
                stmt.setString(9, textCEP.getText());

                // Executar a consulta SQL
                stmt.executeUpdate();

                // Fechar a conexão com o banco de dados
                ConexaoBD.fecharConexao();

                // Exibir mensagem de sucesso
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");

                // Limpar os campos do formulário
                limparCampos();

                // Fechar a janela de cadastro
                dispose();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos do formulário.");
        }
    }

    // Método para limpar os campos do formulário
    private void limparCampos() {
        textNome.setText("");
        textEmail.setText("");
        textSenha.setText("");
        textTelefone.setText("");
        textCPF.setText("");
        textCidadeEstado.setText("");
        textRuaNumero.setText("");
        textPais.setText("");
        textCEP.setText("");
    }

    // Método para verificar se todos os campos foram preenchidos
    private boolean camposPreenchidos() {
        return !textNome.getText().isEmpty() &&
                !textEmail.getText().isEmpty() &&
                !textSenha.getText().isEmpty() &&
                !textTelefone.getText().isEmpty() &&
                !textCPF.getText().isEmpty() &&
                !textCidadeEstado.getText().isEmpty() &&
                !textRuaNumero.getText().isEmpty() &&
                !textPais.getText().isEmpty() &&
                !textCEP.getText().isEmpty();
    }

    // Método para lidar com o evento do botão "Cancelar"
    private void actionButtonCancelar() {
        // Fechar a janela de cadastro
        dispose();
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        new TelaCadastro();
    }
}

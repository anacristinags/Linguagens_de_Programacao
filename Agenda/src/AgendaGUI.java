import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class AgendaGUI extends JFrame {

    //array
    ArrayList<Pessoa> agenda = new ArrayList<>();

    //componentes do painel
    JPanel painel = new JPanel();
    JLabel mensagem = new JLabel("Bem vindo(a) à agenda");
    JButton button1 = new JButton("Cadastrar");
    JButton button2 = new JButton("Listar");
    JButton button3 = new JButton("Remover");

    //Construtor
    public AgendaGUI(){
        //definindo caracteristicas basicas
        this.setTitle("Menu Agenda");
        this.setSize(250,250);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 45,15));

        //adicionando componentes
        this.add(painel);
        painel.add(mensagem);
        painel.add(button1);
        painel.add(button2);
        painel.add(button3);

        //criando listeners para os botoes
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remover();
            }
        });

        //configurando funções basicas do painel
        this.getContentPane().add(painel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void cadastrar(){
        String nome = JOptionPane.showInputDialog(null, "Digite o nome");
        String endereco = JOptionPane.showInputDialog(null, "Digite o endereço");
        String telefone = JOptionPane.showInputDialog(null, "Digite o telefone");

        Pessoa objPessoa = new Pessoa(nome,endereco,telefone);
        agenda.add(objPessoa);
    }

    public void listar(){
        if(!agenda.isEmpty()){
        JOptionPane.showMessageDialog(null,agenda);
        } else JOptionPane.showMessageDialog(null,"A agenda está vazia");

    }

    public void remover(){
        if (!(agenda.isEmpty())) {
            String remover = JOptionPane.showInputDialog(null, "Digite o número da pessoa" +
                    "que você deseja excluir");
            for (Pessoa p1 : agenda) {
                if (p1.getTelefone().equals(remover)) {
                    agenda.remove(p1);
                    JOptionPane.showMessageDialog(null, "Contato Excluido");
                } else {
                    JOptionPane.showMessageDialog(null, "O número digitado está incorreto",
                            "Entrada Inválida", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else JOptionPane.showMessageDialog(null, "Não há contatos para excluir");
    }


    public static void main(String[] args) {
        new AgendaGUI();
    }
}

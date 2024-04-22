import javax.swing.*;

public class Pessoa{
    String nome, endereco, telefone;

    //construtor
    public Pessoa(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    /*construtor GUI
    public Pessoa (JTextField nome, JTextField endereco, JTextField telefone){
        this.nome = String.valueOf(nome); //convertendo o textField para uma String
        this.endereco = String.valueOf(endereco);
        this.telefone = String.valueOf(telefone);
    } */

    //get
    public String getNome() {return nome;}

    public String getEndereco() {return endereco;}

    public String getTelefone() {return telefone;}

    //set
    public void setNome(String nome) {this.nome = nome;}

    public void setEndereco(String endereco) {this.endereco = endereco;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    //toString
    @Override
    public String toString() {
        return "\nNome: " + nome + ", endereco: " + endereco + ", telefone: " + telefone;}


}

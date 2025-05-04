import java.io.*;
import java.util.Scanner;

public class Usuario extends Pessoa {
    private static int contador;
    private int matricula;
    private int userId;

    public Usuario(){
        this.userId = gerarUserId();
    }

    public static void setContador(int contador) {
        Usuario.contador = contador + 1;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int gerarUserId(){
        return contador++;
    }

    public int getUserId() {
        return userId;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public void registrarPessoa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nÁrea de Cadastro de Usuário!\n");
        System.out.println("Preencha todos os campos para cadastrar um usuário:\n");

        System.out.println("Informe o nome do Usuário: ");
        String nome = sc.nextLine();

        System.out.println("\nInforme o CPF do Usuário: ");
        String cpf = sc.nextLine();

        System.out.println("\nInforme a matrícula do Usuário: ");
        int matricula = sc.nextInt();

        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;



        System.out.println("Usuario ID#" + this.getUserId() + " " + this.getNome() + " cadastrado e armazenado com sucesso!");
    }

    public void atualizarDados(String novoNome, int novaMatricula) {
        this.nome = novoNome;
        this.matricula = novaMatricula;
        System.out.println("Dados atualizados: Nome - " + novoNome + ", Matrícula - " + novaMatricula);
    }

    // metodo toString para exibir as informações do usuário
    public String toString() {
        return "ID: " + this.userId + ", Nome: " + this.nome + ", CPF: " + this.cpf + ", Matrícula: " + this.matricula;
    }
}
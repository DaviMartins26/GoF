import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa implements Serializable {
    private static final long serialVersionUID = -3678431921001929337L;
    protected int registro;
    private static int contador;
    private int funId;

    Funcionario(){
    this.funId = gerarFunId();
    }

    public static void setContador(int contador) {
        Funcionario.contador = contador + 1;
    }

    public void setFunId(int id) {
        this.funId = id;
    }

    public int gerarFunId(){
        return contador++;
    }

    public int getFunId() {
        return funId;
    }

    void modificarUsuario(Usuario u, String novoNome, int novaMatricula){

        System.out.println("Voce nao tem permissao para essa acao!");

    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }


    @Override
    public void registrarPessoa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nÁrea de Cadastro de Funcionario!\n");
        System.out.println("Preencha todos os campos para cadastrar um Funcionario:\n");

        System.out.println("Informe o nome do Funcionario: ");
        String nome = sc.nextLine();

        System.out.println("\nInforme o CPF do Funcionario: ");
        String cpf = sc.nextLine();

        System.out.println("\nInforme o registro do Funcionario: ");
        int registro = sc.nextInt();

        this.nome = nome;
        this.cpf = cpf;
        this.registro = registro;



        System.out.println("Funcionario Registro#" + this.getRegistro() + " " + this.getNome() + " cadastrado e armazenado com sucesso!");
    }

}

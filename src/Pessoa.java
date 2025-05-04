import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    protected String cpf;
    protected String nome;

    public Pessoa(){
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public abstract void registrarPessoa();

}
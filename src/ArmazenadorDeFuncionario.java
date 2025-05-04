import java.io.*;
import java.util.ArrayList;

public class ArmazenadorDeFuncionario {
    protected ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public int retornarRegistroTxt() {
        int c = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getFunId() > c) {
                c = funcionario.getFunId();
            }
        }
        return c;
    }

    public void armazenarFun(Funcionario u) {
        funcionarios.add(u);
    }

    public Funcionario selecionarFun(int id) {
        for (Funcionario u : funcionarios) {
            if (u.getFunId() == id) {
                return u;
            }
        }
        System.out.println("ID inválido ou não encontrado");
        return null;
    }

    public void salvarEmArquivo() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("Funcionario.txt");
             ObjectOutputStream os = new ObjectOutputStream(fos)) {

            for (Funcionario funcionario : funcionarios) {
                os.writeObject(funcionario);
            }
        }
    }

    public void armazenarArrayList(ArrayList<Funcionario> ar) {
        this.funcionarios = ar;
    }

    public static ArrayList<Funcionario> carregarDoArquivo() throws IOException {
        ArrayList<Funcionario> f = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("Funcionario.txt");
             ObjectInputStream is = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Funcionario funcionario = (Funcionario) is.readObject();
                    f.add(funcionario);
                } catch (EOFException e) {
                    // Fim do arquivo atingido, sair do loop
                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Erro ao carregar dados: " + e.getMessage());
                    break;
                }
            }
        }
        return f;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}

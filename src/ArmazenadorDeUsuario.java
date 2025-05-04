import java.io.*;
import java.util.ArrayList;

public class ArmazenadorDeUsuario {
    private ArrayList<Usuario> users =  new ArrayList<>();

    public int retornarIdTxt(){
        int c = 0;

        for (Usuario user : users) {
            if (user.getUserId() > c) {
                c = user.getUserId();
            }
        }
        return c;
    }

    public void armazenarUser(Usuario u){
        users.add(u);
    }


    public Usuario selecionarUsuario(int id){
        for (Usuario u : users) {
            if (u.getUserId() == id) {
                return u;
            }
        }
        System.out.println("ID inválido ou não encontrado");
        return null;
    }

    public void salvarEmArquivo() {
        try (FileWriter writer = new FileWriter("usuario.txt")) { // true para acrescentar ao final
            for (Usuario u : users) {
                writer.write("ID:" + u.getUserId() + ", Nome:" + u.getNome() + ", CPF:" + u.getCpf() + ", Matricula:" + u.getMatricula() + "\n");
            }
            System.out.println("Todos os itens foram salvos com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os itens no arquivo: " + e.getMessage());
        }
    }



    public void armazenarArrayList(ArrayList<Usuario> ar){
        this.users = ar;
    }

    public static ArrayList<Usuario> carregarDoArquivo() {
        ArrayList<Usuario> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("ID:")) { // Verifica se é uma linha de dados
                    String[] partes = linha.split(", ");
                    int id = Integer.parseInt(partes[0].split(":")[1]);
                    String nome = partes[1].split(":")[1];
                    String cpf = partes[2].split(":")[1];
                    int matricula = Integer.parseInt(partes[3].split(":")[1]);

                    Usuario u = new Usuario();
                    u.setUserId(id);
                    u.setNome(nome);
                    u.setCpf(cpf);
                    u.setMatricula(matricula);

                    users.add(u);

                }
            }
            System.out.println("//Usuarios carregados do arquivo com sucesso!\n");
        } catch (IOException e) {
            System.out.println("Erro ao carregar itens do arquivo: " + e.getMessage());
        }
        return users;
    }
    public ArrayList<Usuario> getUsuarios() {
        return users;
    }
}

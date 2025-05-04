public class Admin extends Funcionario {
    private static final long serialVersionUID = 1768499302012145581L;


    public Admin(){
    }


    public void modificarUsuario(Usuario usuario, String novoNome, int novaMatricula) {
        usuario.atualizarDados(novoNome, novaMatricula);
        System.out.println("Credenciais do usuário atualizadas com sucesso.");
    }
}

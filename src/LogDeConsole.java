public class LogDeConsole implements ObservadorDeItem {
    public void atualizar(String acao, Item item) {
        System.out.println("[LOG] " + acao + ": " + item);
    }
}

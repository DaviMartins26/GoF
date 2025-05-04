import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEmArquivo implements ObservadorDeItem {

    @Override
    public void atualizar(String acao, Item item) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String log = String.format("[%s] %s: %s\n",
                agora.format(formatador), acao, item.toString());

            writer.write(log);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no log: " + e.getMessage());
        }
    }
}

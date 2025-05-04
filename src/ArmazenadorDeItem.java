// ArmazenadorDeItem.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArmazenadorDeItem {
    // 1) Instância única do Singleton
    private static ArmazenadorDeItem instancia;

    // 2) Lista interna de itens
    private ArrayList<Item> itens;

    // 3) Construtor privado para impedir new externo
    private ArmazenadorDeItem() {
        this.itens = new ArrayList<>();
    }

    // 4) Ponto de acesso global à instância única
    public static synchronized ArmazenadorDeItem getInstancia() {
        if (instancia == null) {
            instancia = new ArmazenadorDeItem();
            // Carregar do arquivo assim que a instância for criada
            instancia.armazenarArrayList(carregarDoArquivo());
        }
        return instancia;
    }

    /*** Métodos de instância ***/

    // Adiciona um item à lista em memória
    public void armazenarItem(Item i) {
        itens.add(i);
    }

    // Remove um item pelo ID; retorna true se removido
    public boolean retirarItem(int id) {
        for (Item it : itens) {
            if (it.getIdItem() == id) {
                itens.remove(it);
                return true;
            }
        }
        return false;
    }

    // Busca um item pelo ID; retorna null se não encontrar
    public Item selecionarItem(int id) {
        for (Item it : itens) {
            if (it.getIdItem() == id) {
                return it;
            }
        }
        return null;
    }

    // Salva todos os itens no arquivo texto
    public void salvarEmArquivo() {
        try (FileWriter writer = new FileWriter("itens.txt")) {
            for (Item i : itens) {
                writer.write(
                    "ID:" + i.getIdItem() +
                    ", Nome:" + i.getNomeItem() +
                    ", Categoria:" + i.getCategoria() +
                    ", Descricao:" + i.getDecricao() +
                    "\n"
                );
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os itens no arquivo: " + e.getMessage());
        }
    }

    // Substitui a lista interna pela fornecida
    public void armazenarArrayList(ArrayList<Item> lista) {
        this.itens = lista;
    }

    // Retorna a lista atual de itens em memória
    public ArrayList<Item> getItens() {
        return itens;
    }

    // Retorna o maior ID presente, para controle de contador
    public int RetornarIdTxt() {
        int max = 0;
        for (Item it : itens) {
            if (it.getIdItem() > max) {
                max = it.getIdItem();
            }
        }
        return max;
    }

    /*** Método estático para carregar itens sem instanciar o Singleton ***/
    public static ArrayList<Item> carregarDoArquivo() {
        ArrayList<Item> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("itens.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Exemplo de linha: "ID:6, Nome:teste, Categoria:tset, Descricao:teste"
                String[] campos = linha.split(", ");
                int id       = Integer.parseInt(campos[0].split(":")[1]);
                String nome  = campos[1].split(":")[1];
                String cat   = campos[2].split(":")[1];
                String desc  = campos[3].split(":")[1];

                Item i = new Item();
                i.setIdItem(id);
                i.setNomeItem(nome);
                i.setCategoria(cat);
                i.setDecricao(desc);
                lista.add(i);
            }
        } catch (IOException e) {
            // Se o arquivo não existir ou ocorrer erro, retorna lista vazia
            System.out.println("Aviso: não foi possível ler itens.txt (" + e.getMessage() + ")");
        }
        return lista;
    }
}

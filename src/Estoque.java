import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Estoque {
    private int bloco;
    private ArrayList<Item> itens =  new ArrayList<>();

    public Estoque(int bloco) {
        this.bloco = bloco;
    }

    public int getBloco() {
        return bloco;
    }

    public int RetornarIdTxt(){
        int c = 0;

        for (Item item : itens) {
            if (item.getIdItem() > c) {
                c = item.getIdItem();
            }
        }
        return c;
    }

    public void armazenarItem(Item i){
        itens.add(i);
    }

    public boolean retirarItem(int id){

        for (Item item : itens) {
            if (item.getIdItem() == id) {
                itens.remove(item);
                return true;
            }
        }
        System.out.println("ID inválido ou não encontrado");
        return false;
    }

    public Item selecionarItem(int id){
        for (Item item : itens) {
            if (item.getIdItem() == id) {
                return item;
            }
        }
        System.out.println("ID inválido ou não encontrado");
        return null;
    }

    public void salvarEmArquivo() {
        try (FileWriter writer = new FileWriter("estoque.txt")) { // true para acrescentar ao final
            for (Item i : itens) {
                writer.write("ID:" + i.getIdItem() + ", Nome:" + i.getNomeItem() + ", Categoria:" + i.getCategoria() + ", Descricao:" + i.getDecricao() + "\n");
            }
            System.out.println("Todos os itens foram salvos com sucesso no arquivo!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os itens no arquivo: " + e.getMessage());
        }
    }



    public void armazenarArrayList(ArrayList<Item> ar){
        this.itens = ar;
    }

    public static ArrayList<Item> carregarDoArquivo() {
        ArrayList<Item> itens = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("estoque.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("ID:")) { // Verifica se é uma linha de dados
                    String[] partes = linha.split(", ");
                    int id = Integer.parseInt(partes[0].split(":")[1]);
                    String nome = partes[1].split(":")[1];
                    String categoria = partes[2].split(":")[1];
                    String descricao = partes[3].split(":")[1];
                    Item i = new Item();
                    i.setNomeItem(nome);
                    i.setCategoria(categoria);
                    i.setDecricao(descricao);
                    i.setIdItem(id);
                    itens.add(i);

                }
            }
            System.out.println("//Estoque carregado do arquivo com sucesso!\n");
        } catch (IOException e) {
            System.out.println("Erro ao carregar itens do arquivo: " + e.getMessage());
        }
        return itens;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }
}

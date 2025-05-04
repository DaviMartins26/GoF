import java.util.Scanner;

public class Item {
    // Contador estático: compartilhado por todas as instâncias
    private static int contador = 1;

    // Atributos de instância
    private int idItem;
    private String nomeItem;
    private String categoria;
    private String descricao;

    // Construtor padrão: atribui ID único
    public Item() {
        this.idItem = contador++;
    }

    // Getter do ID
    public int getIdItem() {
        return idItem;
    }

    // Setter do ID (usado ao carregar de arquivo)
    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    // Getter/Setter de nome
    public String getNomeItem() {
        return nomeItem;
    }
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    // Getter/Setter de categoria
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Getter/Setter de descrição
    public String getDecricao() {
        return descricao;
    }
    public void setDecricao(String descricao) {
        this.descricao = descricao;
    }

    // Método de instância para popular via console
    public void gerarItem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome do item: ");
        this.nomeItem = sc.nextLine();
        System.out.print("Categoria do item: ");
        this.categoria = sc.nextLine();
        System.out.print("Descrição do item: ");
        this.descricao = sc.nextLine();
    }

    // Métodos estáticos para controle do contador global

    /**
     * Ajusta o contador interno para (c + 1), evitando colisão de IDs.
     * Deve ser chamado antes de criar novos itens, usando o maior ID já existente.
     */
    public static void setContador(int c) {
        contador = c + 1;
    }

    /**
     * Retorna o valor atual do contador (próximo ID que será atribuído).
     */
    public static int getContador() {
        return contador;
    }

    @Override
    public String toString() {
        return "Item{id=" + idItem +
               ", nome='" + nomeItem + '\'' +
               ", categoria='" + categoria + '\'' +
               ", descricao='" + descricao + '\'' +
               '}';
    }
}

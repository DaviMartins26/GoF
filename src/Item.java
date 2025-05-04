public class Item {
    private static int contador = 1; // usado para gerar ID único
    private int idItem;
    private String nomeItem;
    private String categoria;
    private String descricao;

    // Construtor padrão
    public Item() {
        this.idItem = contador++;
    }

    // Getters e Setters
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDecricao() {
        return descricao;
    }

    public void setDecricao(String descricao) {
        this.descricao = descricao;
    }

    // Método para gerar novo item via console
    public void gerarItem() {
        try {
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.print("Nome do item: ");
            this.nomeItem = sc.nextLine();
            System.out.print("Categoria do item: ");
            this.categoria = sc.nextLine();
            System.out.print("Descrição do item: ");
            this.descricao = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao gerar item: " + e.getMessage());
        }
    }

    // Controle do contador global (usado ao carregar do arquivo)
    public void setContador(int c) {
        contador = c + 1; // evitar sobrescrever o último ID usado
    }

    public int getContador() {
        return contador;
    }
}

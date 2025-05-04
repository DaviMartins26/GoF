public class ItemFactory {

    // Instância única (Singleton)
    private static ItemFactory instance;

    // Construtor privado
    private ItemFactory() {
    }

    // Método para obter a instância única
    public static ItemFactory getInstance() {
        if (instance == null) {
            instance = new ItemFactory();
        }
        return instance;
    }

    // Método para criar item com entrada via console
    public Item criarItemViaConsole() {
        Item item = new Item();
        item.gerarItem(); // Lê nome, categoria, descrição
        return item;
    }

    // Método para sincronizar o contador global de IDs
    public void sincronizarContadorGlobal(int idPerdido, int idEstoque) {
        int maior = Math.max(idPerdido, idEstoque);
        Item.setContador(maior);
    }
}

public class BuscadorDeItem {
    private final BuscaStrategy estrategia;

    public BuscadorDeItem(BuscaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public Item buscar(String termo) {
        // Usa o ArrayList interno para procurar
        for (Item item : ArmazenadorDeItem.getInstancia().getItens()) {
            if (estrategia.comparar(item, termo)) {
                return item;
            }
        }
        return null;
    }
}

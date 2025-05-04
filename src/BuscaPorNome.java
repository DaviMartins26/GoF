public class BuscaPorNome implements BuscaStrategy {
    public boolean comparar(Item item, String termo) {
        return item.getNomeItem().equalsIgnoreCase(termo);
    }
}

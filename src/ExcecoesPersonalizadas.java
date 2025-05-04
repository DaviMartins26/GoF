public class ExcecoesPersonalizadas extends Exception {
    public ExcecoesPersonalizadas(String mensagem) {
        super(mensagem);
    }
}
class ExcecaoNoId extends ExcecoesPersonalizadas{
    public ExcecaoNoId(String mensagem){
        super("Erro de validação no Id:" + mensagem);
    }
}
class ExcecaoValidacao extends ExcecoesPersonalizadas{
    public ExcecaoValidacao(String mensagem){
        super("Erro de validação de Pessoa:" + mensagem);
    }
}
class ExcecaoAutorizacao extends ExcecoesPersonalizadas{
    public ExcecaoAutorizacao(String mensagem){
        super("Erro de validação de Autorização:" + mensagem);
    }
}
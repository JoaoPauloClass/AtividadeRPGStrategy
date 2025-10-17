public interface IArma {
    String getNome();
    int getDanoBase();
    int getCustoMana();
    TipoAtributo getAtributoRequerido();
    int getValorRequerido();
    ResultadoAtaque atacar(Personagem atacante, Personagem alvo);
}
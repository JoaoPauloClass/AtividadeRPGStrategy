class CajadoArcano implements IArma {
    @Override
    public String getNome() { return "Cajado Arcano"; }
    
    @Override
    public int getDanoBase() { return 8; }
    
    @Override
    public int getCustoMana() { return 25; }
    
    @Override
    public TipoAtributo getAtributoRequerido() { return TipoAtributo.INTELIGENCIA; }
    
    @Override
    public int getValorRequerido() { return 12; }
    
    @Override
    public ResultadoAtaque atacar(Personagem atacante, Personagem alvo) {
        int dano = getDanoBase();
        String msg = atacante.getNome() + " conjura BOLA DE FOGO com " + getNome() + "!";
        
        StatusEffect efeito = new StatusEffect(TipoEfeito.QUEIMADURA, 10, 2);
        
        ResultadoAtaque resultado = new ResultadoAtaque(dano, true, msg);
        resultado.setEfeitoAplicado(efeito);
        return resultado;
    }
}
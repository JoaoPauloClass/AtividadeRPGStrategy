class ArcoElfico implements IArma {
    @Override
    public String getNome() { return "Arco Élfico"; }
    
    @Override
    public int getDanoBase() { return 12; }
    
    @Override
    public int getCustoMana() { return 15; }
    
    @Override
    public TipoAtributo getAtributoRequerido() { return TipoAtributo.DESTREZA; }
    
    @Override
    public int getValorRequerido() { return 8; }
    
    @Override
    public ResultadoAtaque atacar(Personagem atacante, Personagem alvo) {
        int dano = getDanoBase();
        String msg = atacante.getNome() + " lança CHUVA DE FLECHAS com " + getNome() + "!";
        
        return new ResultadoAtaque(dano, true, msg);
    }
}
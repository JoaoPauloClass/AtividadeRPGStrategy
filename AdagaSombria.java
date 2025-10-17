public class AdagaSombria implements IArma {
    @Override
    public String getNome() { return "Adaga Sombria"; }
    
    @Override
    public int getDanoBase() { return 10; }
    
    @Override
    public int getCustoMana() { return 10; }
    
    @Override
    public TipoAtributo getAtributoRequerido() { return TipoAtributo.DESTREZA; }
    
    @Override
    public int getValorRequerido() { return 12; }
    
    @Override
    public ResultadoAtaque atacar(Personagem atacante, Personagem alvo) {
        int dano = getDanoBase();
        String msg = atacante.getNome() + " ataca com " + getNome();
        
        // Verifica se o alvo está desprevenido (primeira rodada ou atordoado)
        if (alvo.estaDesprevenido()) {
            dano *= 3;
            msg += " com ATAQUE FURTIVO (CRÍTICO x3)!";
        }
        
        ResultadoAtaque resultado = new ResultadoAtaque(dano, true, msg);
        return resultado;
    }
}
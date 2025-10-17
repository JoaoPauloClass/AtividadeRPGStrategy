import java.util.Random;

public class EspadaLonga implements IArma {
    private static final Random random = new Random();
    
    @Override
    public String getNome() { return "Espada Longa"; }
    
    @Override
    public int getDanoBase() { return 15; }
    
    @Override
    public int getCustoMana() { return 0; }
    
    @Override
    public TipoAtributo getAtributoRequerido() { return TipoAtributo.FORÇA; }
    
    @Override
    public int getValorRequerido() { return 10; }
    
    @Override
    public ResultadoAtaque atacar(Personagem atacante, Personagem alvo) {
        int dano = getDanoBase();
        String msg = atacante.getNome() + " ataca com " + getNome();
        
        // Chance de 30% de causar sangramento
        StatusEffect efeito = null;
        if (random.nextInt(100) < 30) {
            efeito = new StatusEffect(TipoEfeito.SANGRAMENTO, 5, 3);
            msg += " causando CORTE PROFUNDO!";
        }
        
        ResultadoAtaque resultado = new ResultadoAtaque(dano, true, msg);
        resultado.setEfeitoAplicado(efeito);
        return resultado;
    }
}
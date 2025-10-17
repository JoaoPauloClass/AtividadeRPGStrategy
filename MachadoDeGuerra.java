import java.util.Random;

public class MachadoDeGuerra implements IArma {
    private static final Random random = new Random();
    
    @Override
    public String getNome() { return "Machado de Guerra"; }
    
    @Override
    public int getDanoBase() { return 18; }
    
    @Override
    public int getCustoMana() { return 5; }
    
    @Override
    public TipoAtributo getAtributoRequerido() { return TipoAtributo.FORÇA; }
    
    @Override
    public int getValorRequerido() { return 15; }
    
    @Override
    public ResultadoAtaque atacar(Personagem atacante, Personagem alvo) {
        int dano = getDanoBase();
        String msg = atacante.getNome() + " desfere GOLPE ESMAGADOR com " + getNome();
        
        StatusEffect efeito = null;
        if (random.nextInt(100) < 25) {
            efeito = new StatusEffect(TipoEfeito.ATORDOADO, 0, 1);
            msg += " ATORDOANDO o inimigo!";
        }
        
        ResultadoAtaque resultado = new ResultadoAtaque(dano, true, msg);
        resultado.setEfeitoAplicado(efeito);
        return resultado;
    }
}
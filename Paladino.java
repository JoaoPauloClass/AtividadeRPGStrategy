import java.util.Random;

class Paladino extends Personagem {
    private static final Random random = new Random();
    
    public Paladino(String nome) {
        super(nome, 12, 8, 10, 100, 100);
    }
    
    @Override
    public String getClasse() { return "Paladino"; }
    
    @Override
    public boolean podeUsarArma(IArma arma) {
        return arma instanceof EspadaLonga || arma instanceof MachadoDeGuerra || 
               arma instanceof CajadoArcano;
    }
    
    @Override
    protected int calcularReducaoDano(int dano) {
        return (int)(dano * 0.85);
    }
    
    @Override
    protected boolean tentarEsquiva() {
        return random.nextInt(100) < 10;
    }
    
    @Override
    public void iniciarTurno() {
        vidaAtual = Math.min(vidaMaxima, vidaAtual + 5);
    }
}
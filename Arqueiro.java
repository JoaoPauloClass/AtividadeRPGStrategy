import java.util.Random;

class Arqueiro extends Personagem {
    private static final Random random = new Random();
    
    public Arqueiro(String nome) {
        super(nome, 8, 15, 7, 90, 80);
    }
    
    @Override
    public String getClasse() { return "Arqueiro"; }
    
    @Override
    public boolean podeUsarArma(IArma arma) {
        return arma instanceof ArcoElfico || arma instanceof AdagaSombria;
    }
    
    @Override
    protected int calcularReducaoDano(int dano) {
        return dano;
    }
    
    @Override
    protected boolean tentarEsquiva() {
        // Esquiva: 25% de chance
        return random.nextInt(100) < 25;
    }
}
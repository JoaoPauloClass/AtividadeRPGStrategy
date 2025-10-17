class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 5, 7, 18, 70, 150);
    }
    
    @Override
    public String getClasse() { return "Mago"; }
    
    @Override
    public boolean podeUsarArma(IArma arma) {
        return arma instanceof CajadoArcano || arma instanceof AdagaSombria;
    }
    
    @Override
    protected int calcularReducaoDano(int dano) {
        return dano;
    }
    
    @Override
    protected boolean tentarEsquiva() {
        return false;
    }
    
    @Override
    public void iniciarTurno() {
        manaAtual = Math.min(manaMaxima, manaAtual + 10);
    }
}
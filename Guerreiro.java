class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 15, 8, 5, 120, 50);
    }
    
    @Override
    public String getClasse() { return "Guerreiro"; }
    
    @Override
    public boolean podeUsarArma(IArma arma) {
        return arma instanceof EspadaLonga || arma instanceof MachadoDeGuerra;
    }
    
    @Override
    protected int calcularReducaoDano(int dano) {
        // Pele Dura: Reduz 20% do dano
        return (int)(dano * 0.8);
    }
    
    @Override
    protected boolean tentarEsquiva() {
        return false;
    }
}
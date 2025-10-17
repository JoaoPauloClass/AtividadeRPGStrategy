public class StatusEffect {
    private TipoEfeito tipo;
    private int dano;
    private int turnosRestantes;
    
    public StatusEffect(TipoEfeito tipo, int dano, int turnos) {
        this.tipo = tipo;
        this.dano = dano;
        this.turnosRestantes = turnos;
    }
    
    public void aplicarEfeito(Personagem personagem) {
        if (turnosRestantes > 0) {
            personagem.receberDano(dano);
            turnosRestantes--;
            System.out.println("  → " + personagem.getNome() + " sofre " + dano + 
                             " de dano por " + tipo + " (" + turnosRestantes + " turnos restantes)");
        }
    }
    
    public boolean isAtivo() {
        return turnosRestantes > 0;
    }
    
    public TipoEfeito getTipo() {
        return tipo;
    }
}

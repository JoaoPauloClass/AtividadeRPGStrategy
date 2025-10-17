public class Main {
    public static void main(String[] args) {
        // Criar personagens
        Guerreiro guerreiro = new Guerreiro("Thorin");
        Mago mago = new Mago("Gandalf");
        
        // Criar armas
        EspadaLonga espada = new EspadaLonga();
        MachadoDeGuerra machado = new MachadoDeGuerra();
        CajadoArcano cajado = new CajadoArcano();
        AdagaSombria adaga = new AdagaSombria();
        
        // Equipar personagens
        guerreiro.adicionarArma(espada);
        guerreiro.adicionarArma(machado);
        guerreiro.equiparArma(espada);
        
        mago.adicionarArma(cajado);
        mago.adicionarArma(adaga);
        mago.equiparArma(cajado);
        
        // Iniciar primeira batalha
        Batalha batalha = new Batalha(guerreiro, mago);
        batalha.iniciar();
        

        System.out.println("\n\n═══ DEMONSTRAÇÃO: PALADINO ═══");
        Paladino paladino = new Paladino("Arthur");
        Arqueiro arqueiro = new Arqueiro("Legolas");
        
        paladino.adicionarArma(espada);
        paladino.equiparArma(espada);
        
        ArcoElfico arco = new ArcoElfico();
        arqueiro.adicionarArma(arco);
        arqueiro.adicionarArma(adaga);
        arqueiro.equiparArma(arco);
        
        // Iniciar a segunda batalha
        Batalha batalha2 = new Batalha(paladino, arqueiro);
        batalha2.iniciar();
    }
}
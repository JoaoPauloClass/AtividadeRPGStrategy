import java.util.List;
import java.util.Scanner;

class Batalha {
    private Personagem jogador1;
    private Personagem jogador2;
    private int turno;
    private Scanner scanner;
    
    public Batalha(Personagem p1, Personagem p2) {
        this.jogador1 = p1;
        this.jogador2 = p2;
        this.turno = 1;
        this.scanner = new Scanner(System.in);
    }
    
    public void iniciar() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   BATALHA INICIADA!                    ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println(jogador1.getNome() + " vs " + jogador2.getNome());
        
        while (jogador1.estaVivo() && jogador2.estaVivo()) {
            executarTurno();
        }
        
        exibirVencedor();
    }
    
    private void executarTurno() {
        System.out.println("\n═══════════════ TURNO " + turno + " ═══════════════");
        
        // Turno do Jogador 1
        if (jogador1.estaVivo()) {
            executarAcaoJogador(jogador1, jogador2);
        }
        
        // Turno do Jogador 2
        if (jogador2.estaVivo() && jogador1.estaVivo()) {
            executarAcaoJogador(jogador2, jogador1);
        }
        
        turno++;
    }
    
    private void executarAcaoJogador(Personagem atacante, Personagem defensor) {
        System.out.println("\n--- Turno de " + atacante.getNome() + " ---");
        
        atacante.iniciarTurno();
        atacante.processarEfeitos();
        
        if (!atacante.estaVivo()) {
            return;
        }
        
        atacante.exibirStatus();
        
        System.out.println("\nEscolha uma ação:");
        System.out.println("1. Atacar");
        System.out.println("2. Trocar arma");
        
        int escolha = scanner.nextInt();
        
        if (escolha == 2) {
            trocarArma(atacante);
        }
        
        ResultadoAtaque resultado = atacante.atacar(defensor);
        defensor.receberAtaque(resultado);
    }
    
    private void trocarArma(Personagem personagem) {
        List<IArma> armas = personagem.getArmasDisponiveis();
        
        if (armas.isEmpty()) {
            System.out.println("Nenhuma arma disponível!");
            return;
        }
        
        System.out.println("\nArmas disponíveis:");
        for (int i = 0; i < armas.size(); i++) {
            IArma arma = armas.get(i);
            System.out.println((i + 1) + ". " + arma.getNome() + 
                             " (Dano: " + arma.getDanoBase() + 
                             ", Mana: " + arma.getCustoMana() + ")");
        }
        
        System.out.print("Escolha a arma: ");
        int escolha = scanner.nextInt() - 1;
        
        if (escolha >= 0 && escolha < armas.size()) {
            personagem.equiparArma(armas.get(escolha));
        }
    }
    
    private void exibirVencedor() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   FIM DA BATALHA!                      ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        if (jogador1.estaVivo()) {
            System.out.println("\n🏆 " + jogador1.getNome() + " VENCEU! 🏆");
            jogador1.exibirStatus();
        } else {
            System.out.println("\n🏆 " + jogador2.getNome() + " VENCEU! 🏆");
            jogador2.exibirStatus();
        }
        
        System.out.println("\nTotal de turnos: " + (turno - 1));
    }
}
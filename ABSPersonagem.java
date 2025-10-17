import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

abstract class Personagem {
    protected String nome;
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int manaMaxima;
    protected int manaAtual;
    protected IArma armaEquipada;
    protected List<IArma> armasDisponiveis;
    protected List<StatusEffect> efeitosAtivos;
    protected boolean desprevenido;
    private static final Random random = new Random();
    
    public Personagem(String nome, int forca, int destreza, int inteligencia, 
                     int vida, int mana) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.manaMaxima = mana;
        this.manaAtual = mana;
        this.armasDisponiveis = new ArrayList<>();
        this.efeitosAtivos = new ArrayList<>();
        this.desprevenido = true; // Começa desprevenido
    }
    
    public abstract String getClasse();
    public abstract boolean podeUsarArma(IArma arma);
    protected abstract int calcularReducaoDano(int dano);
    protected abstract boolean tentarEsquiva();
    
    public void equiparArma(IArma arma) {
        if (!podeUsarArma(arma)) {
            System.out.println(nome + " não pode usar " + arma.getNome());
            return;
        }
        
        int atributo = getAtributo(arma.getAtributoRequerido());
        if (atributo < arma.getValorRequerido()) {
            System.out.println(nome + " não tem " + arma.getAtributoRequerido() + 
                             " suficiente para usar " + arma.getNome());
            return;
        }
        
        this.armaEquipada = arma;
        System.out.println(nome + " equipou " + arma.getNome());
    }
    
    public void adicionarArma(IArma arma) {
        armasDisponiveis.add(arma);
    }
    
    public ResultadoAtaque atacar(Personagem alvo) {
        if (armaEquipada == null) {
            return new ResultadoAtaque(0, false, nome + " não tem arma equipada!");
        }
        
        if (estaAtordoado()) {
            return new ResultadoAtaque(0, false, nome + " está ATORDOADO e perdeu o turno!");
        }
        
        if (manaAtual < armaEquipada.getCustoMana()) {
            return new ResultadoAtaque(0, false, nome + " não tem mana suficiente!");
        }
        
        manaAtual -= armaEquipada.getCustoMana();
        ResultadoAtaque resultado = armaEquipada.atacar(this, alvo);
        
        // Chance de crítico (15%)
        if (random.nextInt(100) < 15) {
            resultado = new ResultadoAtaque(
                (int)(resultado.getDano() * 1.5), 
                true, 
                resultado.getMensagem() + " [CRÍTICO!]"
            );
            resultado.setCritico(true);
            resultado.setEfeitoAplicado(resultado.getEfeitoAplicado());
        }
        
        desprevenido = false; // Não está mais desprevenido após atacar
        return resultado;
    }
    
    public void receberAtaque(ResultadoAtaque resultado) {
        if (!resultado.isAcertou()) {
            System.out.println(resultado.getMensagem());
            return;
        }
        
        if (tentarEsquiva()) {
            System.out.println(nome + " ESQUIVOU do ataque!");
            return;
        }
        
        System.out.println(resultado.getMensagem());
        
        int danoFinal = calcularReducaoDano(resultado.getDano());
        receberDano(danoFinal);
        
        if (resultado.getEfeitoAplicado() != null) {
            aplicarEfeito(resultado.getEfeitoAplicado());
        }
    }
    
    public void receberDano(int dano) {
        vidaAtual = Math.max(0, vidaAtual - dano);
        System.out.println("  → " + nome + " recebeu " + dano + " de dano! (Vida: " + 
                         vidaAtual + "/" + vidaMaxima + ")");
    }
    
    public void aplicarEfeito(StatusEffect efeito) {
        efeitosAtivos.add(efeito);
        System.out.println("  → " + nome + " foi afetado por " + efeito.getTipo() + "!");
    }
    
    public void processarEfeitos() {
        if (efeitosAtivos.isEmpty()) return;
        
        System.out.println("\n[Efeitos de Status de " + nome + "]");
        efeitosAtivos.forEach(e -> e.aplicarEfeito(this));
        efeitosAtivos.removeIf(e -> !e.isAtivo());
    }
    
    public void iniciarTurno() {
        // Implementado nas subclasses se necessário
    }
    
    private int getAtributo(TipoAtributo tipo) {
        switch (tipo) {
            case FORÇA: return forca;
            case DESTREZA: return destreza;
            case INTELIGENCIA: return inteligencia;
            default: return 0;
        }
    }
    
    public boolean estaAtordoado() {
        return efeitosAtivos.stream()
            .anyMatch(e -> e.getTipo() == TipoEfeito.ATORDOADO && e.isAtivo());
    }
    
    public boolean estaDesprevenido() {
        return desprevenido || estaAtordoado();
    }
    
    public boolean estaVivo() {
        return vidaAtual > 0;
    }
    
    public String getNome() { return nome; }
    public int getVidaAtual() { return vidaAtual; }
    public int getManaAtual() { return manaAtual; }
    public List<IArma> getArmasDisponiveis() { return armasDisponiveis; }
    
    public void exibirStatus() {
        System.out.println("\n[" + nome + " - " + getClasse() + "]");
        System.out.println("Vida: " + vidaAtual + "/" + vidaMaxima);
        System.out.println("Mana: " + manaAtual + "/" + manaMaxima);
        System.out.println("IArma: " + (armaEquipada != null ? armaEquipada.getNome() : "Nenhuma"));
        if (!efeitosAtivos.isEmpty()) {
            System.out.println("Efeitos: " + efeitosAtivos.stream()
                .map(e -> e.getTipo().toString())
                .collect(Collectors.joining(", ")));
        }
    }
}
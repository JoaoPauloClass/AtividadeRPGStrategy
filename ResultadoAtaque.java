public class ResultadoAtaque {
    private int dano;
    private boolean acertou;
    private boolean critico;
    private StatusEffect efeitoAplicado;
    private String mensagem;
    
    public ResultadoAtaque(int dano, boolean acertou, String mensagem) {
        this.dano = dano;
        this.acertou = acertou;
        this.mensagem = mensagem;
        this.critico = false;
    }
    
    public void setEfeitoAplicado(StatusEffect efeito) {
        this.efeitoAplicado = efeito;
    }
    
    public void setCritico(boolean critico) {
        this.critico = critico;
    }
    
    public int getDano() { return dano; }
    public boolean isAcertou() { return acertou; }
    public boolean isCritico() { return critico; }
    public StatusEffect getEfeitoAplicado() { return efeitoAplicado; }
    public String getMensagem() { return mensagem; }
}

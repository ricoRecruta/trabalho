package exercicio.tres.amigo;

public abstract class  Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonimo;

    public Mensagem(String texto, String emailRemetente, boolean anonimo){
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonimo = anonimo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public abstract String getTextoCompletoAExibir();

    public boolean ehAnonima(){
        return this.anonimo;
    }

}

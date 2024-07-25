package exercicio.tres.amigo;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente,String emailDestinatario, boolean anonimo){
        super( texto,  emailRemetente,  anonimo);
        this.emailDestinatario = emailDestinatario;
    }
    public String getEmailDestinatario(){ return this.emailDestinatario; }

    @Override
    public String getTextoCompletoAExibir(){
        if(super.ehAnonima()){
            return "exercicio.tres.amigo.Mensagem para " + this.getEmailDestinatario() + "."+" Texto: "+ super.getTexto();
        }

        return "exercicio.tres.amigo.Mensagem de: "+ super.getEmailRemetente() + " Para " + getEmailDestinatario() + " Texto: "+ super.getTexto();
    }

}

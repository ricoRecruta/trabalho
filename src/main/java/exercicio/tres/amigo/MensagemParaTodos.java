package exercicio.tres.amigo;

public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonimo){
        super(texto, emailRemetente,anonimo);
    }

    @Override
    public String getTextoCompletoAExibir(){

        if(super.ehAnonima()){
            return "exercicio.tres.amigo.Mensagem para todos. Texto: "+ super.getTexto();
        }
        return "exercicio.tres.amigo.Mensagem de "+super.getEmailRemetente() + "para todos. Texto:" + super.getTexto();
    }
}

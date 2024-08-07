package exercicio.tres.amigo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private Map<String,Amigo>amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap(){
        amigos= new HashMap<>();
        mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException{
        if(this.amigos.containsKey(emailAmigo)){
            throw new AmigoJaExisteException("Este amigo já existe com esse email ");
        } else {
            Amigo a = new Amigo(nomeAmigo, emailAmigo);
            amigos.put(emailAmigo,a);
        }

    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        if(this.amigos.containsKey(emailAmigo)){
            return this.amigos.get(emailAmigo);
        } else {
            throw new AmigoInexistenteException("Não existe amigo com esse email ");
        }
    }

    public void enviarMensagemParaTodos(String texto,String emailRemetente, boolean ehAnonima){
        Mensagem mensagem = new MensagemParaTodos(texto,emailRemetente,ehAnonima);
        this.mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto,String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem mensagem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonima);
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m: this.mensagens){
            if(m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){ return this.mensagens;}

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSecreto) throws AmigoInexistenteException{
        if(this.amigos.containsKey(emailDaPessoa)){
            this.amigos.get(emailDaPessoa).setEmailAmigoSorteado(emailAmigoSecreto);

        } else{
            throw new AmigoInexistenteException("Não existe amigo passado com esse email ");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        if(this.amigos.containsKey(emailDaPessoa)){
            Amigo a = this.amigos.get(emailDaPessoa);
            if(a.getEmailAmigoSorteado() != null){
                return a.getEmailAmigoSorteado();
            }else{
                throw new AmigoNaoSorteadoException("Esse amigo ainda não tem um amigo secreto");
            }
        } else {
            throw new AmigoInexistenteException(("Não existe amigo com esse email passado"));
        }
    }
}

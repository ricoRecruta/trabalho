package exercicio.tres.amigo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        mensagens = new LinkedList<>();
        amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo a = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(a);
    }

    public Amigo pesquisaAmigo( String emailAmigo){
        for(Amigo a: this.amigos){
            if(a.getEmailAmigoSorteado().equalsIgnoreCase(emailAmigo)){
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto,String emailRemetente,boolean ehAnonima){
        Mensagem mensagem = new MensagemParaTodos(texto,emailRemetente,ehAnonima);
        this.mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto,String emailRemetente,String emailDestinatario,boolean ehAnonimo){
        Mensagem mensagem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonimo);
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

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{

        int cont = 0;
        for(Amigo a: this.amigos){
            if(a.getEmail().equalsIgnoreCase(emailDaPessoa)){
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                cont++;
            }
        }
        if(cont == 0){
            throw new AmigoInexistenteException("Não existe um amigo com esse email cadastrado");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        int cont = 0;

        for(Amigo a: this.amigos){

            if(a.getEmail().equalsIgnoreCase(emailDaPessoa)){

                if(a.getEmailAmigoSorteado() != null){
                    return a.getEmailAmigoSorteado();
                } else{
                    cont++;

                }
            }
        }
        if(cont == 0){
            throw new AmigoInexistenteException("Não existe um amigo com esse email");
        } else {
            throw new AmigoNaoSorteadoException("Esse amigo ainda não tem um amigo secreto cadastrado");
        }
    }


    // Parte do código a ser alterada
    public void sortear() throws IllegalAccessException {
        //TODO: verifcar se está dando certo.
        if(this.amigos.size() < 2){
            throw new IllegalAccessException("É nescessário pelo menos 2 pessoas para poder realizar o sorteio");
        } else{
            List<Amigo> amigosNãoSorteados = new ArrayList<>(this.amigos);
            List<Amigo> amigosJaSorteados = new ArrayList<>();
            //a

            for(Amigo a: this.amigos){
                Amigo amigoSorteado;
                do{
                amigoSorteado = amigosNãoSorteados.remove((int) (Math.random()*amigosNãoSorteados.size()));
                } while(amigoSorteado.getEmail().equals(a.getEmail()));
                {
                    a.setEmailAmigoSorteado(amigoSorteado.getEmail());
                }

            }
        }
    }


}

package exercicio.tres.amigo;

import java.util.List;

public class MainSistemaAmigo {
    public static void main(String[] args){
        SistemaAmigo sistemaJoao = new SistemaAmigo();
            sistemaJoao.cadastraAmigo("José","josé@email.com");
            sistemaJoao.cadastraAmigo("Maria","maria@email.com");

            try{
                sistemaJoao.configuraAmigoSecretoDe("josé@email.com","maria@email.com");
                sistemaJoao.configuraAmigoSecretoDe("maria@email.com","José@email.com");

            }catch (AmigoInexistenteException a){
                System.out.println(a);

            }

            sistemaJoao.enviarMensagemParaAlguem("exercicio.tres.amigo.Mensagem de Maria","maria@email.com","josé@email.com",true);
            sistemaJoao.enviarMensagemParaTodos("teste teste", "maria@email.com",true);

            List<Mensagem> mensagensAnonimas = sistemaJoao.pesquisaMensagensAnonimas();
            for(Mensagem m: mensagensAnonimas){
                System.out.println(m.getTextoCompletoAExibir());
            }

            try {
                String teste = sistemaJoao.pesquisaAmigoSecretoDe("josé@email.com");
                if(teste.equalsIgnoreCase("maria@email.com")){
                    System.out.println("OK");
                }
            } catch(AmigoInexistenteException a) {
                System.out.println(a);
            } catch(AmigoNaoSorteadoException b){
                System.out.println("não existe amigo sorteado");
            }




    }
}

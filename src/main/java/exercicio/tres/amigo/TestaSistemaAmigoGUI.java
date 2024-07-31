package exercicio.tres.amigo;
import javax.swing.JOptionPane;
public class TestaSistemaAmigoGUI {
  public static void main(String[] args){
      SistemaAmigo sistema = new SistemaAmigo();
      int quant = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de amigos a casastrar"));

      for(int i = 0; i<quant; i++){
          String nome = JOptionPane.showInputDialog("Qual o nome do amigo");
          String email = JOptionPane.showInputDialog("Qual é o seu email? ");
          sistema.cadastraAmigo(nome,email);
      }
      System.out.println("Todos os amigos ja foram criados");

      for(int i = 0; i<quant;i++){
          try{
              String emailP = JOptionPane.showInputDialog("Qual o email da pessoa\n que deseja configurar?");
              String emailA = JOptionPane.showInputDialog("Qual o email do amigo sorteado?");
              sistema.configuraAmigoSecretoDe(emailP,emailA);
          }catch(Exception e){
              System.err.println(e.getMessage());
              e.printStackTrace();
              JOptionPane.showMessageDialog(null,"erro na hora de configurar\n tente novamente passando os parametros corretos\n "+e.getMessage());
          }
      }

      String emailRemetente = JOptionPane.showInputDialog("Qual é o email remetente?");
      boolean ehAnonima = Boolean.parseBoolean(JOptionPane.showInputDialog("Você deseja mandar essa mensagem anonimamente?\n Digite true se sim\n ou false caso não"));
      String texto = JOptionPane.showInputDialog("Qual mensagem deseja mandar?");

      sistema.enviarMensagemParaTodos(texto,emailRemetente,ehAnonima);

      for(Mensagem m: sistema.pesquisaTodasAsMensagens()){
          System.out.println(m.getTextoCompletoAExibir());
      }





  }


}

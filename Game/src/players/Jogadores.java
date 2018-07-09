
package players;

public class Jogadores {
    private String nome;
 
    
    
    public void mostraJogadores(){
        System.out.println("Jogador: "+getNome());
        
    }
    public String getNome(){
      return nome;  
    }
    public void setNome(String nome){
        this.nome=nome;
    
}
}
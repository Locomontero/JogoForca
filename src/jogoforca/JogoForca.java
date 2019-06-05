
package jogoforca;
import java.util.Scanner;
import java.util.Random;

public class JogoForca {

    
    public static void main(String[] args) {
        Scanner sd=new Scanner(System.in);
        System.out.println("JOGO DA FORCA");
        //LISTA DE PALAVRAS
        String palavra[]={"AMIGO","ORTODOXO","MITOCONDRIA","MACARRONADA","APOCALIPSE","ABOBORA","PAI",
            "PAPAGAIO","PLUMA","ABACAXI","PETROLEO","CALABOUCO","PROFESSOR","INDICE","AUMENTO","CORCOVADO",
            "PARALELO","BABACA","TROVAO"};
        //QTD DE PALAVRAS
        int quantPalavras= palavra.length; //PEGA O TAM DO VETOR!
        Random random=new Random();
        int indiceSorteado= random.nextInt(quantPalavras);//POSICAO DO VETOR DA PALAVRA SORTEADA
        String sorteada =palavra[indiceSorteado];//PALAVRA SORTEADA
    
        /*CONTROLA OS ACERTOS DO USUÀRIO
        A M I G O
        0 1 2 3 4 ->POSICAO
        0 0 0 0 0 ->ACERTOS
        0 0 1 0 0 -> ACERTOU A LETRA I
        */
        char[] acertos=new char[sorteada.length()];
        for (int i = 0; i < acertos.length; i++) {
            acertos[i]=0;     
        }
        String letrasUtilizadas="";//SAIDA DE DADOS
        
        char letra;
        boolean ganhou=false;
        int vidas = sorteada.length();//TAM DA PALAVRA SORTEADA
        
        for (int i = 0; i < sorteada.length(); i++) {
            System.out.print(" _ ");//DICA DA PALAVRA POR QTD DE UNDERLINES
        }
        
        do{     //ENTRA NO JOGO!!!
            System.out.print("\n"
            + "Vc tem " + vidas +" vidas "+
            "\nLetras ultilizadas:" + letrasUtilizadas+ 
            "\nQue letra deseja tentar? ");
            
        letra= sd.next().toUpperCase().charAt(0); //USA O SCANNER PRA LER (COLOCAR EM CAIXA ALTA)-charAT PEGAR A PRIMEIRA LETRA.
        letrasUtilizadas +=" "+letra; //CONCATENAR
        
        boolean perdeVida=true;
        for (int i = 0; i < acertos.length; i++) {
            if (letra==sorteada.charAt(i)){
                //System.out.println("ACERTOU a letra da posição"+i);
                acertos[i]=1;
                perdeVida=false;
            }
        }
            if (perdeVida){
                vidas--; //EXECUTA SE O USUARIO NAO ACERTAR A LETRA DA RODADA!
            }
            
        ganhou=true;
        for (int i = 0; i < sorteada.length(); i++) {
            
            if (acertos[i]==0){
            System.out.print(" _ ");
            ganhou=false;
        }
            else{
                System.out.print(" "+sorteada.charAt(i)+" ");
        }
    }  
}       while (!ganhou && vidas>0);
        
        if (vidas!=0){
            System.out.println("\n***VOCÈ É FODA MEMO EIN CARA!!***");
        } 
        else{
            
            System.out.println("\nQUE BURRO DÁ ZERO PRA ELE >:( ");
            System.out.println("A palavra era: " +sorteada);
        }
    }
}
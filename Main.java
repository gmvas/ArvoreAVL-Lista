import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Declaração das estruturas utilizadas
        ArvoreAVL arvore = new ArvoreAVL();
        ListaDupla lista = new ListaDupla();

        //Arbertura e Leitura do arquivo contendo nomes
        File arq = new File("nomesArvore.txt"); //Abertura do arquivo contendo os nomes
        BufferedReader leitor = new BufferedReader(new FileReader(arq)); //Leitor do arquivo
        String arquivo = leitor.readLine(); //Leitura da primeira linha para pré-carregar

        while(arquivo != null) { //Condição para a leitura do arquivo constante
            String textoSujo = arquivo.replaceAll("\\p{P}", ""); //Substitui todas as pontuações do texto e as remove
            String []nomes = textoSujo.split(" "); //Pega o texto sem pontuação e cria 
            for (int i = 0; i < nomes.length; i++) { 
                arvore.inserir(nomes[i]); //Inserção dos nomes individualmente na Arvore
            }
            arquivo = leitor.readLine(); //Le a proxima linha
        }
        lista.obterConteudo(arvore.getRaiz()); //Obtendo conteudo da ArvoreAVL para a ListaDupla

        // Exibição dos conteudos em diferentes ordens
        System.out.println("Impressao Arvore Binaria - ordem lexografica:");
        arvore.listar();
        System.out.println("\n---------------------------------------------");
        System.out.println("Impressao Lista Dupla - ordem de incidencia:");
        lista.listar();
        
        //Fechamento do leitor para não vazar memória
        leitor.close();
    }
}
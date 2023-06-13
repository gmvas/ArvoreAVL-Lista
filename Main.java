import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ArvoreAVL arvore;
        ListaDupla lista;

        //Arbertura e Leitura do arquivo contendo nomes
        File arq = new File("nomesArvore.txt");
        BufferedReader leitor = new BufferedReader(new FileReader(arq));
        String arquivo = leitor.readLine();

        //implementar um while para leitura do arquivo / implementar um arquivo.split para separar as palavras dos demais
        while(arquivo != null) {
            String simbolos = arquivo.replaceAll("[a-zA-Z]+", " "); //Busca todos simbolos que nao sejam letras
            String []nomes = arquivo.split(simbolos );
            for (int i = 0; i < nomes.length; i++) { //TODO: Verificar o porque do split nao estar removendo pontuação, ou encontrar outro metodo
                System.out.println(nomes[i] + "-");                
            }
            arquivo = leitor.readLine();
        }



        leitor.close();
    }
}
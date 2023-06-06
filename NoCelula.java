public class NoCelula {
    String nome;
    int contador = 0;
    NoCelula Aesq; //Arvore esquerda
    NoCelula Adir; //Arvore direita
    NoCelula Lprox; //Lista proximo
    NoCelula Lant; //Lista anterior

    NoCelula() { //Contrutor base
        this.nome = null;
        Aesq = null;
        Adir = null;
        Lprox = null;
        Lant = null;
    }

    NoCelula(String nome) { //Construtor com conteudo
        this.nome = nome.toUpperCase(); //Strings todas em letra maiscula afim de não haver conflitos de nome por conta de letras maiusculas
        contador++; //Novo nome indica uma aparicao de pelo menos 1 vez
        Aesq = null;
        Adir = null;
        Lprox = null;
        Lant = null;
    }
}
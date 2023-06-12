public class No {
    String nome;
    int contador = 0;
    No esq; //Arvore esquerda
    No dir; //Arvore direita

    No() { //Contrutor base
        this.nome = null;
        esq = null;
        dir = null;
    }

    No(String nome) { //Construtor com conteudo
        this.nome = nome.toUpperCase(); //Strings todas em letra maiscula afim de não haver conflitos de nome por conta de letras maiusculas
        contador++; //Novo nome indica uma aparicao de pelo menos 1 vez
        esq = null;
        dir = null;
    }
}

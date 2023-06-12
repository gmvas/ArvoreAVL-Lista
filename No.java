public class No {
    String nome;
    int contador = 0;
    No esq; //No a esquerda
    No dir; //No a direita

    No() { //Contrutor base
        this.nome = null;
        esq = null;
        dir = null;
    }

    No(String nome) { //Construtor com conteudo - para arvore binaria
        this.nome = nome.toUpperCase(); //Strings todas em letra maiscula afim de não haver conflitos de nome por conta de letras maiusculas
        contador++; //Novo nome indica uma aparicao de pelo menos 1 vez
        esq = null;
        dir = null;
    }

    No(No existente) { //Construtor para criacao de Nos da ListaDupla
        this.nome = existente.nome;
        this.contador = existente.contador;
        this.esq = null;
        this.dir = null;
    }
}

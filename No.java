public class No {
    String nome;
    int contador;
    int altura;
    No esq; //No a esquerda
    No dir; //No a direita

    No() { //Contrutor base
        this.nome = null;
        esq = null;
        dir = null;
    }

    No(String nome) { //Construtor de folhas para arvore binaria
        this.nome = nome.toUpperCase(); //Strings todas em letra maiscula afim de não haver conflitos de nome por conta de letras maiusculas
        contador = 1; //Novo nome indica uma aparicao de pelo menos 1 vez
        altura = 1; //Uma nova folha sempre tera a altura de 1
        esq = null;
        dir = null;
    }

    No(No existente) { //Construtor para criacao de Nos da ListaDupla
        this.nome = existente.nome;
        this.contador = existente.contador;
        this.altura = existente.altura;
        this.esq = null; //Mantendo apontadores vazios para a atribuição manual dos devidos Nós
        this.dir = null;
    }

    public void setAltura() { //Calcula o nivel total de vertice X
        this.altura = 1 + Math.max(esq.altura, dir.altura);
    }
}
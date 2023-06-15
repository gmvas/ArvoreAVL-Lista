public class No {
    String nome;
    int contador;
    int altura;
    No esq; //No a esquerda
    No dir; //No a direita

    //Construtor vazio para um No vazio
    No() {
        this.nome = null;
        esq = null;
        dir = null;
    }

    //Construtor de No com conteudo
    No(String nome) {
        this.nome = nome.toUpperCase(); //Strings todas em letra maiscula afim de não haver conflitos de nome por conta de letras maiusculas
        contador = 1; //Novo nome indica uma aparicao de pelo menos 1 vez
        altura = 1; //Uma nova folha sempre tera a altura de 1
        esq = null;
        dir = null;
    }

    //Construtor de No baseado de outro No
    No(No existente) {
        //Copiando dados do No existente
        this.nome = existente.nome;
        this.contador = existente.contador;
        this.altura = existente.altura;

        //Mantendo apontadores vazios para a atribuição manual dos devidos Nós
        this.esq = null; 
        this.dir = null;
    }

    //Metodo para calcular a nova altura do No
    public void setAltura() { //Calcula o nivel total de vertice X
        this.altura = 1 + Math.max(esq.altura, dir.altura);
    }
}

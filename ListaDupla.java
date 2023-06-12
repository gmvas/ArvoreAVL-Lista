public class ListaDupla {
    private No cabeca; //Maior elemento da Lista - primeiro elemento
    private No cauda; //Menor elemento da Lista - ultimo elemento

    ListaDupla() {
        cabeca = new No();
        cauda = new No();
    }

    /*
     *  TODO: verificar se utilizar esse metodo dentro da ListaDupla vai funcionar
     *  possivel problema com a chamada da 'ArvoreAVL arvore' onde pode impedir o
     *  caminhamento do No da Árvore
     * 
     *  Caso nao funcione, transferir funcao para a ArvoreAVL e fazer as 
     *  respectivas mudancas necessarias
     */
    public void obterConteudo(ArvoreAVL arvore) { //Metodo para copiar a Arvore para a Lista
        if(cabeca.nome == null) { //Caso de primeira insercao
            cabeca = new No(arvore.getRaiz());
            cabeca.dir = cauda;
            cauda.esq = cabeca;
        }
    }

    public void listar(No cabeca) {
        if(cabeca!=null){ //Verifica pela existencia de conteudo
            System.out.print("Nome: " + cabeca.nome);
            System.out.println(" - Frequencia: " + cabeca.contador);
            listar(cabeca.dir); //Caminha para o proximo No
        }
        
    }
}
public class ListaDupla {
    No cabeca; //Maior elemento da Lista - primeiro elemento
    No cauda; //Menor elemento da Lista - ultimo elemento

    ListaDupla() {
        cabeca = new No();
        cauda = new No();
    }

    /*
     *  TODO: verificar se utilizar esse metodo dentro da ListaDupla vai funcionar com o professor
     */
    public void obterConteudo(No raizArvore, No cabeca, No cauda) { //Metodo para copiar a Arvore para a Lista - deve ser usado no main
        if(cabeca.nome == null) { //Primeira inserção na Lista
            cabeca = new No(raizArvore);
            cabeca.dir = cauda;
            cauda.esq = cabeca;
        }
        else if(cauda.nome == null) { //Primeira inserção na Cauda
            cauda = new No(raizArvore);
        }
        else transfConteudoNo(raizArvore, cauda); //Inserção no meio da Lista
    }

    public No transfConteudoNo(No raizArvore, No raizLista) { //Metodo para transferir conteudo entre Nos
        if(raizArvore.contador > raizLista.contador) { //Caminhamento para achar o devido local
            raizLista = transfConteudoNo(raizArvore, raizLista.dir);
        }
        else {
            //Transferencia de conteudos de No e de apontadores
            No aux = new No(raizLista);
            aux.esq = raizLista.esq;
            aux.dir = raizLista;
            raizLista.esq.dir = aux;    
            raizLista.esq = aux;

            //Transferindo conteudos da raiz da Arvore para a Lista
            raizLista = raizArvore;
        }

        return raizLista;
    }

    public void listar(No cabeca) {
        if(cabeca!=null){ //Verifica pela existencia de conteudo
            System.out.print("Nome: " + cabeca.nome);
            System.out.println(" - Frequencia: " + cabeca.contador);
            listar(cabeca.dir); //Caminha para o proximo No
        }
        
    }
}
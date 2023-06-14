public class ListaDupla {
    No primeiro; //Maior elemento da Lista - primeiro elemento
    No ultimo; //Menor elemento da Lista - ultimo elemento

    ListaDupla() {
        primeiro = new No(); //Sempre ficara vazio para facilitar a insercao
        ultimo = primeiro;
    }

    public void obterConteudo(No raizArvore) {
        if(raizArvore != null){ //Caminhamento central da Arvore para inserção na Lista
            obterConteudo(raizArvore.esq);
            obterConteudo(raizArvore, primeiro, ultimo);
            obterConteudo(raizArvore.dir);
        }
    }

    private void obterConteudo(No raizArvore, No primeiro, No ultimo) { //Metodo para copiar a Arvore para a Lista - deve ser usado no main
        if(primeiro.dir == null) { //Primeira inserção na Lista
            No aux = new No(raizArvore);
            aux.dir = primeiro.dir;
            aux.esq = primeiro;
            primeiro.dir = aux;
            ultimo = aux; //PROBLEMA ULTIMO NÃO MODIFICA PARA AUX
        }   
        else if(raizArvore.contador < ultimo.contador) { //Inserção no fim da Lista
            ultimo.dir = new No(raizArvore);
            ultimo.dir.esq = ultimo;
            ultimo = ultimo.dir;
        }
        else primeiro = obterConteudoMeio(raizArvore, ultimo); //Inserção no meio da Lista
    }

    private No obterConteudoMeio(No raizArvore, No raizLista) { //Metodo para inserir um No no meio da Lista
        if(raizArvore.contador > raizLista.esq.contador && raizArvore.contador > raizLista.contador) { //Caminhamento para achar o devido local
            raizLista = obterConteudoMeio(raizArvore, raizLista.dir);
        }
        else {
            //Mudança de apontadores do No
            No aux = new No();
            aux.esq = raizLista.esq;
            aux.dir = raizLista;
               
            raizLista.esq = aux;
            aux.esq.dir = aux;

            //Transferindo conteudos da raiz da Arvore para a Lista
            aux.nome = raizArvore.nome;
            aux.contador = raizArvore.contador;

            aux = null; // Esvaziando No auxiliar (seguindo como indicado no slide)
        }

        return raizLista;
    }

    private void listar(No primeiro) {
        if(primeiro!=null){ //Verifica pela existencia de conteudo
            System.out.print("Nome: " + primeiro.nome);
            System.out.println(" - Frequencia: " + primeiro.contador);
            listar(primeiro.dir); //Caminha para o proximo No
        }
    }

    public void listar() {
        listar(primeiro.dir); // O primeiro No da lista é sempre vazio
    }
}

/*
 * TODO LIST - LISTA DUPLA
 * 
 * Encadeamento duplo - feito
 * Contrutor - feito (ok)
 * Transferencia de conteudo - feito (PROBLEMA)
 * Listamento - feito (ok)
 */
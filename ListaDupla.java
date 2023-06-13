public class ListaDupla {
    No primeiro; //Maior elemento da Lista - primeiro elemento
    No ultimo; //Menor elemento da Lista - ultimo elemento

    ListaDupla() {
        primeiro = new No();
        ultimo = primeiro;
    }

    public void obterConteudo(No raizArvore, No primeiro, No ultimo) { //Metodo para copiar a Arvore para a Lista - deve ser usado no main
        if(primeiro.dir == null) { //Primeira inserção na Lista
            No aux = new No(raizArvore);
            aux.dir = primeiro.esq;
            aux.esq = primeiro;
            primeiro.dir = aux;
            ultimo = aux;
        }   
        else primeiro = transfConteudoNo(raizArvore, ultimo); //Inserção no meio da Lista
    }

    private No transfConteudoNo(No raizArvore, No raizLista) { //Metodo para transferir conteudo entre Nos
        if(raizArvore.contador > raizLista.esq.contador && raizArvore.contador > raizLista.contador) { //Caminhamento para achar o devido local
            raizLista = transfConteudoNo(raizArvore, raizLista.dir);
        }
        else {
            //Transferencia de conteudos de No e de apontadores
            No aux = new No();
            aux.esq = raizLista.esq;
            aux.dir = raizLista;
               
            raizLista.esq = aux;
            aux.esq.dir = aux;

            //Transferindo conteudos da raiz da Arvore para a Lista
            aux.nome = raizArvore.nome;
            aux.contador = raizArvore.contador;

            aux = null; // Esvaziando No auxiliars (seguindo como indicado no slide)
        }

        return raizLista;
    }

    public void listar(No primeiro) {
        if(primeiro!=null){ //Verifica pela existencia de conteudo
            System.out.print("Nome: " + primeiro.nome);
            System.out.println(" - Frequencia: " + primeiro.contador);
            listar(primeiro.dir); //Caminha para o proximo No
        }
        
    }
}
public class ListaDupla {
    private No primeiro; //Maior elemento da Lista - primeiro elemento
    private No ultimo; //Menor elemento da Lista - ultimo elemento

    //Construtor base da ListaDupla
    ListaDupla() {
        primeiro = new No(); //Sempre ficara vazio para facilitar a insercao
        ultimo = primeiro;
    }

    //Metodo publico obterConteudo - realiza um caminhamento central pela Arvore, e chama o método de inserção privado com seus devidos parametros
    public void obterConteudo(No raizArvore) {
        if(raizArvore != null){ //Caminhamento pela Arvore para realizar inserção na Lista
            obterConteudo(raizArvore.esq);
            obterConteudo(raizArvore.dir);
            ultimo = obterConteudo(raizArvore, primeiro, ultimo); //Fixando o novo No ultimo (caso tenha)
        }
    }

    //Metodo privado obterConteudo - procura o devido local do No para ser inserido com base no seu contador
    private No obterConteudo(No raizArvore, No primeiro, No ultimo) {
        if(primeiro.dir == null) { //Primeira inserção na Lista
            No aux = new No(raizArvore); //Criando o novo No
            
            //Mudanças no ponteiros
            aux.esq = primeiro;
            primeiro.dir = aux;
            ultimo = aux; //Apontando para o novo ultimo
        }   
        else if(raizArvore.contador < ultimo.contador) { //Inserção no fim da Lista
            ultimo.dir = new No(raizArvore); //Criação de um novo No
            ultimo.dir.esq = ultimo; //Atribuindo ponteiro do novo No
            ultimo = ultimo.dir; //Mudando No para qual 'ultimo' aponta
        }
        else primeiro = obterConteudoMeio(raizArvore, ultimo); //Inserção no meio da Lista

        return ultimo;
    }

    //Metodo privado obterConteudoMeio - faz a busca na Lista pelo local onde o novo No será inserido e faz as devidas movimentações de apontadores
    private No obterConteudoMeio(No raizArvore, No raizLista) { //Metodo para inserir um No no meio da Lista
        if(raizLista.esq.nome != null && (raizArvore.contador > raizLista.esq.contador && raizArvore.contador > raizLista.contador)) { 
            raizLista = obterConteudoMeio(raizArvore, raizLista.esq); //Caminhamento para achar o devido local
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

    //Metodo privado listar - lista todos os Nos em ordem decrescente 
    private void listar(No primeiro) {
        if(primeiro!=null){ //Verifica pela existencia de conteudo
            System.out.print("Nome: " + primeiro.nome);
            System.out.println(" - Frequencia: " + primeiro.contador);
            listar(primeiro.dir); //Caminha para o proximo No
        }
    }

    //Metodo listar publico - chama o método listar privado com seus devido parametros
    public void listar() {
        listar(primeiro.dir); // O primeiro No da lista é sempre vazio
    }
}
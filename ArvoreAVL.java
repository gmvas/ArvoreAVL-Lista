import javax.sound.midi.MidiChannel;

public class ArvoreAVL {
    private No raizA;
    private ListaDupla raizL;

    private No inserir(No raizA, No novo) {
        if(raizA == null) { //Situação de nova insercao na arvore
            raizA = novo; 
        }
        else if(novo.nome.compareToIgnoreCase(raizA.nome) < 0) //Buscando caminho de itens menores
            raizA.esq = inserir(novo, raizA.esq);
        else if(novo.nome.compareToIgnoreCase(raizA.nome) > 0) //Buscando caminho de itens maiores
            raizA.dir = inserir(novo, raizA.dir);
        else incrementaContador(raizA, novo);

        return raizA;
    }

    public void inserir(String nome) {
        No novo = new No(nome);
        raizA = inserir(raizA, novo);
    }

    private No incrementaContador(No raizA, No buscando) {
        if(raizA!=null) {
            if(raizA.nome == buscando.nome) { //Busca pelo conteudo desejado
                raizA.contador++;
                return raizA;
            }
            else if(buscando.nome.compareToIgnoreCase(raizA.nome) < 0) //Caminha a esquerda (nomes menores)
                raizA.esq = incrementaContador(buscando, raizA.esq);
            else if(buscando.nome.compareToIgnoreCase(raizA.nome) > 0) //Caminha a direita (nomes maiores)
                raizA.dir = incrementaContador(buscando, raizA.dir);
        }
        return raizA; //Return para efetivar a alteração dentro da arvore
    }

    private void listarArvore(No raizA) { //Listagem por caminhamento central
        listarArvore(raizA.esq);
        System.out.println("- " + raizA.nome);
        listarArvore(raizA.dir);
    }

    private ListaDupla montarLista(No raizA, ListaDupla raizL) {
        if(raizA != null){ //Checando por conteudo dentro do No
            raizL.conteudo = raizA; //Pegando conteudo do No sem fazer ordenação
            montarLista(raizA.esq, raizL.prox);
            montarLista(raizA.dir, raizL.prox);
        }
        return raizL;
    }

    public void montarLista() { //Tentando achar um jeito que de certo
        ListaDupla aux = new ListaDupla();
        raizL = montarLista(raizA, aux);
        while (aux.conteudo != null) {
            
        }
    }

    public void listarArvore() {
        listarArvore(raizA);
    }

    private void listarLista(No raizA) {
        System.out.println();
    }

    public void listarLista() {
        listarArvore(raizA);
    }
}
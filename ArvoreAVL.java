public class ArvoreAVL {
    private No raiz;

    private No inserir(No raiz, No novo) {
        if(raiz == null) { //Situação de nova insercao na arvore
            raiz = novo; 
        }
        else if(novo.nome.compareToIgnoreCase(raiz.nome) < 0) //Buscando caminho de itens menores
            raiz.esq = inserir(novo, raiz.esq);
        else if(novo.nome.compareToIgnoreCase(raiz.nome) > 0) //Buscando caminho de itens maiores
            raiz.dir = inserir(novo, raiz.dir);
        else incrementaContador(raiz, novo);

        return raiz;
    }

    public void inserir(String nome) {
        No novo = new No(nome);
        raiz = inserir(raiz, novo);
    }

    private No incrementaContador(No raiz, No buscando) {
        if(raiz!=null) {
            if(raiz.nome == buscando.nome) { //Busca pelo conteudo desejado
                raiz.contador++;
                return raiz;
            }
            else if(buscando.nome.compareToIgnoreCase(raiz.nome) < 0) //Caminha a esquerda (nomes menores)
                raiz.esq = incrementaContador(buscando, raiz.esq);
            else if(buscando.nome.compareToIgnoreCase(raiz.nome) > 0) //Caminha a direita (nomes maiores)
                raiz.dir = incrementaContador(buscando, raiz.dir);
        }
        return raiz; //Return para efetivar a alteração dentro da arvore
    }

    private void listar(No raiz) { //Listagem por caminhamento central
        listar(raiz.esq);
        System.out.println("- " + raiz.nome);
        listar(raiz.dir);
    }

    public void listar() {
        listar(raiz);
    }
}

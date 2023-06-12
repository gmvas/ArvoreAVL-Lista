public class ArvoreAVL {
    No raiz;

    private No inserir(No raiz, No novo) {
        if(raiz == null) { //Situação de nova insercao na arvore
            raiz = novo; 
        }
        else if(novo.nome.compareToIgnoreCase(raiz.nome) < 0) //Buscando caminho de itens menores
            raiz.esq = inserir(novo, raiz.esq);
        else if(novo.nome.compareToIgnoreCase(raiz.nome) > 0) //Buscando caminho de itens maiores
            raiz.dir = inserir(novo, raiz.dir);
        else raiz = incrementaContador(raiz, novo); //Situacao onde o No ja exista - Nao ha nenhum menor ou maior

        return raiz;
    }

    public void inserir(String nome) {
        No novo = new No(nome);
        raiz = inserir(raiz, novo);
    }

    private No incrementaContador(No raiz, No buscando) {
        if(raiz.nome == buscando.nome) { //Ceretificando se os nomes sao iguais
            raiz.contador++;
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

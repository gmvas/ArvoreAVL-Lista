public class ArvoreAVL {
    private NoCelula raiz;

    private NoCelula inserir(NoCelula raiz, NoCelula novo) {
        if(raiz == null) { //Situação de nova insercao na arvore
            raiz = novo; 
        }
        else if(novo.nome.compareToIgnoreCase(raiz.nome) < 0) //Buscando caminho de itens menores
            raiz.Aesq = inserir(novo, raiz.Aesq);
        else if(novo.nome.compareToIgnoreCase(raiz.nome) > 0) //Buscando caminho de itens maiores
            raiz.Adir = inserir(novo, raiz.Adir);
        else incrementaContador(raiz, novo);

        return raiz;
    }

    public void inserir(String nome) {
        NoCelula novo = new NoCelula(nome);
        raiz = inserir(raiz, novo);
    }

    private NoCelula incrementaContador(NoCelula raiz, NoCelula buscando) {
        if(raiz!=null) {
            if(raiz.nome == buscando.nome) { //Busca pelo conteudo desejado
                raiz.contador++;
                return raiz;
            }
            else if(buscando.nome.compareToIgnoreCase(raiz.nome) < 0) //Caminha a esquerda (nomes menores)
                raiz.Aesq = incrementaContador(buscando, raiz.Aesq);
            else if(buscando.nome.compareToIgnoreCase(raiz.nome) > 0) //Caminha a direita (nomes maiores)
                raiz.Adir = incrementaContador(buscando, raiz.Adir);
        }
        return raiz; //Return para efetivar a alteração dentro da arvore
    }

    private void listar(NoCelula raiz) { //Listagem por caminhamento central
        listar(raiz.Aesq);
        System.out.println("- " + raiz.nome);
        listar(raiz.Adir);
    }

    public void listar() {
        listar(raiz);
    }
}

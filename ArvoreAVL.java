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
            if(raiz.nome == buscando.nome) {
                raiz.contador++;
                return raiz;
            }
            else if(buscando.nome.compareToIgnoreCase(raiz.nome) < 0)
                raiz.Aesq = incrementaContador(buscando, raiz.Aesq);
            else if(buscando.nome.compareToIgnoreCase(raiz.nome) > 0)
                raiz.Adir = incrementaContador(buscando, raiz.Adir);
        }
        return raiz;
    }
}

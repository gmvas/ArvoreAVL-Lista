public class ArvoreAVL {
    No raiz;

    ArvoreAVL() {
        raiz = null;
    }

    public void inserir(String nome) {
        No novo = new No(nome);
        raiz = inserir(raiz, novo);
        raiz = balancear(raiz);
    }

    private No inserir(No arvore, No novo) {
        if(arvore == null) { //Situação de nova insercao na arvore
            arvore = new No(novo);
        }
        else if(novo.nome.compareToIgnoreCase(arvore.nome) < 0) //Buscando caminho de itens menores
            arvore.esq = inserir(arvore.esq, novo);
        else if(novo.nome.compareToIgnoreCase(arvore.nome) > 0) //Buscando caminho de itens maiores
            arvore.dir = inserir(arvore.dir, novo);
        else arvore = incrementaContador(arvore, novo); //Situacao onde o No ja exista - Nao ha nenhum menor ou maior
        
        return arvore;
    }

    private No balancear(No no) {
        if(no.esq != null && no.dir != null) {
            int fator = no.dir.altura - no.esq.altura;

            if(Math.abs(fator) <= 1) //Verificando se o valor é 0 ou 1 - abs = modulo / valores sempre maiores que 0
                no.setAltura();

            else if (fator == 2) { //Desbalanceamento para a direita
                int fatorDir = no.dir.dir.altura - no.dir.esq.altura;

                if(fatorDir == -1) { //Desbalanceamento duplo (esq.dir)
                    no.dir = rotacionaDir(no.dir);
                }
                no = rotacionaEsq(no);
            }
            else if(fator == -2) { //Desbalanceamento para a esquerda
                int fatorEsq = no.esq.dir.altura - no.esq.esq.altura;

                if(fatorEsq == 1) { //Desbalanceaamento duplo (dir.esq)
                    no.esq = rotacionaEsq(no.esq);
                }
                no = rotacionaDir(no);
            }
            else {
                System.out.println("Erro ao balancear no " + no.nome + " de altura " + no.altura);
            }
        }
        return no;
    }

    private No rotacionaDir(No no) {
        No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setAltura(); //Atualiza o nivel do no
		noEsq.setAltura(); //Atualiza o nivel do noEsq

		return noEsq;
    }

    private No rotacionaEsq(No no) {
        No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;

		no.setAltura(); // Atualiza o nivel do no
		noDir.setAltura(); // Atualiza o nivel do noDir
		return noDir;
    }

    private No incrementaContador(No raiz, No buscando) {
        if(raiz.nome.equals(buscando.nome)) { //Ceretificando se os nomes sao iguais
            raiz.contador++;
        }
        return raiz; //Return para efetivar a alteração dentro da arvore
    }

    private void listar(No raiz) { //Listagem por caminhamento central
        if(raiz != null){
            listar(raiz.esq);
            System.out.println("-> " + raiz.nome + " | " + raiz.contador);
            listar(raiz.dir);
        }
    }

    public void listar() {
        listar(raiz);
    }
}
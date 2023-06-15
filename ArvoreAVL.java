public class ArvoreAVL {
    private No raiz;

    //Construtor base da Arvore
    ArvoreAVL() { 
        raiz = null;
    }

    //Metodo publico do inserir - faz uma chamada para o metodo privado, inserindo o no raiz
    public void inserir(String nome) {
        No novo = new No(nome);
        raiz = inserir(raiz, novo); //Inserção de nome na árvore
        raiz = balancear(raiz); //Balanceamento da árvore
    }

    //Metodo privado de inserir - faz a busca da posição correta na árvore e retorna a raiz com o nó inserido
    private No inserir(No arvore, No novo) {
        if(arvore == null) { //Criação de novo nó para inserir na árvore
            arvore = new No(novo);
        }
        else if(novo.nome.compareToIgnoreCase(arvore.nome) < 0) //Buscando caminho de itens menores
            arvore.esq = inserir(arvore.esq, novo);
        else if(novo.nome.compareToIgnoreCase(arvore.nome) > 0) //Buscando caminho de itens maiores
            arvore.dir = inserir(arvore.dir, novo);
        else arvore = incrementaContador(arvore, novo); //No ja existente - Nao ha nenhum menor ou maior, contador é incrementado
        
        return arvore;
    }

    //Método privado de balanceamento - é chamado pós inserção para realizar manter a árvore balanceada para a próxima inserção
    private No balancear(No no) {
        if(no.esq != null && no.dir != null) { //Verificando por filhos para balancear
            int fator = no.dir.altura - no.esq.altura; //Gerando o fator de balanceamento

            if(Math.abs(fator) <= 1) //Verificando se o valor é 0 ou 1 - abs = modulo / valores sempre maiores que 0
                no.setAltura();

            else if (fator == 2) { //Desbalanceamento para a direita
                int fatorDir = no.dir.dir.altura - no.dir.esq.altura; //Checando por desbalanceamento duplo

                if(fatorDir == -1) { //Desbalanceamento duplo (esq.dir)
                    no.dir = rotacionaDir(no.dir);
                }
                no = rotacionaEsq(no);
            }
            else if(fator == -2) { //Desbalanceamento para a esquerda
                int fatorEsq = no.esq.dir.altura - no.esq.esq.altura; //Checando por desbalanceamento duplo

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

    //Metodo privado de rotacionamento de Nó para a direita - chamado exclusivamente pelo balancear()
    private No rotacionaDir(No no) {
        //Criando No para auxilio da rotação
        No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

        //Mudando os conteudos dos Nos
		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setAltura(); //Atualiza o nivel do no
		noEsq.setAltura(); //Atualiza o nivel do noEsq

		return noEsq;
    }

    //Metodo privado de rotacionamento de Nó para a esquerda - chamado exclusivamente pelo balancear()
    private No rotacionaEsq(No no) {
        //Criando No para auxilio da rotação
        No noDir = no.dir;
		No noDirEsq = noDir.esq;

        //Mudando os conteudos dos Nos
        noDir.esq = no;
		no.dir = noDirEsq;
		no.setAltura(); // Atualiza o nivel do no
		noDir.setAltura(); // Atualiza o nivel do noDir

        return noDir;
    }

    //Metodo privado de incrementação dos contadores - em caso da inserção não achar uma posição maior ou menor para 
    //o No novo, ele é enviado para ter o contador da sua raiz equivalente incrementada
    private No incrementaContador(No raiz, No buscando) {
        if(raiz.nome.equals(buscando.nome)) { //Ceretificando se os nomes sao iguais
            raiz.contador++;
        }
        return raiz; //Return para efetivar a alteração dentro da arvore
    }

    //Metodo privado de listar - imprime o conteudo em ordem lexografica 
    private void listar(No raiz) { 

        //Listagem por caminhamento central
        if(raiz != null){
            listar(raiz.esq);
            System.out.println("-> " + raiz.nome + " | " + raiz.contador);
            listar(raiz.dir);
        }
    }

    //Metodo publico listar - realiza a chamada para o metodo privado sem realizar a chamada da raiz no main
    public void listar() {
        listar(raiz);
    }

    //Metodo getRaiz - retorna o valor da raiz (raiz é privado)
    public No getRaiz(){
        return raiz;
    }
}

/**
 * Implementação de Pesquisa de dados em estrutura sequencial.
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Tamamho máximo da lista.
     */
    private static final int TAMANHO = 1000;
    /**
     * Quantidade de elementos da lista.
     */
    private static int n = 0;

    /**
     * Lista os dados da lista.
     *
     * @param lista Lista dos Nós.
     * @param n Quantidade de Nós da lista.
     * @return Uma String com os dados da lista.
     */
    public static String listar(int[] lista, int n) {
        //String de retorno
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp = temp + (i) + "-" + lista[i];
            if (i % 30 == 0) {
                temp = temp + "\n";
            }
        }
        return temp;
    }

    /**
     * Inserir em posição especifica.
     *
     * @param lista Lista dos Nós.
     * @param k Posição de inserção.
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @return Retorna verdadeiro ou falso.
     */
    public static boolean inserir(int lista[], int k, int valor) {
        if (n < TAMANHO) {
            if ((k >= 0) && (k <= n)) {
                for (int i = n - 1; i >= k; i--) {
                    lista[i + 1] = lista[i];
                }
                lista[k] = valor;
                n = n + 1;
                return true;
            } else {
                System.out.print("Posição inválida!\n");
                return false;
            }
        } else {
            System.out.print("A lista está cheia!\n");
            return false;
        }
    }

    /**
     * Inserção ordenada de elementos na lista.
     *
     * @param lista Lista dos Nós.
     * @param valor Um novo valor de um nó a ser inserido na lista.
     * @return Verdadeiro o falso se conseguiu realizar a inclusão.
     */
    public static boolean inserirOrdenado(int lista[], int valor) {
        if (n < TAMANHO) {
            int i = 0;
            while ((i < n) && (valor > lista[i])) {
                i = i + 1;
            }
            if (i <= n) {
                return inserir(lista, i, valor);
            } else {
                System.out.print("Posição Inválida!");
                return false;
            }
        } else {
            System.out.print("Lista Cheia!");
            return false;
        }
    }

    /**
     * Realiza a pesquisa lenta da chave na lista de dados.
     *
     * Complexidade de tempo. 
     * T(n) = Theta(1) + Theta(n) + Theta(n) + O(n) + Theta(1) + O(1)
     * T(n) = Theta(2n + 2) + O(n + 1) = Theta(n)
     *
     * @param lista vetor com os dados armazenados
     * @param n quantidade de elementos da lista
     * @param chave valor a ser procurado na lista
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisaLenta(int lista[], int n, int chave) {
        System.out.println("\n >>> Pesquisa Lenta");
        //Inicio do cronômetro
        Cronometro.inicio();
        long tempoInicio = Cronometro.tempoGasto();

        int posicao = -1;                                   //Theta(1)
        for (int i = 0; i < n; i++) {                       //Theta(n)
            if (lista[i] == chave) {                        //n * Theta(1) = Theta(n)
                posicao = i;                                //n * O(1) = O(n)
            }
            //Gera um atraso de 1 segundo no procedimento de busca
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        //Parada do cronômetro
        Cronometro.parada();
        long tempoFim = Cronometro.tempoGasto();
        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);

        if (posicao < n) {                                  //Theta(1)
            return posicao;                                 //O(1)
        } else {
            return -1;                                      //O(1)
        }
    }

    /**
     * Realiza a pesquisa da chave na lista de dados.
     *
     * Complexidade de tempo no melhor caso.      
     * T(n) = Theta(1) + Omega(2) + Omega(1) + Theta(1) + O(1)
     * T(n) = Theta(2) + Omega(3) + O(1)
     * T(n) = O(1)
     * 
     * Complexidade de tempo no pior caso.      
     * T(n) = Theta(1) + O(2n) + O(n) + Theta(1) + O(1)
     * T(n) = Theta(2) + O(3n + 1)
     * T(n) = O(n)
     *
     * @param lista vetor com os dados armazenados
     * @param n quantidade de elementos da lista
     * @param chave valor a ser procurado na lista
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisa(int lista[], int n, int chave) {
        System.out.println("\n >>> Pesquisa ");
        //Inicio do cronometro
        Cronometro.inicio();
        long tempoInicio = Cronometro.tempoGasto();

        int i = 0;                                          //Theta(1)
        while ((i < n) && (lista[i] != chave)) {            //Omega(2) no melhor caso  e no pior caso O(n) pior caso
            i = i + 1;                                      //Omega(2) no melhor caso  e no pior caso O(n) pior caso
            //Gera um atraso de 1 segundo no procedimento de busca
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }

        //Parada do cronometro
        Cronometro.parada();
        long tempoFim = Cronometro.tempoGasto();
        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);

        if (i < n) {                                        //Theta(1)
            return i;                                       //O(1)
        } else {
            return -1;                                      //O(1)
        }
    }

    /**
     * Realiza a pesquisa rápida da chave na lista de dados.
     *
     * Complexidade de tempo no melhor caso.      
     * T(n) = Theta(1) + Theta(1) + Omega(1) + Omega(1) + Theta(1) + O(1)
     * T(n) = Theta(3) + Omega(2) + O(1)
     * T(n) = O(1)
     * 
     * Complexidade de tempo no pior caso.      
     * T(n) = Theta(1) + Theta(1) + O(n+1) + O(n+1) + Theta(1) + O(1)
     * T(n) = Theta(3) + O(2n + 3)
     * T(n) = O(n)
     *
     * @param lista vetor com os dados armazenados
     * @param n quantidade de elementos da lista
     * @param chave valor a ser procurado na lista
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisaRapida(int lista[], int n, int chave) {
        System.out.println("\n >>> Pesquisa Rápida");
        //Inicio do cronômetro
        Cronometro.inicio();
        long tempoInicio = Cronometro.tempoGasto();

        lista[n] = chave;                               // Theta(1)
        int i = 0;                                      // Theta(1)
        while (lista[i] != chave) {                     // Omega(1) no melhor caso e no pior caso O(n+1) pior caso            
            i = i + 1;                                  // Omega(1) no melhor caso e no pior caso O(n+1) pior caso
            //Gera um atraso de 1 segundo no procedimento de busca
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        //Parada do cronômetro
        Cronometro.parada();
        long tempoFim = Cronometro.tempoGasto();
        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);

        if (i < n) {                                    //Theta(1)
            return i;                                   //O(1)
        } else {
            return -1;                                  //O(1)
        }
    }

    /**
     * Realiza a pesquisa mais rápida da chave na lista de dados.
     * 
     * Complexidade de tempo no melhor caso.      
     * T(n) = Theta(1) + Theta(1) + Omega(1) + Omega(1) + Omega(1) + Theta(1) + O(1)
     * T(n) = Theta(3) + Omega(3) + O(1)
     * T(n) = O(1)
     * 
     * Complexidade de tempo no pior caso.      
     * T(n) = Theta(1) + Theta(1) + O(n/2) + O(n/2) + O(1) + Theta(1) + O(1)
     * T(n) = Theta(3) + O(n + 2)
     * T(n) = O(n) 
     * 
     * Complexidade de tempo. 
     * T(n) = Theta(2n + 4) + O(2n + 2) = Theta(n)
     *
     * @param lista vetor com os dados armazenados
     * @param n quantidade de elementos da lista
     * @param chave valor a ser procurado na lista
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisaMaisRapida(int lista[], int n, int chave) {
        System.out.println("\n >>> Pesquisa Mais Rápida");
        //Inicio do cronometro
        Cronometro.inicio();
        long tempoInicio = Cronometro.tempoGasto();

        lista[n] = chave;                           // Theta(1) 
        int i = 0;                                  // Theta(1) 
        while (lista[i] != chave) {                 // Omega(1) no melhor caso  e no pior caso O(n/2) pior caso
            if (lista[i + 1] != chave) {            // Omega(1) no melhor caso  e no pior caso O(n/2) pior caso
                i = i + 2;                          // Omega(1) no melhor caso  e no pior caso O(n/2) pior caso
            } else {
                i = i + 1;                          // Omega(1) no melhor caso  e no pior caso O(1) pior caso
            }
            //Gera um atraso de 1 segundo no procedimento de busca
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        //Parada do cronômetro
        Cronometro.parada();
        long tempoFim = Cronometro.tempoGasto();
        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);

        if (i < n) {                                //Theta(1)
            return i;                               //O(1)
        } else {
            return -1;                              //O(1)
        }
    }

    /**
     * Realiza a pesquisa ordenada da chave na lista de dados.
     *
     * Complexidade de tempo no melhor caso.      
     * T(n) = Theta(1) + Theta(1) + Omega(1) + Omega(1) + Theta(1) + O(1)
     * T(n) = Theta(3) + Omega(2) + O(1)
     * T(n) = O(1)
     * 
     * Complexidade de tempo no pior caso.      
     * T(n) = Theta(1) + Theta(1) + O(n+1) + O(n+1) + Theta(1) + O(1)
     * T(n) = Theta(3) + O(2n + 3)
     * T(n) = O(n)
     *
     * @param lista vetor com os dados armazenados
     * @param n quantidade de elementos da lista
     * @param chave valor a ser procurado na lista
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisaOrdenada(int lista[], int n, int chave) {
        System.out.println("\n >>> Pesquisa Ordenada");
        //Inicio do cronômetro
        Cronometro.inicio();
        long tempoInicio = Cronometro.tempoGasto();

        //Pega o maior valor para um inteiro
        lista[n] = Integer.MAX_VALUE;                   // Theta(1) 
        int i = 0;                                      // Theta(1) 
        while (lista[i] < chave) {                      // Omega(1) no melhor caso e no pior caso O(n+1) pior caso 
            i = i + 1;                                  // Omega(1) no melhor caso e no pior caso O(n+1) pior caso 
            //Gera um atraso de 1 segundo no procedimento de busca
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        //Parada do cronômetro
        Cronometro.parada();
        long tempoFim = Cronometro.tempoGasto();
        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);

        if (lista[i] == chave) {                        //Theta(1)
            return i;                                   //O(1)
        } else {
            return -1;                                  //O(1)
        }
    }

    /**
     * Realiza a pesquisa da chave na lista de dados.
     *
     * Complexidade de tempo no melhor caso.      
     * T(n) = Theta(1) + Theta(1) + Theta(1) + Omega(1) + Omega(1) + Omega(1) + Omega(1) + O(1) + Theta(1) + O(1)
     * T(n) = Theta(4) + Omega(4) + O(2)
     * T(n) = O(2)
     * 
     * Complexidade de tempo no pior caso.      
     * T(n) = Theta(1) + Theta(1) + Theta(1) + O((n-1)/2) + O((n-1)/2) + O((n-1)/2) + O(1) + Theta(1) + O(1)
     * T(n) = Theta(4) + Omega(3(n-1)/2) + O(2)
     * T(n) = O(1)
     * 
     * Aplicando o teorema master ou expansão telescópica para provar 
     * por indução a complexidade temos:
     * T(n) = O (log n)
     * 
     * O(log n) Pois cada comparação reduz o número de possíveis 
     * candidatos por um fator de 2. 
     *
     * @param lista vetor com os dados armazenados
     * @param n quantidade de elementos da lista
     * @param chave valor a ser procurado na lista
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisaBinariaIterativa(int lista[], int n, int chave) {
        System.out.println("\n >>> Pesquisa Binária Iterativa");
        //Inicio do cronometro
        Cronometro.inicio();
        long tempoInicio = Cronometro.tempoGasto();

        //Limite infeiro da lista
        int limInf = 0;                                     //Theta(1)
        //Limite superior da lista
        int limSup = n;                                     //Theta(1)
        //Meio da lista
        int meio = 0;                                       //Theta(1)
        while (limInf <= limSup) {                          //Omega(1) no melhor caso e no pior caso O((n-1)/2) pior caso
            meio = (limInf + limSup) / 2;                   //Omega(1) no melhor caso e no pior caso O((n-1)/2) pior caso
            if (chave < lista[meio]) {                      //Omega(1) no melhor caso e no pior caso O((n-1)/2) pior caso
                limSup = meio - 1;                          //Omega(1) no melhor caso e no pior caso O((n-1)/2) pior caso
            } else {
                if (chave > lista[meio]) {                  //Omega(1) no melhor caso e no pior caso O((n-1)/2) pior caso
                    limInf = meio + 1;                      //Omega(1) no melhor caso e no pior caso O((n-1)/2) pior caso
                } else {
                    //Transforma o limite inferior maior que o superior para sair do laço
                    limInf = limSup + 1;                    //Omega(1) no melhor caso e no pior caso O(1) pior caso    
                }
            }
            //Gera um atraso de 1 segundo no procedimento de busca
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        //Parada do cronômetro
        Cronometro.parada();
        long tempoFim = Cronometro.tempoGasto();
        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);

        if (chave == lista[meio]) {                         //Theta(1)
            return meio;                                    //O(1)
        } else {
            return -1;                                      //O(1)
        }
    }

    /**
     * Realiza a pesquisa da chave na lista de dados.
     *
     * pesquisaBinariaRecursiva = Theta((n-1)/2)
     * 
     * Complexidade de tempo. 
     * T(n) = Theta(1) + Theta(1) + O(1) + O(1) + Theta((n-1)/2) + O(1)
     * T(n) = Theta(2) + O(3) + Theta((n-1)/2) 
     * 
     * Aplicando o teorema master ou expansão telescópica para provar 
     * por indução a complexidade temos:
     * T(n) = O (log n)
     * 
     * O(log n) Pois cada comparação reduz o número de possíveis 
     * candidatos por um fator de 2. 
     * 
     * @param lista vetor com os dados armazenados.
     * @param limInf limite inferior de busca na lista.
     * @param limSup Limite superior de busca na lista.
     * @param chave valor a ser procurado na lista.
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisaBinariaRecursiva(int lista[], int limInf, int limSup, int chave) {
        //Gera um atraso de 1 segundo no procedimento de busca
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        int meio = 0;                                                                   //Theta(1)
        if (limInf <= limSup) {                                                         //Theta(1)
            meio = (limInf + limSup) / 2;                                               //O(1)    
            if (chave < lista[meio]) {                                                  //O(1)    
                return pesquisaBinariaRecursiva(lista, limInf, meio - 1, chave);        //Theta((n-1)/2)    
            } else {
                if (chave > lista[meio]) {                                              //O(1)
                    return pesquisaBinariaRecursiva(lista, meio + 1, limSup, chave);    //Theta((n-1)/2)   
                } else {
                    if (chave == lista[meio]) {                                         //O(1)
                        return meio;                                                    //O(1)
                    } else {
                        return -1;                                                      //O(1)
                    }
                }
            }
        } else {
            return -1;                                                                  //O(1)
        }
    }

    /**
     * Realiza a pesquisa binária recursiva da chave na lista de dados.
     *
     * Complexidade Theta(k)
     *
     * @param lista vetor com os dados armazenados
     * @param n quantidade de elementos da lista
     * @param chave valor a ser procurado na lista
     * @return a posição da chave no vetor ou -1 se não encontrou.
     */
    public static int pesquisaBinariaRecursivaPrincipal(int lista[], int n, int chave) {
        System.out.println("\ni >>> Pesquisa Binária Recursiva");
        //Inicio do cronômetro
        Cronometro.inicio();
        long tempoInicio = Cronometro.tempoGasto();

        int limInf = 0;
        int limSup = n;
        int posicao = pesquisaBinariaRecursiva(lista, limInf, limSup, chave);

        //Parada do cronômetro
        Cronometro.parada();
        long tempoFim = Cronometro.tempoGasto();
        System.out.println("Tempo Inicial: " + tempoInicio + " / Tempo Final: " + tempoFim);

        if (posicao == chave) {
            return posicao;
        } else {
            return -1;
        }
    }

    /**
     * Retorna se a lista esta vazia.
     *
     * @return Verdadeiro ou falso se a lista está vazia.
     */
    public static boolean estaVazia() {
        return n == 0;
    }

    /**
     * Retorna a quantidade de Nós da lista.
     *
     * @return A quantidade de Nós da lista.
     */
    public static int getQuantidade() {
        return n;
    }

    public static void main(String[] args) {
        //Vetor com os dados a ser pesquisa
        int lista[] = new int[TAMANHO];

        // Controla o menu da lista
        int opcao = -1;

        while (opcao != 99) {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### PESQUISA DE DADOS ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 1- Inserir Ordenado\n"
                    + " 2- Listar elementos\n"
                    + " 3- Pesquisa Lenta\n"
                    + " 4- Pesquisa \n"
                    + " 5- Pesquisa Rápida\n"
                    + " 6- Pesquisa Mais Rápida\n"
                    + " 7- Pesquisa Ordenada\n"
                    + " 8- Pesquisa Binária Iterativa\n"
                    + " 9- Pesquisa Binária Recursiva\n"
                    + "10- Gerar Dados Aleatório\n"
                    + "99- Sair\n"));
            switch (opcao) {
                case 1: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Novo elemento:"));
                    if (inserirOrdenado(lista, dado) == true) {
                        JOptionPane.showMessageDialog(null, "Valor incluído com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não incluído!");
                    }
                    break;
                }
                case 2: {
                    if (estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Lista vazia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Listagem \n" + listar(lista, n));
                    }
                    break;
                }
                case 3: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser pesquisado:"));
                    int k = pesquisaLenta(lista, n, dado);
                    if (k != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não encontrado!");
                    }
                    break;
                }
                case 4: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser pesquisado:"));
                    int k = pesquisa(lista, n, dado);
                    if (k != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não encontrado!");
                    }
                    break;
                }
                case 5: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser pesquisado:"));
                    int k = pesquisaRapida(lista, n, dado);
                    if (k != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não encontrado!");
                    }
                    break;
                }
                case 6: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser pesquisado:"));
                    int k = pesquisaMaisRapida(lista, n, dado);
                    if (k != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não encontrado!");
                    }
                    break;
                }
                case 7: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser pesquisado:"));
                    int k = pesquisaOrdenada(lista, n, dado);
                    if (k != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não encontrado!");
                    }
                    break;
                }
                case 8: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser pesquisado:"));
                    int k = pesquisaBinariaIterativa(lista, n, dado);
                    if (k != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não encontrado!");
                    }
                    break;
                }
                case 9: {
                    int dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser pesquisado:"));
                    int k = pesquisaBinariaRecursivaPrincipal(lista, n, dado);
                    if (k != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " está na posição " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não encontrado!");
                    }
                    break;
                }
                case 10: {
                    //Gerando números aleatorios para preencher a lista até o tamanho do vetor -1.
                    for (int i = 0; i < TAMANHO; i++) {
                        inserirOrdenado(lista, (int) (Math.random() * 100));
                    }
                    JOptionPane.showMessageDialog(null, "Gerado " + getQuantidade() + " elementos na lista");
                }
            }
        }
    }
}

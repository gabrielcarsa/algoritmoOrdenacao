package algoritmoordenacao;

import java.util.Random;
import java.util.Scanner;

public class AlgoritmoOrdenacao {

    //Variável de entrada
    public static Scanner entrada = new Scanner(System.in);

    //Variável usada para definir opção no menu
    public static int op;

    //Gerando vetor Aleartório
    public static int[] vetorAleartorio = new int[10000];

    //Gerando vetor Ordenado
    public static int[] vetorOrdenado = new int[10000];

    //Gerando vetor Desordenado
    public static int[] vetorDesordenado = new int[10000];

    public static void main(String[] args) {
        //Chamando método para gerar vetor Aleartório
        gerarVetorAleartorio();

        //Chamando método para gerar vetor Ordenado
        gerarVetorOrdenado();

        //Chamando método para gerar vetor Desordenado
        gerarVetorDesordenado();

        //Laço de repetição para Menu
        do {
            System.out.println("\n\n--MENU--");
            System.out.println("ESCOLHA UM ALGORITMO DE ORDENAÇÃO:");
            System.out.println("1 - Bubble Sort");
            System.out.println("2 - Insertion Sort");
            System.out.println("3 - Selection Sort");
            System.out.println("4 - Merge Sort");
            System.out.println("5 - Quick Sort");
            System.out.println("6 - Sair: ");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Ordenando com Bubble...");
                    bubbleSort(vetorAleartorio);
                    bubbleSort(vetorOrdenado);
                    bubbleSort(vetorDesordenado);

                    break;
                case 2:
                    System.out.println("Ordenando com Insertion...");
                    insertionSort(vetorAleartorio);
                    insertionSort(vetorOrdenado);
                    insertionSort(vetorDesordenado);
                    break;
                case 3:
                    System.out.println("Ordenando com Selection...");
                    selectionSort(vetorAleartorio);
                    selectionSort(vetorOrdenado);
                    selectionSort(vetorDesordenado);
                    break;
                case 4:
                    System.out.println("Ordenando com Merge...");
                    mergeSort(vetorAleartorio);
                    mergeSort(vetorOrdenado);
                    mergeSort(vetorDesordenado);
                    break;
                case 5:
                    System.out.println("Ordenando com Quick...");
                    quick(vetorAleartorio);
                    quick(vetorOrdenado);
                    quick(vetorDesordenado);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (op != 6);
    }

    public static void gerarVetorAleartorio() {
        
        //instância um objeto da classe Random usando o construtor padrão
        Random gerador = new Random();

        //Colocando valores aleartórios no vetor
        for (int i = 0; i < vetorAleartorio.length; i++) {
            vetorAleartorio[i] = gerador.nextInt(10);
        }
    }

    public static void gerarVetorOrdenado() {
        //Colocando valores aleartórios no vetor
        for (int i = 0; i < vetorOrdenado.length; i++) {
            vetorOrdenado[i] = i;
        }
    }

    public static void gerarVetorDesordenado() {
        //Colocando valores aleartórios no vetor
        int j = 100;
        for (int i = 0; i < vetorDesordenado.length; i++) {
            vetorDesordenado[i] = j;
            j--;

        }
    }

    public static void bubbleSort(int[] vetor) {
        long t1 = System.nanoTime();

        //Variável booleana para verificar se houve troca
        boolean troca = true;

        //Variável auxiliar
        int aux;

        //Percorre até que não haja mais troca
        while (troca == true) {
            troca = false;
            //Percorre o vetor até o final - 1
            for (int i = 0; i < vetor.length - 1; i++) {
                //Se vetor for maior que sua próxima posição, então troca
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i + 1];
                    vetor[i + 1] = vetor[i];
                    vetor[i] = aux;
                    troca = true;
                }
            }
        }

        long t2 = System.nanoTime() - t1;
        System.out.println("Tempo " + t2 * Math.pow(10, -9) + " segundos");

    }

    public static void insertionSort(int[] vetor) {
        long t1 = System.nanoTime();
        int i, j;
        //Percorre vetor da segunda posição (j = 1) até o final
        for (j = 1; j < vetor.length; j++) {
            //Pega o valor da posição atual
            int eleito = vetor[j];

            //Compara com decremento todos valores anteriores
            for (i = j - 1; (i >= 0) && (vetor[i] > eleito); i--) {
                //Se vetor[i] > eleito, copia
                vetor[i + 1] = vetor[i];

            }
            //Faz a troca em os pares
            vetor[i + 1] = eleito;
        }
        long t2 = System.nanoTime() - t1;
        System.out.println("Tempo " + t2 * Math.pow(10, -9) + " segundos");
    }

    public static void selectionSort(int[] vetor) {
        long t1 = System.nanoTime();
        int menor, indiceMenor;

        //Percorre vetor até seu final -1
        for (int i = 0; i < vetor.length - 1; i++) {
            //Considera o vetor[i] como menor
            menor = vetor[i];
            //Guarda a posição do vetor
            indiceMenor = i;
            //Percorre o vetor i + 1 até seu final
            for (int j = i + 1; j < vetor.length; j++) {
                //Compara posição por posição até encontrar a menor e define como menor
                if (vetor[j] < menor) {
                    menor = vetor[j];
                    indiceMenor = j;
                }
            }
            //Troca as posições
            vetor[indiceMenor] = vetor[i];
            vetor[i] = menor;
        }
        long t2 = System.nanoTime() - t1;
        System.out.println("Tempo " + t2 * Math.pow(10, -9) + " segundos");
    }

    public static void mergeSort(int[] vetor) {
        long t1 = System.nanoTime();
        //Variavel utilizada para percorrer o vetor. Inicializa com 1 para indicar que o vetor tenha pelo menos 1 elemento. 
        int elementos = 1;
        //Variaveis utilizadas para marcar o inicio, meio e fim do vetor. 
        int inicio, meio, fim;

        //Percorre os elementos do vetor até chegar no fim do vetor. 
        while (elementos < vetor.length) {
            //Aponta o inicio do vetor. 
            inicio = 0;

            //Percorre o vetor do inicio + quantidade de elementos ja percorrido, até o tamanho do vetor. 
            while (inicio + elementos < vetor.length) {
                //Guarda a posição do meio do vetor que será ordenado.
                meio = inicio + elementos;
                //Guarda a posição final do vetor que será ordenado.
                fim = inicio + 2 * elementos;

                //Caso o fim fique com um tamanho maior, que o tamanho do vetor, então faz o fim ter o mesmo tamanho que o tamanho do vetor. 
                if (fim > vetor.length) {
                    fim = vetor.length;
                }

                //Chama o método que faz a intercalação dos valores ordenados do vetor. 
                intercala(vetor, inicio, meio, fim);

                //Faz o inicio do vetor ser igual ao fim. 
                inicio = fim;
            }

            //Percorre o vetor dobrando a quantidade de itens ja ordenados. 
            elementos = elementos * 2;
        }
        long t2 = System.nanoTime() - t1;
        System.out.println("Tempo " + t2 * Math.pow(10, -9) + " segundos");
    }

    public static void intercala(int[] vetor, int inicio, int meio, int fim) {
        //Vetor utilizado para guardar os valors ordenados. 
        int novoVetor[] = new int[fim - inicio];
        //Variavel utilizada para guardar a posicao do inicio do vetor. 
        int i = inicio;
        //Variavel utilizada para guardar a posição do meio do vetor. 
        int m = meio;
        //Variavel utilizada para guarda a posição onde os valores serão inseridos no novo vetor. 
        int pos = 0;

        // Enquanto o inicio não chegar até seu fim, compara os valores entre o inicio e o meio, verificando em qual ordem vai guarda-los ordenado
        while (i < meio && m < fim) {
            // Se o vetor[i] for menor que o vetor[m], então guarda o valor do vetor[i] pois este é menor. 
            if (vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
                // Senão guarda o valor do vetor[m] pois este é o menor.
            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }

        // Adicionar no vetor os elementos que estão entre o inicio e meio,
        // que ainda não foram adicionados no vetor.
        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }

        // Adicionar no vetor os elementos que estão entre o meio e o fim,
        // que ainda não foram adicionados no vetor.
        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }
        // Coloca no vetor os valores já ordenados.
        for (pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }

    }

    //Método Auxiliar que irá fazer a chamada para QuickSort passando os parâmetros
    public static void quick(int[] vetor) {
        long t1 = System.nanoTime();

        quickSort(vetor, 0, vetor.length - 1);
        
        long t2 = System.nanoTime() - t1;
        System.out.println("Tempo " + t2 * Math.pow(10, -9) + " segundos");
    }

    //Método QuickSort
    public static void quickSort(int vetor[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        int pivo = vetor[(esq + dir) / 2];
        int troca;

        while (esq <= dir) {
            while (vetor[esq] < pivo) {
                esq = esq + 1;
            }
            while (vetor[dir] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda) {
            quickSort(vetor, esquerda, dir);
        }

        if (esq < direita) {
            quickSort(vetor, esq, direita);
        }

    }
}

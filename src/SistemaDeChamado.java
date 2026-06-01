package queue;

public class SistemaDeChamado {

    // Filas separadas por nível de prioridade (1 = mais alta, 5 = mais baixa)
    private static final int MAX_PRIORIDADE = 5;
    private LinkedListQueue<Chamado>[] filas;
    private long tamanho;

    @SuppressWarnings("unchecked")
    public SistemaDeChamado() {
        filas = new LinkedListQueue[MAX_PRIORIDADE + 1];
        for (int i = 1; i <= MAX_PRIORIDADE; i++) {
            filas[i] = new LinkedListQueue<>();
        }
        tamanho = 0;
    }

    /**
     * Adiciona um chamado na fila correspondente à sua prioridade.
     */
    public void adicionar(Chamado chamado) {
        int p = chamado.getPrioridade();
        if (p < 1 || p > MAX_PRIORIDADE) {
            throw new IllegalArgumentException(
                "Prioridade deve ser entre 1 e " + MAX_PRIORIDADE + ". Recebido: " + p);
        }
        filas[p].enqueue(chamado);
        tamanho++;
    }

    /**
     * Remove e retorna o próximo chamado (maior prioridade, menor número).
     * Em caso de empate de prioridade, respeita a ordem de chegada (FIFO).
     */
    public Chamado proximo() {
        for (int i = 1; i <= MAX_PRIORIDADE; i++) {
            if (!filas[i].isEmpty()) {
                tamanho--;
                return filas[i].dequeue();
            }
        }
        throw new EmptyQueueException();
    }

    /**
     * Retorna o próximo chamado sem removê-lo.
     */
    public Chamado consultarOProximo() {
        for (int i = 1; i <= MAX_PRIORIDADE; i++) {
            if (!filas[i].isEmpty()) {
                return filas[i].peek();
            }
        }
        throw new EmptyQueueException();
    }

    /**
     * Retorna o total de chamados em espera.
     */
    public long tamanho() {
        return tamanho;
    }
}
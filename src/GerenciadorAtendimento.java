package queue;

public class GerenciadorAtendimento {

    // Canais de filas baseados nos níveis (1 = Urgente, 5 = Baixo)
    private static final int LIMITE_PRIORIDADE = 5;
    private LinkedListQueue<TicketSuporte>[] canaisPrioridade;
    private long totalRegistros;

    @SuppressWarnings("unchecked")
    public GerenciadorAtendimento() {
        canaisPrioridade = new LinkedListQueue[LIMITE_PRIORIDADE + 1];
        for (int idx = 1; idx <= LIMITE_PRIORIDADE; idx++) {
            canaisPrioridade[idx] = new LinkedListQueue<>();
        }
        totalRegistros = 0;
    }

    /**
     * Registra um novo ticket no canal correspondente ao seu nível.
     */
    public void registrarTicket(TicketSuporte ticket) {
        int nivel = ticket.getNivelPrioridade();
        if (nivel < 1 || nivel > LIMITE_PRIORIDADE) {
            throw new IllegalArgumentException(
                "Nível de prioridade inválido (deve ser de 1 a " + LIMITE_PRIORIDADE + "). Informado: " + nivel);
        }
        canaisPrioridade[nivel].enqueue(ticket);
        totalRegistros++;
    }

    /**
     * Despacha e remove o próximo ticket com maior relevância.
     * Mantém o padrão FIFO (ordem de entrada) em casos de mesmo nível.
     */
    public TicketSuporte atenderProximo() {
        for (int idx = 1; idx <= LIMITE_PRIORIDADE; idx++) {
            if (!canaisPrioridade[idx].isEmpty()) {
                totalRegistros--;
                return canaisPrioridade[idx].dequeue();
            }
        }
        throw new EmptyQueueException();
    }

    /**
     * Espia o próximo ticket da fila sem removê-lo do sistema.
     */
    public TicketSuporte espiarProximo() {
        for (int idx = 1; idx <= LIMITE_PRIORIDADE; idx++) {
            if (!canaisPrioridade[idx].isEmpty()) {
                return canaisPrioridade[idx].peek();
            }
        }
        throw new EmptyQueueException();
    }

    /**
     * Retorna a quantidade total de tickets aguardando suporte.
     */
    public long obterTotal() {
        return totalRegistros;
    }
}
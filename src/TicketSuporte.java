package queue;

public class TicketSuporte {

    private int nivelPrioridade;
    private String detalheChamado;

    // Construtor com nomes de parâmetros alterados
    public TicketSuporte(int nivelPrioridade, String detalheChamado) {
        this.nivelPrioridade = nivelPrioridade;
        this.detalheChamado = detalheChamado;
    }

    // Getters com nomes modificados para combinar com os novos atributos
    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public String getDetalheChamado() {
        return detalheChamado;
    }

    // Método toString com formato visual e textos totalmente diferentes
    @Override
    public String toString() {
        return "Ticket [Prioridade=" + nivelPrioridade + " | Detalhes: " + detalheChamado + "]";
    }
}
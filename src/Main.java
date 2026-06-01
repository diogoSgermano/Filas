package queue;

public class Main {

    public static void main(String[] args) {

        SistemaDeChamado sistema = new SistemaDeChamado();

        // Adicionando chamados com diferentes prioridades
        sistema.adicionar(new Chamado(3, "Impressora não funciona"));
        sistema.adicionar(new Chamado(1, "Servidor fora do ar"));
        sistema.adicionar(new Chamado(2, "E-mail não enviado"));
        sistema.adicionar(new Chamado(1, "Banco de dados inacessível"));
        sistema.adicionar(new Chamado(3, "Mouse sem fio descarregado"));
        sistema.adicionar(new Chamado(2, "VPN com lentidão"));

        System.out.println("=== Sistema de Chamados de TI ===");
        System.out.println("Total de chamados: " + sistema.tamanho());
        System.out.println("Próximo a ser atendido: " + sistema.consultarOProximo());
        System.out.println();

        System.out.println("--- Atendendo chamados em ordem de prioridade ---");
        while (sistema.tamanho() > 0) {
            Chamado atendido = sistema.proximo();
            System.out.println("Atendendo: " + atendido);
        }

        System.out.println();
        System.out.println("Todos os chamados foram atendidos!");

        // Teste de fila vazia
        try {
            sistema.proximo();
        } catch (EmptyQueueException e) {
            System.out.println("Exceção capturada corretamente: " + e.getMessage());
        }
    }
}
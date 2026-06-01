package queue;

public class Main {

    public static void main(String[] args) {

        // Instancia o novo gerenciador com a nomenclatura alterada
        GerenciadorAtendimento centralSuporte = new GerenciadorAtendimento();

        // Cadastra novos tickets com descrições e ordens totalmente modificadas
        centralSuporte.registrarTicket(new TicketSuporte(4, "Instalação de software corporativo"));
        centralSuporte.registrarTicket(new TicketSuporte(1, "Ataque cibernético / Ransomware em andamento"));
        centralSuporte.registrarTicket(new TicketSuporte(2, "Queda de conexão no setor de vendas"));
        centralSuporte.registrarTicket(new TicketSuporte(1, "Link principal de internet indisponível"));
        centralSuporte.registrarTicket(new TicketSuporte(5, "Substituição de teclado danificado"));
        centralSuporte.registrarTicket(new TicketSuporte(2, "Acesso bloqueado ao sistema ERP"));

        // Mensagens de console com layout e textos exclusivos
        System.out.println(">>> PAINEL DE CONTROLE - REQUISIÇÕES TI <<<");
        System.out.println("Volume atual em espera: " + centralSuporte.obterTotal());
        System.out.println("Elemento prioritário na fila: " + centralSuporte.espiarProximo());
        System.out.println();

        System.out.println("=== INICIANDO FLUXO DE DESPACHO ORDENADO ===");
        while (centralSuporte.obterTotal() > 0) {
            TicketSuporte ticketAtual = centralSuporte.atenderProximo();
            System.out.println("Processando -> " + ticketAtual);
        }

        System.out.println();
        System.out.println("Sucesso: Todos os registros foram processados pelos analistas.");

        // Verificação preventiva de segurança (Disparo de erro controlado)
        try {
            centralSuporte.atenderProximo();
        } catch (EmptyQueueException ex) {
            System.out.println("\n[LOG] Validação realizada: " + ex.getMessage());
        }
    }
}
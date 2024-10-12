public class Pagamento {
    // Atributos
    private int IdPagamento;
    private String tipoPagamento; // cartao_credito, cartao_debito, boleto e pix
    private String dadosPagamento; // numero_cartao, vencimento, codigo_seguranca, parcelas...
    private String statusPagamento; // pendente, aprovado, recusado;

    // Getters and Setters
    public int getIdPagamento() {
        return IdPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        IdPagamento = idPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(String dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }



    // Outros métodos
    public void efetuarPagamento() {
        // Lógica de processamento do pagamento
        if (tipoPagamento.equals("Cartão de crédito") || tipoPagamento.equals("Cartão de débito")) {
            // Simulando aprovação de pagamento
            statusPagamento = "aprovado";
        } else if (tipoPagamento.equals("Boleto bancário") || tipoPagamento.equals("Pix")) {
            // Simulando aprovação de pagamento
            statusPagamento = "pendente";
        }
    }

    public void consultarPagamento() {
        // Verifica o status do pagamento (simulação)
        System.out.println("Status do pagamento: " + statusPagamento);
    }
}

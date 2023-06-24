package domain;

public class Servicos {
    private boolean incluirSeguro;
    private Integer tempoAluguel;
    private String formaPagamento;
    Carro carro;


    public Servicos(boolean incluirSeguro, Integer tempoAluguel, String formaPagamento) {
        this.incluirSeguro = incluirSeguro;
        this.tempoAluguel = tempoAluguel;
        this.formaPagamento = formaPagamento;
    }

    public boolean isIncluirSeguro() {
        return incluirSeguro;
    }

    public void setIncluirSeguro(boolean incluirSeguro) {
        this.incluirSeguro = incluirSeguro;
    }

    public Integer getTempoAluguel() {
        return tempoAluguel;
    }

    public void setTempoAluguel(Integer tempoAluguel) {
        this.tempoAluguel = tempoAluguel;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // Calculo preço aluguel
    public static Float precoAluguel(boolean incluirSeguro, Integer tempoAluguelCarro, Float precoAluguelCarro, Float precoSeguroCarro) {
        return incluirSeguro ? (tempoAluguelCarro * precoAluguelCarro) + precoSeguroCarro : tempoAluguelCarro * precoAluguelCarro;
        // return (tempoAluguelCarro * precoAluguelCarro) + precoSeguroCarro;
    }
}

package domain;

public class Servicos {
    private boolean incluirSeguro;
    private short tempoAluguel;
    Carro carro;

    public Servicos(boolean incluirSeguro, short tempoAluguel) {
        this.incluirSeguro = incluirSeguro;
        this.tempoAluguel = tempoAluguel;
    }

    public boolean isIncluirSeguro() {
        return incluirSeguro;
    }

    public void setIncluirSeguro(boolean incluirSeguro) {
        this.incluirSeguro = incluirSeguro;
    }

    public short getTempoAluguel() {
        return tempoAluguel;
    }

    public void setTempoAluguel(short tempoAluguel) {
        this.tempoAluguel = tempoAluguel;
    }

    // Calculo preço aluguel
    public float precoAluguel() {
        return tempoAluguel * carro.getPrecoAluguel() + carro.getPrecoSeguro();
    }
}

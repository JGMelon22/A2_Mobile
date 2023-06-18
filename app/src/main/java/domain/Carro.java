package domain;

public class Carro {
    private String nomeCarro, marcaCarro, corCarro;
    private int quantidadePassageiros;
    private float precoAluguel, precoSeguro;
    private boolean disponivel;

    // Construtor

    public Carro() {
    }

    public Carro(String nomeCarro, String marcaCarro, String corCarro, int quantidadePassageiros, float precoSeguro, float precoAluguel, boolean disponivel) {
        this.nomeCarro = nomeCarro;
        this.marcaCarro = marcaCarro;
        this.corCarro = corCarro;
        this.quantidadePassageiros = quantidadePassageiros;
        this.precoSeguro = precoSeguro;
        this.precoAluguel = precoAluguel;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nomeCarro) {
        this.nomeCarro = nomeCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getCorCarro() {
        return corCarro;
    }

    public void setCorCarro(String corCarro) {
        this.corCarro = corCarro;
    }

    public float getPrecoSeguro() {
        return precoSeguro;
    }

    public void setPrecoSeguro(float precoSeguro) {
        this.precoSeguro = precoSeguro;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public float getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(float precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

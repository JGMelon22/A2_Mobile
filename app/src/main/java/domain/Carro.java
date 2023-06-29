package domain;

import java.io.Serializable;

public class Carro implements Serializable {
    private String nomeCarro, marcaCarro, corCarro;
    private int quantidadePassageiros;
    private float precoAluguel, precoSeguro;
    private boolean disponivel;
    private int imagem;

    // Construtor

    public Carro() {
    }

    public Carro(String nomeCarro, String marcaCarro, String corCarro, int quantidadePassageiros, float precoAluguel, float precoSeguro, boolean disponivel) {
        this.nomeCarro = nomeCarro;
        this.marcaCarro = marcaCarro;
        this.corCarro = corCarro;
        this.quantidadePassageiros = quantidadePassageiros;
        this.precoAluguel = precoAluguel;
        this.precoSeguro = precoSeguro;
        this.disponivel = disponivel;
        //this.imagem = imagem;
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

    public String getStringPrecoAluguel() {
        return String.valueOf(precoAluguel);
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

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}

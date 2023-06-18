package domain;

public class CarroGolf extends Carro {
    private final String nomeCarro = "Golf";
    private final String marcaCarro = "Volkswagen";
    private final String corCarro = "Branco";
    private final int quantidadePassageiros = 5;
    private final float precoAluguel = 562.00F;
    private final float precoSeguro = 275.00F;
    private final boolean disponivel = true;

    public CarroGolf(String nomeCarro, String marcaCarro, String corCarro, int quantidadePassageiros, float precoSeguro, float precoAluguel, boolean disponivel) {
        super(nomeCarro, marcaCarro, corCarro, quantidadePassageiros, precoSeguro, precoAluguel, disponivel);
    }

    @Override
    public String getNomeCarro() {
        return nomeCarro;
    }

    @Override
    public String getMarcaCarro() {
        return marcaCarro;
    }

    @Override
    public String getCorCarro() {
        return corCarro;
    }

    @Override
    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    @Override
    public float getPrecoAluguel() {
        return precoAluguel;
    }

    @Override
    public float getPrecoSeguro() {
        return precoSeguro;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }
}

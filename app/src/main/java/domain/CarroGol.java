package domain;

public class CarroGol extends Carro {
    private final String nomeCarro = "Gol";
    private final String marcaCarro = "Volkswagen";
    private final String corCarro = "Vermelho";
    private final int quantidadePassageiros = 5;
    private final float precoAluguel = 90.00F;
    private final float precoSeguro = 166.00F;
    private final boolean disponivel = true;

    public CarroGol(String nomeCarro, String marcaCarro, String corCarro, int quantidadePassageiros, float precoSeguro, float precoAluguel, boolean disponivel) {
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


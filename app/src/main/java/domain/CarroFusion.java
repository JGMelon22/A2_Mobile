package domain;

public class CarroFusion extends Carro {
    private static final String nomeCarro = "Ford Fusion";
    private static final String marcaCarro = "Ford";
    private static final String corCarro = "Azul";
    private static final int quantidadePassageiros = 5;
    private static final float precoAluguel = 700.00F;
    private static final float precoSeguro = 441.00F;
    private static final boolean disponivel = true;

    public CarroFusion() {
        super(nomeCarro, marcaCarro, corCarro, quantidadePassageiros, precoAluguel, precoSeguro, disponivel);
    }

    public CarroFusion(String nomeCarro, String marcaCarro, String corCarro, int quantidadePassageiros, float precoSeguro, float precoAluguel, boolean disponivel) {
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

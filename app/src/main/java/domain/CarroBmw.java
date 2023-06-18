package domain;

public class CarroBmw extends Carro{

    private final String nomeCarro = "BMW i8";
    private final String marcaCarro = "BMW";
    private final String corCarro = "Laranja";
    private final int quantidadePassageiros = 2;
    private final float precoAluguel = 3500.00F;
    private final float precoSeguro = 2896.00F;
    private final boolean disponivel = true;

    public CarroBmw(String nomeCarro, String marcaCarro, String corCarro, int quantidadePassageiros, float precoSeguro, float precoAluguel, boolean disponivel) {
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

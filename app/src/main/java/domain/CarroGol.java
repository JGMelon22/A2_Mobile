package domain;

import com.example.aplicacaonave.R;

public class CarroGol extends Carro {
    private static final String nomeCarro = "Gol";
    private static final String marcaCarro = "Volkswagen";
    private static final String corCarro = "Vermelho";
    private static final int quantidadePassageiros = 5;
    private static final float precoAluguel = 90.00F;
    private static final float precoSeguro = 166.00F;
    private static final boolean disponivel = true;
    private static final int imagem = R.drawable.gol;

    public CarroGol() {
        super(nomeCarro, marcaCarro, corCarro, quantidadePassageiros, precoAluguel, precoSeguro, disponivel);
    }

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

    @Override
    public int getImagem(){
        return imagem;
    }

}


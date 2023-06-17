package service;

import java.util.Random;

public class MockAlugueisService {
    public short gerarQuantidadeAlugueisDiarios() {

        short minValue = 60;
        short maxValue = 1200;

        Random random = new Random();
        return (short) (random.nextInt(maxValue - minValue + 1) + minValue);
    }
}

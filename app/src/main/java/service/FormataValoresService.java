package service;

import java.text.NumberFormat;
import java.util.Locale;

public class FormataValoresService {
    public static String formataPreco(Float precoCarro) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(precoCarro);
    }

    // Formata CPF
    public static String formataCpf(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    // Formata CNPJ
    public static String formataCnpj(String cnpj) {
        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
    }

    // TODO - Formata CEP: precisa constar 8 números na editTextNumber e criar um método com substring, similar da formatCpf
    public static String formataCep(String cep) {
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }
}

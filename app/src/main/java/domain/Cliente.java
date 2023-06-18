package domain;

public class Cliente {
    private String nomeCompleto;
    private String cpfCnpj; // 11 ou 14 caracteres
    private String cep; // 8 caracteres
    private Character sexo; // F ou M
    private String numeroCnh; // 12 caracteres (sem mascara de formatação)

    // Sem sexo
    public Cliente(String nomeCompleto, String cpfCnpj, String cep, String numeroCnh) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.cep = cep;
        this.numeroCnh = numeroCnh;
    }

    // Construtor
    public Cliente(String nomeCompleto, String cpfCnpj, String cep, Character sexo, String numeroCnh) {
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.cep = cep;
        this.sexo = sexo;
        this.numeroCnh = numeroCnh;
    }

    // Getters
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getCep() {
        return cep;
    }

    public Character getSexo() {
        return sexo;
    }

    public String getNumeroCnh() {
        return numeroCnh;
    }

    // Setters
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setNumeroCnh(String numeroCnh) {
        this.numeroCnh = numeroCnh;
    }
}
package br.ucsal.mobile.medicamentos;

public class Medicamentos {

    private String nome;
    private String dosagem;
    private String frequencia;


    public Medicamentos(String nome, String dosagem, String frequencia) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
    }
    public Medicamentos(String nome, String frequencia) {
        this.nome = nome;
        this.frequencia = frequencia;

    }
        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

}


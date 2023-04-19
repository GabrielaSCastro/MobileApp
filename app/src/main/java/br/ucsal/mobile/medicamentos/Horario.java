package br.ucsal.mobile.medicamentos;

public class Horario {
    private int hora;
    private int minuto;

    //colocar checkbox e se marcada adicionar a um contador de "tomados"
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Horario(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
}

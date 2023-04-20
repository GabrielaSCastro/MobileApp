package br.ucsal.mobile.medicamentos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//Mostra as informações do medicamento selecionado
public class MostrarMedicamentoActivity extends AppCompatActivity {

    private DBHelper DB;
    private ArrayList<Medicamentos> lista;
    private Medicamentos medicamento;
    private TextView nome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_med);
        getSupportActionBar().hide();
        int posicao = getIntent().getIntExtra("posição",0);
        System.out.println(posicao);
        DB= new DBHelper(this);
        lista= DB.listaMed();
        medicamento= lista.get(posicao);

        nome= findViewById(R.id.mostrar_nome);
        nome.setText(medicamento.getNome());
    }
}

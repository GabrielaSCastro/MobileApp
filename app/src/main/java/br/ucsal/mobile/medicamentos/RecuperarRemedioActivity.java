package br.ucsal.mobile.medicamentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecuperarRemedioActivity extends AppCompatActivity {

        private TextView nomeInserido, nome, frequencia, dosagem, horario;
        private Button excluir, editar, buscar;
        private FloatingActionButton voltar;
        private DBHelper DB;
        private ArrayList<String> medicamento;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_remedio);
        getSupportActionBar().hide();

        nome = findViewById(R.id.recuperar_nome);
        frequencia = findViewById(R.id.recuperar_frequencia);
        dosagem = findViewById(R.id.recuperar_dosagem);
        horario = findViewById(R.id.recuperar_horario);
        nomeInserido = findViewById(R.id.inserir_nome);
        DB= new DBHelper(this);

        buscar = findViewById(R.id.recuperar_button_buscar);
        excluir = findViewById(R.id.recuperar_excluir);
        editar = findViewById(R.id.recuperar_editar);
        voltar = findViewById(R.id.recuperar_voltar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medicamento= DB.ViewMedicamento(nomeInserido.getText().toString());
                nome.setText(medicamento.get(0));
                frequencia.setText(medicamento.get(1));
                dosagem.setText(medicamento.get(2));
                horario.setText(medicamento.get(3));
            }

        });
        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.deleteData(String.valueOf(nomeInserido.getText()));
                Intent intent = new Intent(RecuperarRemedioActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(RecuperarRemedioActivity.this, "Medicamento excluido.", Toast.LENGTH_SHORT).show();
            }
        });
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecuperarRemedioActivity.this,EditarMedicamento.class);
                intent.putExtra("Nome do remedio", String.valueOf(nomeInserido.getText()));
                startActivity(intent);
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}

package br.ucsal.mobile.medicamentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EditarMedicamento extends AppCompatActivity {
    private TextView nome, dosagem, frequencia, horario;
    private Button salvar, voltar;
    private DBHelper DB;
    private ArrayList<String> medicamento;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_editar_medicamento);
        getSupportActionBar().hide();
        DB= new DBHelper(this);

        nome = findViewById(R.id.editar_nome);
        dosagem = findViewById(R.id.editar_Dosagem);
        frequencia = findViewById(R.id.editar_frequencia);
        horario = findViewById(R.id.editar_horario);

        String valor = getIntent().getStringExtra("Nome do remedio");
        nome.setText(valor);
        medicamento= DB.ViewMedicamento(nome.getText().toString());
        nome.setText(medicamento.get(0));
        frequencia.setText(medicamento.get(1));
        dosagem.setText(medicamento.get(2));
        horario.setText(medicamento.get(3));


        salvar = findViewById(R.id.editar_button_salvar);
        voltar = findViewById(R.id.editar_button_voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditarMedicamento.this, "Medicamento não editado.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checkUpdateData=DB.updateData(nome.getText().toString(),frequencia.getText().toString(),dosagem.getText().toString(),horario.getText().toString());
                if(checkUpdateData) {
                    Toast.makeText(EditarMedicamento.this, "Medicamento editado com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditarMedicamento.this, "Medicamento não foi editado.", Toast.LENGTH_SHORT).show();
                }
                Intent intent= new Intent(EditarMedicamento.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

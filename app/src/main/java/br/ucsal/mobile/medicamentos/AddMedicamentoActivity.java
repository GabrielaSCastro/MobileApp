package br.ucsal.mobile.medicamentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class AddMedicamentoActivity extends AppCompatActivity {
    private TextView nomeTextView;
    private TextView dosagemTextView;
    private TextView frequenciaTextView;
    private TextView horarioTextView;
    private FloatingActionButton voltar;
    private Button adicionar;
    private  DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_med);
        DB= new DBHelper(this);

        nomeTextView = findViewById(R.id.add_nome_remedio);
        dosagemTextView = findViewById(R.id.add_Dosagem);
        frequenciaTextView = findViewById(R.id.add_frequencia);
        horarioTextView=findViewById(R.id.add_horario);
        voltar = findViewById(R.id.add_button_voltar);
        adicionar = findViewById(R.id.add_button_proximo);

       //volta a tela inicial
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddMedicamentoActivity.this, "Medicamento não foi cadastrado.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        //adiciona novo medicamento no banco
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checkInsertData = DB.insertData(nomeTextView.getText().toString(),frequenciaTextView.getText().toString(),dosagemTextView.getText().toString()
                        ,horarioTextView.getText().toString());
                if(checkInsertData) {
                    Toast.makeText(AddMedicamentoActivity.this, "Medicamento cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddMedicamentoActivity.this, "Medicamento não foi cadastrado.", Toast.LENGTH_SHORT).show();
                }
                 Intent intent= new Intent(AddMedicamentoActivity.this,MainActivity.class);
                 startActivity(intent);
            }
        });



    }
}

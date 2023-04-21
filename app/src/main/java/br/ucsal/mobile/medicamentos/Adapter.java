package br.ucsal.mobile.medicamentos;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

//classe Adapter do RecyclerView da tela principal
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Medicamentos> listaMedicamentos;
    public Adapter(List<Medicamentos> lista){
        this.listaMedicamentos= lista;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_medicamentos_item,parent,false);

        return new MyViewHolder(itemLista);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,  int position) {
        Medicamentos medicamento = listaMedicamentos.get(position);
        holder.nomeMedicamento.setText(medicamento.getNome());
    }

    @Override
    public int getItemCount() {

        return listaMedicamentos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nomeMedicamento;
        CheckBox checkTomados;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeMedicamento = itemView.findViewById(R.id.Main_NomeRemedio);
            checkTomados = itemView.findViewById(R.id.Main_Checkbox);
        }
    }
}

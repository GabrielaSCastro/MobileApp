package br.ucsal.mobile.medicamentos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Medicamentos(nome TEXT primary key, frequencia TEXT, dosagem TEXT, horario TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists Medicamentos");
    }

    public Boolean insertData(String nome, String frequencia, String dosagem, String horario) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", nome);
        contentValues.put("frequencia", frequencia);
        contentValues.put("dosagem", dosagem);
        contentValues.put("horario", horario);
        long result = DB.insert("Medicamentos", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateData(String nome, String frequencia, String dosagem, String horario) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("frequencia", frequencia);
        contentValues.put("dosagem", dosagem);
        contentValues.put("horario", horario);

        Cursor cursor = DB.rawQuery("Select * from Medicamentos where nome = ?", new String[] {nome});
        if(cursor.getCount() > 0) {
            long result = DB.update("Medicamentos", contentValues, "nome=?", new String[] {nome});
            return result != -1;
        } else {
            return false;
        }

    }

    public Boolean deleteData(String nome) {

        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Medicamentos where nome = ?", new String[] {nome});
        if(cursor.getCount() > 0) {
            long result = DB.delete("Medicamentos", "nome = ?", new String[] {nome});
            return result != -1;
        } else {
            return false;
        }

    }

    public Cursor getData() {

        SQLiteDatabase DB = this.getWritableDatabase();

        return DB.rawQuery("Select * from Medicamentos", null);
    }
    public ArrayList<Medicamentos> listaMed() {
        ArrayList<Medicamentos> medicamentos = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT nome, frequencia FROM Medicamentos", null);

        while(cursor.moveToNext()) {
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String frequencia = cursor.getString(cursor.getColumnIndex("frequencia"));
            Medicamentos medicamento = new Medicamentos(nome, frequencia);
            medicamentos.add(medicamento);
        }
        return medicamentos;
    }
    public ArrayList<String> ViewMedicamento(String nome){
        ArrayList<String> medicamento = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from Medicamentos where nome = ?", new String[] {nome});
        String nomeView="", frequenciaView="", dosagemView="", horarioView="";
        while (cursor.moveToNext()){
             nomeView= cursor.getString(0).toString();
             frequenciaView = cursor.getString(1).toString();
             dosagemView = cursor.getString(2).toString();
             horarioView = cursor.getString(3).toString();
        }
        medicamento.add(nomeView);
        medicamento.add(frequenciaView);
        medicamento.add(dosagemView);
        medicamento.add(horarioView);
        return medicamento;
    }
}

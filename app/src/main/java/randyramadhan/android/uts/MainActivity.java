package randyramadhan.android.uts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] listJurusan = {
            "-- Pilih Jurusan --",
            "Sistem Informasi",
            "Manajemen Informatika",
            "Teknik Informatika",
            "Robotika Genetik"
    };
    String strJurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerJurusan = findViewById(R.id.id_jurusan);

        final ArrayAdapter<String> dataJurusan = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listJurusan);
        spinnerJurusan.setAdapter(dataJurusan);
        spinnerJurusan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String item = String.valueOf(spinnerJurusan.getSelectedItem());
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strJurusan = (item.equals(spinnerJurusan.getSelectedItem())) ? "" : parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        Button btnSubmit = findViewById(R.id.btn_daftar);
        btnSubmit.setOnClickListener(new MainActivity.submitForm());

        Button btnExit = findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(new MainActivity.SubmitExit());
    }




    private class submitForm implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText textNPM = findViewById(R.id.id_npm);
            EditText textNama = findViewById(R.id.id_nama);


            Toast data = Toast.makeText(getApplicationContext(), "Anda Memilih : " + strJurusan
                    , Toast.LENGTH_LONG);
            data.show();

        }
    }

    public class SubmitExit implements View.OnClickListener {



        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Keluar Dari Aplikasi?")
                    .setCancelable(false)
                    .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();

            alert.show();
        }
    }
}
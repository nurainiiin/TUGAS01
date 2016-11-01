package id.sch.smktelkom_mlg.learn.form2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etAlamat;
    RadioButton rbP, rbL;
    Spinner spJK;
    CheckBox cb1, cb2, cb3, cb4;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        rbL = (RadioButton) findViewById(R.id.radioButtonL);
        spJK = (Spinner) findViewById(R.id.spinnerJK);
        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) ;

                String nama = etNama.getText().toString();
                String alamat = etAlamat.getText().toString();

                String hasil1 = null;
                if (rbP.isChecked()) {
                    hasil1 = rbP.getText().toString();
                } else if (rbL.isChecked()) {


                    hasil1 = rbP.getText().toString();
                }
                String hasil2 = "\n\nKegiatan yang ingin diikuti:\n";
                int starlen = hasil2.length();
                if (cb1.isChecked()) hasil2 += cb1.getText() + "\n";
                if (cb2.isChecked()) hasil2 += cb2.getText() + "\n";
                if (cb3.isChecked()) hasil2 += cb3.getText() + "\n";
                if (cb4.isChecked()) hasil2 += cb4.getText() + "\n";

                if (hasil2.length() == starlen) hasil2 += "Belum Pernah Memilih";


                tvHasil.setText("Nama:\n" + nama + "\n\nAlamat:\n" + alamat + "\n\nAsal:\n" +
                        spJK.getSelectedItem() +
                        "\n\nJenis Kelamin: \n" + hasil1 + hasil2);
            }
        });

    }

    private boolean isValid() {

        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();

        if (nama.isEmpty()) {

            etNama.setError("Anda Belum Mengisi Nama");
        } else if (nama.length() < 8) {
            etNama.setError("Minimal 8 Karakter");
        } else {
            etNama.setError(null);
        }
        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum Diisi");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        return valid;
    }
}

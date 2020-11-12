package id.dicoding.mirel.dts_ujianpraktek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class add_data extends AppCompatActivity {
    EditText textnama,textalamat;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        textnama =findViewById(R.id.txtnama);
        textalamat =findViewById(R.id.txtalamat);
        hasil =findViewById(R.id.view_dong);
    }
    public void TampilNama(View v){
        hasil.setText("nama anda :"+textnama.getText()+"   alamat Anda:"+textalamat.getText());

    }
}

package id.dicoding.mirel.dts_ujianpraktek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class view_sqllite extends AppCompatActivity {

        Button btnbuat, btnread;
        private EditText editname;
        private DbHelper DbHelper;
        private TextView tv_baca;
        private ArrayList<String> arrayList;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_sqllite);
            DbHelper = new DbHelper(this);
            tv_baca = (TextView) findViewById(R.id.tv_read);
            btnbuat = (Button) findViewById(R.id.btnbuat);
            btnread = (Button) findViewById(R.id.btnread);
            editname = (EditText) findViewById(R.id.edit_nama);

            btnbuat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DbHelper.adddetail(editname.getText().toString());
                    editname.setText("");
                    Toast.makeText(view_sqllite.this,
                            "penyimpanan berhasil",
                            Toast.LENGTH_SHORT).show();
                }
            });

            btnread.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arrayList = DbHelper.getStudent();
                    tv_baca.setText("");
                    for(int i = 0 ; i<arrayList.size();i++){
                        tv_baca.setText(tv_baca.getText().toString()+", "+arrayList.get(i));
                    }
                }
            });
        }
    }
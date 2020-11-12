package id.dicoding.mirel.dts_ujianpraktek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button add,view,maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);
        view = (Button)findViewById(R.id.view);
        view.setOnClickListener(this);
        maps = (Button)findViewById(R.id.maps);
        maps.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add:
                Intent moveinputintent = new Intent(MainActivity.this,add_data.class);
                startActivity(moveinputintent);
                break;

            case R.id.view:
                Intent movekalkulaorintent = new Intent(MainActivity.this,view_sqllite.class);
                startActivity(movekalkulaorintent);
                break;

            case R.id.maps:
                Intent movenegaraintent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(movenegaraintent);
                break;
        }
    }
}

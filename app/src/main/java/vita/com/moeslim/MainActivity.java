package vita.com.moeslim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ImageView btn_doa;
    private ImageView btn_sholat;
    private ImageView btn_halal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_doa = (ImageView) findViewById(R.id.Doa);
        btn_doa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DoaHarian.class);
                startActivity(intent);
            }
        });

        btn_sholat = (ImageView) findViewById(R.id.sholat);
        btn_sholat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JadwalSholat.class);
                startActivity(intent);
            }
        });

        btn_halal = (ImageView) findViewById(R.id.produk);
        btn_halal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Halal.class);
                startActivity(intent);
            }
        });
    }
}








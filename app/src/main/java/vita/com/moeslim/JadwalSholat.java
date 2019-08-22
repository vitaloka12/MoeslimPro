package vita.com.moeslim;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JadwalSholat extends AppCompatActivity {
    private ArrayList<Kota> listKota;
    private ArrayAdapter<Kota> mKotaAdapter;
    private Spinner spKota;
    private TextView tvTanggal;
    private TextView tvSubuh;
    private TextView tvDzuhur;
    private TextView tvAsar;
    private TextView tvMaghrib;
    private TextView tvIsya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_sholat);

        spKota= (Spinner)findViewById(R.id.kota);
        tvTanggal=(TextView)findViewById(R.id.tv_tanggal);
        tvSubuh=(TextView)findViewById(R.id.tv_subuh);
        tvDzuhur=(TextView)findViewById(R.id.tv_Dzuhur);
        tvAsar=(TextView)findViewById(R.id.tv_asar);
        tvMaghrib=(TextView)findViewById(R.id.tv_maghrib);
        tvIsya=(TextView)findViewById(R.id.tv_isya);

        listKota = new ArrayList<Kota>();
        mKotaAdapter = new ArrayAdapter<Kota>(this,
                android.R.layout.simple_spinner_item, listKota);

        mKotaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(mKotaAdapter);
        spKota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Kota kota = mKotaAdapter.getItem(position);
                loadJadwal(kota.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        loadKota();
    }

    private void loadJadwal(int id) {
        try {
            String id_kota = String.valueOf(id);

            SimpleDateFormat current = new SimpleDateFormat("yyy-MM-dd");
            String tanggal = current.format(new Date());

            String api_url = "/jadwal/kota/"+id_kota+"/tanggal/"+tanggal;
            ClientAsyncTask task = new ClientAsyncTask(this, api_url, new ClientAsyncTask.OnPostExecuteListener() {
                @Override
                public void OnPostExecute(String result) {

                    Log.d("JadwalData", result);
                    try {
                        JSONObject jsonObj = new JSONObject(result);
                        JSONObject objJadwal = jsonObj.getJSONObject("jadwal");
                        JSONObject obData = objJadwal.getJSONObject("data");

                        tvTanggal.setText(obData.getString("tanggal"));
                        tvSubuh.setText(obData.getString("subuh"));
                        tvDzuhur.setText(obData.getString("dzuhur"));
                        tvAsar.setText(obData.getString("ashar"));
                        tvMaghrib.setText(obData.getString("maghrib"));
                        tvIsya.setText(obData.getString("isya"));

                        Log.d("dataJadwal", obData.toString());
                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            task.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadKota() {
        try {
            String api = "/Kota";
            ClientAsyncTask task = new ClientAsyncTask(this, api, new ClientAsyncTask.OnPostExecuteListener() {
                @Override
                public void OnPostExecute(String result) {
                            Log.d("kotadata", result);
                            try {
                                JSONObject jsonObj= new JSONObject(result);
                                JSONArray jsonArray = jsonObj.getJSONArray("kota");
                                Kota kota = null;

                                for (int i=0; i<jsonArray.length(); i++){
                                    JSONObject obj= jsonArray.getJSONObject(i);
                                    kota = new Kota();
                                    kota.setId(obj.getInt("id"));
                                    kota.setNama(obj.getString("nama"));
                                    listKota.add(kota);

                                }
                                mKotaAdapter.notifyDataSetChanged();
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            task.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

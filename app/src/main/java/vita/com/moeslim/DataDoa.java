package vita.com.moeslim;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class DataDoa extends AppCompatActivity {

    private TextView Getdoa, Getarab, Getbaca, Getarti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_doa);

        getSupportActionBar().setTitle("Doa Harian");
        Getdoa = findViewById(R.id.getdoa);
        Getarab = findViewById(R.id.getarab);
        Getbaca = findViewById(R.id.getbaca);
        Getarti = findViewById(R.id.getarti);
        showData();
    }

    @SuppressLint("SetTextI18n")
    private void showData() {
        String doa = getIntent().getExtras().getString("MyName");

        switch (doa) {
            case "Doa Masuk Masjid":
                Getdoa.setText("Doa Masuk Masjid");
                Getarab.setText("اَللّهُمَّ افْتَحْ لِيْ اَبْوَابَ رَحْمَتِكَ");
                Getbaca.setText("Allahummaf-tahlii abwaaba rahmatika");
                Getarti.setText("Ya Allah, bukakanlah untukku pintu-pintu rahmat-Mu");
                break;

            case "Doa Keluar Masjid":
                Getdoa.setText("Doa Keluar Masjid");
                Getarab.setText("اَللّهُمَّ اِنِّيْ أسْأَلُكَ مِنْ فَضْلِكََ");
                Getbaca.setText("Allahumma innii as-aluka min fadhlik");
                Getarti.setText("Ya Allah, sesungguhnya aku memohon kepada-Mu atas segala keutamaan dari-Mu");
                break;

            case "Doa Masuk Rumah":
                Getdoa.setText("Doa Masuk Rumah");
                Getarab.setText("اَللّٰهُمَّ اِنِّىْ اَسْأَلُكَ خَيْرَالْمَوْلِجِ وَخَيْرَالْمَخْرَجِ بِسْمِ اللهِ وَلَجْنَا وَبِسْمِ اللهِ خَرَجْنَا وَعَلَى اللهِ رَبِّنَا تَوَكَّلْنَاَ");
                Getbaca.setText("Allahumma innii as-aluka khoirol mauliji wa khoirol makhroji bismillaahi wa lajnaa wa bismillaahi khorojnaa wa’alallohi robbina tawakkalnaa");
                Getarti.setText("Ya Allah, sesungguhnya aku mohon kepada-Mu baiknya tempat masuk dan baiknya tempat keluar dengan menyebut nama Allah kami masuk, dan dengan menyebut nama Allah kami keluar dan kepada Allah Tuhan kami, kami bertawakkal");
                break;

            case "Doa Keluar Rumah":
                Getdoa.setText("Doa Keluar Rumah");
                Getarab.setText("اللَّهُمَّ إِنِّى أَعُوذُ بِكَ أَنْ أَضِلَّ أَوْ أُضَلَّ أَوْ أَزِلَّ أَوْ أُزَلَّ أَوْ أَظْلِمَ أَوْ أُظْلَمَ أَوْ أَجْهَلَ أَوْ يُجْهَلَ عَلَىََّ");
                Getbaca.setText("Allahumma inni a-’udzu bika an adhilla aw udholla, aw azilla aw uzalla, aw azhlima aw uzhlama, aw ajhala aw yujhala ‘alayya");
                Getarti.setText("Ya Allah, aku berlindung kepada-Mu dari: aku tersesat, atau aku menyesatkan, atau aku tergelincir, atau aku digelincirkan, atau aku mendhalimi, atau aku didhalimi, atau kebodohanku atau dibodohi");
                break;


            case "Doa Kedua Orang Tua":
                Getdoa.setText("Doa Kedua Orang Tua");
                Getarab.setText("اللَّهُمَّ اغْفِرْ لِى وَلِوَ الِدَىَّ وَارْ حَمْهُمَا كَمَا رَبَّيَا نِى صَغِيْرًاََ");
                Getbaca.setText("Allahumma fighfirlii wa liwaa lidhayya warham humaa kamaa rabbayaa nii shokhiroon");
                Getarti.setText(" Ya Allah, ampunilah aku dan kedua orang tuaku, baik ibu dan bapakku, kasihanilah keduanya seperti mereka menyayangiku di waktu kecil.");
        }
    }
}

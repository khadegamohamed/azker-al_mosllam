package com.example.azkeral_moslam;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class sleep extends AppCompatActivity {
    RecyclerView rvv;
    Button sleeptimer;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        rvv = findViewById(R.id.sleep);
        sleeptimer = findViewById(R.id.sleeptimer);
        sleeptimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sleeptimer = new Intent(sleep.this,sleeptimer.class);
                startActivity(sleeptimer);
            }
        });
        ArrayList<imageazker> listimage = new ArrayList<>();
        ArrayList<String> listazker = new ArrayList<>();
        listimage.add(new imageazker(R.drawable.almolk, "قراءه سوره الملك "));
        listimage.add(new imageazker(R.drawable.molk2, "قراءه سوره الملك "));
        listimage.add(new imageazker(R.drawable.molk3, "قراءه سوره الملك "));
        listimage.add(new imageazker(R.drawable.charr, "آية الكرسى"));
        listimage.add(new imageazker(R.drawable.almaostan, "يجمع كفيه ثم ينفث فيهما والقراءة فيهما\u200F:\u200F \u200F{\u200Fقل هو الله أحد\u200F}\u200F و\u200F{\u200Fقل أعوذ برب الفلق\u200F}\u200F و\u200F{\u200Fقل أعوذ برب الناس\u200F}\u200F ومسح ما استطاع من الجسد يبدأ بهما على رأسه ووجه وما أقبل من جسد "));
        listimage.add(new imageazker(R.drawable.bakara, " من قرأ آيتين من آخر سورة البقرة في ليلة كفتاه.\n" +
                "\n"));
        listazker.add("«بِاسْمِكَ رَبِّـي وَضَعْـتُ جَنْـبي، وَبِكَ أَرْفَعُـه، فَإِن أَمْسَـكْتَ نَفْسـي فارْحَـمْها ، وَإِنْ أَرْسَلْتَـها فاحْفَظْـها بِمـا تَحْفَـظُ بِه عِبـادَكَ الصّـالِحـين». (مرة واحدة)");
        listazker.add("«اللّهُـمَّ قِنـي عَذابَـكَ يَـوْمَ تَبْـعَثُ عِبـادَك». (مرة واحدة).");
        listazker.add("«الـحَمْدُ للهِ الَّذي أَطْـعَمَنا وَسَقـانا، وَكَفـانا، وَآوانا، فَكَـمْ مِمَّـنْ لا كـافِيَ لَـهُ وَلا مُـؤْوي». (مرة واحدة)");
        listazker.add("«اللّهُـمَّ أَسْـلَمْتُ نَفْـسي إِلَـيْكَ، وَفَوَّضْـتُ أَمْـري إِلَـيْكَ، وَوَجَّـهْتُ وَجْـهي إِلَـيْكَ، وَأَلْـجَـاْتُ ظَهـري إِلَـيْكَ، رَغْبَـةً وَرَهْـبَةً إِلَـيْكَ، لا مَلْجَـأَ وَلا مَنْـجـا مِنْـكَ إِلاّ إِلَـيْكَ، آمَنْـتُ بِكِتـابِكَ الّـذي أَنْزَلْـتَ وَبِنَبِـيِّـكَ الّـذي أَرْسَلْـت». (مرة واحدة)");
        listazker.add("«اللّهُـمَّ إِنَّـكَ خَلَـقْتَ نَفْسـي وَأَنْـتَ تَوَفّـاهـا لَكَ ممَـاتـها وَمَحْـياها، إِنْ أَحْيَيْـتَها فاحْفَظْـها، وَإِنْ أَمَتَّـها فَاغْفِـرْ لَـها. اللّهُـمَّ إِنَّـي أَسْـأَلُـكَ العـافِـيَة». (مرة واحدة)\n" +
                "\n");
        listazker.add("سُبْحَانَ اللَّهِ (33 مرة)");
        listazker.add("الْحَمْدُ لِلَّهِ (33 مرة)");
        listazker.add("اللَّهُ أَكْبَرُ (34 مرة)");
        listazker.forEach(s -> listimage.add(new imageazker(-1,s)));
AzkarListAdapter adeptter = new AzkarListAdapter(listimage);
        RecyclerView.LayoutManager im = new LinearLayoutManager(this);
        rvv.setLayoutManager(im);
rvv.setAdapter(adeptter);
        rvv.setHasFixedSize(true);


    }
}
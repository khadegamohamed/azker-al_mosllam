package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.os.Bundle;

import java.sql.Array;
import java.util.ArrayList;

public class Morning extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);
        rv = findViewById(R.id.morring);

        ArrayList<String> arraytext = new ArrayList<>();
        arraytext.add("أَصبَحْنا على فِطرةِ الإسلامِ، وعلى كَلِمةِ الإخلاصِ، وعلى دِينِ نَبيِّنا محمَّدٍ صلَّى اللهُ عليه وسلَّمَ، وعلى مِلَّةِ أبِينا إبراهيمَ، حَنيفًا مُسلِمًا، وما كان مِنَ المُشرِكين");
        arraytext.add(" أَصْـبَحْنا وَأَصْـبَحَ المُـلْكُ لله وَالحَمدُ لله ، لا إلهَ إلاّ اللّهُ وَحدَهُ لا شَريكَ لهُ، لهُ المُـلكُ ولهُ الحَمْـد، وهُوَ على كلّ شَيءٍ قدير ، رَبِّ أسْـأَلُـكَ خَـيرَ ما في هـذا اليوم وَخَـيرَ ما بَعْـدَه ، وَأَعـوذُ بِكَ مِنْ شَـرِّ ما في هـذا اليوم وَشَرِّ ما بَعْـدَه، رَبِّ أَعـوذُبِكَ مِنَ الْكَسَـلِ وَسـوءِ الْكِـبَر ، رَبِّ أَعـوذُبِكَ مِنْ عَـذابٍ في النّـارِ وَعَـذابٍ في القَـبْر. <مرة واحدة>");
        arraytext.add("اللّهـمَّ أَنْتَ رَبِّـي لا إلهَ إلاّ أَنْتَ ، خَلَقْتَنـي وَأَنا عَبْـدُك ، وَأَنا عَلـى عَهْـدِكَ وَوَعْـدِكَ ما اسْتَـطَعْـت ، أَعـوذُبِكَ مِنْ شَـرِّ ما صَنَـعْت ، أَبـوءُ لَـكَ بِنِعْـمَتِـكَ عَلَـيَّ وَأَبـوءُ بِذَنْـبي فَاغْفـِرْ لي فَإِنَّـهُ لا يَغْـفِرُ الذُّنـوبَ إِلاّ أَنْتَ . <مرة واحدة>\n" +
                "من قالها موقنا بها حين يمسى ومات من ليلته دخل الجنة وكذلك حين يصبح");
        arraytext.add("رَضيـتُ بِاللهِ رَبَّـاً وَبِالإسْلامِ ديـناً وَبِمُحَـمَّدٍ صلى الله عليه وسلم نَبِيّـاً.\n" +
                "<ثلاث مرات>\n" +
                "من قالها حين يصبح وحين يمسى كان حقا على الله أن يرضيه يوم القيامة");
        arraytext.add("اللّهُـمَّ إِنِّـي أَصْبَـحْتُ أُشْـهِدُك ، وَأُشْـهِدُ حَمَلَـةَ عَـرْشِـك ، وَمَلائِكَتِك ، وَجَمـيعَ خَلْـقِك ، أَنَّـكَ أَنْـتَ اللهُ لا إلهَ إلاّ أَنْـتَ وَحْـدَكَ لا شَريكَ لَـك ، وَأَنَّ ُ مُحَمّـداً عَبْـدُكَ وَرَسـولُـك.\n" +
                "من قالها أعتقه الله من النار <اربع مرات>");
        arraytext.add(" اللّهُـمَّ ما أَصْبَـَحَ بي مِـنْ نِعْـمَةٍ أَو بِأَحَـدٍ مِـنْ خَلْـقِك ، فَمِـنْكَ وَحْـدَكَ لا شريكَ لَـك ، فَلَـكَ الْحَمْـدُ وَلَـكَ الشُّكْـر.\n" +
                "من قالها حين يصبح أدى شكر يومه <مرة واحدة>");
        arraytext.add("حَسْبِـيَ اللّهُ لا إلهَ إلاّ هُوَ عَلَـيهِ تَوَكَّـلتُ وَهُوَ رَبُّ العَرْشِ العَظـيم.\n" +
                "من قالها كفاه الله ما أهمه من أمر الدنيا والأخرة <سبع مرات>");
        arraytext.add("بِسـمِ اللهِ الذي لا يَضُـرُّ مَعَ اسمِـهِ شَيءٌ في الأرْضِ وَلا في السّمـاءِ وَهـوَ السّمـيعُ العَلـيم. <ثلاث مرات>\n" +
                "لم يضره من الله شيء");
        arraytext.add("للّهُـمَّ بِكَ أَصْـبَحْنا وَبِكَ أَمْسَـينا ، وَبِكَ نَحْـيا وَبِكَ نَمُـوتُ وَإِلَـيْكَ النُّـشُور.\n" +
                "<مرة واحدة>");
        arraytext.add("سُبْحـانَ اللهِ وَبِحَمْـدِهِ عَدَدَ خَلْـقِه ، وَرِضـا نَفْسِـه ، وَزِنَـةَ عَـرْشِـه ، وَمِـدادَ كَلِمـاتِـه.\n" +
                "<ثلاث مرات>");
        arraytext.add("اللّهُـمَّ عافِـني في بَدَنـي ، اللّهُـمَّ عافِـني في سَمْـعي ، اللّهُـمَّ عافِـني في بَصَـري ، لا إلهَ إلاّ أَنْـتَ. <ثلاث مرات>");
        arraytext.add(" اللّهُـمَّ إِنّـي أَعـوذُبِكَ مِنَ الْكُـفر ، وَالفَـقْر ، وَأَعـوذُبِكَ مِنْ عَذابِ القَـبْر ، لا إلهَ إلاّ أَنْـتَ. <ثلاث مرات>");
        arraytext.add(" اللّهُـمَّ إِنِّـي أسْـأَلُـكَ العَـفْوَ وَالعـافِـيةَ في الدُّنْـيا وَالآخِـرَة ، اللّهُـمَّ إِنِّـي أسْـأَلُـكَ العَـفْوَ وَالعـافِـيةَ في ديني وَدُنْـيايَ وَأهْـلي وَمالـي ، اللّهُـمَّ اسْتُـرْ عـوْراتي وَآمِـنْ رَوْعاتـي ، اللّهُـمَّ احْفَظْـني مِن بَـينِ يَدَيَّ وَمِن خَلْفـي وَعَن يَمـيني وَعَن شِمـالي ، وَمِن فَوْقـي ، وَأَعـوذُ بِعَظَمَـتِكَ أَن أُغْـتالَ مِن تَحْتـي.\n" +
                "<مرة واحدة>");
        arraytext.add(" يا حَـيُّ يا قَيّـومُ بِـرَحْمَـتِكِ أَسْتَـغـيث ، أَصْلِـحْ لي شَـأْنـي كُلَّـه ، وَلا تَكِلـني إِلى نَفْـسي طَـرْفَةَ عَـين.\n" +
                "<ثلاث مرات>");
        arraytext.add(" أَصْبَـحْـنا وَأَصْبَـحْ المُـلكُ للهِ رَبِّ العـالَمـين ، اللّهُـمَّ إِنِّـي أسْـأَلُـكَ خَـيْرَ هـذا الـيَوْم ، فَـتْحَهُ ، وَنَصْـرَهُ ، وَنـورَهُ وَبَـرَكَتَـهُ ، وَهُـداهُ ، وَأَعـوذُ بِـكَ مِـنْ شَـرِّ ما فـيهِ وَشَـرِّ ما بَعْـدَه. <مرة واحدة>");
        arraytext.add(" اللّهُـمَّ عالِـمَ الغَـيْبِ وَالشّـهادَةِ فاطِـرَ السّماواتِ وَالأرْضِ رَبَّ كـلِّ شَـيءٍ وَمَليـكَه ، أَشْهَـدُ أَنْ لا إِلـهَ إِلاّ أَنْت ، أَعـوذُ بِكَ مِن شَـرِّ نَفْسـي وَمِن شَـرِّ الشَّيْـطانِ وَشِـرْكِه ، وَأَنْ أَقْتَـرِفَ عَلـى نَفْسـي سوءاً أَوْ أَجُـرَّهُ إِلـى مُسْـلِم. <مرة واحدة>");
        arraytext.add("أَعـوذُ بِكَلِمـاتِ اللّهِ التّـامّـاتِ مِنْ شَـرِّ ما خَلَـق.\n" +
                "<ثلاث مرات>");
        arraytext.add("اللَّهُمَّ صَلِّ وَسَلِّمْ وَبَارِكْ على نَبِيِّنَا مُحمَّد.\n" +
                "من صلى على حين يصبح وحين يمسى ادركته شفاعتى يوم القيامة <عشر مرات>");
        arraytext.add(" اللَّهُمَّ إِنَّا نَعُوذُ بِكَ مِنْ أَنْ نُشْرِكَ بِكَ شَيْئًا نَعْلَمُهُ ، وَنَسْتَغْفِرُكَ لِمَا لَا نَعْلَمُهُ. <ثلاث مرات>");
        arraytext.add("اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ الْهَمِّ وَالْحَزَنِ، وَأَعُوذُ بِكَ مِنْ الْعَجْزِ وَالْكَسَلِ، وَأَعُوذُ بِكَ مِنْ الْجُبْنِ وَالْبُخْلِ، وَأَعُوذُ بِكَ مِنْ غَلَبَةِ الدَّيْنِ، وَقَهْرِ الرِّجَالِ.\n" +
                "<ثلاث مرات>");
        arraytext.add(" أسْتَغْفِرُ اللهَ العَظِيمَ الَّذِي لاَ إلَهَ إلاَّ هُوَ، الحَيُّ القَيُّومُ، وَأتُوبُ إلَيهِ.\n" +
                "<ثلاث مرات>");
        arraytext.add("يَا رَبِّ , لَكَ الْحَمْدُ كَمَا يَنْبَغِي لِجَلَالِ وَجْهِكَ , وَلِعَظِيمِ سُلْطَانِكَ.\n" +
                "<ثلاث مرات>");
        arraytext.add(" لَا إلَه إلّا اللهُ وَحَدُّهُ لَا شَرِيكَ لَهُ، لَهُ الْمَلِكَ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلُّ شَيْءِ قَدِيرِ. <عشر مرات>\n" +
                "كانت له عدل عشر رقاب، وكتبت له مئة حسنة، ومحيت عنه مئة سيئة، وكانت له حرزا من الشيطان");
        arraytext.add(" اللَّهُمَّ أَنْتَ رَبِّي لا إِلَهَ إِلا أَنْتَ ، عَلَيْكَ تَوَكَّلْتُ ، وَأَنْتَ رَبُّ الْعَرْشِ الْكَرِيمِ , مَا شَاءَ اللَّهُ كَانَ ، وَمَا لَمْ يَشَأْ لَمْ يَكُنْ ، وَلا حَوْلَ وَلا قُوَّةَ إِلا بِاللَّهِ الْعَلِيِّ الْعَظِيمِ , أَعْلَمُ أَنَّ اللَّهَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ ، وَأَنَّ اللَّهَ قَدْ أَحَاطَ بِكُلِّ شَيْءٍ عِلْمًا , اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ نَفْسِي ، وَمِنْ شَرِّ كُلِّ دَابَّةٍ أَنْتَ آخِذٌ بِنَاصِيَتِهَا ، إِنَّ رَبِّي عَلَى صِرَاطٍ مُسْتَقِيمٍ.\n" +
                "من قالها أول النهار لم تصبه مصيبة حتى يمسي ومن قالها آخر النهار لم تصبه مصيبة حتى يصبح\n" +
                "<مرة واحدة>");
        arraytext.add("سبحان الله وبحمده 100 مره ");
       arraytext.add("");
        ArrayList<imageazker> imagelist = new ArrayList<>();
        imagelist.add(new imageazker(R.drawable.charr, " آية الكرسى: ِ\n" +
                "من قالها حين يصبح أجير من الجن حتى يمسى ومن قالها حين يمسى أجير من الجن حتى يصبح"));
        imagelist.add(new imageazker(R.drawable.almaostan, "سوره الاخلاص والمعوذتين \n" + "من قالها حين يصبح وحين يمسى كفته من كل شىء <ثلاث مرات>"));

        arraytext.forEach(s -> imagelist.add(new imageazker(-1, s)));


        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        AzkarListAdapter azkarListAdapter = new AzkarListAdapter(imagelist);
        rv.setLayoutManager(lm);
        rv.setAdapter(azkarListAdapter);
        rv.setHasFixedSize(true);
    }
}
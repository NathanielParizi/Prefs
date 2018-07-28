package com.psiarb.go.prefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText editTxt;
    Button btn;
    Button btn2;
    SharedPreferences settings;
    private static final String PREFS_NAME= "myPrefsFile";

    int ENG_correct[] = new int[4999];
    int ENG_total[] = new int[4999];

    int PER_correct[] = new int[4999];
    int PER_total[] = new int[4999];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        txt = (TextView) findViewById(R.id.textView1);
        editTxt = (EditText) findViewById(R.id.editText1);

        final List<String> words = new ArrayList<String>();

        ENG_correct[7] = 143;
        ENG_correct[19] = 888;
        System.out.println("ENG_length: " + ENG_correct.length);

        String index = "";
        for(int i = 0; i < ENG_correct.length; i++){

            index = String.valueOf(ENG_correct[i]);
            words.add(index);
        }

        final List<String> words2 = new ArrayList<String>();
        words2.add("0");
        words2.add("1");
        words2.add("2");
        words2.add("3");
        words2.add("4");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             StringBuilder sb = new StringBuilder();
             for(String str : words){
                 sb.append(str);
                 sb.append(", ");

             }
                StringBuilder sb2 = new StringBuilder();
                for(String str : words2){
                    sb2.append(str);
                    sb2.append(", ");

                }


                settings = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("words", sb.toString());
                editor.putString("words2", sb2.toString());
                editor.commit();



            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get data back
                SharedPreferences settings = getSharedPreferences("PREFS", 0);

                System.out.println("check");

                String wordsString = settings.getString("words","");
                String words2String = settings.getString("words2","");


                String[] itemsWords = wordsString.split(", ");
                String[] itemsWords2 = words2String.split(", ");
                List<String> items = new ArrayList<String>();
                List<String> items2 = new ArrayList<String>();

                for(int i =0; i < itemsWords.length; i++){
                    items.add(itemsWords[i]);
                }
                for(int i = 0; i < items.size(); i++){
                    System.out.println("ListItem" + items.get(i));
                }

                items.set(2,"100");



                for(int i = 0; i < items.size(); i++){
                    System.out.println("ListItem:  " + items.get(i));

                }






                //************2

                for(int i =0; i < itemsWords2.length; i++){
                    items2.add(itemsWords2[i]);
                }
                for(int i = 0; i < items2.size(); i++){
                    System.out.println("ListItem2:  " + items2.get(i));
                }




                for(int i = 0; i < items2.size(); i++){
                    System.out.println("ListItem2:  " + items2.get(i));

                }



                items2.set(2,"4999");


                for(int i = 0; i < items2.size(); i++){
                    System.out.println("Update ListItem2:  " + items2.get(i));

                }


                System.out.println(items2.get(2));




                String number = items.get(2);
                int result = Integer.parseInt(number);
                System.out.println(result);


            }
        });




//        if(prefs.contains("message")){
//            String message = prefs.getString("message","not found");
//            txt.setText("Message: " + message);





    }
}

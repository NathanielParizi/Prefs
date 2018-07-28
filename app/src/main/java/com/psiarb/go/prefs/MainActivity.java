package com.psiarb.go.prefs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText editTxt;
    Button btn;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME= "myPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        txt = (TextView) findViewById(R.id.textView1);
        editTxt = (EditText) findViewById(R.id.editText1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myPrefs = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = myPrefs.edit();

                editor.putString("message" , editTxt.getText().toString());
                editor.commit();

            }
        });

        //get data back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        if(prefs.contains("message")){
            String message = prefs.getString("message","not found");
            txt.setText("Message: " + message);
        }

    }
}

package com.example.kevin.hamburguesas;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar AB = getSupportActionBar();
        AB.hide();
        TextView title = (TextView)findViewById(R.id.title) ;
        title.setTypeface(Fuentes.miFuente2(this));

    }
}

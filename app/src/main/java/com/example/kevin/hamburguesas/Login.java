package com.example.kevin.hamburguesas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView title = (TextView)findViewById(R.id.title) ;
        title.setTypeface(Fuentes.miFuente2(this));
    }
    public void login(View view){
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
        overridePendingTransition(R.anim.zoom_back_in,R.anim.zoom_back_out);
    }
}

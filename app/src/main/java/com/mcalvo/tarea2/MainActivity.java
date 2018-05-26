package com.mcalvo.tarea2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String whatsAppCRUri = "http://api.whatsapp.com/send?phone=+506";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btnAction;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAction = findViewById(R.id.btnAction);
        btnAction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });
    }


    private void openWhatsApp() {
        EditText phone;
        EditText msg;
        Intent intent;

        phone = findViewById(R.id.txtPhone);
        msg = findViewById(R.id.txtMsg);

        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(whatsAppCRUri + phone.getText() + "&text=" + msg.getText()));

        startActivity(intent);
    }
}

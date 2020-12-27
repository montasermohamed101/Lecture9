package com.company.lecture9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button openMap,openBrowser,dial,takePicture,sendEmail,showContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        openMap=findViewById(R.id.btn1);
        openBrowser=findViewById(R.id.btn2);
        dial=findViewById(R.id.btn3);
        takePicture=findViewById(R.id.btn4);
        sendEmail=findViewById(R.id.btn5);
        showContacts=findViewById(R.id.btn6);


        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("geo:47.6,-122.3");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                if(intent.resolveActivity(getPackageManager())!=null)
                startActivity(intent);
            }
        });

        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.google.com");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                if(intent.resolveActivity(getPackageManager())!=null)
                startActivity(intent);

            }
        });


        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri=Uri.parse("tel:124467751");
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                if(intent.resolveActivity(getPackageManager())!=null)
                    startActivity(intent);

            }
        });



        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });



        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");

                intent.putExtra(Intent.EXTRA_TEXT,"Write your email");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });



        showContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                if(intent.resolveActivity(getPackageManager())!= null)
                    startActivity(intent);
                
            }
        });
    }
}
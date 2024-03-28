package com.example.firstapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    ImageView btn_camera;
    ImageView set_img,imgdp;
    ImageView imgcam, imggallery;
    Button toastcustom;
    EditText edtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_camera = findViewById(R.id.setimg_btn);
        edtemail = findViewById(R.id.edit_email_1);

        toastcustom = findViewById(R.id.toast_custom_1);
        toastcustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail = edtemail.getText().toString();
                LayoutInflater layoutInflater = getLayoutInflater();
                View myToast = layoutInflater.inflate(R.layout.raw_toast_activity1,null);
                Toast toast = new Toast(MainActivity2.this);
                toast.setView(myToast);
                toast.setText(stremail);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.activity_img_cam_alert, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.setView(myview);
                alertDialog.show();
            }
        });

    }



    public void AlertClick(View view){
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        imgdp = findViewById(R.id.shape_2); // set image on mainactivity2 id : shape_2
        imgcam = findViewById(R.id.img_cam); // choose image from camera
        imggallery = findViewById(R.id.img_gallery); //choose image from gallery


        imggallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i,1);
            }
        });

        imgcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,2);
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            Uri uri = data.getData();
            imgdp.setImageURI(uri);
        }// image set from gallery

        if(requestCode == 2){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgdp.setImageBitmap(bitmap);
        }
    }
}




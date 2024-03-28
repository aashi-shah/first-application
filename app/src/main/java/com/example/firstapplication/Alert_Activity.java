package com.example.firstapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Alert_Activity extends AppCompatActivity {

    Button btnAlertDialog;
    Button btnCustomAlert;
    Button btnCustomToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        btnCustomToast = findViewById(R.id.toast_custom);
        btnAlertDialog = findViewById(R.id.alert_dialog);
        btnCustomAlert = findViewById(R.id.alert_custom);

        btnCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myToast = layoutInflater.inflate(R.layout.raw_toast,null);

                Toast toast = new Toast(Alert_Activity.this);
                toast.setView(myToast);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
        btnCustomAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.custom_alert,null);
                EditText edtemail = myview.findViewById(R.id.alt_email);
                Button btnsubmit = myview.findViewById(R.id.alt_btn);

                AlertDialog.Builder builder = new AlertDialog.Builder(Alert_Activity.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.setView(myview);
                alertDialog.show();



                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        String stremail = edtemail.getText().toString();
                        Toast.makeText(Alert_Activity.this,""+stremail,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void AlertClick(View view) {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.camera_1);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setMessage("Are you sure, you want to delete ? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Alert_Activity.this, "yes is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Alert_Activity.this, "no is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder  builder= new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.camera_1);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setMessage("Are you sure, you want to exit ? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        builder.show();
    }
}
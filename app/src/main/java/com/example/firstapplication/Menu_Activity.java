package com.example.firstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Menu_Activity extends AppCompatActivity {
    TextView textView;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textView = findViewById(R.id.context_click);
        registerForContextMenu(textView);

        textView1 = findViewById(R.id.popup_click);

        textView1.setOnClickListener(new View.OnClickListener() {

//-------------------------Pop Up Menu----------------------------
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(Menu_Activity.this,textView1);
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.item_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.item_add:
                                Toast.makeText(Menu_Activity.this, "Add", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.item_edit:
                                Toast.makeText(Menu_Activity.this, "Edit", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.item_delete:
                                Toast.makeText(Menu_Activity.this, "Delete", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
//----------------------------------------------------------------
        });
    }

    // --------------------Option menu---------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                Toast.makeText(Menu_Activity.this, "Add", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_edit:
                Toast.makeText(Menu_Activity.this, "Edit", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_delete:
                Toast.makeText(Menu_Activity.this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
//----------------------------------------------------------------

//-------------------------Context Menu---------------------------

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                Toast.makeText(Menu_Activity.this, "Add", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_edit:
                Toast.makeText(Menu_Activity.this, "Edit", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_delete:
                Toast.makeText(Menu_Activity.this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
//----------------------------------------------------------------

}
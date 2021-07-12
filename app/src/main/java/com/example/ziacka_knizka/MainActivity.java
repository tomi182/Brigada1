package com.example.ziacka_knizka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> ziak = new ArrayList<>();
    ArrayList<String> znamky = new ArrayList<>();
    ArrayAdapter adapter;
    String znamky2 = " ";
    int zz = 4000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, requestCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String znamka = data.getStringExtra("znamka");
                    znamky2 = znamky2 + " " + znamka + " |";
                    if(zz==0){znamky.remove(zz); znamky.add(zz,znamky2);}
                    if(zz==1){znamky.remove(zz); znamky.add(zz,znamky2);}
                    if(zz==2){znamky.remove(zz); znamky.add(zz,znamky2);}
                    if(zz==3){znamky.remove(zz); znamky.add(zz,znamky2);}
                    break;
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        naplnZoznam();

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, ziak);
        ListView lv = findViewById(R.id.listview);
        lv.setAdapter(adapter);
        AdapterView.OnItemClickListener myHandler = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,DetailActivity.class);
                i.putExtra("ziak",ziak.get(position));
                i.putExtra("znamky",znamky.get(position));
                startActivity(i);
                znamky2 = znamky.get(position);
                zz=position;
                //startActivityForResult(
                      //  new Intent(MainActivity.this,DetailActivity.class),1
                //);
            }
        }; lv.setOnItemClickListener(myHandler);



    }

    private void naplnZoznam() {
        ziak.add("Tomas Gabel");
        znamky.add("1 | 3 | 1 | 2 |");
        ziak.add("Bara Haha");
        znamky.add("3 | 5 | 1 | 4 |");
        ziak.add("Jozo Hehe");
        znamky.add("2 | 4 | 5 | 1 |");
        ziak.add("Zigmund Pele");
        znamky.add("1 | 1 | 1 | 1 |");
    }
}
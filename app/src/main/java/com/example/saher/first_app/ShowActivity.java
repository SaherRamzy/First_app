package com.example.saher.first_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends Activity {
     //ListView show;
    ListView lv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
//        show =(ListView) findViewById(R.id.lv_showthecontacts);
//        Bundle  data =getIntent().getExtras();
          lv_show = (ListView) findViewById(R.id.lv_showthecontacts);
        ArrayList<String> list = getIntent().getExtras().getStringArrayList("data");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        lv_show.setAdapter(adapter);





    }

}

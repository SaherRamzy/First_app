package com.example.saher.first_app;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    DataBaseManager db;
    EditText etfname, etsname, etmob;
    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DataBaseManager(this);
        etfname = (EditText) findViewById(R.id.editText_first);
        etsname = (EditText) findViewById(R.id.editText_second);
        etmob = (EditText) findViewById(R.id.editText_mob);
        button = (Button) findViewById(R.id.button_insert);
        button2 = (Button) findViewById(R.id.button_view);
        button3 = (Button) findViewById(R.id.button_delete);
    }
    public void insertclick(View v) {

        String fname = etfname.getText().toString();
        String sname = etsname.getText().toString();
        String mob = etmob.getText().toString();


        boolean check = db.addcontacts(fname, sname, mob);
        if (check==true)
            Toast.makeText(this, "the data is inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "the data is not inserted", Toast.LENGTH_LONG)
                    .show();



    }

    public void view(View v) {
        ArrayList<String> list=new ArrayList<String>();

        //StringBuffer buffer = new StringBuffer();
        Cursor cursor = db.viewdata();
        while (cursor.moveToNext()) {
            String fname = cursor.getString(1);
            String sname = cursor.getString(2);
            String mob = cursor.getString(3);

//            Contact contact = new Contact();
//            contact.first_name=fname;
//            contact.second_name=sname;
//            contact.mobile=mob;

            list.add("FN:" + fname + "  " + "SN:" + sname + "  " + "Mob:" + mob );
            list.add("");


// gg

//			buffer.append("first name :" + cursor.getString(1) + "\n");
//			buffer.append("second name :" + cursor.getString(2) + "\n");
//			buffer.append("mob :" + cursor.getString(3) + "\n\n");
        }
        //showthemessage("data", buffer.toString());
//		 tvshow.setText(buffer.toString());


        Intent data = new Intent(MainActivity.this,ShowActivity.class);
        data.putExtra("data", list);

        startActivity(data);
//

    }

    public void showthemessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
        //
    }

    public void delete(View v) {
        boolean chech = db.delete();
        if (chech == true)
            Toast.makeText(MainActivity.this, "all data is deleted",
                    Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

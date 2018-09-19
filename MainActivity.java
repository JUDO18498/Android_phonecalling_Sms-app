package com.example.admin.contextmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    String contacts[]={"9407276739","8006529603","8006529604","123456677","940389394738"};
    String no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView)findViewById(R.id.listv);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView1.setAdapter(adapter);
        registerForContextMenu(listView1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                 no=adapter.getItem(i);
            }
        });
    }
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuinfo){
        super.onCreateContextMenu(menu,v,menuinfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"SMS");
    }
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
        Intent callIntent=new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+no));
        try{
            startActivity(callIntent);
        }
        catch(SecurityException e){

        }}
        else if(item.getTitle()=="SMS") {
            Intent i = new Intent(getApplicationContext(), Main2Activity.class);
            i.putExtra("Value1", no);
            startActivity(i);
        }
        else
            return false;



        return true;
    }
}

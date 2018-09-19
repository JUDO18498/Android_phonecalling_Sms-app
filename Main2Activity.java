package com.example.admin.contextmenu;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText mobileno,message;
    private Button sendmsg;
    String value1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras=getIntent().getExtras();
        value1=extras.getString("Value1");
        mobileno=(EditText)findViewById(R.id.editText);
        mobileno.setText(value1);
        message=(EditText)findViewById(R.id.editText2);
        sendmsg=(Button)findViewById(R.id.button);
        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no=message.getText().toString();
                String msg=message.getText().toString();
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,intent,0);
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(no,null,msg,pi,null);
                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                        Toast.LENGTH_LONG).show();


            }
        });
    }
}

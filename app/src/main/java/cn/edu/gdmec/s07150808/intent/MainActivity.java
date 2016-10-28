package cn.edu.gdmec.s07150808.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText url ,phone;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url= (EditText) findViewById(R.id.url);

        phone= (EditText) findViewById(R.id.phone);

        tv1= (TextView) findViewById(R.id.textview1);

    }

    public void componentname(View v){
        ComponentName componentName=new ComponentName(this,IntentDome2.class);

        Intent intent=new Intent();

        intent.setComponent(componentName);

        startActivity(intent);
    }
    public  void intentfilter(View v){
        try {
            String action = "cn.edn.gdmec.kissme";

            Intent intent = new Intent();

            intent.setAction(action);

            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this,"错误",Toast.LENGTH_SHORT).show();
        }
    }
    public void view(View v){

        Intent intent=new Intent();

        intent.setAction(intent.ACTION_VIEW);

        Uri uri= Uri.parse(url.getText().toString());

        intent.setData(uri);

        startActivity(intent);
    }
    public void dial(View v){

        Intent intent=new Intent(Intent.ACTION_DIAL);

        Uri uri=Uri.parse("tel:"+phone.getText().toString());

        intent.setData(uri);

        startActivity(intent);
    }
    public void forresult(View v){

        Bundle bundle =new Bundle();

        bundle.putString("value",url.getText().toString());

        Intent intent=new Intent(MainActivity.this,IntentDome2.class);

        intent.putExtras(bundle);

         startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       switch (requestCode){
           case 10:
               Bundle bundle=data.getExtras();

               tv1.setText(bundle.getString("result"));


       }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

package cn.edu.gdmec.s07150808.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntentDome2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_dome2);
    }
    public void uppr(View v){
        Intent intent=getIntent();

        Bundle bundle=intent.getExtras();

        final String value=bundle.getString("value").toUpperCase();

        Intent intent1result=new Intent();
        intent1result.putExtra("result",value);

        setResult(RESULT_OK,intent1result);

        finish();
    }
}

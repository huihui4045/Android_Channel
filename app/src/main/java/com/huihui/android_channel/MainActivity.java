package com.huihui.android_channel;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.umeng.analytics.MobclickAgent;

public class MainActivity extends AppCompatActivity {

    private StringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new StringBuilder();

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_SIGNATURES);

            Signature[] signatures = packageInfo.signatures;


            for (Signature signature:signatures){

                builder.append(signature.toCharsString());
            }


            Log.e("=========","签名信息："+builder.toString());


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void onResume() {
        super.onResume();
        //
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }



}

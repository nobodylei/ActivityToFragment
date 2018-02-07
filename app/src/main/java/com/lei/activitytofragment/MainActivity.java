package com.lei.activitytofragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * 演示Activity向Fragment传值
 */
public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private EditText et_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_info = findViewById(R.id.et_content);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.contentlayout,new MyFragment());

        transaction.commit();
    }

    /*
    表示点击按钮将edittext中的数据传递到fragment中
     */
    public void sendValue(View v){
        //获取EditText中的数据
        String info = et_info.getText().toString().trim();
        //创建bundle对象，将需要传递的数据储存到bundle中
        //然后调用fragment的setArguments()方法传递bundle
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("info",info);
        myFragment.setArguments(bundle);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.contentlayout,myFragment);
        transaction.commit();
    }
}

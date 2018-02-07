package com.lei.activitytofragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yanle on 2018/2/7.
 * 展示结果的fragment
 */

public class MyFragment extends Fragment{
    private TextView tv_show;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result,null);
        tv_show = view.findViewById(R.id.tv_fragment);
        //先调用getAugments()方法获取bundle
        //在bundle对象中根据key获取传递的数据 展示在TextView中
        Bundle bundle = getArguments();
        if(bundle != null){
            String info = bundle.getString("info");
            tv_show.setText(info);
        }
        return view;
    }
}

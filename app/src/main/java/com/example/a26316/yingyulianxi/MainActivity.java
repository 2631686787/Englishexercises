package com.example.a26316.yingyulianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public TextView zhongwenxianshi;
    public EditText yinwenshuru;
    public Button hedui;
    public TextView fenshu;
    public EditText mubiaoshuru;
    public  Button shezhimubiao;

    ArrayList<data> arrayList = new ArrayList<>();

    int a1 = 0;
    int fs = 0;
    int end = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zhongwenxianshi = findViewById(R.id.zhongwenxianshi);
        yinwenshuru = findViewById(R.id.yinwenshuru);
        hedui = findViewById(R.id.hedui);
        fenshu = findViewById(R.id.fenshuxianshi);
        mubiaoshuru = findViewById(R.id.mubiao);
        shezhimubiao = findViewById(R.id.shezhimubiao);


        loaddata();//加载数据

        fenshu.setText(String.valueOf(fs));
        zhongwenxianshi.setText(arrayList.get(a1).getZhongwen());




        switch (fs)
        {
            case 50:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        }




        //设置目标
        shezhimubiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mubiaoshuru.getText().toString() == "")
                {
                    Toast.makeText(MainActivity.this, "输入目标为空，请重新输入", Toast.LENGTH_SHORT).show();
                }else if(mubiaoshuru.getText().toString() == "0")
                {
                    Toast.makeText(MainActivity.this, "输入目标为0，请重新输入", Toast.LENGTH_SHORT).show();
                }else if (Integer.valueOf(mubiaoshuru.getText().toString()) <= fs)
                {
                    Toast.makeText(MainActivity.this, "输入目标不能小于等于当前分数，请重新输入", Toast.LENGTH_SHORT).show();

                }
                else
                    {
                        end = Integer.valueOf(mubiaoshuru.getText().toString());
                        Toast.makeText(MainActivity.this, "目标已设置为:"+end, Toast.LENGTH_SHORT).show();

                    }


            }
        });


        //核对
        hedui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (yinwenshuru.getText().toString().equals(arrayList.get(a1).getYinwen()))
                {
                    Toast.makeText(MainActivity.this, "正确", Toast.LENGTH_SHORT).show();
                    yinwenshuru.setText(null);
                    yinwenshuru.setHint("回答正确");
                    Random random = new Random();
                    a1  =random.nextInt(15);//随机数最小不低于0，最大不超过16，不等于16
                    zhongwenxianshi.setText(arrayList.get(a1).getZhongwen());

                    fs+=1;//正确加1分
                    fenshu.setText(String.valueOf(fs));


                    //检查分数和目标是否相等
                    if(fs != 0)
                    {
                        if(end != 0)
                        {
                            if(fs == end)
                            {
                                hedui.setText("当前设置目标已完成，可继续练习也可以重新设置新目标");
                            }
                            else
                            {
                                hedui.setText("核对");
                            }

                        }
                    }



                }
                else
                {
                    Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
                    yinwenshuru.setText(null);
                    yinwenshuru.setHint("回答错误，请重新输入");

                    fs-=3;//错误减3分，可负数
                    fenshu.setText(String.valueOf(fs));
                }

            }


        });



    }
    public void loaddata()
    {
        data d0 = new data("行李","luggage");
        data d1 = new data("培养","train");
        data d2 = new data("车票","ticket");
        data d3 = new data("票价","fare");
        data d4 = new data("包","package");
        data d5 = new data("出口","exit");
        data d6 = new data("子女","family");
        data d7 = new data("手机","mobile phone");
        data d8 = new data("矿泉水","mineral water");
        data d9 = new data("广播","broad cast");
        data d10 = new data("事故","accident");
        data d11 = new data("报警","alarm");
        data d12 = new data("耽误","delay");
        data d13 = new data("再次充值","recharge");
        data d14 = new data("送还","return");


        arrayList.add(d0);
        arrayList.add(d1);
        arrayList.add(d2);
        arrayList.add(d3);
        arrayList.add(d4);
        arrayList.add(d5);
        arrayList.add(d6);
        arrayList.add(d7);
        arrayList.add(d8);
        arrayList.add(d9);
        arrayList.add(d10);
        arrayList.add(d11);
        arrayList.add(d12);
        arrayList.add(d13);
        arrayList.add(d14);



    }



}

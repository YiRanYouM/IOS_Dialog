package com.allens.ios_dialog;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.allens.lib_ios_dialog.IosDialog;
import com.allens.lib_ios_dialog.IosSheetDialog;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IosSheetDialog(MainActivity.this)
                        .builder()
                        .setCancelable(true)
                        .setCancelOutside(true)
                        .setTitle("设置头像")
                        .setTitleColor(Color.GRAY)
                        .setTitleSize(14)
                        .setCancelTvMsg("取消")
                        .setCancelTvColor(Color.RED)
                        .setCancelTvSize(16)
                        .setItemTextSize(18)
                        .setItemHeight(45)
                        .addSheetItem("相册", new IosSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, which + "", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addSheetItem("拍照", new IosSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                Toast.makeText(MainActivity.this, which + "", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();


            }
        });


        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IosDialog(MainActivity.this)
                        .builder()
                        .setCancelable(true)
                        .setCancelOutside(true)
                        .setTitle("标题")
                        .setMsg("内容")
                        .setDialogWidth(0.9f)

                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .show();
            }
        });


        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IosDialog(MainActivity.this)
                        .builder()
                        .addEdit("1")
                        .setEditHint("1","123")
                        .addEdit("2")
                        .setEditHint("2","345")
                        .setCancelable(true)
                        .setCancelOutside(true)
                        .setTitle("标题")
                        .setMsg("内容")
                        .setDialogWidth(0.9f)
                        .setPositiveButton(new IosDialog.OnEdPositiveListener() {
                            @Override
                            public void onClick(View view, HashMap<String, String> msgMap) {
                                Toast.makeText(MainActivity.this, "msg: " + msgMap.toString(), Toast.LENGTH_SHORT).show();
                            }

                        })
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .show();
            }
        });
    }
}

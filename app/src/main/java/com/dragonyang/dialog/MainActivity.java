package com.dragonyang.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 多种形式对话框提示小实例
 */
public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.buttton1);
        b2 = findViewById(R.id.buttton2);
        b3 = findViewById(R.id.buttton3);
        b4 = findViewById(R.id.buttton4);
        b5 = findViewById(R.id.buttton5);

        b1.setOnClickListener(new View.OnClickListener() {
            /**
             * 基本类型对话框
             * 底部最多三个按钮
             * 其他，取消，确定
             */
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.i6).setTitle("标题").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                        .setNeutralButton("其他", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "你点击了其他按钮", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                dialog.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            /**
             * 简单列表对话框
             * @param v
             */
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).setTitle("七大洲列表").setItems(R.array.Radio_dialog_items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray(R.array.Radio_dialog_items);
                        Toast.makeText(MainActivity.this, "你选择的位置是:" + which + ","
                                + "你选择的洲是:" + items[which], Toast.LENGTH_SHORT).show();
                    }
                }).create();
                dialog.show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            /**
             * 单选列表对话框
             * @param v
             */
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.i6).setTitle("七大洲列表").setSingleChoiceItems(R.array.Radio_dialog_items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray(R.array.Radio_dialog_items);
                        String locationName = items[which];
                        Toast.makeText(MainActivity.this, locationName, Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                }).create();
                dialog.show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            /**
             * 复杂多选项列表对话框
             */
            boolean[] selectList = new boolean[]{false, true, false, true, false, false, false};

            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.i6).setTitle("七大洲列表").setMultiChoiceItems(R.array.Radio_dialog_items, selectList, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        selectList[which] = isChecked;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray(R.array.Radio_dialog_items);
                        List<String> selected = new ArrayList<>();
                        for (int i = 0; i < selectList.length; i++) {
                            if (selectList[i]) {
                                selected.add(items[i]);
                            }
                        }
                        Toast.makeText(MainActivity.this, "你选择的是" + selected.toString(), Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                }).create();
                dialog.show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            /**
             * 复杂自定义布局对话框
             * @param v
             */
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                final View textEntryView = factory.inflate(R.layout.layoutdialog, null);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).setIcon(R.mipmap.ic_launcher).setTitle("请登录").setView(textEntryView).setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText user = textEntryView.findViewById(R.id.username);
                        EditText pass = textEntryView.findViewById(R.id.password);
                        String userName = user.getText().toString();
                        String password = pass.getText().toString();
                        Toast.makeText(MainActivity.this, "用户名:" + userName + ",密码:" + password, Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消登录", Toast.LENGTH_SHORT).show();
                    }
                }).create();
                dialog.show();
            }
        });
    }
}
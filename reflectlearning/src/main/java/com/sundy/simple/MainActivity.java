package com.sundy.simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ReflectClass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            // 创建对象
            ReflectClass.reflectNewInstance();

            // 反射私有的构造方法
            ReflectClass.reflectPrivateConstructor();

            // 反射私有属性
            ReflectClass.reflectPrivateField();

            // 反射私有方法
            ReflectClass.reflectPrivateMethod();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Log.d(TAG," zenmode = " + ReflectClass.getZenMode());
        ReflectClass.shutDown();
    }
}

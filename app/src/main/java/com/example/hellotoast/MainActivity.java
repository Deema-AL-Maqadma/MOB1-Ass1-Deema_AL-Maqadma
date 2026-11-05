package com.example.hellotoast;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    @SuppressLint("StaticFieldLeak")
    public static ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        // دعم الحواف الكاملة للشاشة Edge-To-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. الحالة الابتدائية: زر الصفر بلون رمادي
        updateZeroButtonColor(false);
    }

    // حدث النقر على زر Toast
    public void show_toast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    // حدث النقر على زر Count (زيادة العداد وتغيير الألوان ديناميكياً)
    public void increase_count(View view) {
        count++;
        mainBinding.textDisplayCount.setText(String.valueOf(count));

        // تفعيل زر الصفر وتغيير لونه للون نشط (برتقالي)
        updateZeroButtonColor(true);

        // تغيير لون خلفية زر Count حسب العدد الفردي والزوجي
        if (count % 2 != 0) {
            // فردي: أخضر
            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(ContextCompat.getColor(this, R.color.button_count_odd))
            );
        } else {
            // زوجي: أزرق
            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(ContextCompat.getColor(this, R.color.button_count_even))
            );
        }
    }

    // حدث النقر على زر Zero (تصفير العداد واستعادة الحالة الابتدائية)
    public void reset_zero(View view) {
        count = 0;
        mainBinding.textDisplayCount.setText(String.valueOf(count));

        // إعادة زر الصفر إلى اللون الرمادي (خامل)
        updateZeroButtonColor(false);

        // إعادة زر العد إلى لونه الافتراضي
        mainBinding.buttonCount.setBackgroundTintList(
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.count_initial_color))
        );
    }

    // دالة مساعدة لتحديث لون زر الصفر (نشط / خامل)
    private void updateZeroButtonColor(boolean isActive) {
        int colorRes = isActive ? R.color.button_active_zero : R.color.button_gray;
        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(ContextCompat.getColor(this, colorRes))
        );
    }
}
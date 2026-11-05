package com.example.hellotoast;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    public static ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ربط الواجهة عبر View Binding
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        // الحالة الابتدائية: زر الصفر رمادي
        updateZeroButtonColor(false);
    }

    public void show_toast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        count++;
        mainBinding.textDisplayCount.setText(String.valueOf(count));

        // تفعيل زر الصفر
        updateZeroButtonColor(true);

        // تبديل لون زر العد (أخضر للفردي، أزرق للزوجي)
        if (count % 2 != 0) {
            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(ContextCompat.getColor(this, R.color.button_count_odd))
            );
        } else {
            mainBinding.buttonCount.setBackgroundTintList(
                    ColorStateList.valueOf(ContextCompat.getColor(this, R.color.button_count_even))
            );
        }
    }

    public void reset_zero(View view) {
        count = 0;
        mainBinding.textDisplayCount.setText(String.valueOf(count));

        // إعادة زر الصفر إلى اللون الرمادي
        updateZeroButtonColor(false);

        // إعادة زر العد إلى لونه الأساسي
        mainBinding.buttonCount.setBackgroundTintList(
                ColorStateList.valueOf(ContextCompat.getColor(this, R.color.count_initial_color))
        );
    }

    private void updateZeroButtonColor(boolean isActive) {
        int colorRes = isActive ? R.color.button_active_zero : R.color.button_gray;
        mainBinding.buttonZero.setBackgroundTintList(
                ColorStateList.valueOf(ContextCompat.getColor(this, colorRes))
        );
    }
}
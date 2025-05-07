package com.example.k22411caproject2;

import android.os.Bundle;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Locale; // Thêm import này

public class MainActivity extends AppCompatActivity {
    private EditText edtCoefficientA, edtCoefficientB;
    private TextView txtResult;
    private Button btnSolution, btnNext, btnExit, btnEnglish, btnVietnamese, btnFrench, btnSpanish; // Thêm private cho các Button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ các thành phần giao diện
        edtCoefficientA = findViewById(R.id.edtCoefficientA);
        edtCoefficientB = findViewById(R.id.edtCoefficientB);
        txtResult = findViewById(R.id.txtResult);
        btnSolution = findViewById(R.id.btnSolution);
        btnNext = findViewById(R.id.btnNext);
        btnExit = findViewById(R.id.btnExit);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnVietnamese = findViewById(R.id.btnVietnamese);
        btnFrench = findViewById(R.id.btnFrench);
        btnSpanish = findViewById(R.id.btnSpanish);

        // Xử lý sự kiện cho các nút đổi ngôn ngữ
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("en"); // Sửa tên phương thức thành setLanguage
            }
        });

        btnVietnamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("vi"); // Sửa tên phương thức thành setLanguage
            }
        });

        btnFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("fr"); // Sửa tên phương thức thành setLanguage
            }
        });

        btnSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLanguage("es"); // Sửa tên phương thức thành setLanguage
            }
        });

        // Xử lý sự kiện cho nút Exit
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // TODO: Thêm xử lý cho btnSolution và btnNext nếu cần
    }

    // Hàm thay đổi ngôn ngữ
    private void setLanguage(String language) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(language);
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics()); // Sửa config thành configuration

        // Làm mới activity để áp dụng ngôn ngữ mới
        recreate();
    }
}
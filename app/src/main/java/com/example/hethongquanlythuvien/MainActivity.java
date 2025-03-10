package com.example.hethongquanlythuvien;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputNhanVien;
    private Button btnDoi, btnThem;
    private CheckBox checkSach1, checkSach2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view từ XML
        inputNhanVien = findViewById(R.id.inputNhanVien);
        btnDoi = findViewById(R.id.btnDoi);
        btnThem = findViewById(R.id.btnThem);
        checkSach1 = findViewById(R.id.checkSach1);
        checkSach2 = findViewById(R.id.checkSach2);

        // Xử lý sự kiện khi nhấn nút "Đổi"
        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nhanVien = inputNhanVien.getText().toString().trim();
                if (nhanVien.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên nhân viên!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Nhân viên: " + nhanVien, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện khi nhấn nút "Thêm"
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra sách nào đang được chọn
                StringBuilder sachDuocChon = new StringBuilder("Sách đã chọn: ");
                if (checkSach1.isChecked()) {
                    sachDuocChon.append("Sách 01, ");
                }
                if (checkSach2.isChecked()) {
                    sachDuocChon.append("Sách 02, ");
                }

                // Nếu không có sách nào được chọn
                if (sachDuocChon.toString().equals("Sách đã chọn: ")) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn ít nhất một sách!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, sachDuocChon.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
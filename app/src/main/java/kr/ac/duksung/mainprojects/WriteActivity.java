package kr.ac.duksung.mainprojects;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class WriteActivity extends AppCompatActivity {

    TextView writedate;
    EditText writecontent;
    Button writesavebtn;

    // 현재 날짜 초기화
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        writedate = findViewById(R.id.writedate);
        writecontent = findViewById(R.id.writecontent);
        writesavebtn = findViewById(R.id.writesavebtn);

        // 초기 날짜를 현재 날짜로 설정
        calendar = Calendar.getInstance();
        updateDate();

        writesavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // writecontent에서 텍스트 가져옴
                String inputText = writecontent.getText().toString();

                // 다음 액티비티로 전환하고, writecontent와 writedate 내용을 전달
                Intent intent = new Intent(WriteActivity.this, DetailActivity.class);
                intent.putExtra("content", writecontent.getText().toString());
                intent.putExtra("date", writedate.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void updateDate() {
        // 날짜를 형식화하여 TextView에 반영
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        writedate.setText(sdf.format(calendar.getTime()));
    }
}

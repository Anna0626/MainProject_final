package kr.ac.duksung.mainprojects;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView detaildate, emotiontext, detailcontent;
    ImageView detailemotion;
    Button detailbtn1, detailbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        emotiontext = findViewById(R.id.emotiontext);
        detaildate = findViewById(R.id.detaildate);
        detailcontent = findViewById(R.id.detailcontent);
        detailemotion = findViewById(R.id.detailemotion);
        detailbtn1 = findViewById(R.id.detailbtn1);
        detailbtn2 = findViewById(R.id.detailbtn2);

        Intent intent = getIntent();

        String contentText = intent.getStringExtra("content");
        String dateText = intent.getStringExtra("date");

        detailcontent.setText(contentText);
        detaildate.setText(dateText);

        if (contentText.contains("기쁨")) {
            detailemotion.setImageResource(R.drawable.ic_happy);
        } else if (contentText.contains("슬픔")) {
            detailemotion.setImageResource(R.drawable.ic_sad);
        } else if (contentText.contains("분노")) {
            detailemotion.setImageResource(R.drawable.ic_angry);
        } else if (contentText.contains("지루함")) {
            detailemotion.setImageResource(R.drawable.ic_bored);
        } else if (contentText.contains("사랑")) {
            detailemotion.setImageResource(R.drawable.ic_love);
        } else if (contentText.contains("불안")) {
            detailemotion.setImageResource(R.drawable.ic_anxiety);
        } else {

            detailemotion.setImageResource(R.drawable.ic_happy);
        }

        emotiontext.setText("OOO님은 오늘 "+ contentText + "입니다");

    }
}
package com.packtpub.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.packtpub.testapplication.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBG = findViewById(R.id.coursePageBackground);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBG.setBackgroundColor(getIntent().getIntExtra("courseBG", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));
    }

    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("courseId", 0);
        Order.itemsId.add(item_id);
        Toast.makeText(this,"Добавлено",Toast.LENGTH_LONG).show();
    }
}
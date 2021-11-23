 package com.packtpub.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.packtpub.testapplication.adapter.CategoryAdapter;
import com.packtpub.testapplication.adapter.CourseAdapter;
import com.packtpub.testapplication.model.Category;
import com.packtpub.testapplication.model.Course;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {


    RecyclerView categoryRecycler,courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullcourseList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(2,"Сайты"));
        categoryList.add(new Category(3,"Языки"));
        categoryList.add(new Category(4,"Прочее"));

        setCategoryRecycler(categoryList);


        courseList.add(new Course(1,"unity","Unity 3D", "1 января","начальный","#EC6D6D","Text",1));
        courseList.add(new Course(1,"unreal","Unreal Engine 4", "1 января","начальный","#85d980","Text",1));
        courseList.add(new Course(2,"_robotics_brain","Machine Learning", "1 января","начальный","#80b2d9","Text",4));
        courseList.add(new Course(2,"_automaton_technology","Neural Networks", "1 января","начальный","#d480d9","Text",4));
        courseList.add(new Course(2,"data_science","Data Science", "1 января","начальный","#d6a383","Text",4));
        courseList.add(new Course(2,"web","Web", "1 января","начальный","#82c4d7","Text",2));
        courseList.add(new Course(2,"android","Android", "1 января","начальный","#9fd782","Text",4));


        fullcourseList.addAll(courseList);
        setCourseRecycler(courseList);

    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this,OrderPage.class);
        startActivity(intent);
    }

     private void setCourseRecycler(List<Course> courseList) {
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
         courseRecycler = findViewById(R.id.courseRecycler);
         courseRecycler.setLayoutManager(layoutManager);

         courseAdapter = new CourseAdapter(this,courseList);
         courseRecycler.setAdapter(courseAdapter);
     }

     private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

     }

     public static void showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullcourseList);

        List<Course> filterCourses = new ArrayList<>();

        for (Course c: courseList){
            if(c.getCategory() == category){
                filterCourses.add(c);
            }
        }
        courseList.clear();
        courseList.addAll(filterCourses);
        courseAdapter.notifyDataSetChanged();

     }
 }
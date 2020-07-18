package com.example.bookwala;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Advertisement extends AppCompatActivity {

    Spinner dd_semester , dd_subject , dd_publication , dd_yearofpublication;
    ArrayList<String> arr_list_sem;
    ArrayAdapter<String> arr_adapt_sem;

    ImageView add_img_book;
    ArrayList<String> arrayList_none ,arrayList_sem1,arrayList_sem2,arrayList_sem3,arrayList_sem4,arrayList_sem5,arrayList_sem6,arrayList_sem7,arrayList_sem8;
    ArrayAdapter<String> arr_adapter_subject;

    ViewPager view_page;

    ArrayList<String> arrayList_publication;
    ArrayAdapter<String> arr_adapt_publication;

    ArrayList<String> arrayList_yearofpublication;
    ArrayAdapter<String> arr_adapt_yearofpublication;


    Button btn_add_photos;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    ArrayList<Bitmap> list = new ArrayList<Bitmap>();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Gets called when user has taken the image.
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            // BitMap is data structure of image file
            // which store the image in memory
            Bitmap photo = (Bitmap)data.getExtras()
                    .get("data");

            list.add(photo);

            // Set the image in imageview for display
            Log.d("here", "onActivityResult: 13");

            //Used for slider of taken images.
            ViewPager vp = findViewById(R.id.view_page);
            ImageAdapter adapter = new ImageAdapter(Advertisement.this, list);
            vp.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);

        dd_semester=(Spinner)findViewById(R.id.select_sem_dd);
        dd_subject=(Spinner)findViewById(R.id.select_subject_dd);

        dd_publication=(Spinner)findViewById(R.id.select_publication_dd);
        dd_yearofpublication=(Spinner)findViewById(R.id.select_year_dd);
        //----------------spinner for publication year---------------------
        arrayList_yearofpublication=new ArrayList<>();
        arrayList_yearofpublication.add("----Select year of publication----");
        arrayList_yearofpublication.add("2015");
        arrayList_yearofpublication.add("2016");
        arrayList_yearofpublication.add("2017");
        arrayList_yearofpublication.add("2018");
        arrayList_yearofpublication.add("2019");
        arrayList_yearofpublication.add("2020");

        arr_adapt_yearofpublication=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_yearofpublication);
        dd_yearofpublication.setAdapter(arr_adapt_yearofpublication);




        //--------------------------------------------------------------------
        //add_img_book = findViewById(R.id.add_img_book);

        btn_add_photos = findViewById(R.id.btn_add_photos);
        arr_list_sem=new ArrayList<>();
        arr_list_sem.add("----Select your semester----");
        arr_list_sem.add("1");
        arr_list_sem.add("2");
        arr_list_sem.add("3");
        arr_list_sem.add("4");
        arr_list_sem.add("5");
        arr_list_sem.add("6");
        arr_list_sem.add("7");
        arr_list_sem.add("8");

        arr_adapt_sem=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arr_list_sem);
        dd_semester.setAdapter(arr_adapt_sem);

        //+++++++++++++++  Subject Spinner  ++++++++++++++++++++++++
        arrayList_none=new ArrayList<>();
        arrayList_none.add("Please select semester");

        arrayList_sem1=new ArrayList<>();
        arrayList_sem1.add("----select subject name----");
        arrayList_sem1.add("Engineering Mathematics I");
        arrayList_sem1.add("Engineering Chemistry");
        arrayList_sem1.add("Engineering Physics");
        arrayList_sem1.add("Engineering graphics");
        arrayList_sem1.add("Basic Electrical engineering");
        arrayList_sem1.add("Basic Electronics Engineering");
        arrayList_sem1.add("Basic civil and environmental Engineering");
        arrayList_sem1.add("Fundamentals of programming languages I");



        arrayList_sem2=new ArrayList<>();
        arrayList_sem2.add("----select subject name----");
        arrayList_sem2.add("Engineering Mathematics II");
        arrayList_sem2.add("Engineering Physics");
        arrayList_sem2.add("Basic Mechanical Engineering");
        arrayList_sem2.add("Basic Electrical engineering");
        arrayList_sem2.add("Basic Electronics Engineering");
        arrayList_sem2.add("Fundamentals of programming languages II");
        arrayList_sem2.add("Engineering Mechanics");




        arrayList_sem3=new ArrayList<>();
        arrayList_sem3.add("----select subject name----");
        arrayList_sem3.add("Discrete Mathematics");
        arrayList_sem3.add("Digital Electronics and Logic Design");
        arrayList_sem3.add("Data Structures and Algorithms ");
        arrayList_sem3.add("Computer Organization and Architecture");
        arrayList_sem3.add("Object Oriented Programming");



        arrayList_sem4=new ArrayList<>();
        arrayList_sem4.add("----select subject name----");
        arrayList_sem4.add("Engineering Mathematics III");
        arrayList_sem4.add("Computer Graphics");
        arrayList_sem4.add("Advanced Data Structures");
        arrayList_sem4.add("Microprocessor ");
        arrayList_sem4.add("Principles of Programming Languages");


        arrayList_sem5=new ArrayList<>();
        arrayList_sem5.add("----select subject name----");
        arrayList_sem5.add("Theory of computation(Toc)");
        arrayList_sem5.add("Database Management System(dbms)");
        arrayList_sem5.add("Software Engineering & project management(Sepm)");
        arrayList_sem5.add("Information system & Engineering economics(Isee)");
        arrayList_sem5.add("Computer Networks");


        arrayList_sem6=new ArrayList<>();
        arrayList_sem6.add("----select subject name----");
        arrayList_sem6.add("Design and analysis of algorithm(Daa)");
        arrayList_sem6.add(" System Programming and operating system(SPOS) ");
        arrayList_sem6.add("Embedded Systems and Internet of Things(ESIOT)");
        arrayList_sem6.add(" Software Modeling And Design(SMD) ");
        arrayList_sem6.add("Web Technology(WT)");


        arrayList_sem7=new ArrayList<>();
        arrayList_sem7.add("----select subject name----");
        arrayList_sem7.add("High performance computing ");
        arrayList_sem7.add("Artificial intelligence and robotics");
        arrayList_sem7.add("Data Analytics ");
        arrayList_sem7.add("Digital Signal Processing");
        arrayList_sem7.add("Software Architecture and design");
        arrayList_sem7.add("Pervasive and Ubiquitous computing");
        arrayList_sem7.add("Data Mining and wearhousing");
        arrayList_sem7.add("Distributed System");
        arrayList_sem7.add("Software Testing and Quality Assuarance");
        arrayList_sem7.add("Operational Research");
        arrayList_sem7.add("Mobile Communication");





        arrayList_sem8=new ArrayList<>();
        arrayList_sem8.add("----select subject name----");
        arrayList_sem8.add("Machine Learning");
        arrayList_sem8.add("Information and cyber security");
        arrayList_sem8.add("Advanced Digital Signal Processing");
        arrayList_sem8.add("Compilers");
        arrayList_sem8.add("Embedded and real Time Operating system");
        arrayList_sem8.add("Soft Computing and Optimisation Algorithms");
        arrayList_sem8.add("Software Defined Networks");
        arrayList_sem8.add("Human Computer Interface");
        arrayList_sem8.add("Cloud Computing");
        arrayList_sem8.add("Open Elective");



        dd_semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_none);
                }
                if (position==1)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem1);
                }
                if (position==2)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem2);
                }
                if (position==3)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem3);
                }
                if (position==4)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem4);
                }
                if (position==5)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem5);
                }
                if (position==6)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem6);
                }
                if (position==7)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem7);
                }
                if (position==8)
                {
                    arr_adapter_subject=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sem8);
                }

                dd_subject.setAdapter(arr_adapter_subject);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //+++++++++++++++  Publication spinner  ++++++++++++++++++
        arrayList_publication=new ArrayList<>();
        arrayList_publication.add("Techmax");
        arrayList_publication.add("decode");
        arrayList_publication.add("Technical");
        arrayList_publication.add("Techneo");
        arrayList_publication.add("Nirali");
        arrayList_publication.add("Easy solutions");
        arrayList_publication.add("Techknowlege");

        arrayList_publication.add("Others");


        arr_adapt_publication=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_publication);
        dd_publication.setAdapter(arr_adapt_publication);

       btn_add_photos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //To take photo of books.
               Intent camera_intent
                       = new Intent(MediaStore
                       .ACTION_IMAGE_CAPTURE);

               startActivityForResult(camera_intent, REQUEST_IMAGE_CAPTURE);
           }
       });



    }
}
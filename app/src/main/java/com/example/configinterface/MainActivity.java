package com.example.configinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView books;
    private Random random = new Random();
    private BookDataAdapter adapter;
    private List<Drawable> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        books = findViewById(R.id.bookList);
        adapter = new BookDataAdapter(this, null);
        books.setAdapter(adapter);

        fillImages();
        generateRandomBookData();
        //создать, собсна, экземпляры класса BookData
    }

    private void fillImages() {
        images.add(ContextCompat.getDrawable(MainActivity.this,
                R.drawable.ic_book));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                R.drawable.ic_book1));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                R.drawable.ic_book2));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                R.drawable.ic_book3));
        images.add(ContextCompat.getDrawable(MainActivity.this,
                R.drawable.ic_book4));
    }

    private void generateRandomBookData() {
        for (int i = 0; i < images.size(); i++) {
            adapter.addItem(new BookData(images.get(random.nextInt(images.size())),"A nice book" + adapter.getCount(),"Get excited by the new bestseller!", random.nextBoolean()));
        }
    }
}

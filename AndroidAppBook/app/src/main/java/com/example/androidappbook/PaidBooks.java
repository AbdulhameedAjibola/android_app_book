package com.example.androidappbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PaidBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_books);

        List<PaidBook> books = new ArrayList<>();

        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book5, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book7, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book17, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book9, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book8, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book18, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book10, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book12, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book15, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book17, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book16, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book14, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book13, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book11, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater", "Price: $3500"));
        



        // Create a BookAdapter and set it to the ListView
        PaidBookAdapter adapter = new PaidBookAdapter(this, books);

        ListView listView = findViewById(R.id.paidListView); // Reference to the ListView in your layout
        listView.setAdapter(adapter); // Set the adapter to the ListView

        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



         Button searchButton = findViewById(R.id.searchButtonPaid);
        EditText searchEditText = findViewById(R.id.searchPaidbook);


// Assuming you have a reference to the original list of books
        final List<PaidBook> originalBooks = new ArrayList<>(books);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchEditText.getText().toString().toLowerCase().trim();

                // Create a new list to store filtered books
                List<PaidBook> filteredBooks = new ArrayList<>();

                // Iterate through the original list of books and add matching books to the filtered list
                for (PaidBook book: originalBooks) {
                    if (book.getTitle().toLowerCase().contains(query) || book.getAuthor().toLowerCase().contains(query)) {
                        filteredBooks.add(book);
                    }
                }

                // Create a new adapter with the filtered list and set it to the ListView
                PaidBookAdapter adapter = new PaidBookAdapter(PaidBooks.this, filteredBooks);
                listView.setAdapter(adapter);
            }
        });
    }
}
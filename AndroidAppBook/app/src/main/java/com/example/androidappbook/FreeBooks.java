package com.example.androidappbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FreeBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_books);

        List<Book> books = new ArrayList<>();

        books.add(new Book("Book: A Soldier of ManHattan and his Adventures at Ticonderoga and Quebec", "Author: Joseph. A. Altsheler", R.drawable.soldierfree3, "https://archive.org/details/soldierofmanhatt00alts/page/n5/mode/2up?ref=ol&view=theater"));
        books.add(new Book("Book: Tanglewood Tales ", "Author: Illustrated", R.drawable.tanglewood14, ""));
        books.add(new Book("Book: Mary WallstoneCraft ", "Author: Falkner", R.drawable.mary15, ""));
        books.add(new Book("Book: The Red Thumb Mark ", "Author: R Austin Freeman ", R.drawable.red12, ""));
        books.add(new Book("Book: Essays of Elia ", "Author: Charles Lana ", R.drawable.essays13, ""));
        books.add(new Book("Book: Herakles ", "Author:Euripedes ", R.drawable.hercles10, ""));
        books.add(new Book("Book:Mortal Coils ", "Author: Aldous Huxley", R.drawable.aldox9, ""));
        books.add(new Book("Book: Gentlemen Prefer Blondes", "Author:Anita Loos ", R.drawable.gentlemen8, ""));
        books.add(new Book("Book: The heart pf Emerson's Journals", "Author: Ralph Waldo Emerson ", R.drawable.emerson7, ""));
        books.add(new Book("Book:Amalia ", "Author: Jos Marmol", R.drawable.amalia6, ""));
        books.add(new Book("Book: The Scarlet Letter ", "Author: Nathaniel Hawthorne", R.drawable.scarlet5, "https://archive.org/details/hawthworks03hawtuoft/mode/2up?ref=ol&view=theater"));



        // Create a BookAdapter and set it to the ListView
        BookAdapter adapter = new BookAdapter(this, books);

         ListView listView = findViewById(R.id.bookList); // Reference to the ListView in your layout
        listView.setAdapter(adapter); // Set the adapter to the ListView

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button searchButton = findViewById(R.id.searchButtonPaid);
        EditText searchEditText = findViewById(R.id.searchPaidbook);


// Assuming you have a reference to the original list of books
        final List<Book> originalBooks = new ArrayList<>(books);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchEditText.getText().toString().toLowerCase().trim();

                // Create a new list to store filtered books
                List<Book> filteredBooks = new ArrayList<>();

                // Iterate through the original list of books and add matching books to the filtered list
                for (Book book : originalBooks) {
                    if (book.getTitle().toLowerCase().contains(query) || book.getAuthor().toLowerCase().contains(query)) {
                        filteredBooks.add(book);
                    }
                }

                // Create a new adapter with the filtered list and set it to the ListView
                BookAdapter adapter = new BookAdapter(FreeBooks.this, filteredBooks);
                listView.setAdapter(adapter);
            }
        });

    }
}
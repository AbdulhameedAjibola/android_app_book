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

        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book5, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $3500"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book7, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $300"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book17, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $200"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book9, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $100"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book8, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $50"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book18, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $67.99"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book10, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $34.55"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book12, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $42.22"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book15, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $18.50"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book17, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $30"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book16, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $40.98"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book14, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $12.30"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book13, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $45.78"));
        books.add(new PaidBook("Book: Benefits of coding", "Author: Morgan Housel", R.drawable.book11, "https://www.konga.com/product/programming-for-the-absolute-beginner-second-edition-by-jerry-lee-6255439", "Price: $40.87"));
        



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
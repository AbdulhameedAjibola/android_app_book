package com.example.androidappbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    // Constructor to initialize the adapter
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    // This method prepares the view for each book card

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Book book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.book_card, parent, false);
        }

        ImageView bookCover = convertView.findViewById(R.id.book_cover);
        TextView bookTitle = convertView.findViewById(R.id.book_title);
        TextView bookAuthor = convertView.findViewById(R.id.book_author);

        // Set the book cover image programmatically
        bookCover.setImageResource(book.getCoverResourceId()); // Assuming getCoverResourceId() returns the resource ID of the image

        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());

        // Add a click listener to the card
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here, e.g., open the book or show details
                openWebView(book.getWebUrl());
            }

            private void openWebView(String Url) {
                Intent webViewIntent = new Intent(getContext(), Web_view.class);
                webViewIntent.putExtra("url", Url);
                getContext().startActivity(webViewIntent);
            }
        });

        return convertView;

        // Method to open a WebView

    }

}



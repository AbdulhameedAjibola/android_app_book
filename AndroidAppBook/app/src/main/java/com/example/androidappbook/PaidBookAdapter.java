package com.example.androidappbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

import java.util.List;


public class PaidBookAdapter extends ArrayAdapter<PaidBook>{

    public PaidBookAdapter(Context context, List<PaidBook> books) {
        super(context, 0, books);
    }

    // This method prepares the view for each book card

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PaidBook book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.paid_books_card, parent, false);
        }

        ImageView bookCover = convertView.findViewById(R.id.paidBookImage);
        TextView bookTitle = convertView.findViewById(R.id.paidBookName);
        TextView bookAuthor = convertView.findViewById(R.id.paidBookAuthor);
        TextView bookPrice = convertView.findViewById(R.id.paidBookPrice);
        Button button = convertView.findViewById(R.id.buyBook);

        // Set the book cover image programmatically
        bookCover.setImageResource(book.getCoverResourceId()); // Assuming getCoverResourceId() returns the resource ID of the image
        bookPrice.setText(book.getPrice());
        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());

        // Add a click listener to the card
        button.setOnClickListener(new View.OnClickListener() {
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

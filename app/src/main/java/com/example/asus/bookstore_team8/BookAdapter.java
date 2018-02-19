package com.example.asus.bookstore_team8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yxong on 21/12/2017.
 */

public class BookAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Book> books;


    public BookAdapter(Context context, List<Book> books) {
        this.mContext = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Book book = books.get(i);

        // 2
        if (view == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(R.layout.book_info, null);
        }

        // 3
        final ImageView imageView = (ImageView)view.findViewById(R.id.bookImg);
        final TextView titleTextView = (TextView)view.findViewById(R.id.title);
        final TextView authorTextView = (TextView)view.findViewById(R.id.author);

        // 4
        String imgName = "a" + book.get("ISBN");
        int imgId = mContext.getResources().getIdentifier(imgName,"drawable", mContext.getPackageName());
        imageView.setImageResource(imgId);
        titleTextView.setText(book.get("Title"));
        authorTextView.setText(book.get("Author"));

        return view;
    }
}

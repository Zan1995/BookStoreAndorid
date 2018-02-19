package com.example.asus.bookstore_team8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;

public class GridActivity extends AppCompatActivity{

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);




        /*List<Book> result = Book.list();

        for(Book b : result){
            View bookInfo = getLayoutInflater().inflate(R.layout.book_info, layout, false);

            ImageView img = (ImageView) bookInfo.findViewById(R.id.bookImg);
            String imgName = "a" + b.get("ISBN");
            int imgId = getResources().getIdentifier(imgName,"drawable", getPackageName());
            img.setImageResource(imgId);

            TextView title = (TextView) bookInfo.findViewById(R.id.title);
            title.setText(b.get("Title"));

            TextView author = (TextView) bookInfo.findViewById(R.id.author);
            author.setText(b.get("Author"));

            layout.addView(bookInfo);
            @Override
            protected List<Book> doInBackground(Void... params) {
                return Book.list();
            }
        }*/

        new AsyncTask<Void, Void, List<Book>>() {
            @Override
            protected void onPostExecute(final List<Book> result) {
//                GridView gridView = (GridView)findViewById(R.id.gridview);
                BookAdapter booksAdapter = new BookAdapter(GridActivity.this, result);
                final GridView gridView = (GridView)findViewById(R.id.gridview);

                gridView.setAdapter(booksAdapter);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView parent, View view, int position, long id) {
                        Book book = result.get(position);
                        Intent intent = new Intent(GridActivity.this, BookDetailActivity.class);
                        intent.putExtra("bid", book.get("BookID"));
                        startActivity(intent);
                    }
                });
            }
        }.execute();


    }

/*    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        Book s = (Book) av.getAdapter().getItem(position);
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra("bid", s.get("BookID"));
        startActivity(intent);
    }*/
}

package kamal.agooz.ahmed.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookInfo extends AppCompatActivity {
    ImageView image;
    TextView title,author,publisher,date,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        image = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
        author = (TextView) findViewById(R.id.author);
        publisher = (TextView) findViewById(R.id.publisher);
        date = (TextView) findViewById(R.id.date);
        description = (TextView) findViewById(R.id.description);


        String title2 =getIntent().getStringExtra("title");
        String author2 = getIntent().getStringExtra("author");
        String publisher2 = getIntent().getStringExtra("pub");
        String Date2 = getIntent().getStringExtra("date");
        String description2 = getIntent().getStringExtra("desc");
        String url = getIntent().getStringExtra("url");

        title.setText(title2);
        author.setText(author2);
        publisher.setText("Published By : " + publisher2);
        date.setText("Published Date : " + Date2);
        description.setText(description2);

        if (url.length() != 0)
        {

        } else
        {
            image.setImageResource(R.drawable.notebook);
        }





    }
}
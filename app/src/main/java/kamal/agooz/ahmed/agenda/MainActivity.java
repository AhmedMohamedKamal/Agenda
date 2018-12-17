package kamal.agooz.ahmed.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText book_title;
    Button search;
    ProgressBar progressBar;
    ListView listView;
    Adapter adapter;
    String GOOGLE_BOOKS_API;
    String s;
    ImageView agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        book_title = (EditText) findViewById(R.id.edit_txt_book);
        search = (Button) findViewById(R.id.search_btn);
        listView = (ListView) findViewById(R.id.listview);
        agenda = (ImageView) findViewById(R.id.agenda);
        progressBar = (ProgressBar) findViewById(R.id.progeress_bar);

        progressBar.setVisibility(View.INVISIBLE);

        adapter = new Adapter(getApplicationContext(), 0, new ArrayList<DataClass>());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataClass currentbook = (DataClass) adapter.getItem(position);

                String title = currentbook.getBook_title();
                String author = currentbook.getAuthor_name();
                String publisher = currentbook.getPublisher();
                String Date = currentbook.getDate();
                String description = currentbook.getDescription();
                String url = currentbook.getImage_url();

                Intent intent = new Intent(getApplicationContext(), BookInfo.class);

                intent.putExtra("title", title);
                intent.putExtra("author", author);
                intent.putExtra("pub", publisher);
                intent.putExtra("date", Date);
                intent.putExtra("desc", description);
                intent.putExtra("url", url);

                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = book_title.getText().toString();

                if (s.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Enter Book Title", Toast.LENGTH_SHORT).show();
                } else {
                    agenda.setVisibility(View.GONE);

                    GOOGLE_BOOKS_API =
                            "https://www.googleapis.com/books/v1/volumes?q=" + s;

                    AsyncTask newtask = new AsyncTask();
                    newtask.execute(GOOGLE_BOOKS_API);

                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(
                            Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    book_title.setText("");
                }
            }
        });
    }

    public class AsyncTask extends android.os.AsyncTask<String, Void, ArrayList<DataClass>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<DataClass> doInBackground(String... strings) {
            if (strings.length < 1 || strings[0] == null) {
                return null;
            }

            ArrayList<DataClass> books = utils.fetchBooksData(strings[0]);

            return books;
        }

        @Override
        protected void onPostExecute(ArrayList<DataClass> dataClasses) {
            adapter.clear();

            if (dataClasses != null && !dataClasses.isEmpty()) {
                progressBar.setVisibility(View.INVISIBLE);
                adapter.addAll(dataClasses);
            }
        }
    }
}
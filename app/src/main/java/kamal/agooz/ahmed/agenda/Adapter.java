package kamal.agooz.ahmed.agenda;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter <DataClass> {
    TextView book_title,author_name;
    ImageView book_image;

    public Adapter(@NonNull Context context, int resource, ArrayList<DataClass> books) {
        super(context, resource, books);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent)
    {
        View view = convertView;

        if (view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent,
                    false);
        }

        DataClass dataClass = getItem(position);

        book_title = (TextView) view.findViewById(R.id.book_title);
        author_name = (TextView) view.findViewById(R.id.author_name);
        book_image = (ImageView) view.findViewById(R.id.book_image);

        book_title.setText(dataClass.getBook_title());
        author_name.setText(dataClass.getAuthor_name());

        if (dataClass.getImage_url().length() != 0)
        {

        } else
        {
            book_image.setImageResource(R.drawable.notebook);
        }


        return view;
    }
}
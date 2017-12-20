package es.cice.clienteslv;

/**
 * Created by cice on 23/3/17.
 */

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomerAdapter extends ArrayAdapter<Customer> {
    private Context context;
    private String sex;
    private List<Customer> data;

    public CustomerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Customer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.data = objects;
    }

    // Constructor

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowMan = inflater.inflate(R.layout.man_customer, null);

        ImageView imageViewMan = (ImageView) rowMan.findViewById(R.id.imageViewSex);
        //ImageView imageViewWoman = (ImageView) rowMan.findViewById(R.id.imageViewSex);
        TextView nameView = (TextView) rowMan.findViewById(R.id.textViewName);
        TextView phoneView = (TextView) rowMan.findViewById(R.id.textViewPhone);

        if (data.get(position).getSex().equals("H"))
            imageViewMan.setImageResource(R.drawable.hombre);
        else
            imageViewMan.setImageResource(R.drawable.mujer);

        nameView.setText(data.get(position).getName());
        phoneView.setText(data.get(position).getPhoneNumber());

        return rowMan;
        //return super.getView(position, convertView, parent);
    }
}














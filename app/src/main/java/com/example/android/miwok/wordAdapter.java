package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class wordAdapter extends ArrayAdapter<Word> {

    int mColorResourceId;

    public wordAdapter(Context context, ArrayList<Word> word, int colorResourceId) {

        super(context, 0, word);
        mColorResourceId=colorResourceId;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View listItemView=convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView=listItemView.findViewById(R.id.image);

        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
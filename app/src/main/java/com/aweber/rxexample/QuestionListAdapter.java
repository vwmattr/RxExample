package com.aweber.rxexample;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aweber.rxexample.entities.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * List Adapter to display {@link com.aweber.rxexample.entities.QuestionList}.
 */
public class QuestionListAdapter extends ArrayAdapter<Question> {

    private final Activity context;
    private List<Question> questions;

    static class ViewHolder {
        public TextView titleText;
    }

    public QuestionListAdapter(Activity context) {
        super(context, R.layout.list_item_question, new ArrayList<Question>());
        this.context = context;
    }

    @Override
    public int getCount() {
        if (questions == null) {
            return 0;
        }
        return questions.size();
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_item_question, null);
            ViewHolder viewholder = new ViewHolder();
            viewholder.titleText = (TextView) rowView.findViewById(R.id.title);
            rowView.setTag(viewholder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        Question question = questions.get(position);

        //fill 'er up
        holder.titleText.setText(Html.fromHtml(question.getTitle()));

        return rowView;
    }

}

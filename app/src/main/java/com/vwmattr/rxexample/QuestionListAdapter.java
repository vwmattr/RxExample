package com.vwmattr.rxexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vwmattr.rxexample.entities.Question;

import java.util.List;

/**
 * List Adapter to display {@link com.vwmattr.rxexample.entities.QuestionList}.
 */
public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder> {

    private List<Question> questions;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_question, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Question question = questions.get(position);

        holder.titleText.setText(question.getTitle());
        holder.itemView.setTag(question);
    }

    @Override
    public int getItemCount() {
        if (questions == null) {
            return 0;
        }
        return questions.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleText;

        public ViewHolder(View itemView) {
            super(itemView);
            titleText = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        notifyDataSetChanged();
    }
}

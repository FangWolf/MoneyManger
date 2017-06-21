package com.example.siyu2.moneymanger;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import model.Tb_Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Tb_Note> mNoteList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView note,id;
        View noteView;

        public ViewHolder (View view) {
            super(view);
            note = (TextView) view.findViewById(R.id.recnote);
            noteView = view;
        }
    }

    public NoteAdapter (List<Tb_Note> noteList) {
        mNoteList = noteList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_nt,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.noteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Tb_Note tbNote = mNoteList.get(position);
                Intent intent = new Intent(view.getContext().getApplicationContext(),UpdataNote.class);
                String furk = tbNote.getNote();
                intent.putExtra("note_xinxi",furk);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tb_Note tbnote = mNoteList.get(position);
        holder.note.setText(tbnote.getNote());
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }
}

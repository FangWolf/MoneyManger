package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.siyu2.moneymanger.NoteAdapter;
import com.example.siyu2.moneymanger.R;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import model.Tb_Note;

public class FragmentDnote extends Fragment {
    private List<Tb_Note> NoteList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_downnote,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inintnote();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.noteList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        NoteAdapter adapter = new NoteAdapter(NoteList);
        recyclerView.setAdapter(adapter);
    }

    private void inintnote() {
        List<Tb_Note> allget = DataSupport.findAll(Tb_Note.class);
        for (int i = 0;i<allget.size();i++) {
            Tb_Note bianqian = new Tb_Note(allget.get(i).getNote());
            NoteList.add(bianqian);
        }
    }

}

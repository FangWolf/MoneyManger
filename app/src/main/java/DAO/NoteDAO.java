package DAO;

import android.util.Log;

import org.litepal.crud.DataSupport;

import model.Tb_Note;

public class NoteDAO extends DataSupport {

    public void add(Tb_Note tb_note) {
        //添加便签
        Tb_Note tbnote = new Tb_Note();
        tbnote.setNote(tb_note.getNote());
        tbnote.save();
    }

    public Tb_Note find() {
        //查询密码
        Tb_Note lastnote = DataSupport.findLast(Tb_Note.class);
        Log.d("Addnote",lastnote.getNote());
        return lastnote;
    }

}

package DAO;

import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.List;

import model.Tb_Note;

public class NoteDAO extends DataSupport {

    public void add(Tb_Note tb_note) {
        Tb_Note tbnote = new Tb_Note();
        tbnote.setNote(tb_note.getNote());
        tbnote.save();
    }

    public void updata(String s,String ss) {
        Tb_Note tbnote = new Tb_Note();
        tbnote.setNote(ss);
        tbnote.updateAll("note = ?",s);
    }

    public void delate(String s) {
        DataSupport.deleteAll(Tb_Note.class,"note = ?" ,s);
    }
}

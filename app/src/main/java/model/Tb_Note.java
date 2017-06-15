package model;

import org.litepal.crud.DataSupport;

public class Tb_Note extends DataSupport{
    private String note;

    public Tb_Note() {}

    public Tb_Note(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

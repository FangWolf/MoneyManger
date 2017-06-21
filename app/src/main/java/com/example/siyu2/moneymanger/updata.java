package com.example.siyu2.moneymanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DAO.NoteDAO;

public class updata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata);
        final EditText wenben = (EditText) findViewById(R.id.wenben);
        Button xiugai = (Button)findViewById(R.id.xigai);
        Button shanchu = (Button) findViewById(R.id.shanchu);

        final Intent intent = getIntent();
        final String string = intent.getStringExtra("note_xinxi");
        wenben.setText(string);


        xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteDAO noteDao = new NoteDAO();
                noteDao.updata(string,wenben.getText().toString());
                Toast.makeText(updata.this,"修改成功,刷新后查看",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteDAO noteDao = new NoteDAO();
                noteDao.delate(string);
                Toast.makeText(updata.this,"删除成功,刷新后查看",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

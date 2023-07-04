package ru.undefined.bugurter;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.ClipboardManager;
import android.content.ClipData;
import android.widget.Toast;
import android.widget.EditText;

import android.os.Bundle;

import ru.undefined.bugurter.BugurtHelper;

public class MainActivity extends AppCompatActivity {

    // 0xff00 + item id
    private static int menulast = 0xff00;
    private static final int MenuItem_COPYBUGURT = ++menulast;
    private static final int MenuItem_CONVERTBUGURT = ++menulast;
    private static final int MenuItem_CONVERTTEXT = ++menulast;
    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = (EditText)findViewById(R.id.bugurt_plain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(Menu.NONE, MenuItem_COPYBUGURT, Menu.NONE, "Скопировать в формате бугурта");
        menu.add(Menu.NONE, MenuItem_CONVERTBUGURT, Menu.NONE, "Конвертировать текст в бугурт");
        menu.add(Menu.NONE, MenuItem_CONVERTTEXT, Menu.NONE, "Конвертировать бугурт в текст");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId()==MenuItem_COPYBUGURT) {
            ClipboardManager cbman = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            cbman.setPrimaryClip(ClipData.newPlainText("Bugurt",
                BugurtHelper.toBugurt(edittext.getText().toString())
            ));
            Toast toast = Toast.makeText(this, "Скопировано!", 0);
            toast.show();
        } else if (item.getItemId()==MenuItem_CONVERTBUGURT) {
            edittext.setText(
                BugurtHelper.toBugurt(    
                    edittext.getText().toString()
                )
            );
        } else if (item.getItemId()==MenuItem_CONVERTTEXT) {
            edittext.setText(
                BugurtHelper.toText(    
                    edittext.getText().toString()
                )
            );
        } else return false;
        return true;
    }
}

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

    private EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = (EditText)findViewById(R.id.bugurt_plain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater()
            .inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId()==R.id.menu_copy_bugurt) {
            ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(ClipData.newPlainText("Bugurt",
                BugurtHelper.toBugurt(edittext.getText().toString())
            ));
            Toast.makeText(this, getString(R.string.copied), 0)
                .show();
        } else if (item.getItemId()==R.id.menu_convert_bugurt) {
            edittext.setText(
                BugurtHelper.toBugurt(    
                    edittext.getText().toString()
                )
            );
        } else if (item.getItemId()==R.id.menu_convert_text) {
            edittext.setText(
                BugurtHelper.toText(    
                    edittext.getText().toString()
                )
            );
        } else return false;
        return true;
    }
}

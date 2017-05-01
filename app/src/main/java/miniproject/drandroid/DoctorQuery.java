package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class DoctorQuery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_query);
    }


    public void sendQuery(View view) {
        Intent intent = getIntent();
        String usernameStr = intent.getStringExtra("username");
        EditText queryText = (EditText) findViewById(R.id.queryText);
        String queryStr = queryText.getText().toString();

        if (!queryStr.isEmpty()) {
            ParseObject usersDoc = new ParseObject("Queries");
            usersDoc.put("username", usernameStr);
            usersDoc.put("query", queryStr);
            usersDoc.saveInBackground();
            Toast.makeText(getApplicationContext(), "Query submitted", Toast.LENGTH_SHORT).show();
            queryText.setText("");

        }else
        {
            Toast.makeText(getApplicationContext(),"Your query is empty!!",Toast.LENGTH_SHORT).show();
            queryText.findFocus();
        }
    }
}

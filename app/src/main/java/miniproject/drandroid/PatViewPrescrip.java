package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.w3c.dom.Text;



import java.util.List;

public class PatViewPrescrip extends AppCompatActivity {
    String queryListString = "\n";
    String prescripListString = "\n",name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_view_prescrip);

        Intent intent = getIntent();
        name = intent.getStringExtra("username");

/*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Queries");
        query.whereEqualTo("username",name);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if(e == null){
                    //Success
                    for(ParseObject parseObject : objects){
                        String queryStr = parseObject.get("query").toString();
                        queryListString = queryListString + queryStr +"\n";
                    }
                    TextView queryListText = (TextView)findViewById(R.id.queryListTextView);
                    queryListText.setText(queryListString);


                }else {
                    Toast.makeText(getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        */

    }


    public void showPres(View view){
        Intent intent =new Intent(this,ShowPrescription.class);
        intent.putExtra("username",name);
        startActivity(intent);


    }

}

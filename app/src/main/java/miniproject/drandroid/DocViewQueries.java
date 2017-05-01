package miniproject.drandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class DocViewQueries extends AppCompatActivity {
    String queriesListString="\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_view_queries);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Queries");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if(e == null){
                    //Success
                    for(ParseObject parseObject : objects){
                        String patNameStr = parseObject.get("username").toString();

                        String queryStr = parseObject.get("query").toString();
                        queriesListString = queriesListString +"Name: "+patNameStr +"\n"+"Query: "+queryStr+"\n\n";

                    }
                    TextView queriesListText = (TextView)findViewById(R.id.queryListTextView);
                    queriesListText.setText(queriesListString);
                }else {
                    Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

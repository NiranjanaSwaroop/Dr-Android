package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class DocViewApptmts extends AppCompatActivity {
    String appointmentsListStr = "\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_view_apptmts);


        Intent intent = getIntent();
        String docNameStr = intent.getStringExtra("username");
        final TextView appointmentsText = (TextView)findViewById(R.id.appointmentsListTextView);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Appointments");
        query.whereEqualTo("docName",docNameStr);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if(e == null){
                    //appointment
                    for(ParseObject parseObject : objects){
                        String morningStr = parseObject.get("morning").toString();
                        String eveningStr = parseObject.get("evening").toString();
                        String patNameStr = parseObject.get("patName").toString();
                        if(morningStr.equalsIgnoreCase("true")){
                            morningStr = "Morning appointment";
                        }
                        else
                        {
                            morningStr = "No morning appointment";
                        }
                        if (eveningStr.equalsIgnoreCase("true"))
                        {
                            eveningStr = "Evening appointment";
                        }
                        else
                        {
                            eveningStr = "No evening appointment";
                        }
                        appointmentsListStr = appointmentsListStr+"Name:"+patNameStr+"\n"+morningStr+"\n"+eveningStr+"\n\n";
                        appointmentsText.setText(appointmentsListStr);

                    }
                }
                else
                {
                    //no appointments
                    Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                    appointmentsText.setText("No Appointments!");
                }

            }
        });

    }
}

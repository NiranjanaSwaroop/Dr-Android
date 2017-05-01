package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ShowPrescription extends AppCompatActivity {
    public  String prescripListString = "\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_prescription);
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");

        ParseUser currentUser = ParseUser.getCurrentUser();
        currentUser.logOut();
        
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Prescriptions");
        query.whereEqualTo("username",name);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if(e == null){
                    //Success
                    for(ParseObject parseObject : objects){
                        String docNameStr = parseObject.get("docName").toString();
                        String patNameStr = parseObject.get("patName").toString();
                        String prescriptionStr = parseObject.get("prescription").toString();
                        prescripListString = prescripListString + "Doctor:"+docNameStr +"\n"+"Patient:"+patNameStr+"\n"+"Prescription:"+prescriptionStr+"\n\n";
                    }
                    TextView prescripListText = (TextView)findViewById(R.id.prescripListTextView);
                    prescripListText.setText(prescripListString);
                    System.out.println(prescripListString);

                }else {
                    Toast.makeText(getApplicationContext(),e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        query.cancel();

    }
}

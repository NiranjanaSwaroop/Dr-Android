package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.FindCallback;
import java.util.List;

import android.widget.TextView;
import android.widget.Toast;

public class DoctorsList extends AppCompatActivity {
    String userNameStr,nameListStr = "\n",regNoListStr = "\n";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);


        Intent intent = getIntent();
        userNameStr = intent.getStringExtra("username");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Doctors");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if(e == null){
                    //Success
                    for(ParseObject parseObject : objects){
                        String docNameStr = parseObject.get("username").toString();

                        String docRegNoStr = parseObject.get("regNoDoc").toString();
                        nameListStr = nameListStr+docNameStr+"\n";
                        regNoListStr = regNoListStr+docRegNoStr+"\n" ;
                        System.out.println(docNameStr+"\t"+docRegNoStr);
                        System.out.println("----------------------------");
                        System.out.print(nameListStr);
                        System.out.print(regNoListStr);
                    }
                    TextView doctorsTextView = (TextView)findViewById(R.id.docTextView);
                    TextView regNoTextView = (TextView)findViewById(R.id.regTextView);
                    doctorsTextView.setText(nameListStr);
                    regNoTextView.setText(regNoListStr);
                }else {
                    Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}

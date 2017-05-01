package miniproject.drandroid;

import android.content.Intent;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class PatientHome extends AppCompatActivity {
    String userNameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        TextView patName = (TextView)findViewById(R.id.patNameTextView);
        Intent intent = getIntent();
        userNameStr = intent.getStringExtra("namePatStr");
        patName.setText(userNameStr);
    }

    public void showDocList(View view)
    {
        Intent intent = new Intent(this,DoctorsList.class);
        intent.putExtra("username",userNameStr);
        startActivity(intent);

    }

    public void askDocQuery(View view){
        Intent intent =  new Intent(this,DoctorQuery.class);
        intent.putExtra("username",userNameStr);
        startActivity(intent);
    }

    public void bookAppointment(View view)
    {
        Intent intent = new Intent(this,PatientAppointment.class);
        intent.putExtra("username",userNameStr);
        startActivity(intent);
    }

    public void showPrescription(View view)
    {
        Intent intent = new Intent(this,PatViewPrescrip.class);
        intent.putExtra("username",userNameStr);
        startActivity(intent);
    }
}

package miniproject.drandroid;

import android.content.Intent;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class DoctorHome extends AppCompatActivity {
    String docNameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        Intent intent = getIntent();
        TextView docNameTextView = (TextView)findViewById(R.id.docNameTextView);
        docNameStr = intent.getStringExtra("docNameStr");
        docNameTextView.setText(docNameStr);
    }


    public void showQueries(View view)
    {
        Intent intent = new Intent(this,DocViewQueries.class);
        intent.putExtra("username",docNameStr);
        startActivity(intent);
    }

    public void viewAppointments(View view)
    {
        Intent intent = new Intent(this,DocViewApptmts.class);
        intent.putExtra("username",docNameStr);
        startActivity(intent);

    }

    public void writePescription(View view)
    {
        Intent intent = new Intent(this,DoctorWrite.class);
        intent.putExtra("username",docNameStr);
        startActivity(intent);
    }
}

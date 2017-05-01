package miniproject.drandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Welcome_Patient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__patient);
    }

    public void enterPatSignup(View view)
    {
        Intent intent = new Intent(this,PatientEmail.class);
        startActivity(intent);
    }

    public void logInPatient(View view)
    {
        final EditText userNamePatText = (EditText)findViewById(R.id.userNamePatText);
        final String userNamePatStr = userNamePatText.getText().toString();
        final EditText passwordPatText = (EditText)findViewById(R.id.passwordPatText);
        String passwordPatStr = passwordPatText.getText().toString();

        ParseUser.logInInBackground(userNamePatStr, passwordPatStr, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {

                    Toast.makeText(getApplicationContext(),"Login Sucessful ,"+parseUser.getUsername().toString(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Welcome_Patient.this,PatientHome.class);
                    intent.putExtra("namePatStr",userNamePatStr);
                    userNamePatText.setText("");
                    passwordPatText.setText("");



                    startActivity(intent);

                } else {

                    Toast.makeText(getApplicationContext(),"Login Fail "+ e.getMessage() +" Please re-try",Toast.LENGTH_LONG).show();
                    userNamePatText.setText("");
                    passwordPatText.setText("");

                }
            }
        });


    }
}


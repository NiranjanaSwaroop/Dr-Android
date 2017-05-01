package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class PatientPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_password);

    }

    public void enterPatSignup(View view)
    {
        final Intent intent = getIntent();
        String emailPatStr = intent.getStringExtra("emailPatStr");
        final String namePatStr = intent.getStringExtra("namePatStr");
        final EditText passwordPatText = (EditText)findViewById(R.id.passwordPatText);
        String passwordPatStr = passwordPatText.getText().toString();
        if(!passwordPatStr.isEmpty())
        {
            ParseObject usersPat = new ParseObject("Patients");
            usersPat.put("email",emailPatStr);
            usersPat.put("name",namePatStr);
            usersPat.put("password",passwordPatStr);
            usersPat.put("patients",true);
            usersPat.saveInBackground();

            ParseUser currentUser = ParseUser.getCurrentUser();
            currentUser.logOut();

            ParseUser userPat = new ParseUser();
            userPat.setEmail(emailPatStr);
            userPat.setUsername(namePatStr);
            userPat.setPassword(passwordPatStr);


            userPat.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        //Register successful
                        Toast.makeText(getApplicationContext(),"Register successfull ",Toast.LENGTH_SHORT).show();
                        passwordPatText.setText("");
                        Intent intent = new Intent(PatientPassword.this,FinalPatSignUp.class);
                        intent.putExtra("namePatStr",namePatStr);
                        startActivity(intent);
                    }
                    else{
                        //Register unsuccessful
                        Toast.makeText(getApplicationContext(),"Register unsuccessfull "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                        passwordPatText.setText("");
                    }
                }
            });
        }

    }
}

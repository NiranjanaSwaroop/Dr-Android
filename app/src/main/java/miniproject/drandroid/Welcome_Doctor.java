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

public class Welcome_Doctor extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "welcome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__doctor);
    }
    public void signUpDoctor(View view)
    {
        Intent intent = new Intent(this,signUpDoctor.class);
        String message = "Welcome Doctor";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void logInDoctor(View view)
    {
        final EditText userNameDocText = (EditText)findViewById(R.id.userNameDocText);
        final String userNameDocStr = userNameDocText.getText().toString();
        final EditText passwordDocText = (EditText)findViewById(R.id.passwordDocText);
        String passwordDocStr = passwordDocText.getText().toString();

        ParseUser.logInInBackground(userNameDocStr, passwordDocStr, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {

                        Toast.makeText(getApplicationContext(),"Login Sucessful ,"+parseUser.getUsername().toString(),Toast.LENGTH_LONG).show();
                        userNameDocText.setText("");
                        passwordDocText.setText("");
                       Intent intent = new Intent(Welcome_Doctor.this,DoctorHome.class);
                        intent.putExtra("docNameStr",userNameDocStr);
                        startActivity(intent);

                } else {

                    Toast.makeText(getApplicationContext(),"Login Fail "+ e.getMessage() +" Please re-try",Toast.LENGTH_LONG).show();
                    userNameDocText.setText("");
                    passwordDocText.setText("");

                }
            }
        });


    }

}

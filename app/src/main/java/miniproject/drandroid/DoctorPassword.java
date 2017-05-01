package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class DoctorPassword extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_password);




    }


    public void enterDocSignup(View view) {


        EditText passwordText = (EditText) findViewById(R.id.passwordDocText);
        String passwordStr = passwordText.getText().toString();
        Intent intent;
        if(!passwordStr.isEmpty()) {
            intent = getIntent();
            String emailDocStr = intent.getStringExtra("emailDocStr");
            String regNoStr = intent.getStringExtra("regNoStr");
            String nameDocStr = intent.getStringExtra("nameDocStr");

            ParseObject usersDoc = new ParseObject("Doctors");
            usersDoc.put("email",emailDocStr);
            usersDoc.put("username", nameDocStr);
            usersDoc.put("regNoDoc", regNoStr);
            usersDoc.put("password", passwordStr);
            usersDoc.put("doctor",true);
            usersDoc.saveInBackground();


            ParseUser currentUser = ParseUser.getCurrentUser();
            currentUser.logOut();
            ParseUser userDoc = new ParseUser();
            userDoc.setEmail(emailDocStr);
            userDoc.setPassword(passwordStr);
            userDoc.setUsername(nameDocStr);
            userDoc.put("regNoDoc", regNoStr);

            userDoc.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e == null){
                        //Register successfull
                        Toast.makeText(getApplicationContext(), "Register successfull ", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DoctorPassword.this, FinalDocSignup.class);
                        startActivity(intent);

                    }else{
                        //Register fail
                        Toast.makeText(getApplicationContext(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                }
            });

            passwordText.setText("");


        }else{
            Toast.makeText(getApplicationContext(),"You left the field empty!",Toast.LENGTH_LONG).show();
            passwordText.setText("");
            passwordText.findFocus();
        }


    }



}


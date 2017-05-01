package miniproject.drandroid;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

public class signUpDoctor extends AppCompatActivity {
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_doctor);

        btn = (Button)findViewById(R.id.continueEmailButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                enterNamePage();
            }
        });






    }
    public void enterNamePage()
    {
        Intent intent = new Intent(this,DoctorName.class);
        EditText emailDocText = (EditText)findViewById(R.id.emailDocText);
        String emailDocStr = emailDocText.getText().toString();
        if(!emailDocStr.isEmpty()) {
            intent.putExtra("emailDocStr",emailDocStr );
            startActivity(intent);
        }else
        {
            Toast.makeText(getApplicationContext(),"You have left the field empty!",Toast.LENGTH_LONG).show();
            emailDocText.setText("");
        }
    }

}

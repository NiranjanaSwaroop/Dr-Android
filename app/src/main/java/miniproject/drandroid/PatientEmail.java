package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientEmail extends AppCompatActivity {

    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_email);

        btn = (Button)findViewById(R.id.continuePatEmailButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterNamePatPage();
            }
        });
    }

    public void enterNamePatPage()
    {
        Intent intent = new Intent(this,PatientName.class);
        EditText emailPatText = (EditText)findViewById(R.id.emailPatText);
        String emailPatStr = emailPatText.getText().toString();
        if(!emailPatStr.isEmpty()) {
            intent.putExtra("emailPatStr", emailPatStr);
            startActivity(intent);
        }else
        {
            Toast.makeText(getApplicationContext(),"You left the field empty!",Toast.LENGTH_SHORT).show();
            emailPatText.setText("");
            emailPatText.findFocus();
        }
    }
}

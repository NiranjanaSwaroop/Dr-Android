package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientName extends AppCompatActivity {

    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_name);

        btn = (Button)findViewById(R.id.continuePatNameButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPasswordPatPage();
            }
        });
    }
    public void enterPasswordPatPage()
    {
        Intent intent = getIntent();
        String emailPatStr = intent.getStringExtra("emailPatStr");
        EditText namePatText = (EditText)findViewById(R.id.namePatText);
        String namePatStr = namePatText.getText().toString();
        if(!namePatStr.isEmpty()) {
            intent = new Intent(this, PatientPassword.class);
            intent.putExtra("emailPatStr",emailPatStr);
            intent.putExtra("namePatStr",namePatStr);
            startActivity(intent);
        }else
        {
            Toast.makeText(getApplicationContext(),"You left the field empty!",Toast.LENGTH_SHORT).show();
            namePatText.setText("");
            namePatText.findFocus();
        }
    }
}

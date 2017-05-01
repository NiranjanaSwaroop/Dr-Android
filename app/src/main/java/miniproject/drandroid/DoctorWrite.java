package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

public class DoctorWrite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_write);
    }

    public void sendPresciption(View view)
    {
        Intent intent = getIntent();
        String docNameStr = intent.getStringExtra("username");
        EditText patNameText = (EditText)findViewById(R.id.patNameText);
        EditText prescriptionText = (EditText)findViewById(R.id.prescriptionDocText);
        String patNameStr = patNameText.getText().toString();
        String prescriptionStr = prescriptionText.getText().toString();

        if(patNameStr.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Patient name is empty!",Toast.LENGTH_SHORT).show();
            patNameText.findFocus();
        }
        if (prescriptionStr.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Prescription is empty!",Toast.LENGTH_SHORT).show();
            prescriptionText.findFocus();
        }
        if(!patNameStr.isEmpty() && !prescriptionStr.isEmpty())
        {
            ParseObject prescriptions = new ParseObject("Prescriptions");
            prescriptions.put("docName",docNameStr);
            prescriptions.put("patName",patNameStr);
            prescriptions.put("prescription",prescriptionStr);
            prescriptions.saveInBackground();
            Toast.makeText(getApplicationContext(),"Presription sent",Toast.LENGTH_SHORT).show();
            patNameText.setText("");
            prescriptionText.setText("");

        }

    }
}

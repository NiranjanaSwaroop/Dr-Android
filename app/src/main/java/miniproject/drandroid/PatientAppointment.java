package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

public class PatientAppointment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_appointment);
    }

    public void submitAppointment(View view) {

        CheckBox morningBox = (CheckBox) findViewById(R.id.morningCheckBox);
        CheckBox eveningBox = (CheckBox) findViewById(R.id.eveningCheckBox);
        boolean morning = morningBox.isChecked();
        boolean evening = eveningBox.isChecked();
        if (morning || evening) {
            EditText docNameText = (EditText) findViewById(R.id.docNameText);
            String docNameStr = docNameText.getText().toString();
            if (!docNameStr.isEmpty()) {

                Intent intent = getIntent();
                String patNameStr = intent.getStringExtra("username");

                ParseObject appointments = new ParseObject("Appointments");
                appointments.put("morning", morning);
                appointments.put("evening", evening);
                appointments.put("docName", docNameStr);
                appointments.put("patName", patNameStr);
                appointments.saveInBackground();
                docNameText.setText("");
                morningBox.setChecked(false);
                eveningBox.setChecked(false);
                Toast.makeText(getApplicationContext(), "Requested appointent!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Doctor name should not be empty!", Toast.LENGTH_SHORT).show();
                docNameText.findFocus();
            }


        } else {
            Toast.makeText(getApplicationContext(), "You should atleast select one of them", Toast.LENGTH_LONG).show();
        }
    }
}

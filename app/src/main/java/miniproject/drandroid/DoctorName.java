package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorName extends AppCompatActivity {
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_name);

        btn = (Button)findViewById(R.id.continueNameButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                enterRegNoPage();
            }
        });
    }

    public void enterRegNoPage()
    {
        Intent intent = getIntent();
        String emailDocStr = intent.getStringExtra("emailDocStr");
        EditText nameDocText = (EditText)findViewById(R.id.nameDocText);
        String nameDocStr = nameDocText.getText().toString();
        if(!nameDocStr.isEmpty()) {
            intent = new Intent(this, DoctorRegNo.class);
            intent.putExtra("nameDocStr", nameDocStr);
            intent.putExtra("emailDocStr",emailDocStr);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"You left the field empty!",Toast.LENGTH_LONG).show();
            nameDocText.setText("");
        }
    }
}

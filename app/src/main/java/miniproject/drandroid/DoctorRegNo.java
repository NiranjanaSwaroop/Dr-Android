package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorRegNo extends AppCompatActivity {
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_reg_no);

        btn = (Button)findViewById(R.id.continueRegNoButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                enterPasswordPage();
            }
        });
    }




    public void enterPasswordPage()
    {
        Intent intent = getIntent();
        String nameDocStr = intent.getStringExtra("nameDocStr");
        String emailDocStr = intent.getStringExtra("emailDocStr");
        EditText regNoText = (EditText)findViewById(R.id.regNoText);
        String regNoStr = regNoText.getText().toString();
        if(!regNoStr.isEmpty()) {
            intent = new Intent(this, DoctorPassword.class);
            intent.putExtra("regNoStr",regNoStr);
            intent.putExtra("nameDocStr",nameDocStr);
            intent.putExtra("emailDocStr",emailDocStr);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"You left the field empty!",Toast.LENGTH_LONG).show();
            regNoText.setText("");
        }
    }
}

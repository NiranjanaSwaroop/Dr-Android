package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalPatSignUp extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_pat_sign_up);


    }
    public void enterPatLogInPage(View view)
    {
        Intent intent = getIntent();
        String namePatStr = intent.getStringExtra("namePatStr");
        intent = new Intent(this,Welcome_Patient.class);
        intent.putExtra("namePatStr",namePatStr);
        startActivity(intent);
    }
}

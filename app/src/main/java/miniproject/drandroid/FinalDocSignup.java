package miniproject.drandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalDocSignup extends AppCompatActivity {
public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_doc_signup);

        btn = (Button)findViewById(R.id.logInFirstButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                enterLogInPage();
            }
        });
    }


    public void enterLogInPage()
    {
        Intent intent = new Intent(this,Welcome_Doctor.class);
        startActivity(intent);
    }

}

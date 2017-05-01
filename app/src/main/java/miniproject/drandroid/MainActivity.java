package miniproject.drandroid;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.content.Intent;
        import android.widget.EditText;
        import android.widget.Toast;
        import android.net.ConnectivityManager;
        import android.content.Context;

        import com.parse.Parse;
        import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "welcome";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null) {
            try {
                Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("3srj3eQk87PoOc4WCFnoFnYLL5ZLxIBuWFt1TlZ5")
                        .clientKey("UrFEeRGet24SdEytDw349Ccz7srBbzI8aPaScqLM")
                        .server("https://parseapi.back4app.com/").build()
                );
            } catch (IllegalStateException e) {
            }
        }else {
            Toast.makeText(getApplicationContext(),"No Internet!!!",Toast.LENGTH_LONG).show();
        }
    }

    public void enterDoctor(View view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null) {
            try {
                Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("3srj3eQk87PoOc4WCFnoFnYLL5ZLxIBuWFt1TlZ5")
                        .clientKey("UrFEeRGet24SdEytDw349Ccz7srBbzI8aPaScqLM")
                        .server("https://parseapi.back4app.com/").build()
                );
            } catch (IllegalStateException e) {
            }
            Intent intent = new Intent(this, Welcome_Doctor.class);
            String message = "Welcome Doctor";
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "No Internet!!!", Toast.LENGTH_LONG).show();
        }
    }

    public void enterPaient(View view)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() != null){
            try {
                Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("3srj3eQk87PoOc4WCFnoFnYLL5ZLxIBuWFt1TlZ5")
                        .clientKey("UrFEeRGet24SdEytDw349Ccz7srBbzI8aPaScqLM")
                        .server("https://parseapi.back4app.com/").build()
                );
            } catch (IllegalStateException e) {
            }
        Intent intent = new Intent(this,Welcome_Patient.class);
        String message = "Welcome Patient";
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "No Internet!!!", Toast.LENGTH_LONG).show();
        }
    }

    public void showAbout(View view)
    {
        Intent intent = new Intent(this,About.class);
        startActivity(intent);
    }




}

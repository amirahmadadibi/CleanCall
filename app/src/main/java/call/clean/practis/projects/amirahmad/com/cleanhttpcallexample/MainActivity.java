package call.clean.practis.projects.amirahmad.com.cleanhttpcallexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import call.clean.practis.projects.amirahmad.com.cleanhttpcallexample.HttpRequest.GetRequest;
import call.clean.practis.projects.amirahmad.com.cleanhttpcallexample.HttpRequest.GetRequestBuilder;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupLogger();
        //without Builder Pattern
//        new GetRequest("https://publicobject.com/helloworld.txt")
//                .sendGerRequest(new GetRequest.responseImp() {
//                    @Override
//                    public void onSuccessFulCall(String response) {
//                        Logger.d(response);
//                        Log.d("test", "onSuccessFulCall: " + response);
//                    }
//
//                    @Override
//                    public void onFailedCall(IOException e) {
//                        e.printStackTrace();
//                    }
//                });
        //with Builder Pattern
        new GetRequestBuilder()
                .setmUrl("https://publicobject.com/helloworld.txt")
                .createGetRequest()
                .sendGerRequest(new GetRequest.responseImp() {
                    @Override
                    public void onSuccessFulCall(String response) {
                        Logger.d(response);
                    }
                    @Override
                    public void onFailedCall(IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private void setupLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}

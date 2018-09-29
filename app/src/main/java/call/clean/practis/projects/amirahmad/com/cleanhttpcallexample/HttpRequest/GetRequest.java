package call.clean.practis.projects.amirahmad.com.cleanhttpcallexample.HttpRequest;

import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetRequest {
    String mUrl;
    private Call call;

    public GetRequest(String url) {
        this.mUrl = url;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(mUrl)
                .build();
        call = client.newCall(request);
    }

    public void sendGerRequest(final responseImp responseImp) {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                responseImp.onFailedCall(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                responseImp.onSuccessFulCall(response.body().string());
                Log.d("test", "onResponse: " + response);
            }
        });
    }


    public interface responseImp {
        void onSuccessFulCall(String response);

        void onFailedCall(IOException e);
    }

}

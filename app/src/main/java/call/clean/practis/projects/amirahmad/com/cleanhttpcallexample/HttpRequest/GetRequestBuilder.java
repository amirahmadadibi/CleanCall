package call.clean.practis.projects.amirahmad.com.cleanhttpcallexample.HttpRequest;

public class GetRequestBuilder {
    private String mUrl;

    public GetRequestBuilder setmUrl(String mUrl) {
        this.mUrl = mUrl;
        return this;
    }

    public GetRequest createGetRequest() {
        return new GetRequest(mUrl);
    }
}
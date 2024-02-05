import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Login_Api_3 {

    private static final String API_URL = "http://localhost:3000/api/session";
    private static final String COOKIE_HEADER = "metabase.DEVICE=55f22276-7652-4ff4-b7be-97890d600ffc; metabase.TIMEOUT=alive; metabase.SESSION=18797c81-2b7c-4edf-9ee6-053b669ae19e";
    private static final String CONTENT_TYPE_HEADER = "application/json";
    private static final String USER_AGENT_HEADER = "insomnia/8.3.0";
    private static final String AUTHORIZATION_HEADER = "Bearer 8b03b82e-d22d-45d5-8a90-e2e5bedeec94";
    private static final String EMPTY_REQUEST_BODY = "{\n\t\"username\": \"\",\n\t\"password\": \"\"\n}";

    public static void main(String[] args) throws Exception {
        MetabaseApiRequest apiRequest = new MetabaseApiRequest();
        apiRequest.sendEmptyRequestBodyRequest();
    }

    public void sendEmptyRequestBodyRequest() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("cookie", COOKIE_HEADER)
                .header("Content-Type", CONTENT_TYPE_HEADER)
                .header("User-Agent", USER_AGENT_HEADER)
                .header("Authorization", AUTHORIZATION_HEADER)
                .method("POST", HttpRequest.BodyPublishers.ofString(EMPTY_REQUEST_BODY))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}

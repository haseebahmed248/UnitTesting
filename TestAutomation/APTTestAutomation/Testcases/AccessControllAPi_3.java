import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccessControllAPi_3 {

    public static void main(String[] args) throws Exception {
        HttpResponse<String> response = makeInvalidTokenRequest();
        verifyUnauthorizedStatus(response);
    }

    private static HttpResponse<String> makeInvalidTokenRequest() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000/api/session"))
                .header("cookie", "123")
                .header("Content-Type", "application/json")
                .header("User-Agent", "insomnia/8.3.0")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\n\t\"username\": \"f219485@cfd.nu.edu.pk\",\n\t\"password\": \"aiman@1234\"\n}"))
                .build();

        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static void verifyUnauthorizedStatus(HttpResponse<String> response) {
        if (response.statusCode() == 401) {
            System.out.println("Unauthorized request. Response body: " + response.body());
        } else {
            System.out.println("Unexpected response. Response code: " + response.statusCode() +
                    ", Response body: " + response.body());
        }
    }
}

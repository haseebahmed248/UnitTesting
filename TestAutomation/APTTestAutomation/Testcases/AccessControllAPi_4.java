import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccessControllAPi_4 {

    public static void main(String[] args) throws Exception {
        HttpResponse<String> response = makeInvalidEndpointRequest();
        verifyNotFoundStatus(response);
    }

    private static HttpResponse<String> makeInvalidEndpointRequest() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000/api/123"))
                .header("Content-Type", "application/json")
                .header("User-Agent", "insomnia/8.3.0")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\n\t\"username\": \"f219485@cfd.nu.edu.pk\",\n\t\"password\": \"aiman@1234\"\n}"))
                .build();

        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static void verifyNotFoundStatus(HttpResponse<String> response) {
        if (response.statusCode() == 404) {
            System.out.println("Not Found. Response body: " + response.body());
        } else {
            System.out.println("Unexpected response. Response code: " + response.statusCode() +
                    ", Response body: " + response.body());
        }
    }
}

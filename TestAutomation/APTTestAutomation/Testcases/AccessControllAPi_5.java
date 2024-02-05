import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AccessControllAPi_5 {

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            HttpResponse<String> response = makeAccessControlRequest();
            verifyResponseStatus(response, i);
        }
    }

    private static HttpResponse<String> makeAccessControlRequest() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000/api/session"))
                .header("cookie", "metabase.DEVICE=55f22276-7652-4ff4-b7be-97890d600ffc; metabase.TIMEOUT=alive; metabase.SESSION=18797c81-2b7c-4edf-9ee6-053b669ae19e")
                .header("Content-Type", "application/json")
                .header("User-Agent", "insomnia/8.3.0")
                .header("Authorization", "Bearer 8b03b82e-d22d-45d5-8a90-e2e5bedeec94")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\n\t\"username\": \"f219485@cfd.nu.edu.pk\",\n\t\"password\": \"aiman@1234\"\n}"))
                .build();

        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static void verifyResponseStatus(HttpResponse<String> response, int requestNumber) {
        if (response.statusCode() >= 200 && response.statusCode() < 300) {
            System.out.println("Request " + requestNumber + " successful. Response body: " + response.body());
        } else {
            System.out.println("Request " + requestNumber + " failed. Response code: " + response.statusCode() +
                    ", Response body: " + response.body());
        }
    }
}

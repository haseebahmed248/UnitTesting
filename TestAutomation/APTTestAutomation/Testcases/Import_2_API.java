import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Import_2_API {


    public static void main(String[] args) throws Exception {
        UnsupportedFileImportApiRequest apiRequest = new UnsupportedFileImportApiRequest();
        apiRequest.sendUnsupportedFileImportRequest();
    }

    public void sendUnsupportedFileImportRequest() throws Exception {
        Path filePath = Paths.get("C:/Downloads/abc.csv");
        byte[] fileBytes = Files.readAllBytes(filePath);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("cookie", COOKIE_HEADER)
                .header("Content-Type", CONTENT_TYPE_HEADER)
                .header("User-Agent", USER_AGENT_HEADER)
                .header("Authorization", AUTHORIZATION_HEADER)
                .POST(buildMultipartBody(fileBytes, "abc.txt"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        verifyErrorResponse(response, 400, "Unsupported file format");
    }

    private HttpRequest.BodyPublisher buildMultipartBody(byte[] fileBytes, String fileName) {
        return HttpRequest.BodyPublishers.ofMultipartData("file", fileName, HttpRequest.BodyPublishers.ofByteArray(fileBytes));
    }

    private void verifyErrorResponse(HttpResponse<String> response, int expectedStatusCode, String expectedErrorMessage) {
        if (response.statusCode() == expectedStatusCode && response.body().contains(expectedErrorMessage)) {
            System.out.println("Expected error response. Response code: " + response.statusCode() +
                    ", Response body: " + response.body());
        } else {
            System.out.println("Unexpected response. Response code: " + response.statusCode() +
                    ", Response body: " + response.body());
        }
    }
}

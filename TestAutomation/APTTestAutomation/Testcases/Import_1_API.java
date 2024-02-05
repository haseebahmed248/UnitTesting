import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Import_1_API {
    public static void main(String[] args) throws Exception {
        FileImportApiRequest apiRequest = new FileImportApiRequest();
        apiRequest.sendFileImportRequest();
    }

    public void sendFileImportRequest() throws Exception {
        Path filePath = Paths.get("path/to/your/file.txt"); 
        byte[] fileBytes = Files.readAllBytes(filePath);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("cookie", COOKIE_HEADER)
                .header("Content-Type", CONTENT_TYPE_HEADER)
                .header("User-Agent", USER_AGENT_HEADER)
                .header("Authorization", AUTHORIZATION_HEADER)
                .POST(buildMultipartBody(fileBytes, "file.txt"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        verifySuccessMessage(response);
    }

    private HttpRequest.BodyPublisher buildMultipartBody(byte[] fileBytes, String fileName) {
        return HttpRequest.BodyPublishers.ofMultipartData("file", fileName, HttpRequest.BodyPublishers.ofByteArray(fileBytes));
    }

    private void verifySuccessMessage(HttpResponse<String> response) {
        if (response.statusCode() == 200) { 
            System.out.println("Success. Response body: " + response.body());
        } else {
            System.out.println("Unexpected response. Response code: " + response.statusCode() +
                    ", Response body: " + response.body());
        }
    }
}


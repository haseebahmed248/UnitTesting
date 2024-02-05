import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Import_5_API {

    private static final String API_URL = "http://localhost:3000/api/file/import";

    public static void main(String[] args) throws IOException, InterruptedException {
        UnauthorizedFileImportApiRequest apiRequest = new UnauthorizedFileImportApiRequest();
        apiRequest.sendUnauthorizedFileImportRequest();
    }

    public void sendUnauthorizedFileImportRequest() throws IOException, InterruptedException {
        Path filePath = Paths.get("C:/Downloads/file.csv");
        byte[] fileBytes = Files.readAllBytes(filePath);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "text/csv") 
                .POST(HttpRequest.BodyPublishers.ofByteArray(fileBytes))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response Code: " + response.statusCode() + "Response Body: " + response.body());
    }
}

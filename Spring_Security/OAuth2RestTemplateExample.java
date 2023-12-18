import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

public class OAuth2RestTemplateExample {

    public static void main(String[] args) {
        // Configure OAuth2 client details
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId("my-client-id");
        resourceDetails.setClientSecret("my-client-secret");
        resourceDetails.setAccessTokenUri("my-token-uri");
        resourceDetails.setScope(Arrays.asList("read", "write"));

        // Create an OAuth2RestTemplate
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);

        // Make a request using RestTemplate with the access token
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.example.com/resource", String.class);

        // Process the response
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response: " + response.getBody());
        } else {
            System.err.println("Error: " + response.getStatusCode());
        }

        // If we need to include the access token in the request headers for subsequent requests
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(restTemplate.getAccessToken().getTokenValue());

        // For example, making another request with the obtained access token
        ResponseEntity<String> anotherResponse = restTemplate.exchange(
                "https://api.example.com/another-resource",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);

        // Process the response for the second request
        if (anotherResponse.getStatusCode().is2xxSuccessful()) {
            System.out.println("Another Response: " + anotherResponse.getBody());
        } else {
            System.err.println("Error in Another Request: " + anotherResponse.getStatusCode());
        }
    }
}

package backend.wil.autoswap.configs;



import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import com.google.gson.Gson;

import backend.wil.autoswap.secrets.AwsSecrets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class ApplicationConfig {
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretkey;


    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource() {
        AwsSecrets secrets = getSecret();
        return DataSourceBuilder
                .create()
                  .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:" + secrets.getEngine() + "://" + secrets.getHost() + ":" + secrets.getPort() + "/autoswap?useSSL=true")
//                .url("jdbc:mysql://localhost:3306/autoswap?useSSL=false")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }



 public AwsSecrets getSecret() {

     String secretName = "autoswap-db";
     Region region = Region.of("us-east-2");

     // Create a Secrets Manager client
     SecretsManagerClient client = SecretsManagerClient.builder()
             .region(region)
             .build();

     GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
             .secretId(secretName)
             .build();

     GetSecretValueResponse getSecretValueResponse;

     try {
         getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
         String secret = getSecretValueResponse.secretString();
         return gson.fromJson(secret, AwsSecrets.class);
     } catch (Exception e) {
         // For a list of exceptions thrown, see
         // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
         throw e;
     }

     
   
     // Your code goes here.
 }

 


   

}
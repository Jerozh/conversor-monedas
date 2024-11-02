import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {

         String moneda1;
         String moneda2;
         double cantidad;
        String json = "{\"Conversion\": \"0\"}";

    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public ConexionApi(String moneda1, String moneda2, double cantidad) {
        this.moneda1 = moneda1;
        this.moneda2 = moneda2;
        this.cantidad = cantidad;
    }

        HttpClient cliente = HttpClient
                .newBuilder()
                .build();

        public String realizarPeticion() throws IOException, InterruptedException {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/c9f657d3d004c21d869c6ddf/pair/" + moneda1 + "/" + moneda2 + "/" + cantidad))
                    .GET()
                    .build();

            HttpResponse<String> response = cliente.send(request,
                    HttpResponse
                            .BodyHandlers.ofString());

            String json = response.body();
               // resultado = gson.fromJson(json, String.class);

            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

            String conversionResponse = jsonObject.get("conversion_result").getAsString();

            if (response.statusCode() == 200) {
                //return json;
              return conversionResponse;
            } else {
                return "Error: " + response.statusCode();
            }
        }
    }


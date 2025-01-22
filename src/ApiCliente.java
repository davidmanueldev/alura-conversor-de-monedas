import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiCliente {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5a58ffeace89b902305799ce/latest/";

    public static double convertirMoneda(String origen, String objetivo, double cantidad) throws Exception {
        String requestUrl = API_URL + origen;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        TipoCambio tipoCambio = gson.fromJson(response.body(), TipoCambio.class);

        Map<String, Double> tasas = tipoCambio.getRates();
        if (tasas.containsKey(objetivo)) {
            return cantidad * tasas.get(objetivo);
        } else {
            throw new IllegalArgumentException("Moneda de destino no válida. (Moneda no encontrada en la lista de tasas)");
        }
    }
}

package controller;

import com.google.gson.Gson;
import model.Clasificacion;
import model.Liga;
import model.Equipo;
import model.Team;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIController {

    //Variable para almacenar el ENDPOINT común
    private String urlBase = "https://www.thesportsdb.com/api/v1/json/123/";

    public void obtenerLigas() {
        //1. Debemos Obtener URL
        String urlLigas = urlBase + "all_leagues.php";

        try {
            //Uso de GSON para realizar la conversion directa
            Gson gson = new Gson();

            //2. Abrimos el Navegador - HttpClient permite hacer una petición hacia afuera.
            HttpClient client = HttpClient.newHttpClient(); //Construimos de forma directa

            //3. Petición de lo que se va a realizar.
            HttpRequest request = HttpRequest
                    .newBuilder() //Creamos
                    .uri(URI.create(urlLigas))// A quien le pedimos la petición
                    .GET() // Obtener Datos
                    .build(); //Construimos la petición

            //4. Obtenemos respuesta
            HttpResponse<String> response = client.send(request //Petición
                    , HttpResponse.BodyHandlers.ofString() //Se gestiona con HttpResponse mediante los header y que se convierta en String
            );//Lanzo la petición

            //Leemos el Objeto
            JSONObject objectLigas = new JSONObject(response.body());
            JSONArray arrayLigas = objectLigas.getJSONArray("leagues");

            //Devolvemos todas
            for (int i = 0; i < arrayLigas.length(); i++) {
                //Obtenemos la posición
                JSONObject ligaJSON = arrayLigas.getJSONObject(i);

                Liga liga = gson.fromJson(
                        ligaJSON.toString(), // Convertimos a String
                        Liga.class //La clase a la que se quiere convertir
                );

                System.out.println(liga);
            }
            //Mostramos resultados
            //String body = response.body();
            //System.out.println(body);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void obtenerClasificacion(String id){
        String urlClasificacion = urlBase + "lookuptable.php?l=" + String.valueOf(id);

        try {
            //Uso de GSON para realizar la conversion directa
            Gson gson = new Gson();

            //2. Abrimos el Navegador - HttpClient permite hacer una petición hacia afuera.
            HttpClient client = HttpClient.newHttpClient(); //Construimos de forma directa

            //3. Petición de lo que se va a realizar.
            HttpRequest request = HttpRequest
                    .newBuilder() //Creamos
                    .uri(URI.create(urlClasificacion))// A quien le pedimos la petición
                    .GET() // Obtener Datos
                    .build(); //Construimos la petición

            //4. Obtenemos respuesta
            HttpResponse<String> response = client.send(request //Petición
                    , HttpResponse.BodyHandlers.ofString() //Se gestiona con HttpResponse mediante los header y que se convierta en String
            );//Lanzo la petición

            //Leemos el Objeto
            JSONObject objectClasificacion = new JSONObject(response.body());
            JSONArray arrayEquipos = objectClasificacion.getJSONArray("table");

            System.out.println("ID EQUIPO: " + id);

            //Devolvemos todas
            for (int i = 0; i < arrayEquipos.length(); i++) {
                //Obtenemos la posición
                JSONObject equipoJSON = arrayEquipos.getJSONObject(i);

                Equipo equipo = gson.fromJson(
                        equipoJSON.toString(), // Convertimos a String
                        Equipo.class //La clase a la que se quiere convertir
                );

                System.out.printf("%s - %s - %s - %s - %s%n",
                        equipo.getIntRank(),
                        equipo.getStrTeam(),
                        equipo.getIntWin(),
                        equipo.getIntDraw(),
                        equipo.getIntLoss()
                );
            }
            //Mostramos resultados
            //String body = response.body();
            //System.out.println(body);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void obtenerClasificacionCompleta(String id){
        String urlClasificacion = urlBase + "lookuptable.php?l=" + id;

        try {
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlClasificacion))
                    .GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject objectClasificacion = new JSONObject(response.body());
            Clasificacion clasificacion = gson.fromJson(objectClasificacion.toString(), Clasificacion.class);

            for (int i = 0; i <clasificacion.getTable().length; i++) {
                Team team = clasificacion.getTable()[i];
                System.out.printf("%s - %s - %s - %s - %s%n",
                        team.getIntRank(),
                        team.getStrTeam(),
                        team.getIntWin(),
                        team.getIntDraw(),
                        team.getIntLoss()
                );
            }
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}

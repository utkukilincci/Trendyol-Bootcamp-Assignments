package endpoints;

import helper.Helper;
import io.restassured.response.Response;
import org.json.JSONObject;
import spec.RequestSpec;
import spec.ResponseSpec;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class User extends RequestSpec {

    public User() {
        super("https://petstore.swagger.io/v2/user");
    }

    public Response get(Object username, int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .get("/{username}",username)
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }
    public Response post(String jsonFile, int statusCode) throws IOException {

        JSONObject jsonObject = Helper.readJsonFile(jsonFile);
        Long id = Helper.createId();
        jsonObject.put("id", id);

        return   given()
                    .spec(super.getRequestSpecification())
                    .body(jsonObject.toString())
                    .post()
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();

    }

    public Response put(Object username, String key, String value, int statusCode){

        String responseStr = get(username, statusCode).body().asString();
        JSONObject response = new JSONObject(responseStr);
        response.put(key,value);

        return  given()
                    .spec(super.getRequestSpecification())
                    .body(response.toString())
                    .put("/{username}",username)
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }

    public Response delete(Object username, int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .delete("/{username}",username)
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }

    public Response login(String username, String password, int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .queryParam("username",username)
                    .queryParam("password",password)
                    .get("/login")
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }
    public Response logout(int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .get("/logout")
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }
}

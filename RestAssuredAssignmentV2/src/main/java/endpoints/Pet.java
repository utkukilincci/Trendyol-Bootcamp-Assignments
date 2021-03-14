package endpoints;

import helper.Helper;
import io.restassured.response.Response;
import org.json.JSONObject;
import spec.RequestSpec;
import spec.ResponseSpec;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Pet extends RequestSpec {

    public Pet() {
        super("https://petstore.swagger.io/v2/pet");
    }

    public Response get(Object id, int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .get("/{id}",id)
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

    public Response put(Object id, String key, String value, int statusCode){

        String responseStr = get(id, statusCode).body().asString();
        JSONObject response = new JSONObject(responseStr);
        response.put(key,value);

        return  given()
                    .spec(super.getRequestSpecification())
                    .body(response.toString())
                    .put()
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }

    public Response delete(Object id, int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .delete("/{id}",id)
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }

}
package endpoints;

import helper.Helper;
import io.restassured.response.Response;
import org.json.JSONObject;
import spec.RequestSpec;
import spec.ResponseSpec;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Store extends RequestSpec {
    public Store() {
        super("https://petstore.swagger.io/v2/store/order");
    }

    public Response get(Object orderId, int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .get("/{orderId}",orderId)
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }
    public Response post(String jsonFile, Long id,Long petId, int statusCode) throws IOException {

        JSONObject jsonObject = Helper.readJsonFile(jsonFile);
        jsonObject.put("id", id);
        jsonObject.put("petId",petId);

        return   given()
                    .spec(super.getRequestSpecification())
                    .body(jsonObject.toString())
                    .post()
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();

    }

    public Response delete(Object orderId, int statusCode){

        return   given()
                    .spec(super.getRequestSpecification())
                    .delete("/{orderId}",orderId)
                .then()
                    .spec(ResponseSpec.checkStatusCode(statusCode))
                .extract()
                .response();
    }
}

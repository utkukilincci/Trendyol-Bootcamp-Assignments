package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

    public static ResponseSpecification checkStatusCode(int statusCode){

        switch (statusCode){
            case(200):
                return new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();
            case(404):
                return new ResponseSpecBuilder()
                        .expectStatusCode(404)
                        .build();
        }

        return null;
    }
}

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class PetStoreApiTest extends BaseServiceTest {

    @Test
    public void petServiceTest() throws IOException {

        Long id = pet.post("pet",200).jsonPath().getLong("id");
        pet.get(id,200);
        pet.put(id,"name","nihahaha",200);
        String actualName = pet.get(id,200).jsonPath().getString("name");
        Assert.assertEquals("nihahaha",actualName);
        pet.delete(id,200);
        pet.get(id,404);

    }

    @Test
    public void userServiceTest() throws IOException {

        user.post("user",200);
        user.get("utkukilincci",200);
        user.put("utkukilincci","firstName","nihahaha",200);
        String actualName = user.get("utkukilincci",200).jsonPath().getString("firstName");
        Assert.assertEquals("nihahaha",actualName);
        user.delete("utkukilincci",200);
        user.get("utkukilincci",404);

    }

    @Test
    public void storeServiceTest() throws IOException {

        Long orderId = 155l;
        store.post("order",orderId,188l,200);
        store.get(orderId,200);
        store.delete(orderId,200);
        store.get(orderId,404);

    }

    @Test
    public void orderJourney() throws IOException{

        Response userResponse = user.post("user",200);
        Long userId = userResponse.jsonPath().getLong("message");
        Response petResponse = pet.post("pet",200);
        Long petId = petResponse.jsonPath().getLong("id");
        user.login("utkukilincci","123123",200);
        store.post("order",userId,petId,200);
        Long actualOrderPetId = store.get(userId,200).jsonPath().getLong("petId");
        Assert.assertEquals(petId,actualOrderPetId);
        pet.put(petId,"status","sold",200);
        user.logout(200);

    }

}

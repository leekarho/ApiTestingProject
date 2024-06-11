package store.deleteOrder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import store.Utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DeleteNonExistentOrderTest {
    private static Response response;
    private static final String ID = "99";

    @BeforeAll
    public static void beforeAll() {
        response = RestAssured
                .given(Utils.getSpecificOrderRequestSpec(ID))
                .when()
                    .delete()
                .thenReturn();
    }

    @Test
    @DisplayName("Check that sending a delete request with a non existent id returns a 404 status code")
    void checkDeleteOrderWithNonExistentId_Returns404Code() {
        assertThat(response.statusCode(), is(404));
    }

    @Test
    @DisplayName("Check that sending a delete request with a non existent id returns the message \"Order not found\"")
    void checkDeleteOrderWithNonExistentId_ReturnsOrderNotFound() {
        assertThat(response.body().asString(), is("Order not found"));
    }
}

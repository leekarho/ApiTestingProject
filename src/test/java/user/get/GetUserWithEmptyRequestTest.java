package user.get;

import config.TestConfig;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.UserUtils;

public class GetUserWithEmptyRequestTest {
    private static final String BASE_URI = TestConfig.getBaseUri();
    private static final String KEY = TestConfig.getAPIKey();

    private static Response response;

    private static UserUtils userUtils = new UserUtils();

    @BeforeAll
    public static void beforeAll() {
        response = userUtils.getUser("");
    }

    @Test
    @DisplayName("requesting info for non-existent user returns response with status code 400")
    void requestingNonExistentUser_returns400Status() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(400));
    }
}
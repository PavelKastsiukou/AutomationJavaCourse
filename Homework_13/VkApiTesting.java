import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;

public class VkApiTesting {
    private static final String postThisTextOnTheWall = "Ulyana, You are the best teacher!";
    private static final String ownerId = "573797192";
    private static final String editPostedTextOnTheWall = "Ulyana, You are the best teacher ever!";
    private static final int successfulStatusCode = 200;
    private static final String accessToken = "some_token";
    private static final String successfulDeleteResponse = "{\"response\":1}";
    private String vkApiVersion = "5.103";
    private String postId;
    private String postIdEdited;
    private String postIdWithOwnerId;

    @Test
    public void apiVkPostTextOnTheWall() {
        RestAssured.baseURI = "https://api.vk.com/method/wall.post?";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("owner_id", ownerId);
        httpRequest.param("message", postThisTextOnTheWall);
        httpRequest.param("access_token", accessToken);
        httpRequest.param("v", vkApiVersion);
        Response response = httpRequest.request(Method.POST);
        String responseBody = response.body().asString();
        JSONObject myResponseBody = new JSONObject(responseBody);
        JSONObject responseObject = (JSONObject) myResponseBody.get("response");
        postId = responseObject.get("post_id").toString();
        postIdWithOwnerId = ownerId + "_" + postId;
        Assert.assertEquals(successfulStatusCode, response.getStatusCode());
    }

    @Test(dependsOnMethods = "apiVkPostTextOnTheWall")
    public void apiVkGetPostedTextOnTheWall() {
        RestAssured.baseURI = "https://api.vk.com/method/wall.getById?";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("posts", postIdWithOwnerId);
        httpRequest.param("owner_id", ownerId);
        httpRequest.param("access_token", accessToken);
        httpRequest.param("v", vkApiVersion);
        httpRequest.param("copy_history_depth", "1");
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.body().asString();
        JSONObject myResponseBody = new JSONObject(responseBody);
        JSONArray responseArray = (JSONArray) myResponseBody.get("response");
        JSONObject responseObject = responseArray.getJSONObject(0);
        Assert.assertEquals(postThisTextOnTheWall, responseObject.getString("text"));
        Assert.assertEquals(successfulStatusCode, response.getStatusCode());
    }

    @Test(dependsOnMethods = "apiVkGetPostedTextOnTheWall")
    public void apiVkEditTextOnTheWall() {
        RestAssured.baseURI = "https://api.vk.com/method/wall.edit?";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("post_id", postId);
        httpRequest.param("owner_id", ownerId);
        httpRequest.param("message", editPostedTextOnTheWall);
        httpRequest.param("access_token", accessToken);
        httpRequest.param("v", vkApiVersion);
        Response response = httpRequest.request(Method.POST);
        String responseBody = response.body().asString();
        JSONObject myResponseBody = new JSONObject(responseBody);
        JSONObject responseObject = (JSONObject) myResponseBody.get("response");
        postIdEdited = responseObject.get("post_id").toString();
        Assert.assertEquals(successfulStatusCode, response.getStatusCode());
    }

    @Test(dependsOnMethods = "apiVkEditTextOnTheWall")
    public void apiVkGetEditedTextOnTheWall() {
        RestAssured.baseURI = "https://api.vk.com/method/wall.getById?";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("posts", postIdWithOwnerId);
        httpRequest.param("owner_id", ownerId);
        httpRequest.param("access_token", accessToken);
        httpRequest.param("v", vkApiVersion);
        httpRequest.param("copy_history_depth", "1");
        Response response = httpRequest.request(Method.GET);
        String responseBody = response.body().asString();
        JSONObject myResponseBody = new JSONObject(responseBody);
        JSONArray responseArray = (JSONArray) myResponseBody.get("response");
        JSONObject responseObjectWithText = responseArray.getJSONObject(0);
        Assert.assertEquals(editPostedTextOnTheWall, responseObjectWithText.getString("text"));
        Assert.assertEquals(successfulStatusCode, response.getStatusCode());
    }

    @Test(dependsOnMethods = "apiVkGetEditedTextOnTheWall")
    public void apiVkDeleteTextOnTheWall() {
        RestAssured.baseURI = "https://api.vk.com/method/wall.delete?";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("post_id", postIdEdited);
        httpRequest.param("owner_id", ownerId);
        httpRequest.param("access_token", accessToken);
        httpRequest.param("v", vkApiVersion);
        Response response = httpRequest.request(Method.POST);
        String responseBody = response.body().asString();
        JSONObject myResponseBody = new JSONObject(responseBody);
        Assert.assertEquals(successfulStatusCode, response.getStatusCode());
        Assert.assertEquals(successfulDeleteResponse, myResponseBody.toString());
    }
}
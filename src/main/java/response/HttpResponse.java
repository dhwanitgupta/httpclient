package response;

public class HttpResponse {
    private final Integer statusCode;
    private String errorMessage;
    private final String payload;

    public HttpResponse(Integer statusCode, String payload){
        this.statusCode = statusCode;
        this.payload = payload;
    }
}

package ru.host.ws000.to;

public class RegisterPGUResponseComposite {

	private long requestId;

	private String responseCode;

    private RegisterPGUResponseComposite(long requestId, String responseCode) {
        this.requestId = requestId;
        this.responseCode = responseCode;
    }

    public long getRequestId() {
        return requestId;
    }

    public String getResponseCode() {
        return responseCode;
    }    

    public static RegisterPGUResponseComposite createOk(long id) {
        return new RegisterPGUResponseComposite(id, "OK");
    }

    public static RegisterPGUResponseComposite createError() {
        return new RegisterPGUResponseComposite(0, "ERROR");
    }
}

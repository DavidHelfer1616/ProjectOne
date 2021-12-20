package models;

public class JsonResponse {

    Boolean isSuccessful;
    String message;
    Object user;
    Object reimb;

    public JsonResponse(Boolean isSuccessful, String message, Object data) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.user = data;
    }

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public Object getReimb() {
        return reimb;
    }

    public void setReimb(Object reimb) {
        this.reimb = reimb;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "isSuccessful=" + isSuccessful +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", reimb=" + reimb +
                '}';
    }
}

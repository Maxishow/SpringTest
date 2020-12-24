package io.exceptions.excadvice;

public class SecurityResponseError {
    private String error;

    public SecurityResponseError() {

    }

    public SecurityResponseError(String error) {
        this.error = error;
    }



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

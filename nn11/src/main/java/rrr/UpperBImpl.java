package rrr;

public class UpperBImpl implements B{
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.toUpperCase();
    }
}

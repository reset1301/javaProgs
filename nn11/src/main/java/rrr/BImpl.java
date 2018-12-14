package rrr;

public class BImpl implements B {
    private final String message;

    public BImpl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

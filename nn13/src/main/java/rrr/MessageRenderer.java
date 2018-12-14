package rrr;

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessagaProvider();
}

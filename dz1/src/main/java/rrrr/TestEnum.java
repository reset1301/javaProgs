package rrrr;

public enum TestEnum {

    GET_PASSPORT("Синхронизация справочника объектов мониторинга", "getObjects"),
    GET_EVENT("Прием телематических сообщений", "getEvents"),
    GET_NSI_DEVICES("Прием телематических сообщений", "getAllObjects");

    TestEnum(String value, String stats) {
        this.value = value;
        this.stats = stats;
    }

    String value;
    String stats;

    public String getValue() {
        return value;
    }

    public String getStats() {
        return stats;
    }

}

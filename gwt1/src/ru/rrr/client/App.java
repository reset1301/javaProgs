package ru.rrr.client;

public class App {
    public static native void getMsg() /*-{
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'http://192.168.2.108:8072/messages/search/filter', false);
        xhr.send();
        if (xhr.status != 200) {
            // обработать ошибку
            alert( xhr.status + ': ' + xhr.statusText ); // пример вывода: 404: Not Found
        } else {
            // вывести результат
            alert( xhr.responseText ); // responseText -- текст ответа.
        }
    }-*/;

    public static void main(String[] args) {
//        getMsg();
    }

}

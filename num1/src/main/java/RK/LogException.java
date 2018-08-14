package RK;

class LogException extends Exception {
    public static void log(Exception e) {
        Helper.printMessage(e.toString());
    }
}

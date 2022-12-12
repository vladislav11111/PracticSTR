public class Main {

    public static void main (String[] args) throws Exception {
        final Sender sender = new Sender();
        final Receiver receiver = new Receiver();

        receiver.startListener();
        for (int i = 1; i <= 5; i++) {
            String m = "Hello world! " + i;
            sender.sendMessage(m);
            Thread.sleep(300);
        }

        sender.destroy();
        receiver.destroy();
    }
}
package dpp;

import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;

public class Main {

    public static Socket socket = null;

    public static void main(String[] args){

        try {
            IO.Options opts = new IO.Options();
            opts.forceNew = true;
            socket = IO.socket("https://streams.dapowerplay.com?apikey=PLACE_YOUR_API_KEY_HERE&apisecret=PLACE_YOUR_SECRET_KEY_HERE", opts);
            socket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            public void call(Object... args) {
                System.out.println("Connected.");

                socket.emit("streams", new Ack() {
                    public void call(Object... args) {
                        for (Object o: args
                             ) {
                            System.out.println(o);
                        }

                        socket.emit("subscribe", args[1], new Ack() {

                            public void call(Object... args) {
                                System.out.println("Subscribed.");
                            }
                        });
                    }
                });
            }
        });

        socket.on("trades", new Emitter.Listener() {

            public void call(Object... args) {
                for (Object o: args
                ) {
                    System.out.println(o);
                }
            }
        });

        socket.on("orderbooks_lv2", new Emitter.Listener() {

            public void call(Object... args) {
                for (Object o: args
                ) {
                    System.out.println(o);
                }
            }
        });

        socket.on("orderbooks_lv1", new Emitter.Listener() {

            public void call(Object... args) {
                for (Object o: args
                ) {
                    System.out.println(o);
                }
            }
        });

        socket.on("indices", new Emitter.Listener() {

            public void call(Object... args) {
                for (Object o: args
                ) {
                    System.out.println(o);
                }
            }
        });

        socket.on("candles", new Emitter.Listener() {

            public void call(Object... args) {
                for (Object o: args
                ) {
                    System.out.println(o);
                }
            }
        });

        socket.on("sentiments", new Emitter.Listener() {

            public void call(Object... args) {
                for (Object o: args
                ) {
                    System.out.println(o);
                }
            }
        });

        socket.on("news", new Emitter.Listener() {

            public void call(Object... args) {
                for (Object o: args
                ) {
                    System.out.println(o);
                }
            }
        });

        socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            public void call(Object... args) {
                System.out.print("Disconnected.");
            }
        });
    }
}
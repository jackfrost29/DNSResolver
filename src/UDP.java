
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP {
    public static void main(String[] args) {
        DatagramSocket skt;
        try {
            skt = new DatagramSocket();
            String msg = "www.google.com";
            byte[] b = msg.getBytes();
            InetAddress host = InetAddress.getByName("172.16.41.48");
            int serverSocket = 53;
            DatagramPacket request = new DatagramPacket(b, b.length, host, serverSocket);
            skt.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            skt.receive(reply);
            skt.close();
            System.out.println(new String(request.getData()));
            System.out.println(new String(reply.getData()));
        } catch (Exception ex) {
            System.out.printf("Exception : ", ex);
        }
    }
}
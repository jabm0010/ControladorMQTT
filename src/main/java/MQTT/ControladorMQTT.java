package MQTT;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

public class ControladorMQTT {

    static String ip_broker="tcp://192.168.0.189:1883";
    static int pubQoS = 1;

    static public String getMac() throws UnknownHostException, SocketException {

        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("Current IP address : " + ip.getHostAddress());

        NetworkInterface network = NetworkInterface.getByInetAddress(ip);

        byte[] mac = network.getHardwareAddress();

        System.out.print("Current MAC address : ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++)
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));

        System.out.println(sb.toString());

        return sb.toString()+"-sub";

    }


    public static void main(String[] args) throws MqttPersistenceException, MqttException, UnknownHostException, SocketException, InterruptedException {


        MqttConnectOptions connOpt = new MqttConnectOptions();

        connOpt.setCleanSession(true);
        connOpt.setKeepAliveInterval(30);

        MqttClient myClient = new MqttClient(ip_broker, getMac());
        myClient.connect(connOpt);


        System.out.println("Connected to " + ip_broker);

        //No more than 200 movements
        CountDownLatch receivedSignal = new CountDownLatch(1000000000);
        myClient.subscribe("#");

        myClient.setCallback(new CallbackMQTT(receivedSignal,myClient));
        receivedSignal.await();

        myClient.disconnect();
        myClient.close();

        System.out.println("End ");
    }



}

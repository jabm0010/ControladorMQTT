package MQTT;

import Controladores.ControladorExcel;
import Entidades.PartidaNivel1;
import Entidades.PartidaNivel2;
import Entidades.Test;
import Entidades.Usuario;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class CallbackMQTT implements MqttCallback {

    static Gson gson = new Gson();

    CountDownLatch receivedSignal;
    MqttClient myClient;
    Map<Long, Test> tests;

    CallbackMQTT(CountDownLatch receivedSignal, MqttClient myClient) {
        this.receivedSignal = receivedSignal;
        this.myClient = myClient;
        tests = new TreeMap<>();
    }


    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("connectionLost:" + cause);
        System.out.println("bye");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {

        System.out.println("Mensaje: " + message);
        receivedSignal.countDown();

        //Definir rutas para todos los campos

        if (topic.endsWith("test")) {
            System.out.println("Prueba"+message);
        }

        if (topic.endsWith("zoo/usuario")) {
            Usuario usuario = gson.fromJson(message.toString(), Usuario.class);
            tests.put(usuario.getIdentificador(), new Test());
            tests.get(usuario.getIdentificador()).setUsuario(usuario);
        }

        if (topic.endsWith("zoo/partida/uno")) {
            PartidaNivel1 pniveluno = gson.fromJson(message.toString(), PartidaNivel1.class);
            tests.get(pniveluno.getIdentificador()).setPartidaNivel1(pniveluno);

        }

        if (topic.endsWith("zoo/partida/dos")) {
            PartidaNivel2 pniveldos = gson.fromJson(message.toString(), PartidaNivel2.class);
            tests.get(pniveldos.getIdentificador()).setPartidaNivel2(pniveldos);

        }


        //Definir una ruta para indicar el fin y generar la hoja de calculo
        if(topic.endsWith("zoo/fin")){

            //Prueba
            String rutaArchivo = "C:\\Users\\jabm9\\OneDrive\\Escritorio\\Clases\\Entornos Virtuales y Simulacion\\prueba.xlsx";
            String hoja = "Hoja1";
            ControladorExcel cExcel = new ControladorExcel(rutaArchivo,test);
            cExcel.crearHojaUsuario();
            cExcel.crearHojaPartida1();
            //cExcel.crearHojaPartida2();
        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete:" + token);

    }

}

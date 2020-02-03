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

import java.util.concurrent.CountDownLatch;

public class CallbackMQTT implements MqttCallback {

    static Gson gson = new Gson();

    CountDownLatch receivedSignal;
    MqttClient myClient;
    Test test;

    CallbackMQTT(CountDownLatch receivedSignal, MqttClient myClient) {
        this.receivedSignal = receivedSignal;
        this.myClient = myClient;
        this.test = new Test();
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
        if (topic.endsWith("zoo/usuario")) {
            Usuario usuario = gson.fromJson(message.toString(), Usuario.class);
            test.setUsuario(usuario);
        }

        if (topic.endsWith("zoo/partida/uno")) {
            PartidaNivel1 pniveluno = gson.fromJson(message.toString(), PartidaNivel1.class);
            test.setPartidaNivel1(pniveluno);
        }

        if (topic.endsWith("zoo/partida/dos")) {
            PartidaNivel2 pniveldos = gson.fromJson(message.toString(), PartidaNivel2.class);
            test.setPartidaNivel2(pniveldos);
        }


        //Definir una ruta para indicar el fin y generar la hoja de calculo
        if(topic.endsWith("zoo/fin")){

            String userprofile = System.getenv("USERPROFILE");
            String rutaArchivo = userprofile+"\\Desktop\\prueba.xlsx";
            String hoja = "Hoja1";
            ControladorExcel cExcel = new ControladorExcel(rutaArchivo,hoja,test);
            cExcel.crearHojaResultados();
        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete:" + token);

    }

}

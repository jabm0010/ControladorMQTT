package MQTT;

import Controladores.ControladorExcel;
import Controladores.ControladorPosicion;
import Entidades.*;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public class CallbackMQTT implements MqttCallback {

    static Gson gson = new Gson();

    CountDownLatch receivedSignal;
    MqttClient myClient;
    Map<Long, Test> tests;
    Map<Long, List<Posicion>> posicionesNivel1;
    Map<Long, List<Posicion>> posicionesNivel2;


    CallbackMQTT(CountDownLatch receivedSignal, MqttClient myClient) {
        this.receivedSignal = receivedSignal;
        this.myClient = myClient;
        tests = new TreeMap<>();
        posicionesNivel1 = new TreeMap<>();
        posicionesNivel2 = new TreeMap<>();
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
            posicionesNivel1.put(usuario.getIdentificador(), new ArrayList<>());
            posicionesNivel2.put(usuario.getIdentificador(), new ArrayList<>());
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

        if(topic.endsWith("zoo/posicion")){
            Posicion p = gson.fromJson(message.toString(),Posicion.class);
            if(p.getNivel() == 1){
                posicionesNivel1.get(p.getIdentificador()).add(p);
            }else{
                posicionesNivel2.get(p.getIdentificador()).add(p);
            }
        }


        //Definir una ruta para indicar el fin y generar la hoja de calculo
        if(topic.endsWith("zoo/fin")){

            String idUsuario = message.toString();
            String ficheroExcel = idUsuario+".xlsx";
            String ficheroTxt1 = idUsuario+"-nivel1.txt";
            String ficheroTxt2 = idUsuario+"-nivel2.txt";


            Long identificador = Long.valueOf(idUsuario);
            String ruta =  "C:\\Users\\jabm9\\OneDrive\\Escritorio\\Clases\\Entornos Virtuales y Simulacion\\";
            String rutaArchivo = ruta+ficheroExcel;

            ControladorExcel cExcel = new ControladorExcel(rutaArchivo,tests.get(identificador));
            cExcel.crearExcel();;

            ControladorPosicion controladorPosicion = new ControladorPosicion();
            controladorPosicion.crearFicheroPosiciones(posicionesNivel1.get(idUsuario),ruta+ficheroTxt1);
            controladorPosicion.crearFicheroPosiciones(posicionesNivel2.get(idUsuario),ruta+ficheroTxt2);


        }

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete:" + token);

    }

}

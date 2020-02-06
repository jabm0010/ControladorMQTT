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

        //System.out.println("Mensaje: " + message);
        receivedSignal.countDown();

        //Definir rutas para todos los campos

        if (topic.endsWith("test")) {
            System.out.println("Prueba"+message);
        }

        if (topic.endsWith("zoo/usuario")) {
            System.out.println("Usuario creado con datos: "+message);
            Usuario usuario = gson.fromJson(message.toString(), Usuario.class);
            tests.put(usuario.getIdentificador(), new Test());
            posicionesNivel1.put(usuario.getIdentificador(), new ArrayList<>());
            posicionesNivel2.put(usuario.getIdentificador(), new ArrayList<>());
            tests.get(usuario.getIdentificador()).setUsuario(usuario);
        }

        if (topic.endsWith("zoo/partida/uno")) {
            PartidaNivel1 pniveluno = gson.fromJson(message.toString(), PartidaNivel1.class);
            System.out.println("Partida nivel 1 creada con datos: "+message);

            pniveluno.inicializarPartidaNivel1();
            System.out.println(pniveluno.toString());


            tests.get(pniveluno.getIdentificador()).setPartidaNivel1(pniveluno);

        }

        if (topic.endsWith("zoo/partida/dos")) {
            PartidaNivel2 pniveldos = gson.fromJson(message.toString(), PartidaNivel2.class);
            System.out.println("Partida nivel 2 creada con datos: "+message);
            pniveldos.inicalizarPartidaNivel2();
            System.out.println(pniveldos.toString());
            tests.get(pniveldos.getIdentificador()).setPartidaNivel2(pniveldos);

        }

        if(topic.endsWith("zoo/posicion")){
            //System.out.println("Hola, estoy recibiendo posicion");
            Posicion p = gson.fromJson(message.toString(),Posicion.class);
            if(p.getNivel() == 1){
                posicionesNivel1.get(p.getIdentificador()).add(p);
            }else{
                posicionesNivel2.get(p.getIdentificador()).add(p);
            }
        }


        //Definir una ruta para indicar el fin y generar la hoja de calculo
        if(topic.endsWith("zoo/fin")){
            System.out.println("El usuario con id: "+message+" ha terminado la partida");

            String idUsuario = message.toString();

            String ficheroTxt1 = idUsuario+"nivel1.txt";
            String ficheroTxt2 = idUsuario+"nivel2.txt";

            String ficheroExcel = idUsuario+".xlsx";
            String userprofile = System.getenv("USERPROFILE");
            Long identificador = Long.valueOf(idUsuario);
            String ruta =  userprofile+"\\Desktop\\";
            String rutaArchivo = ruta+ficheroExcel;

            ControladorPosicion controladorPosicion = new ControladorPosicion();
            controladorPosicion.crearFicheroPosiciones(posicionesNivel1.get(idUsuario),ruta+ficheroTxt1);
            controladorPosicion.crearFicheroPosiciones(posicionesNivel2.get(idUsuario),ruta+ficheroTxt2);

            ControladorExcel cExcel = new ControladorExcel(rutaArchivo,tests.get(identificador));
            cExcel.crearExcel();

            System.out.println("Final!");

        }

        /**
         * Cuando un cliente unity se suscribe a esta ruta, el servidor empezará a publicar todas las posiciones
         * del usuario indicado en el nivel 1
         */
        if(topic.endsWith("zoo/resultado/uno")){
            String idUsuario = message.toString();
            for(Posicion p : posicionesNivel1.get(idUsuario)){
                String msg = gson.toJson(p);
                MqttMessage message2send=new MqttMessage(msg.getBytes());
                message2send.setQos(2);
                message2send.setRetained(false);
                this.myClient.publish("zoo/posicion",  message2send);
            }
        }

        /**
         * Cuando un cliente unity se suscribe a esta ruta, el servidor empezará a publicar todas las posiciones
         * del usuario indicado en el nivel 2
         */
        if(topic.endsWith("zoo/resultado/dos")){
            String idUsuario = message.toString();
            for(Posicion p : posicionesNivel2.get(idUsuario)){
                String msg = gson.toJson(p);
                MqttMessage message2send=new MqttMessage(msg.getBytes());
                message2send.setQos(2);
                message2send.setRetained(false);
                this.myClient.publish("zoo/posicion",  message2send);
            }

        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("deliveryComplete:" + token);

    }

}

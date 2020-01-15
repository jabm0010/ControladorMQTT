package Entidades;




public class Recinto {

    public enum ValoresRecinto{
        Llama("Ll"),
                Elefante("E"),
                Picnic("P"),
                Pajaro("Pa"),
                Cafe("C"),
                Camello("Ca"),
                Entrada("E"),
                Oso("O"),
                Cocodrilo("Co"),
                Mono("M"),
                MamiferosPequenos("Mp"),
                Leones("L"),
                Tigres("T"),
                Reptiles("R");


        String code;

        ValoresRecinto(String code) {
            this.code = code;

        }
    }


    public ValoresRecinto recinto;
    public Recinto(ValoresRecinto recinto){
        this.recinto = recinto;
    }

}

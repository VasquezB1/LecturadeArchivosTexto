/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.prinicipal;

import ec.edu.ups.controladores.ControladorArchivos;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Byron PC
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        ControladorArchivos controladorArchivos = new ControladorArchivos();
        String url = "C:\\Users\\Byron PC\\Documents\\NetBeansProjects\\ManejoArchivoTexto\\src\\ec\\edu\\ups\\archivos";
        File archivo = new File(url);
        File[] archivos = archivo.listFiles();
        for (File archivo1 : archivos) {
            if(!archivo1.getName().equals("Final.txt")){
                controladorArchivos.ModeloPalabras(url+"\\"+ archivo1.getName());
            }
        }
        controladorArchivos.escribir();
        
    }
    
}

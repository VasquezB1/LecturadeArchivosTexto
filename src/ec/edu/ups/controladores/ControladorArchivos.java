/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.prinicipal.Archivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.FileWriter;
import jdk.jfr.events.FileWriteEvent;

/**
 *
 * @author Byron PC
 */
public class ControladorArchivos {
    
    private String lectura;
    private List<Archivos> lista;

    public ControladorArchivos() {
        lista = new ArrayList<>();
    }
  
    
    public void ModeloPalabras(String url) throws  IOException {
        lectura = "";
        try{
            FileReader archivo = new FileReader(url);
            BufferedReader leer = new BufferedReader(archivo);
            while(lectura != null){
                lectura = leer.readLine();
                if(lectura != null){
                    leerTexto();
                }
                    
            }
                
        }catch(FileNotFoundException error){
            System.out.println("El archivo "+ url + "No existe");
        }catch(IOException error2){
            System.out.println("Error en la escrita del archivo");
        }
        
    }
    
    public void escribir() throws IOException{
        Collections.sort(lista, new Comparator<Archivos>(){
        public int compare(Archivos a1 , Archivos a2){
            return a1.getNombre().compareTo(a2.getNombre());
        }
    });
        try{
            System.out.println("***** Universidad Politècnica Salesiana *****");
            System.out.println("**  Lectura de Arcghivo Realizado con exito  **");
            String url = "C:\\Users\\Byron PC\\Documents\\NetBeansProjects\\ManejoArchivoTexto\\src\\ec\\edu\\ups\\archivos\\Resultado.txt";
            System.out.println("El resultado lo econtrarà en la direcciòn:\n "
                    + "C:\\Users\\Byron PC\\Documents\\NetBeansProjects\\ManejoArchivoTexto\\src\\ec\\edu\\ups\\archivos");
            FileWriter prueba = new FileWriter (url, false);
            BufferedWriter escribir = new BufferedWriter(prueba);
            for(Archivos archivoEscribir : lista){
                escribir.append(archivoEscribir.getNombre()+" **** se repitio: "+ archivoEscribir.getCantidad() + " veces");
                escribir.newLine();
            }
            escribir.close();
            prueba.close();
        }catch(IndexOutOfBoundsException error3){
            System.out.println("Error");
        }
    }
    
      
    private void comparar(String palabra){
        int contador =0;
        for (Archivos archivosListados : lista) {
            if(archivosListados.getNombre().equals(palabra)){
                archivosListados.setCantidad(archivosListados.getCantidad()+1);
                contador=1;
                break;
            }   
        }if(contador==0){
    Archivos archivosNuevos = new Archivos();
    archivosNuevos.setNombre(palabra);
    archivosNuevos.setCantidad(1);
    lista.add(archivosNuevos);
    }   
}
    
    private void leerTexto(){
        String palabras[] = lectura.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            comparar(palabras[i].toLowerCase());
        }
    }
           
            
    
    
            
            
    
}

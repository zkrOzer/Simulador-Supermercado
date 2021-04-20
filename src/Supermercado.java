  /*
      Author krOzer
  */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Supermercado {
    private Cajero cajero;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private Random random = new Random();
    private final int maximoClientes = 10;
    private boolean supermercadoAbierto = true;
    private int contador = 0;
    private int clientestotal = 0;
    public Supermercado(){
        cajero = new Cajero(this);
        Thread thread = new Thread(() -> {
            crearCliente();
        });
        thread.start();
        cajero.start();
        teclas();
    }

    private void crearCliente(){
        try{
            while(supermercadoAbierto){
                if(clientes.size() >= maximoClientes){
                    Thread.sleep(1000);
                    continue;
                }
                if(random.nextInt(100) <= 20){
                    agregarCliente();
                }
                Thread.sleep(500);
            }
        }
        catch (Throwable e) {
        }
        }

    public void agregarCliente() {
        clientes.add(new Cliente(this));
        contador++;
        clientestotal++;
        System.out.println((char) 27 + "[35mUn nuevo cliente llego, numero de clientes en el supermercado: " + contador);
        if (this.cajero.desocupado) {
            System.out.println((char) 27 + "[32mEl cliente hizo que el cajero  lo atendiera");
            this.cajero.ocupar();
        }
    }

    public void teclas(){
        while(supermercadoAbierto){
            Scanner scan = new Scanner(System.in);
            if(scan.nextLine().toLowerCase().equals("c")){
                this.supermercadoAbierto = false;
                if(clientes.size() > 0){
                    System.out.println((char)27 + "[33mEl supermercado cerrara cuando se atiendan a los clientes faltantes");
                }
                for(int i = 0 ; i<6 ; i++){
                    System.out.println((char)27 + "[33mCerrando el supermercado en: " + i);

                }
            }
        }
        System.out.println((char)27 + "[33mSupermarcado cerrado, y ultimo cliente atendido");
        System.out.println((char)27 + "[33mNumero de clientes que visitaron el Supermercado: " + clientestotal);
    }
    public boolean isSupermercadoAbierto() {
        return supermercadoAbierto;
    }
    public int numeroClientes(){
        return this.clientes.size();
    }

    public Cliente getCliente(){
        return this.clientes.size() > 0 ? clientes.get(0) : null;
    }

    public void eliminarCliente(){
        clientes.remove(clientes.get(0));
    }
    public Cajero getCajero(){
        return this.cajero;
    }
    public int getNumClientes(){
        return contador;
    }
    public int getclientesa(){
        return this.cajero.getClientesatendidos();
    }
    public void setclientesa(int contador){
        this.contador = contador;
    }
    public int getclientesatendidos(){
        return this.cajero.getClientesatendidos();
    }
    public int getClientestotal(){
        return clientestotal;
    }
    }



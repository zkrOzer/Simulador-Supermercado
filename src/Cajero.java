 /*
      Author krOzer
 */

public class Cajero extends Thread {
    boolean desocupado;
    private Supermercado supermercado;
    private int clientesatendidos = 0;
    public Cajero(Supermercado supermercado){
        this.supermercado = supermercado;
    }

    public void run(){
        while(this.supermercado.isSupermercadoAbierto()){
            if (this.supermercado.numeroClientes() == 0) {
                desocupado();
            } else{
                atender4();
                atender2();
                atender();
                atender3();
            }
        }
    }
    public void desocupado() {
        this.desocupado = true;
        System.out.println("los cajeros estan desocupados");
        while (this.desocupado) {
            if (!supermercado.isSupermercadoAbierto()) {
                System.out.println("El supermercado va a cerrar");
                return;
            }
            try {
                System.out.println((char)27 + "[36mCajero sin nada que hacer :c");
                Thread.sleep(1000);
            } catch (Throwable e) {
            }
        }
    }
    private void atender(){
        Cliente cliente = this.supermercado.getCliente();
        if(cliente == null) {
            return;
         }
             System.out.println("El cajero 1 esta atendiendo a un cliente");
        clientesatendidos++;
        this.supermercado.setclientesa(supermercado.getNumClientes()-1);
             for (int i = 0; i < 6; i++)
                 System.out.println("Cajero 1 atendiendo al cliente " + i);
        try {
            Thread.sleep(9000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
    }
    System.out.println((char)27 + "[32mEl cliente fue atendido");
        System.out.println((char)27 + "[32mEl cliente esta caminando a la salida");
        for(int i = 0 ; i<6 ; i++) {
            System.out.println((char)27 + "[32mCliente caminando a la salida " + i);
        }
        System.out.println((char)27 + "[32mEl cliente salio :)");

    supermercado.eliminarCliente();
    }
    private void atender2(){
        Cliente cliente = this.supermercado.getCliente();
        if(cliente == null) {
            return;
        }
        System.out.println("El cajero 2 esta atendiendo a un cliente");
        clientesatendidos++;
        this.supermercado.setclientesa(supermercado.getNumClientes()-1);
        for (int i = 0; i < 6; i++)
            System.out.println("Cajero 2 atendiendo al cliente " + i);
        try {
            Thread.sleep(9000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((char)27 + "[32mEl cliente fue atendido");
        System.out.println((char)27 + "[32mEl cliente esta caminando a la salida");
        for(int i = 0 ; i<6 ; i++) {
            System.out.println((char)27 + "[32mCliente caminando a la salida " + i);
        }
        System.out.println((char)27 + "[32mEl cliente salio :)");

        supermercado.eliminarCliente();
    }
    private void atender3(){
        Cliente cliente = this.supermercado.getCliente();
        if(cliente == null) {
            return;
        }
        System.out.println("El cajero 3 esta atendiendo a un cliente");
        clientesatendidos++;
        this.supermercado.setclientesa(supermercado.getNumClientes()-1);
        for (int i = 0; i < 6; i++)
            System.out.println("Cajero 3 atendiendo al cliente " + i);
        try {
            Thread.sleep(9000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((char)27 + "[32mEl cliente fue atendido");
        System.out.println((char)27 + "[32mEl cliente esta caminando a la salida");
        for(int i = 0 ; i<6 ; i++) {
            System.out.println((char)27 + "[32mCliente caminando a la salida " + i);
        }
        System.out.println((char)27 + "[32mEl cliente salio :)");

        supermercado.eliminarCliente();
    }
    private void atender4() {
        if (this.supermercado.getNumClientes() > 5) {
            System.out.println("El cajero 4 entro en turno");
            Cliente cliente = this.supermercado.getCliente();
            if (cliente == null) {
                return;
            }
            System.out.println("El cajero 4 esta atendiendo a un cliente");
            clientesatendidos++;
            this.supermercado.setclientesa(supermercado.getNumClientes()-1);
            for (int i = 0; i < 6; i++)
                System.out.println("Cajero 4 atendiendo al cliente " + i);
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println((char) 27 + "[32mEl cliente fue atendido");
            System.out.println((char) 27 + "[32mEl cliente esta caminando a la salida");
            for (int i = 0; i < 6; i++) {
                System.out.println((char) 27 + "[32mCliente caminando a la salida " + i);
            }
            System.out.println((char) 27 + "[32mEl cliente salio :)");
            supermercado.eliminarCliente();
        }
        System.out.println("El cajero 4 esta esperando la hora pico para entrar en turno");
    }

    public void ocupar(){
        this.desocupado = false;
        System.out.println("El cajero esta ocupado");
    }
    public int getClientesatendidos(){
        return clientesatendidos;
    }
}


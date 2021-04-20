 /*
      Author krOzer
 */

public class Cliente {
    private Supermercado supermercado;
    public Cliente(Supermercado supermercado){
        this.supermercado = supermercado;
    }

    public void run(){
        if(this.supermercado.getCajero().desocupado){
            this.supermercado.getCajero().desocupado();
        }
    }
}
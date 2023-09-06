
package ejercicio133;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;


public class Tarjeta {
    private Trabajador trabajador;
    private int clave, monto;
    private long codigo;
    private String vigencia;
    
    public Tarjeta() {
    }

    public Tarjeta(String vigencia, long codigo, int clave, int monto, Trabajador trabajador) {
        this.vigencia = vigencia;
        this.codigo = codigo;
        this.clave = clave;
        this.monto = monto;
        this.trabajador = trabajador;
    }
   
    public static Tarjeta crearTarjeta(int indexInt, ArrayList<Trabajador> listaTrabajadores){
        int monto = 50000;
        String vigencia = "31/12/2025";
        Trabajador trabajador = listaTrabajadores.get(indexInt);
        String run = Integer.toString(trabajador.getRun());        
        String clave1234 = "";
        clave1234 = run.substring(0,4);
        int clave = Integer.parseInt(clave1234);
        Random random = new Random();
        int largoCodigo = 16;
        StringBuilder codigoCorrelativo = new StringBuilder(largoCodigo);
              
        for (int i = 0; i < largoCodigo; i++) {
            int digito = random.nextInt(10); // 
            codigoCorrelativo.append(digito);
        }

        long codigo = Long.parseLong(codigoCorrelativo.toString()); 
        JOptionPane.showMessageDialog(null, "TARJETA INGRESADA CON EXITO!\n DATOS DE TARJETA \nCodigo: " + codigo+ "\nClave: " + clave + 
            "\nMonto: " + monto + "\nVigencia: " + vigencia + "\nTrabajador: " + trabajador);

        return new Tarjeta(vigencia, codigo, clave, monto, trabajador);
        
    }

    @Override
    public String toString() {
        return "codigo: " + codigo + " monto:" + monto + " vigencia:" + vigencia;
    }

    
    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}

package ejercicio133;

import javax.swing.JOptionPane;

public class Trabajador {

    private String dv, nombre;
    private int run;

    public Trabajador(int run, String dv, String nombre) {
        this.run = run;
        this.dv = dv;
        this.nombre = nombre;
    }

    public Trabajador() {
    }
 
    
    
    //Validar rut, nombre y dv
    public static Trabajador crearTrabajador() {
        String nom = "";
        String dv = "";
        String run = "";
        int runListo = 0;
        try {
            while (true) {
                nom = JOptionPane.showInputDialog("Nombre: ");
                if (nom.length() > 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre debe ser mayor a 0");
                }

            }

        } catch (Exception e) {

        }

        try {
            while (true) {
                run = JOptionPane.showInputDialog("RUN (sin puntos, guion o DV; Ejemplo: 12345789): ");
                if (run.length() >= 7 && run.length() <= 8) {
                    runListo = Integer.valueOf(run);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "RUN debe tener entre 7 y 8 dígitos");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes ingresar numeros");

        }

        while (true) {
            try {
                dv = JOptionPane.showInputDialog("DV (sin puntos ni guion): ");
                if (dv.length() == 1) {

                    if (dv.equals("k") || dv.equals("K")) {
                        break;
                    } else {
                        Integer.valueOf(dv);
                        break;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "DV no debe superar 1 caracter");
                }

            } catch (Exception e) {
                System.out.println("Debes ingresar un número o K");
            }

        }
        JOptionPane.showMessageDialog(null, "Trabajador creado con exito!");
        return new Trabajador(runListo, dv, nom);
        

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(nombre);
        sb.append(" // ").append(run);
        sb.append("-").append(dv);

        return sb.toString();
    }
   
                
            
    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

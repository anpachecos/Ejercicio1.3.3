package ejercicio133;

import static ejercicio133.Tarjeta.crearTarjeta;
import static ejercicio133.Trabajador.crearTrabajador;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class Ejercicio133 {

    public static void main(String[] args) {
        int opcion;
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();
        boolean salir = false;
        while (!salir) {
            try {
                String opcionP = "";
                opcionP = JOptionPane.showInputDialog("******PROGRAMA EMPRESA****** \n1) Ingresar Trabajador \n "
                        + "2) Asignar Tarjeta\n 3) Comprar/Gastar \n " + "4) Salir\nIntroduce una opcion: ");
                int opciones = Integer.parseInt(opcionP);
                switch (opciones) {
                    case 1:
                        listaTrabajadores.add(crearTrabajador());
                        break;
                    case 2:
                        try{
                        StringBuilder listacaso2 = new StringBuilder();
                        for (Trabajador trab : listaTrabajadores) {
                            listacaso2.append("\n" + listaTrabajadores.indexOf(trab) + ") " + trab.toString());

                        }
                        String indexTrabajador = JOptionPane.showInputDialog("LISTA DE TRABAJADORES DISPONIBLES: \n" + listacaso2 + "\nIngresa la opcion segun trabajador:  ");
                        int indexInt = Integer.parseInt(indexTrabajador);
                        listaTarjetas.add(crearTarjeta(indexInt, listaTrabajadores));
                        break;
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Pucha no sé como arreglar este error, intenta más tarde por fa");

                        }

                    case 3:
                        try {
                        StringBuilder listacaso3 = new StringBuilder();
                        for (Trabajador trab : listaTrabajadores) {
                            listacaso3.append("\n" + listaTrabajadores.indexOf(trab) + ") " + trab.toString());
                        }
                        String indiceTrabajador = JOptionPane.showInputDialog(listacaso3 + "\n Ingresa la opcion de la persona que comprará:  ");

                        Tarjeta tarjetaGastar = listaTarjetas.get(Integer.parseInt(indiceTrabajador));

                        try {
                            while (true) {
                                String a = "";
                                String b = "";
                                b = JOptionPane.showInputDialog("Ingresa tu clave: ");
                                int ingresarClave = Integer.parseInt(b);
                                if (ingresarClave == tarjetaGastar.getClave()) {
                                    a = JOptionPane.showInputDialog("Cuánto vas a gastar?: ");
                                    int gastar = Integer.parseInt(a);
                                    if (gastar <= tarjetaGastar.getMonto()) {
                                        tarjetaGastar.setMonto(tarjetaGastar.getMonto() - gastar);
                                        JOptionPane.showMessageDialog(null, "Gastaste " + gastar + "\nTe quedan " + tarjetaGastar.getMonto());
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Superaste tu saldo, vuelve a intentar");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Clave incorrecta, reintente más tarde");
                                }
                            }
                        } catch (Exception e) {
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Para comprar debes asignar una tarjeta al trabajador (opcion 2), vuelve al menú e intentalo más tarde");
                    }
                    break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "CHAOOOOOOO ");
                        salir = true;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Ingresa una opción valida(1 a 4): ");

                }
            } catch (InputMismatchException e) {
                JOptionPane.showInputDialog("Debes introducir un numero (1 a 4) ");

            }

        }

    }

}

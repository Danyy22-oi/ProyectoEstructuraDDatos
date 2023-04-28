
package GUI;

import Node.*;
import personajes.*;
import EstructuraDeDatos.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Principal extends javax.swing.JFrame {
    String nombre;
    private int unidadesDesplegadas = 0;
    private int ronda = 0;
    ListaCircular listaC = new ListaCircular();
    ListaCircularCPU listaCCPU = new ListaCircularCPU();
    ColaJugadorDerecha colaDer = new ColaJugadorDerecha();
    ColaJugadorIzquierda colaIzq = new ColaJugadorIzquierda();
    ColaCPUDerecha colaCPUD = new ColaCPUDerecha();
    ColaCPUIzquierda colaCPUI = new ColaCPUIzquierda();
    ganadorCPU ganadorC = new ganadorCPU();
    ganadorJugador ganadorJ = new ganadorJugador();
    Personaje cabeza = colaIzq.frente();
    Personaje cabezaCPU = colaCPUI.frente();
    PilaEnemigo pila1 = new PilaEnemigo();
    PilaUsuario pila2 = new PilaUsuario();
    
    public ColaJugadorIzquierda getColaIzq() {
        
        return colaIzq;
    }
   
    /**
     * Creates new form Principal
     */
    
    //Creamos los datos del cronometro
    private Timer tiempo;
    private int centesimas_segundos = 0;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    
    
    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            centesimas_segundos ++;
            if(centesimas_segundos == 100){
                segundos++;
                centesimas_segundos = 0;
            }
            if(segundos == 60 ){
                minutos ++;
                segundos = 0;
            }
            if(minutos == 60){
                horas++;
                minutos = 0;
            }
            if(horas == 24){
                horas = 0;
            }
            
            ActualizaTiempo();
        }
    };
    
    private void ActualizaTiempo(){
        String texto = (horas<=9?"0":"")+horas+":"+(minutos<=9?"0":" ")+minutos+":"+(segundos<=9?"0":"")+segundos+":"+(centesimas_segundos <=9?"0":"")+centesimas_segundos;
        etiquetaCronometro.setText(texto);
    }
    
    
    
    public Principal() {
        initComponents();
        tiempo = new Timer(10, acciones);
        pila1.push(1.0);
        pila1.push(1.5);
        pila1.push(2.0);
        pila1.push(2.5);
        pila1.push(3.0);
        pila1.push(3.5);
        pila1.push(4.0);
        pila1.push(4.5);
        pila1.push(5.0);
        pila1.push(5.5);
        pila1.push(6.5);
        pila1.push(7.5);
        pila1.push(8.0);
        pila1.push(8.5);
        pila1.push(9.0);
        pila1.push(9.5);
        pila1.push(10.0);     
        pila1.imprimir();
        pila2.push(1.0);
        pila2.push(1.5);
        pila2.push(2.0);
        pila2.push(2.5);
        pila2.push(3.0);
        pila2.push(3.5);
        pila2.push(4.0);
        pila2.push(4.5);
        pila2.push(5.0);
        pila2.push(5.5);
        pila2.push(6.5);
        pila2.push(7.5);
        pila2.push(8.0);
        pila2.push(8.5);
        pila2.push(9.0);
        pila2.push(9.5);
        pila2.push(10.0);
        pila2.imprimir();
        etiquetaCronometro.setVisible(false);
        etiquetaCronometro.setEnabled(false);
        Camino1.setVisible(false);
        Camino1.setEnabled(false);
        Camino2.setVisible(false);
        Camino2.setEnabled(false);
        CastilloEnemigo.setVisible(false);
        CastilloUsuario.setVisible(false);
        jLabel3.setVisible(false);
        jPanel2.setVisible(false);
        Comprobar.setVisible(false);
        
   
    }
  public void imagenes(){
      
        
    }
    
    private void agregarUnidadesAleatoriasCPU(){
        int cantidadPersonajes = 3 + ronda;
        int numColaIzq = 0;
        int numColaDer = 0;
        for (int i = 0; i < cantidadPersonajes; i++) {
            int tipoPersonaje = (int) (Math.random() * 3) + 1; // Genera un número aleatorio entre 1 y 3
            switch (tipoPersonaje) {
                case 1: // Arquero
                    listaCCPU.agregar(new Personaje("Arquero", 1.0, "Roca"));
                    break;
                case 2: // Caballero
                    listaCCPU.agregar(new Personaje("Caballero", 2.0, "Papel"));
                    break;
                case 3: // Mago
                    listaCCPU.agregar(new Personaje("Mago", 1.5, "Tijera"));
                    break;
        }
            int Seleccion = (int) (Math.random() * 2);  //Genera un número aleatorio entre 0 y 1
            if (Seleccion == 0 && numColaIzq < 2){
                Personaje eliminado = listaCCPU.eliminarPrimero();
                if (eliminado == null){
                    JOptionPane.showMessageDialog(null, "La lista esta vacia");
                } else {
                    colaCPUI.encolar(eliminado);
                    numColaIzq++;
                }
            } else if(Seleccion == 1 && numColaDer < 2) {
                Personaje eliminado = listaCCPU.eliminarPrimero();
                if (eliminado == null){
                    JOptionPane.showMessageDialog(null, "La lista esta vacia");
                } else {
                    colaCPUD.encolar(eliminado);
                    numColaDer++;
                }
            }
            //colaCPUD.imprimir();
            //colaCPUI.imprimir();
            //listaCCPU.imprimir(); 
        }       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaCronometro = new javax.swing.JLabel();
        Comprobar = new javax.swing.JButton();
        Camino2 = new javax.swing.JButton();
        Camino1 = new javax.swing.JButton();
        CastilloEnemigo = new javax.swing.JLabel();
        CastilloUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Derecha = new javax.swing.JButton();
        ContinuarB = new javax.swing.JButton();
        ArqueroB = new javax.swing.JButton();
        MagoB = new javax.swing.JButton();
        CaballeroB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaCronometro.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        etiquetaCronometro.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaCronometro.setText("00:00:00:00");
        getContentPane().add(etiquetaCronometro, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 80, 30));

        Comprobar.setText("COMPROBAR");
        Comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprobarActionPerformed(evt);
            }
        });
        getContentPane().add(Comprobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 160, 50));

        Camino2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Camino_1.PNG"))); // NOI18N
        Camino2.setText("jButton2");
        Camino2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Camino2ActionPerformed(evt);
            }
        });
        getContentPane().add(Camino2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 50, 150));

        Camino1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Camino.PNG"))); // NOI18N
        Camino1.setText("jButton1");
        Camino1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Camino1ActionPerformed(evt);
            }
        });
        getContentPane().add(Camino1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 50, 150));

        CastilloEnemigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Castillo.PNG"))); // NOI18N
        getContentPane().add(CastilloEnemigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 140, 130));

        CastilloUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Castillo.PNG"))); // NOI18N
        getContentPane().add(CastilloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, 160));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/FondoJuego.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, Short.MAX_VALUE)
                .addGap(350, 350, 350))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 370, 500));

        Derecha.setText("CAMINOS");
        Derecha.setToolTipText("");
        Derecha.setBorderPainted(false);
        Derecha.setDoubleBuffered(true);
        Derecha.setFocusCycleRoot(true);
        Derecha.setFocusPainted(false);
        Derecha.setFocusable(false);
        Derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DerechaActionPerformed(evt);
            }
        });
        getContentPane().add(Derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 170, 20));

        ContinuarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Captura de pantalla 2023-04-21 024047.png"))); // NOI18N
        ContinuarB.setBorderPainted(false);
        ContinuarB.setContentAreaFilled(false);
        ContinuarB.setDefaultCapable(false);
        ContinuarB.setFocusPainted(false);
        ContinuarB.setFocusable(false);
        ContinuarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarBActionPerformed(evt);
            }
        });
        getContentPane().add(ContinuarB, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 90, 20));

        ArqueroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Arquero.png"))); // NOI18N
        ArqueroB.setText("jButton2");
        ArqueroB.setBorderPainted(false);
        ArqueroB.setContentAreaFilled(false);
        ArqueroB.setDefaultCapable(false);
        ArqueroB.setFocusPainted(false);
        ArqueroB.setRequestFocusEnabled(false);
        ArqueroB.setVerifyInputWhenFocusTarget(false);
        ArqueroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArqueroBActionPerformed(evt);
            }
        });
        getContentPane().add(ArqueroB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 150, 200));

        MagoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Mago.png"))); // NOI18N
        MagoB.setText("jButton3");
        MagoB.setBorderPainted(false);
        MagoB.setContentAreaFilled(false);
        MagoB.setDefaultCapable(false);
        MagoB.setFocusPainted(false);
        MagoB.setFocusable(false);
        MagoB.setRequestFocusEnabled(false);
        MagoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MagoBActionPerformed(evt);
            }
        });
        getContentPane().add(MagoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 120, 170));

        CaballeroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Caballero.png"))); // NOI18N
        CaballeroB.setText("jButton1");
        CaballeroB.setBorderPainted(false);
        CaballeroB.setContentAreaFilled(false);
        CaballeroB.setDefaultCapable(false);
        CaballeroB.setFocusPainted(false);
        CaballeroB.setFocusable(false);
        CaballeroB.setRequestFocusEnabled(false);
        CaballeroB.setVerifyInputWhenFocusTarget(false);
        CaballeroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaballeroBActionPerformed(evt);
            }
        });
        getContentPane().add(CaballeroB, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 140, 160));

        jLabel2.setBackground(new java.awt.Color(102, 102, 0));
        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("SELECCIONE LOS PERSONAJES PARA ESTA RONDA");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        jLabel2.setDoubleBuffered(true);
        jLabel2.setFocusCycleRoot(true);
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 410, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/91WLVxaIU8L.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 1210, 700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 870, 500));

        setSize(new java.awt.Dimension(1041, 555));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ArqueroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArqueroBActionPerformed
        String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea desplegar de este campeon");
        int cantidadN = Integer.parseInt(cantidad);
        if (unidadesDesplegadas + cantidadN > 4 + ronda) {
            JOptionPane.showMessageDialog(null, "No se pueden desplegar mas de "+ (4 + ronda) + " Unidades");
        }else{
            unidadesDesplegadas += cantidadN;
            for (int i = 0; i< cantidadN; i++){
                listaC.agregar(new Personaje("Arquero",1.0,"Roca"));
            }
        }
        //listaC.imprimir();        
    }//GEN-LAST:event_ArqueroBActionPerformed

    private void CaballeroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaballeroBActionPerformed
        String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea desplegar de este campeon");
        int cantidadN = Integer.parseInt(cantidad);
        if (unidadesDesplegadas + cantidadN >4 + ronda){
            JOptionPane.showMessageDialog(null, "No se pueden desplegar mas de "+ (4 + ronda) + "Unidades");
        }else{
            unidadesDesplegadas += cantidadN;
            for (int i = 0; i< cantidadN; i++){
                listaC.agregar(new Personaje("Caballero",2.0,"Papel"));
            }    
        }
        //listaC.imprimir();
    }//GEN-LAST:event_CaballeroBActionPerformed

    private void MagoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MagoBActionPerformed
       String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de unidades que desea desplegar de este campeon");
        int cantidadN = Integer.parseInt(cantidad);
        if (unidadesDesplegadas + cantidadN >4 + ronda){
            JOptionPane.showMessageDialog(null, "No se pueden desplegar mas de "+ (4 + ronda) + " Unidades");
        }else{
            unidadesDesplegadas += cantidadN; 
            for (int i = 0; i< cantidadN; i++){
                listaC.agregar(new Personaje("Mago",1.5,"Tijera"));
            }   
        }
        //listaC.imprimir();
    }//GEN-LAST:event_MagoBActionPerformed

    
    
    
    
    private void ContinuarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarBActionPerformed
        int unidadesRequeridas = 4 + ronda;
        if (unidadesDesplegadas < unidadesRequeridas || !listaC.estaVacia()){
            JOptionPane.showMessageDialog(null, "No se puede continuar sin" + unidadesRequeridas + "unidades elegidas.");            
        }else{ 
            tiempo.start();
            etiquetaCronometro.setVisible(true);
            etiquetaCronometro.setEnabled(true);
            agregarUnidadesAleatoriasCPU();   
            Derecha.setEnabled(false);
            Derecha.setVisible(false);
            jLabel2.setVisible(false);
            ArqueroB.setEnabled(false);
            ArqueroB.setVisible(false);
            MagoB.setEnabled(false);
            MagoB.setVisible(false);
            CaballeroB.setEnabled(false);
            CaballeroB.setVisible(false);
            ContinuarB.setEnabled(false);
            ContinuarB.setVisible(false);
            Camino1.setVisible(true);
            Camino1.setEnabled(true);
            Camino2.setVisible(true);
            Camino2.setEnabled(true);
            CastilloEnemigo.setVisible(true);
            CastilloUsuario.setVisible(true);
            jPanel2.setVisible(true);
            jLabel3.setVisible(true);
            
                  
        }        
    }//GEN-LAST:event_ContinuarBActionPerformed

    private void DerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DerechaActionPerformed
    Personaje eliminado = listaC.eliminarPrimero();
    if (eliminado == null) {
        JOptionPane.showMessageDialog(null, "La lista está vacía");
    } else {
        String[] opciones = {"Camino de la Izquierda", "Camino de la Derecha"};
        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione la cola a la que desea agregar el personaje", "Seleccionar Cola", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        switch (seleccion) {
            case 0: // Jugador Izquierda
                colaIzq.encolar(eliminado);
                break;
            case 1: // Jugador Derecha
                colaDer.encolar(eliminado);
                break;
            default:
                break;
        }
    }
    colaDer.imprimir();
    colaIzq.imprimir();
    listaC.imprimir();
        
    }//GEN-LAST:event_DerechaActionPerformed
    
    private void jugarRPSI() {
    // Obtener la cabeza de ambas colas
    Object cabezaJugador = colaIzq.frente();
    Object cabezaCPU = colaCPUI.frente();

    // Validar que las cabezas sean del tipo esperado
    if (!(cabezaJugador instanceof Personaje) || !(cabezaCPU instanceof Personaje)) {
        // Si no son del tipo esperado, lanzar una excepción o manejar el error apropiadamente
        throw new IllegalArgumentException("Las cabezas de las colas deben ser del tipo Personaje");
    }

    // Obtener los tipos de los personajes
    String tipoJugador = ((Personaje) cabezaJugador).getTipo();
    String tipoCPU = ((Personaje) cabezaCPU).getTipo();

    // Definir las reglas del juego de piedra, papel o tijera
    String ganador;
    if (tipoJugador.equals("Roca") && tipoCPU.equals("Tijera") ||
        tipoJugador.equals("Papel") && tipoCPU.equals("Roca") ||
        tipoJugador.equals("Tijera") && tipoCPU.equals("Papel")) {
        // El jugador gana
        ganador = "jugador";
    } else if (tipoCPU.equals("Roca") && tipoJugador.equals("Tijera") ||
               tipoCPU.equals("Papel") && tipoJugador.equals("Roca") ||
               tipoCPU.equals("Tijera") && tipoJugador.equals("Papel")) {
        // La CPU gana
        ganador = "cpu";
    } else {
        // Empate
        ganador = "empate";
    }

    // Eliminar el personaje correspondiente a la cabeza de la cola perdedora
    if (ganador.equals("jugador")) {
        colaCPUI.desencolar();
        ganadorJ.encolar((Personaje) cabezaJugador);
    } else if (ganador.equals("cpu")) {
        colaIzq.desencolar();
        ganadorC.encolar((Personaje) cabezaCPU);
    } else {
        // Empate, no se hace nada
    }
    // Imprimir el ganador junto con su respectiva cola
    JOptionPane.showMessageDialog(null, "Ganador: " + ganador);
    JOptionPane.showMessageDialog(null,"Cola del ganador:");
    if (ganador.equals("jugador")) {
        System.out.println(ganadorJ.toString());
    } else if (ganador.equals("cpu")) {
        System.out.println(ganadorC.toString());
    } else if (ganador.equals("empate")) {
        JOptionPane.showMessageDialog(null,"No hubo ganador.");
    } else {
       JOptionPane.showMessageDialog(null, "Error: el valor de 'ganador' no es válido");
    }
    
}
    private void jugarRPSD() {
    // Obtener la cabeza de ambas colas
    Object cabezaJugador = colaDer.frente();
    Object cabezaCPU = colaCPUD.frente();

    // Validar que las cabezas sean del tipo esperado
    if (!(cabezaJugador instanceof Personaje) || !(cabezaCPU instanceof Personaje)) {
        // Si no son del tipo esperado, lanzar una excepción o manejar el error apropiadamente
        throw new IllegalArgumentException("Las cabezas de las colas deben ser del tipo Personaje");
    }

    // Obtener los tipos de los personajes
    String tipoJugador = ((Personaje) cabezaJugador).getTipo();
    String tipoCPU = ((Personaje) cabezaCPU).getTipo();

    // Definir las reglas del juego de piedra, papel o tijera
    String ganador;
    if (tipoJugador.equals("Roca") && tipoCPU.equals("Tijera") ||
        tipoJugador.equals("Papel") && tipoCPU.equals("Roca") ||
        tipoJugador.equals("Tijera") && tipoCPU.equals("Papel")) {
        // El jugador gana
        ganador = "jugador";
    } else if (tipoCPU.equals("Roca") && tipoJugador.equals("Tijera") ||
               tipoCPU.equals("Papel") && tipoJugador.equals("Roca") ||
               tipoCPU.equals("Tijera") && tipoJugador.equals("Papel")) {
        // La CPU gana
        ganador = "cpu";
    } else {
        // Empate
        ganador = "empate";
    }

    // Eliminar el personaje correspondiente a la cabeza de la cola perdedora
    if (ganador.equals("jugador")) {
        colaCPUI.desencolar();
        ganadorJ.encolar((Personaje) cabezaJugador);
    } else if (ganador.equals("cpu")) {
        colaIzq.desencolar();
        ganadorC.encolar((Personaje) cabezaCPU);
    } else {
        // Empate, no se hace nada
    }
    // Imprimir el ganador junto con su respectiva cola
    JOptionPane.showMessageDialog(null, "Ganador: " + ganador);
    JOptionPane.showMessageDialog(null, "Cola del ganador:");
    if (ganador.equals("jugador")) {
        JOptionPane.showMessageDialog(null, ganadorJ.toString());
    } else if (ganador.equals("cpu")) {
        JOptionPane.showMessageDialog(null, ganadorC.toString());
    } else if (ganador.equals("empate")) {
        JOptionPane.showMessageDialog(null, "No hubo ganador.");
    } else {
      JOptionPane.showMessageDialog(null,"Error: el valor de 'ganador' no es válido");
    }
    
}
    
    
    private void Camino1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Camino1ActionPerformed
        Camino1.setEnabled(false);     
        jugarRPSI();
        AtaqueTorresE();
        AtaqueTorresU();     
        verificar();
        
        
        
    }//GEN-LAST:event_Camino1ActionPerformed

    private void Camino2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Camino2ActionPerformed
        Camino2.setEnabled(false);
        jugarRPSD();
        AtaqueTorresE();
        AtaqueTorresU();
        verificar();
        
        
       
    }//GEN-LAST:event_Camino2ActionPerformed

    private void ComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprobarActionPerformed
        comprobarPilas();
        vaciarColas();
        if(tiempo.isRunning()){
        tiempo.stop();    
        }
        centesimas_segundos = 0;
        segundos = 0;
        minutos = 0;
        horas = 0;
        ActualizaTiempo();
        etiquetaCronometro.setVisible(false);
        
        
    }//GEN-LAST:event_ComprobarActionPerformed
    
    public void verificar(){
        if(!Camino1.isEnabled() && !Camino2.isEnabled()){
            Camino1.setVisible(false);
            Camino2.setVisible(false);
            Comprobar.setVisible(true);
            Comprobar.setEnabled(true);
        }
            
    }
    
    private void AtaqueTorresE(){
    // Revisar el tipo de personaje en la cabeza de la cola ganadorJugador
    if (!ganadorJ.estaVacia()) {
        if (ganadorJ.frente().getNombre().equals("Arquero")) {
            pila1.pop(); // sacar 1 nodo
        } else if (ganadorJ.frente().getNombre().equals("Caballero")) {
            pila1.pop(); // sacar 1 nodo
            pila1.pop(); // sacar 1 nodo
            pila1.pop(); // sacar 1 nodo
            pila1.pop(); // sacar 1 nodo
        } else if (ganadorJ.frente().getNombre().equals("Mago")) {
            pila1.pop(); // sacar 1 nodo
            pila1.pop(); // sacar 1 nodo
        }
        // Imprimir la nueva cantidad de nodos en la pilaEnemigo
        System.out.println("Nueva cantidad de nodos en la pilaEnemigo: " + pila1.tam());
    }
}
    private void AtaqueTorresU(){
    // Revisar el tipo de personaje en la cabeza de la cola ganadorCompu
    if (!ganadorC.estaVacia()) {
        if (ganadorC.frente().getNombre().equals("Arquero")) {
            pila2.pop(); // sacar 1 nodo
        } else if (ganadorC.frente().getNombre().equals("Caballero")) {
            pila2.pop(); // sacar 1 nodo
            pila2.pop(); // sacar 1 nodo
            pila2.pop(); // sacar 1 nodo
            pila2.pop(); // sacar 1 nodo
        } else if (ganadorC.frente().getNombre().equals("Mago")) {
            pila2.pop(); // sacar 1 nodo
            pila2.pop(); // sacar 1 nodo
        }
        

        // Imprimir la nueva cantidad de nodos en la pilaAliado
        System.out.println("Nueva cantidad de nodos en la pilaAliado: " + pila2.tam());
    }
}
    
    public void comprobarPilas(){
        if (pila1.estaVacia() && pila2.estaVacia() && ganadorC.estaVacia() && ganadorJ.estaVacia()) {
            // ambas pilas están vacías, no se hace nada
        } else if (pila1.estaVacia() && !pila2.estaVacia()) {
            // la pila1 está vacía y la pila2 tiene nodos, se instancia el frame win.java
            win frame = new win();
            frame.setVisible(true);
        } else if (!pila1.estaVacia() && pila2.estaVacia()) {
            // la pila1 tiene nodos y la pila2 está vacía, se instancia el frame wasted.java
            wasted frame = new wasted();
            frame.setVisible(true);
        } else {
            // ambas pilas tienen nodos, se habilitan los botones
            ronda++;
            unidadesDesplegadas = 0;
            vaciarColas();
            ArqueroB.setEnabled(true);
            CaballeroB.setEnabled(true);
            MagoB.setEnabled(true);
            ArqueroB.setVisible(true);
            CaballeroB.setVisible(true);
            MagoB.setVisible(true);
            Derecha.setEnabled(true);
            Derecha.setVisible(true);
            ContinuarB.setEnabled(true);
            ContinuarB.setVisible(true);
            jLabel3.setVisible(false);
            jPanel2.setVisible(false);
            Camino1.setEnabled(false);
            Camino2.setEnabled(false);
            Camino1.setVisible(false);
            Camino2.setVisible(false);
            Comprobar.setEnabled(false);
            Comprobar.setVisible(false);
            CastilloEnemigo.setVisible(false);
            CastilloUsuario.setVisible(false);
            
        }    
    }
    
    public void vaciarColas() {
        while (!ganadorJ.estaVacia()) {
            ganadorJ.desencolar();
        }
        while (!colaDer.estaVacia()) {
            colaDer.desencolar();
        }
        while (!colaIzq.estaVacia()) {
            colaIzq.desencolar();
        }
        while (!ganadorC.estaVacia()) {
            ganadorC.desencolar();
        }
        while (!colaCPUD.estaVacia()) {
            colaCPUD.desencolar();
        }
        while (!colaCPUI.estaVacia()) {
            colaCPUI.desencolar();
        }
    }






            
            
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArqueroB;
    private javax.swing.JButton CaballeroB;
    private javax.swing.JButton Camino1;
    private javax.swing.JButton Camino2;
    private javax.swing.JLabel CastilloEnemigo;
    private javax.swing.JLabel CastilloUsuario;
    private javax.swing.JButton Comprobar;
    private javax.swing.JButton ContinuarB;
    private javax.swing.JButton Derecha;
    private javax.swing.JButton MagoB;
    private javax.swing.JLabel etiquetaCronometro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

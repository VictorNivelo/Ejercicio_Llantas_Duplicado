/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Persona.EscuelaDao;
import Controlador.TDA.Grafos.DibujarGrafo;
import Controlador.TDA.Lista.Exepcion.ListaVacia;
import Controlador.Utiles.Utiles;
import Vista.Arreglos.Tabla.mODELOadySAFASD;
import Vista.utilidades.UtilesVista;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Vistagrafo extends javax.swing.JFrame {
    private EscuelaDao ed = new EscuelaDao();
    private mODELOadySAFASD mtae = new mODELOadySAFASD();

    /**
     * Creates new form Vistagrafo
     * @throws Controlador.TDA.Lista.Exepcion.ListaVacia
     */
    public Vistagrafo() throws ListaVacia {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
    }
    
    private void limpiar() throws ListaVacia {
        try {
            UtilesVista.CargarComboEscuela(cbxOrigen);
            UtilesVista.CargarComboEscuela(cbxDestino);
            cargarTabla();
        } 
        catch (Exception e) {

        }
    }
    
    private void mostrarGrafo() throws Exception{
        
        DibujarGrafo p = new DibujarGrafo();
        p.updateFile(ed.GrafoEscuelaDao());
//        String url = "d3/grafo.html";
        Utiles.abrirNavegadorPredeterminadorWindows("d3/grafo.html");
        //Tiene que cargar el mapa
        //Consultar como abrir navegador en java
//        UtilesVista.crearMapaEscuela(ed.GrafoEscuelaDao());
//        Runtime rt = Runtime.getRuntime();
//        rt.exec("urs/bin/brave-browser -new-windows mapas/index.html");
//        String url = "mapas/index.html";
//        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    }
    
    private void dibujarGrafo() throws Exception{
        //tiene que cargar el grafo
        
        UtilesVista.crearMapaEscuela(ed.GrafoEscuelaDao());
        Runtime rt = Runtime.getRuntime();
        rt.exec("urs/bin/brave-browser -new-windows mapas/index.html");
//        String url = "mapas/index.html";
//        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    }
    
    private void guardarGrafo(){
        try {
            int i = JOptionPane
                    .showConfirmDialog(null, "¿Estas seguro de guardar?", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
            if (i == JOptionPane.OK_OPTION) {
                if (ed.GrafoEscuelaDao()!= null) {
                    ed.GrafoEscuelaDao();
                    JOptionPane.showMessageDialog(null, "Grafo guardado", "GUARDADO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede guardar un grafo vacio", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
//        try {
//            int i = JOptionPane.showConfirmDialog(null, "SI O NO PANA ","rAPIDO,", JOptionPane.OK_CANCEL_OPTION);
//            if(i == JOptionPane.OK_OPTION){
//            
//        }
//            if(ed.GrafoEscuelaDao() != null){
//                ed.guardarGrafo();
//                JOptionPane.showMessageDialog(null, "si se puede mi pana");
//            }else{
//                
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se guarda mi pana");
//        }
    }
    
    private void Adyacencia(){
        
        try {
            Integer o = cbxOrigen.getSelectedIndex();
            Integer d = cbxDestino.getSelectedIndex();
            if (o.intValue() == d.intValue()) {
                JOptionPane.showMessageDialog(null, "Escoja escuelas diferentes", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                Double dist = UtilesVista.CalcularDistanciaE(ed.getListaEscuela().getInfo(o), ed.getListaEscuela().getInfo(d));
                ed.GrafoEscuelaDao().insertEdgeE(ed.getListaEscuela().getInfo(o), ed.getListaEscuela().getInfo(d), dist);
            }
        } 
        catch (Exception e) {
        }
        
        //Aqui se crean las adyancencias de los grafos
//        try {
//            Integer o = cbxOrigen.getSelectedIndex();
//            Integer d = cbxOrigen.getSelectedIndex();
//            if(o.intValue() == d. intValue()){
//                JOptionPane.showMessageDialog(null, "No se puede mi pana");
//            }
//            else{
//                Double dist = UtilesVista.CalcularDistanciaE(ed.getListaEscuela().getInfo(o), ed.getListaEscuela().getInfo(d));
//                Double re = UtilesVista.redondear(dist);
//                ed.GrafoEscuelaDao().insertEdgeE(ed.getListaEscuela().getInfo(o), ed.getListaEscuela().getInfo(d), re);
////                ed.GrafoEscuelaDao().insertEdgeE(ed.getListaEscuela().getInfo(o), ed.GrafoEscuelaDao().insertEdgeE(ed.getListaEscuela().getInfo(d), dist); 
////                ed.GrafoEscuelaDao().insertEdgeE(o, d, Double.NaN);
//                JOptionPane.showMessageDialog(null, "REGISTRADO");
//            }
//        }
//        catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "tampoco sirve");
//        }
    }
    
    private void mostrarMapa() throws Exception {
        
        UtilesVista.crearMapaEscuela(ed.GrafoEscuelaDao());
//        Runtime rt = Runtime.getRuntime();
//        rt.exec("")
        Runtime rt=Runtime.getRuntime();
        Utiles.abrirNavegadorPredeterminadorWindows("mapas/index.html");
//        UtilesVista.crearMapaEscuela(ed.GrafoEscuelaDao());
////        Runtime rt = Runtime.getRuntime();
////        rt.exec("")
//        String url = "mapas\\index.html";
//        Utiles.abrirNavegadorPredeterminadorWindows(url);
//        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    }
    
//    public void guardarGrafo() {
//        try {
//            int i = JOptionPane
//                    .showConfirmDialog(null, "¿Estas seguro de guardar?", "ADVERTENCIA", JOptionPane.OK_CANCEL_OPTION);
//            if (i == JOptionPane.OK_OPTION) {
//                if (ed.GrafoEscuelaDao()!= null) {
//                    ed.GrafoEscuelaDao();
//                    JOptionPane.showMessageDialog(null, "Grafo guardado", "GUARDADO", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se puede guardar un grafo vacio", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    private void cargarTabla() throws Exception {
        mtae.setGrafo(ed.GrafoEscuelaDao());
        mtae.fireTableDataChanged();
        tblTabla.setModel(mtae);
        tblTabla.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbxOrigen = new javax.swing.JComboBox<>();
        cbxDestino = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("ver grafo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("ver mapa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbxOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTabla);

        jButton3.setText("ADYACENCUA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("GUARDAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CARGAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(14, 14, 14))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            mostrarGrafo();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No sirve");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Adyacencia();
        try {
            cargarTabla();
        } 
        catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            mostrarMapa();
        } 
        catch (Exception e) {
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        guardarGrafo();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Vistagrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vistagrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vistagrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vistagrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Vistagrafo().setVisible(true);
                } catch (ListaVacia ex) {
                    Logger.getLogger(Vistagrafo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxDestino;
    private javax.swing.JComboBox<String> cbxOrigen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
}

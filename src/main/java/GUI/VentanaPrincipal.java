/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import com.estructuras.Documento;
import com.estructuras.Pila;
import com.googolplex.Googolplex;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author e-j-b
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form Interfaz
     */
    private String currentDir = System.getProperty("user.dir");
    private String DOCS_PATH = currentDir + "\\src\\main\\java\\docs";
    private String sortMode = "LIOT";//"Last in on top". Tambien puede ser MSOT "Most searched on top".
                                     //Tambien puede ser "FIOT" First in on top para el orden original.
    private static long ultimoClick=0;
    private final int timeoutParaDoubleClick=500;
    
    public void llenarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) tablaDocumentos.getModel();
        List<String[]> documentosString = Googolplex.programa.popularTabla();
        modelo.setRowCount(0);
        int index=documentosString.size()-1;
        switch (sortMode){
            case "LIOT":
                while (index>=0){
                    modelo.addRow(documentosString.get(index));
                    index--;
                }
                break;
            case "MSOT":
                List<String[]> documentosPorBusquedas=Googolplex.programa.getDocumentosMasBuscados().imprimirPila();
                for(String[] row:documentosPorBusquedas){
                    modelo.addRow(row);
                }
                break;
            case "FIOT":
                for (String[] row:documentosString){
                    modelo.addRow(row);
                }
                break;
        }
    }
    public VentanaPrincipal() {
        initComponents();
        llenarTabla();
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
        jToolBar1 = new javax.swing.JToolBar();
        btnDocumentoExistente = new javax.swing.JButton();
        btnDocumentoNuevo = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDocumentos = new javax.swing.JTable();
        cbbxModoDeOrden = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAbrirArchivo = new javax.swing.JButton();
        txtboxSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Googolplex");
        setLocation(new java.awt.Point(400, 200));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnDocumentoExistente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDocumentoExistente.setText("  Importar Documento  ");
        btnDocumentoExistente.setActionCommand("Importar Documento");
        btnDocumentoExistente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDocumentoExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentoExistenteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDocumentoExistente);

        btnDocumentoNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDocumentoNuevo.setText("  Crear documento  ");
        btnDocumentoNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDocumentoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocumentoNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDocumentoNuevo);

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setText("  Actualizar tabla  ");
        btnActualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);

        tablaDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de documento", "Nombre", "Fecha de adicion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDocumentos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tablaDocumentos);

        cbbxModoDeOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mas recientes", "Mas buscados", "Orden de ingreso" }));
        cbbxModoDeOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbxModoDeOrdenActionPerformed(evt);
            }
        });

        jLabel1.setText("Orden de archivos:");

        btnAbrirArchivo.setText("  Abrir Archivo  ");
        btnAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArchivoActionPerformed(evt);
            }
        });

        txtboxSearch.setToolTipText("");
        txtboxSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtboxSearchCaretUpdate(evt);
            }
        });
        txtboxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAbrirArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbxModoDeOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtboxSearch))))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbxModoDeOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAbrirArchivo))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtboxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addGap(38, 38, 38))
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

    private void btnDocumentoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentoNuevoActionPerformed
        
        CrearArchivo createDOC = new CrearArchivo();
        createDOC.setVisible(true);
        llenarTabla();
    }//GEN-LAST:event_btnDocumentoNuevoActionPerformed

    private void btnDocumentoExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocumentoExistenteActionPerformed
        // TODO add your handling code here:
        File archivo=Googolplex.programa.leerArchivoExistente();
        File destino = new File(Googolplex.programa.getPathRelativoDelPrograma()+Googolplex.programa.getPathRelativoDeLosDocumentos()+archivo.getName());
        try {
            Files.copy(archivo.toPath(), destino.toPath());
            Googolplex.programa.documentoExistente(archivo.getName());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: El documento ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }  
        llenarTabla();
    }//GEN-LAST:event_btnDocumentoExistenteActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        llenarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void cbbxModoDeOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbxModoDeOrdenActionPerformed
        // TODO add your handling code here:
        int index=cbbxModoDeOrden.getSelectedIndex();
        switch (index){
            case 0:
                sortMode="LIOT";
                llenarTabla();
                break;
            case 1:
                sortMode="MSOT";
                llenarTabla();
                break;
            case 2:
                sortMode="FIOT";
                llenarTabla();
                break;
        }
    }//GEN-LAST:event_cbbxModoDeOrdenActionPerformed

    private void btnAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArchivoActionPerformed
        int lineaSeleccionada = tablaDocumentos.getSelectedRow();
        int numeroDeDocumento = -1;
        if (lineaSeleccionada != -1) {
            Object contenidoDeLinea = tablaDocumentos.getModel().getValueAt(lineaSeleccionada, 0);
            numeroDeDocumento = Integer.parseInt(contenidoDeLinea.toString());
        }
        if (numeroDeDocumento == -1) {
            JOptionPane.showMessageDialog(null, "Error: El documento no se encontro.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Documento paraAbrir = Googolplex.programa.getDocumentosRegistrados().encontrarPorNumeroDeDocumento(numeroDeDocumento);
        Googolplex.programa.getDocumentosRegistrados().incrementarNumeroDeBusquedas(paraAbrir.getNumeroDeDocumento());
        //Googolplex.programa.getDocumentosMasBuscados().incrementarNumeroDeBusquedas(paraAbrir.getNumeroDeDocumento());
        Googolplex.programa.getDocumentosMasBuscados().ordenarPilaMayorAMenor(Googolplex.programa.getDocumentosMasBuscados());
        Googolplex.programa.editarLineaDeDocumentoEditado(paraAbrir);
        File archivo = new File(Googolplex.programa.getPathRelativoDelPrograma() + Googolplex.programa.getPathRelativoDeLosDocumentos() + paraAbrir.getNombre());
        try {
            Desktop.getDesktop().open(archivo);
        } catch (IOException f) {
            f.printStackTrace();
        }
        llenarTabla();
    }//GEN-LAST:event_btnAbrirArchivoActionPerformed

    private void txtboxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxSearchActionPerformed

    }//GEN-LAST:event_txtboxSearchActionPerformed

    private void txtboxSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtboxSearchCaretUpdate
        
    }//GEN-LAST:event_txtboxSearchCaretUpdate

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tablaDocumentos.getModel();
        Pila resultadoDeBusqueda=Googolplex.programa.getDocumentosMasBuscados().encontrarTodoDocumentoQueCalce(txtboxSearch.getText());
        modelo.setRowCount(0);
        List<String[]> documentosPorBusquedas = resultadoDeBusqueda.imprimirPila();
        for (String[] row : documentosPorBusquedas) {
            modelo.addRow(row);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public void interfazG() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArchivo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnDocumentoExistente;
    private javax.swing.JButton btnDocumentoNuevo;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbbxModoDeOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tablaDocumentos;
    private javax.swing.JTextField txtboxSearch;
    // End of variables declaration//GEN-END:variables
}

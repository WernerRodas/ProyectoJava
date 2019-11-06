
package Formularios;
import Conexiones.conexionSQL;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmMiCRUD extends javax.swing.JFrame {
	
	//creamos la conexion a la base de 
	conexionSQL cc = new conexionSQL();
	Connection con = cc.conexion();

        /**
     * Creates new form frmMiCRUD
     */
    public frmMiCRUD(){
        initComponents();
		mostrarDatos();
		//getContentPane().setBackground(new java.awt.Color(80, 23, 80));
		//frmMiCRUD.setBackground(Color.red);
		//JFrame.setBackground(new Color(44, 56, 64));
    }
    
	public void limpiarDatos(){
		txtNOMBREALUM.setText("");
		txtAPELLIDO.setText("");
                txtCALIFICACION.setText("");
		txtCURSO.setText("");
    }
	
	public void insertarDatos(){
        try{
            String SQL = "insert into alumnos2 (nombre,apellido,materia,calificacion) values(?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1, txtNOMBREALUM.getText());
            pst.setString(2, txtAPELLIDO.getText());
            pst.setString(3, txtCURSO.getText());
            pst.setString(4, txtCALIFICACION.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Registro Exitoso");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al Registrar");
        }
    }
	
	public void ACTUALIZAR(){
		try{
			String SQL = "update alumnos2 set nombre =?, apellido =?,materia=?, calificacion =? where idalumnos = ?";

			int filaSelect = jtablaAlumnos.getSelectedRow();
			String id = (String) jtablaAlumnos.getValueAt(filaSelect, 0);
			PreparedStatement pst = con.prepareStatement(SQL);

			pst.setString(1, txtNOMBREALUM.getText());
			pst.setString(2, txtAPELLIDO.getText());
			pst.setString(3,txtCURSO.getText());
			pst.setString(4, txtCALIFICACION.getText());
			pst.setString(5, id);
			pst.execute();
			
			JOptionPane.showMessageDialog(null,"Registro Actualizado Exitosamente");

		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"Error al Registrar");
		}
	}
	
	public void mostrarDatos(){
		String[] titulos = {"ID","nombre","apellido", "materia", "calificacion"};
		String[] registros = new String[7];
		DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String sql = "select * from  alumnos2";
        try{
			Statement  st = con.createStatement();
			ResultSet  rs = st.executeQuery(sql);
        
			while(rs.next()){
				registros[0] = rs.getString("idalumnos");
				registros[1] = rs.getString(("nombre"));
				registros[2] = rs.getString("apellido");
				registros[3] = rs.getString("materia");
				registros[4] = rs.getString("calificacion");
				modelo.addRow(registros);
			}
        
			jtablaAlumnos.setModel(modelo);
        } catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al mostrar Datos" + e.getMessage());
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

        jTextField3 = new javax.swing.JTextField();
        lblNOMBRE = new javax.swing.JLabel();
        txtNOMBREALUM = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtAPELLIDO = new javax.swing.JTextField();
        lblCURSO = new javax.swing.JLabel();
        txtCURSO = new javax.swing.JTextField();
        cmdGUARDAR = new javax.swing.JButton();
        cmdEDITAR = new javax.swing.JButton();
        cmdELIMINAR = new javax.swing.JButton();
        cmdNUEVO = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCALIFICACION = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNOMBRE.setBackground(new java.awt.Color(255, 0, 0));
        lblNOMBRE.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNOMBRE.setForeground(new java.awt.Color(0, 0, 255));
        lblNOMBRE.setText("Nombre del Alumno:");
        lblNOMBRE.setAutoscrolls(true);

        lblApellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(0, 0, 255));
        lblApellido.setText("Apellidos del Alumno:");

        txtAPELLIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPELLIDOActionPerformed(evt);
            }
        });

        lblCURSO.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblCURSO.setForeground(new java.awt.Color(0, 0, 255));
        lblCURSO.setText("Curso:");

        cmdGUARDAR.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cmdGUARDAR.setForeground(new java.awt.Color(0, 0, 255));
        cmdGUARDAR.setText("GUARDAR");
        cmdGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdGUARDARActionPerformed(evt);
            }
        });

        cmdEDITAR.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cmdEDITAR.setForeground(new java.awt.Color(0, 0, 255));
        cmdEDITAR.setText("ACTUALIZAR");
        cmdEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEDITARActionPerformed(evt);
            }
        });

        cmdELIMINAR.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cmdELIMINAR.setForeground(new java.awt.Color(0, 0, 255));
        cmdELIMINAR.setText("ELIMINAR");
        cmdELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdELIMINARActionPerformed(evt);
            }
        });

        cmdNUEVO.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        cmdNUEVO.setForeground(new java.awt.Color(0, 0, 255));
        cmdNUEVO.setText("NUEVO");
        cmdNUEVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNUEVOActionPerformed(evt);
            }
        });

        jtablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtablaAlumnos);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Calificacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdGUARDAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdEDITAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdELIMINAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdNUEVO))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblCURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCURSO, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCALIFICACION, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNOMBREALUM, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNOMBRE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNOMBREALUM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lblApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAPELLIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lblCURSO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCURSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCALIFICACION, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdGUARDAR)
                            .addComponent(cmdEDITAR)
                            .addComponent(cmdELIMINAR)
                            .addComponent(cmdNUEVO))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAPELLIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPELLIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPELLIDOActionPerformed

    private void cmdGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdGUARDARActionPerformed
        insertarDatos();
        mostrarDatos();
    }//GEN-LAST:event_cmdGUARDARActionPerformed

    private void cmdELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdELIMINARActionPerformed
        try {
            String SQL="delete from alumnos2 where idalumnos = ?";
            
            int selectfila = jtablaAlumnos.getSelectedRow();
            String id = (String) jtablaAlumnos.getValueAt(selectfila,0);
            PreparedStatement pst = con.prepareStatement (SQL);
            
            pst.setString(1, id);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro");
        }
        mostrarDatos();
    }//GEN-LAST:event_cmdELIMINARActionPerformed

    private void cmdEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEDITARActionPerformed
        ACTUALIZAR();
        mostrarDatos();
    }//GEN-LAST:event_cmdEDITARActionPerformed

    private void cmdNUEVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNUEVOActionPerformed
     limpiarDatos();
    }//GEN-LAST:event_cmdNUEVOActionPerformed

    private void jtablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablaAlumnosMouseClicked
        // TODO add your handling code here:
        int filaSelect = jtablaAlumnos.rowAtPoint(evt.getPoint());
        
        txtNOMBREALUM.setText(jtablaAlumnos.getValueAt(filaSelect, 1).toString());
        txtAPELLIDO.setText(jtablaAlumnos.getValueAt(filaSelect, 2).toString());
        txtCURSO.setText(jtablaAlumnos.getValueAt(filaSelect, 3).toString());
        txtCALIFICACION.setText(jtablaAlumnos.getValueAt(filaSelect, 4).toString());
    }//GEN-LAST:event_jtablaAlumnosMouseClicked
  
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
            java.util.logging.Logger.getLogger(frmMiCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMiCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMiCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMiCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMiCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdEDITAR;
    private javax.swing.JButton cmdELIMINAR;
    private javax.swing.JButton cmdGUARDAR;
    private javax.swing.JButton cmdNUEVO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable jtablaAlumnos;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCURSO;
    private javax.swing.JLabel lblNOMBRE;
    private javax.swing.JTextField txtAPELLIDO;
    private javax.swing.JTextField txtCALIFICACION;
    private javax.swing.JTextField txtCURSO;
    private javax.swing.JTextField txtNOMBREALUM;
    // End of variables declaration//GEN-END:variables
}



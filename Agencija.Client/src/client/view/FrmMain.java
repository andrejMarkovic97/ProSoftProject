/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

/**
 *
 * @author Andrej
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
        setLocationRelativeTo(null);
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
        jMenuMain = new javax.swing.JMenuBar();
        jMenuEmployee = new javax.swing.JMenu();
        jmiOpenEmployeeFrm = new javax.swing.JMenuItem();
        jmiOpenListingFrm = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiOpenRentalFrm = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        jMenuEmployee.setText("Employee");

        jmiOpenEmployeeFrm.setText(" Open Employee Form");
        jMenuEmployee.add(jmiOpenEmployeeFrm);

        jMenuMain.add(jMenuEmployee);

        jmiOpenListingFrm.setText("Listing");

        jMenuItem1.setText("Open Listing Form");
        jmiOpenListingFrm.add(jMenuItem1);

        jMenuMain.add(jmiOpenListingFrm);

        jmiOpenRentalFrm.setText("Rental");

        jMenuItem2.setText("Open Rental Form");
        jmiOpenRentalFrm.add(jMenuItem2);

        jMenuMain.add(jmiOpenRentalFrm);

        setJMenuBar(jMenuMain);

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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuEmployee;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar jMenuMain;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmiOpenEmployeeFrm;
    private javax.swing.JMenu jmiOpenListingFrm;
    private javax.swing.JMenu jmiOpenRentalFrm;
    // End of variables declaration//GEN-END:variables
}
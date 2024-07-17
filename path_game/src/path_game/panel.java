/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package path_game;

import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author PC
 */
public class panel extends javax.swing.JFrame {
    
    String parent_dog = "\\/images/parent_dog.png";
    String puppy_dog = "\\/images/puppy_dog.png";
    String paw = "\\/images/paw.png";
    String thorns = "\\/images/thorns.png";
    
    Component[] comp1;
    Component[] comp2;
    Random random = new Random();
    String randomImage;
    JLabel[][] labels;
    String[][] imagesOrder = new String[5][2];
    ArrayList<String> list = new ArrayList<>();
    
    int count = 0;
    boolean win = true;
    /**
     * Creates new form panel
     */
    public panel() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        displayImage(puppy_dog,jLabel_Dogstart);
        labels = new JLabel[][]{ {jLabel_1_1,jLabel_1_2},{jLabel_2_1,jLabel_2_2},
                                {jLabel_3_1,jLabel_3_2},{jLabel_4_1,jLabel_4_2},
                                {jLabel_5_1,jLabel_5_2}};
        
        for(JLabel[] l: labels){
            l[0].setEnabled(false);
            l[1].setEnabled(false);
        }
        
        list.add(paw);
        list.add(thorns);
        
        comp1 = jPanel2.getComponents();
        comp2 = jPanel3.getComponents();
        
        randomImages();
        
        addAction();
        
    }
    
    public void enableLabels(int i){
        
        if(i<=labels.length-1){
            
            JLabel[] l = labels[i];
            l[0].setEnabled(true);
            l[1].setEnabled(true);
        }
    }
    
    
    public void randomImages(){
        
        for(int i=0; i<labels.length;i++){
            randomImage = list.get(random.nextInt(list.size()));
            imagesOrder[i][0] = randomImage;
            
            if(randomImage.equals(paw))
                imagesOrder[i][1] = thorns;
            else
                imagesOrder[i][1] = paw;
            
            System.out.println(imagesOrder[i][0]);
            System.out.println(imagesOrder[i][1]);
            System.out.println();
            
        }
    }
    
    public void addAction(){
        
        enableLabels(count);
        
        for(Component comp: comp1){ 
            if(comp instanceof JLabel){
                JLabel label = (JLabel) comp;
                label.addMouseListener(new java.awt.event.MouseAdapter() {
                    
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt){
                        
                        if(label.isEnabled()){
                            
                            displayImage(imagesOrder[count][1] ,label);
                            
                            if(imagesOrder[count][1].equals(thorns)){
                                win=false;
                            }
                            
                            label.setEnabled(false);
                            JLabel label = (JLabel)comp2[count];
                            label.setEnabled(false);
                            
                            if(imagesOrder.length-1 == count && win==true){
                             displayImage(parent_dog,jLabel_Dogfinish);   
                             jLabel_msg.setText("YAY!! Puppy meets Mummy");
                            }
                            else if(win==false){
                             jLabel_msg.setText(" OOPS!! Puppy got TRAPPED");   
                            }
                            
                            count++;
                            enableLabels(count);
                        }
                    }
                });
            }
        }
        
        for(Component comp: comp2){
            if(comp instanceof JLabel){
                JLabel label = (JLabel) comp;
                label.addMouseListener(new java.awt.event.MouseAdapter() {
                    
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt){
                      if(label.isEnabled()){
                            
                            displayImage(imagesOrder[count][0] ,label);
                            
                               if(imagesOrder[count][0].equals(thorns)){
                                win=false;
                            }
                            
                            label.setEnabled(false);
                            JLabel label = (JLabel)comp1[count];
                            label.setEnabled(false);
                            
                             if(imagesOrder.length-1 == count && win==true){
                             displayImage(parent_dog,jLabel_Dogfinish);    
                             jLabel_msg.setText("YAY!! Puppy meets Mummy");
                            }
                            else if(win==false){
                             jLabel_msg.setText("OOPS!! Puppy got TRAPPED");   
                            }
                             
                            count++;
                            enableLabels(count);
                        }
                    }
                });
            }
        }
        
    }
    
    public void displayImage(String imgPath, JLabel label){
        
        ImageIcon img = new ImageIcon(getClass().getResource(imgPath));
        
        Image image = img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        
        label.setIcon(new ImageIcon(image));
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
        jPanel_finish = new javax.swing.JPanel();
        jLabel_Dogfinish = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_1_1 = new javax.swing.JLabel();
        jLabel_2_1 = new javax.swing.JLabel();
        jLabel_5_1 = new javax.swing.JLabel();
        jLabel_4_1 = new javax.swing.JLabel();
        jLabel_3_1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_1_2 = new javax.swing.JLabel();
        jLabel_5_2 = new javax.swing.JLabel();
        jLabel_4_2 = new javax.swing.JLabel();
        jLabel_3_2 = new javax.swing.JLabel();
        jLabel_2_2 = new javax.swing.JLabel();
        jPanel_start1 = new javax.swing.JPanel();
        jLabel_Dogstart = new javax.swing.JLabel();
        jButton_PlayGame = new javax.swing.JButton();
        jLabel_msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_finish.setBackground(new java.awt.Color(153, 0, 51));

        javax.swing.GroupLayout jPanel_finishLayout = new javax.swing.GroupLayout(jPanel_finish);
        jPanel_finish.setLayout(jPanel_finishLayout);
        jPanel_finishLayout.setHorizontalGroup(
            jPanel_finishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_finishLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel_Dogfinish, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel_finishLayout.setVerticalGroup(
            jPanel_finishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_finishLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_Dogfinish, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 51));

        jLabel_1_1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_1_1.setOpaque(true);

        jLabel_2_1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_2_1.setOpaque(true);

        jLabel_5_1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_5_1.setOpaque(true);

        jLabel_4_1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_4_1.setOpaque(true);

        jLabel_3_1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_3_1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLabel_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 51));

        jLabel_1_2.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_1_2.setOpaque(true);

        jLabel_5_2.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_5_2.setOpaque(true);

        jLabel_4_2.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_4_2.setOpaque(true);

        jLabel_3_2.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_3_2.setOpaque(true);

        jLabel_2_2.setBackground(new java.awt.Color(51, 153, 0));
        jLabel_2_2.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel_start1.setBackground(new java.awt.Color(153, 0, 51));

        jLabel_Dogstart.setText("jLabel1");

        javax.swing.GroupLayout jPanel_start1Layout = new javax.swing.GroupLayout(jPanel_start1);
        jPanel_start1.setLayout(jPanel_start1Layout);
        jPanel_start1Layout.setHorizontalGroup(
            jPanel_start1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_start1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel_Dogstart, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel_start1Layout.setVerticalGroup(
            jPanel_start1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_start1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Dogstart, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jButton_PlayGame.setBackground(new java.awt.Color(102, 102, 102));
        jButton_PlayGame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton_PlayGame.setForeground(new java.awt.Color(255, 255, 255));
        jButton_PlayGame.setText("PLAY GAME");
        jButton_PlayGame.setOpaque(true);
        jButton_PlayGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PlayGameActionPerformed(evt);
            }
        });

        jLabel_msg.setBackground(new java.awt.Color(204, 0, 204));
        jLabel_msg.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_msg.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_msg.setText("                               MSG");
        jLabel_msg.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(jPanel_start1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_PlayGame, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_start1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel_finish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_PlayGame, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(jLabel_msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PlayGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PlayGameActionPerformed
        // TODO add your handling code here:
        
               randomImages();
        
        for(JLabel[] l : labels){
            l[0].setIcon(null);l[1].setIcon(null);
        }
        jLabel_Dogfinish.setIcon(null);
         
         win = true; count = 0;
         
         enableLabels(count);
         jLabel_msg.setText("");
        
    }//GEN-LAST:event_jButton_PlayGameActionPerformed

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
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_PlayGame;
    private javax.swing.JLabel jLabel_1_1;
    private javax.swing.JLabel jLabel_1_2;
    private javax.swing.JLabel jLabel_2_1;
    private javax.swing.JLabel jLabel_2_2;
    private javax.swing.JLabel jLabel_3_1;
    private javax.swing.JLabel jLabel_3_2;
    private javax.swing.JLabel jLabel_4_1;
    private javax.swing.JLabel jLabel_4_2;
    private javax.swing.JLabel jLabel_5_1;
    private javax.swing.JLabel jLabel_5_2;
    private javax.swing.JLabel jLabel_Dogfinish;
    private javax.swing.JLabel jLabel_Dogstart;
    private javax.swing.JLabel jLabel_msg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_finish;
    private javax.swing.JPanel jPanel_start1;
    // End of variables declaration//GEN-END:variables
}

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gargi
 */
public class HistoryLogQuestionnaire extends javax.swing.JFrame {

    public HistoryLogQuestionnaire() {
        initComponents();
        
        JFrame F = null;
        F = new JFrame();
        
        int q1 = JOptionPane.showConfirmDialog(F, "Has The Patient Taken Their Medications?");
        int q2 = JOptionPane.showConfirmDialog(F, "Has The Patient Done Any Form Of Exercise (Running, Walking, Skipping, Meditation, etc.)?");
        int q3 = JOptionPane.showConfirmDialog(F, "Has The Patient Maintained Hygiene (Brushing Teeth, Showering, Deodorant Use, etc.)?");
        int q4 = JOptionPane.showConfirmDialog(F, "Has The Patient Been Actively Social (Meeting Friends, Playing Games, Talking to Family/Relatives, etc.)?");
        int q5 = JOptionPane.showConfirmDialog(F, "Has The Patient Been Cooperative?");
        int q6 = JOptionPane.showConfirmDialog(F, "Has The Patient Shown Signs of Improvement Healthwise (BP Levels, Sugar Levels, Cholesterol, Diabetes, Breathing, Heart Rate, etc.)?");
        int q7 = JOptionPane.showConfirmDialog(F, "Has The Patient Shown Signs of Improvement Mentally (Decrease of Loneliness, Depression & Anxiety)?");
        int q8 = JOptionPane.showConfirmDialog(F, "Has The Patient Shown Signs of Early Aging (Dimentia, Visually Imparied, Need of Hearing Aids, Walking Cranes, etc.)?");
        
        String Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8;
        
        if (q1 == 0)
            Q1 = "YES";
        else
            Q1 = "NO";
        
        if (q2 == 0)
            Q2 = "YES";
        else
            Q2 = "NO";
        
        if (q3 == 0)
            Q3 = "YES";
        else
            Q3 = "NO";
        
        if (q4 == 0)
            Q4 = "YES";
        else
            Q4 = "NO";
        
        if (q5 == 0)
            Q5 = "YES";
        else
            Q5 = "NO";
        
        if (q6 == 0)
            Q6 = "YES";
        else
            Q6 = "NO";
        
        if (q7 == 0)
            Q7 = "YES";
        else
            Q7 = "NO";
        
        if (q8 == 0)
            Q8 = "YES";
        else
            Q8 = "NO";
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object []{"1) Has The Patient Taken Their Medications?", Q1}); 
        model.addRow(new Object[]{"2) Has The Patient Done Any Form Of Exercise? (Running, Walking, Skipping, Meditation, etc.)", Q2});
        model.addRow(new Object[]{"3) Has The Patient Maintained Hygiene? (Brushing Teeth, Showering, Deodorant Use, etc.)", Q3}); 
        model.addRow(new Object[]{"4) Has The Patient Been Actively Social? (Meeting Friends, Playing Games, Talking to Family/Relatives, etc.)", Q4});
        model.addRow(new Object[]{"5) Has The Patient Been Cooperative?", Q5});
        model.addRow(new Object[]{"6) Has The Patient Shown Signs of Improvement Healthwise? (BP Levels, Sugar Levels, Cholesterol, Diabetes, Breathing, Heart Rate, etc.)", Q6});
        model.addRow(new Object[]{"7) Has The Patient Shown Signs of Improvement Mentally? (Decrease of Loneliness, Depression & Anxiety)", Q7});
        model.addRow(new Object[]{"8) Has The Patient Shown Signs of Early Aging? (Dimentia, Visually Imparied, Need of Hearing Aids, Walking Cranes, etc.)", Q8});
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel11.setText("History Log");
        jLabel11.setAlignmentY(0.0F);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Questions", "Answers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(363, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(340, 340, 340))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoryLogQuestionnaire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java. sql.*;
import java.io.File;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.io.*;
import java.lang.Integer;
import java.io.FileWriter;

public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }
    
    BufferedImage img_b = null;
    BufferedImage img_c = null;

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setForeground(java.awt.Color.darkGray);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 255));
        jTextField2.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        jTextField2.setText("ENCODING");
        jTextField2.setBorder(null);
        

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        jButton1.setText("UPLOAD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jDesktopPane1.setMaximumSize(new java.awt.Dimension(180, 180));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(180, 180));

        jLabel2.setMaximumSize(new java.awt.Dimension(200, 180));
        jLabel2.setMinimumSize(new java.awt.Dimension(200, 180));
        jLabel2.setName(""); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 180));

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTextField1.setBackground(new java.awt.Color(102, 102, 255));
        jTextField1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Upload the base image");

        jTextField3.setBackground(new java.awt.Color(102, 102, 255));
        jTextField3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Upload the code image");
        jTextField3.setScrollOffset(58);
        

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        jButton2.setText("UPLOAD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jDesktopPane2.setMaximumSize(new java.awt.Dimension(180, 180));
        jDesktopPane2.setMinimumSize(new java.awt.Dimension(180, 180));

        jLabel1.setMaximumSize(new java.awt.Dimension(180, 180));
        jLabel1.setMinimumSize(new java.awt.Dimension(180, 180));
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 180));

        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        jButton3.setText("SUBMIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDesktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(82, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

   

    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //base code
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        try{
            //BufferedImage img = null;
            img_b = ImageIO.read(new File(f.getAbsolutePath()));
            Image img1 = img_b.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            jLabel2.setIcon(format);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        filename=f.getAbsolutePath();
        jTextField1.setText(filename);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //code code
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        try{
            //BufferedImage img = null;
            img_c = ImageIO.read(new File(f.getAbsolutePath()));
            Image img1 = img_c.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon format = new ImageIcon(img1);
            jLabel1.setIcon(format);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        filename=f.getAbsolutePath();
        jTextField3.setText(filename);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //submit button
        //BufferedImage

        FileWriter key_file = null;

        try {
            key_file = new FileWriter("key_file.txt");
        } catch (Exception e) {
            e.getStackTrace();
        }
        
		BufferedWriter key = new BufferedWriter(key_file);

        Encode(img_c, img_b, key);
        WriteImage(img_b, "encoded.png");
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
    public static void Encode(BufferedImage code, BufferedImage base, BufferedWriter key){
		int w_b = base.getWidth();
        int h_b = base.getHeight();
        
		int w_c = code.getWidth();
        int h_c = code.getHeight();

        int rgb_base, rgb_code;

        System.out.println(w_b + " " + h_b);
		
		System.out.println(w_c + " " + h_c);

		try{
			key.write(w_c + "," + h_c);
			key.write("\n");
		}
		catch(Exception e){
			e.getStackTrace();
		}
		String temp3="";
		for(int row = 0; row<h_c; row++){
			
			//System.out.println("\nRow "+row);

			String row_base[] = new String[w_b];
			String row_code[] = new String[w_c];

			//creating base binary array

			for(int col = 0; col<w_b; col++){
				rgb_base = base.getRGB(col, row); 
				Color color_base = new Color(rgb_base, true);

				int c_arr_base[] = {color_base.getRed(),color_base.getGreen(),color_base.getBlue()};
				String c_arr_bin_base[]={"0","0","0"};

				for(int l = 0; l<3; l++){

					c_arr_bin_base[l] = Integer.toBinaryString(c_arr_base[l]);
					
					while(c_arr_bin_base[l].length()<8){
						c_arr_bin_base[l] = "0" + c_arr_bin_base[l];
					}
			
				}
				row_base[col] = c_arr_bin_base[0] + c_arr_bin_base[1] + c_arr_bin_base[2];
			}

			//creating code binary array
			
			for(int col = 0; col<w_c; col++){

                rgb_code = code.getRGB(col, row); 
				Color color_code = new Color(rgb_code, true);

				int c_arr_code[] = {color_code.getRed(),color_code.getGreen(),color_code.getBlue()};
				String c_arr_bin_code[]={"0","0","0"};

				for(int l = 0; l<3; l++){

                    c_arr_bin_code[l] = Integer.toBinaryString(c_arr_code[l]);
					
					while(c_arr_bin_code[l].length()<8){
						c_arr_bin_code[l] = "0" + c_arr_bin_code[l];
					}				
				}
				row_code[col] = c_arr_bin_code[0] + c_arr_bin_code[1] + c_arr_bin_code[2];
			}	
			
			//creating 2d base array

			int[][] base_arr = new int[row_base.length][2];
			int temp;

			for(int i = 0; i < base_arr.length; i++) {
				temp = Integer.parseInt(row_base[i],2);
				base_arr[i] = new int[] { temp, i};
			}

			Arrays.sort(base_arr, (a, b) -> Integer.compare(a[0], b[0]));

			//creating 2d code array

			int[][] code_arr = new int[row_code.length][2];

			for(int i = 0; i < code_arr.length; i++) {
				temp = Integer.parseInt(row_code[i],2);
				code_arr[i] = new int[] { temp, i};
			}

			//applying closest pixel algorithm

			int[][] base_copy=base_arr, base_copy2 = base_arr;	
			int row_ind[] = new int[w_c];

			int assigned_size = 0;

			while(assigned_size<w_c){
			
				int ind = 0;
	
				for(int i = 0; i<base_copy.length;i++){
					if(code_arr[assigned_size][0]>base_copy[i][0]){
						ind++;
					}
					else{
						break;
					}
				}
				
				if(ind == base_copy.length){
					row_ind[assigned_size] = base_copy[ind-1][1];
					ind = ind - 1;
				}

				else if(ind == 0){
					row_ind[assigned_size] = base_copy[ind][1];
				}
				
				else if(Math.abs(code_arr[assigned_size][0]-base_copy[ind][0])<Math.abs(code_arr[assigned_size][0]-base_copy[ind-1][0])){
					row_ind[assigned_size] = base_copy[ind][1];
				}

				else{
					row_ind[assigned_size] = base_copy[ind-1][1];
					ind = ind - 1;
				}

				for(int i=0, k=0;i<base_copy.length;i++){
					if(i!=ind){
						base_copy2[k]=base_copy[i];
						k++;
					}
				}base_copy=base_copy2;

				String tempstr = Integer.toString(row_ind[assigned_size]);
						
				assigned_size++;
			}
			//System.out.println(row+" "+row_ind.length);
			

			for(int i = 0; i<w_c;i++){
				temp3 = temp3 + row_ind[i]+","; 
			}temp3+="\n";
			//System.out.println(temp3+"\n");

			Arrays.sort(base_arr, (a, b) -> Integer.compare(a[1], b[1]));

			//encoding

			String[] temp_col = new String[3]; // r g b			

			for(int i = 0; i<w_c; i++){
				temp_col[0] = row_base[row_ind[i]].substring(0, 4)+row_code[i].substring(0, 4);
				temp_col[1] = row_base[row_ind[i]].substring(8, 12)+row_code[i].substring(8, 12);
				temp_col[2] = row_base[row_ind[i]].substring(16, 20)+row_code[i].substring(16, 20);		
				
				int nrgb  = 65536 * Integer.parseInt(temp_col[0], 2) + 256 * Integer.parseInt(temp_col[1], 2) + Integer.parseInt(temp_col[2], 2) ;
                base.setRGB(row_ind[i], row, nrgb);		
			}
			
		}
		//System.out.println("\n"+temp3);
		try{
			key.write(temp3);
			key.close();
			//System.out.println(row);
		}
		catch(Exception e){
			e.getStackTrace();
		}

	}
    
    

    public static void WriteImage(BufferedImage img, String path){
        File ImageFile = new File(path);

        try{
            ImageIO.write(img,"png", ImageFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
byte[] photo=null;
String filename=null;
}

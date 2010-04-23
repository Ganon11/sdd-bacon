/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ComicDialog.java
 *
 * Created on Apr 16, 2010, 11:19:28 AM
 */

package BACON;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Matt
 */
public class ComicDialog extends javax.swing.JDialog {

    /** Creates new form ComicDialog */
    public ComicDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** Creates new form ComicDialog with the given ComicSite data filled in */
    public ComicDialog(java.awt.Frame parent, boolean modal, ComicSite cs) {
        super(parent, modal);
        initComponents();
        
        if(cs != null) {
            if(cs.getAuthor() != null) txtAuthor.setText(cs.getAuthor());
            if(cs.getTitle() != null) txtName.setText(cs.getTitle());
            if(cs.getUrl() != null) loadImages(cs.getUrl(), cs.getIndex());
            this.setTitle("Edit " + cs.getTitle());
        } else this.setTitle("New Comic");

        this.getRootPane().setDefaultButton(btnLoadImages);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtURL = new javax.swing.JTextField();
        btnLoadImages = new javax.swing.JButton();
        lblWebURL = new javax.swing.JLabel();
        panPreview = new javax.swing.JScrollPane();
        lblPreview = new javax.swing.JLabel();
        lblTitleText = new javax.swing.JLabel();
        panBottom = new javax.swing.JPanel();
        txtAuthor = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        lblAuthor = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAccept = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        btnPrevImage = new javax.swing.JButton();
        btnNextImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 400));

        txtURL.setText("http://");
        txtURL.setToolTipText("The URL where the comic can be found");
        txtURL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtURLFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtURLFocusLost(evt);
            }
        });

        btnLoadImages.setText("Load Website Images");
        btnLoadImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImagesActionPerformed(evt);
            }
        });

        lblWebURL.setText("Website URL:");

        lblPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreview.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panPreview.setViewportView(lblPreview);

        lblTitleText.setText("Enter a valid comic URL and press Load");

        txtAuthor.setToolTipText("The comic's author");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblAuthor.setText("Comic Author:");

        txtName.setToolTipText("The comic's name/title");

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        lblName.setText("Comic Name:");

        btnPrevImage.setText("Previous");
        btnPrevImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevImageActionPerformed(evt);
            }
        });

        btnNextImage.setText("Next");
        btnNextImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panBottomLayout = new javax.swing.GroupLayout(panBottom);
        panBottom.setLayout(panBottomLayout);
        panBottomLayout.setHorizontalGroup(
            panBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBottomLayout.createSequentialGroup()
                .addGroup(panBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBottomLayout.createSequentialGroup()
                        .addComponent(btnPrevImage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNextImage))
                    .addGroup(panBottomLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                    .addGroup(panBottomLayout.createSequentialGroup()
                        .addComponent(lblAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                    .addGroup(panBottomLayout.createSequentialGroup()
                        .addComponent(btnAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        panBottomLayout.setVerticalGroup(
            panBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBottomLayout.createSequentialGroup()
                .addGroup(panBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevImage)
                    .addComponent(btnNextImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthor)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAccept)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panPreview, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblWebURL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtURL, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                    .addComponent(btnLoadImages, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWebURL)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadImages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitleText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private URL[] imageURLs = null; //The site image URLs
    //private Icon[] images = null; //The site images (loaded on demand)
    private int cIndex = 0; //The index of the image we are looking at
    private ComicSite comicSite = null; //The final ComicSite we will create
    
    private void btnPrevImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevImageActionPerformed
        if(!hasImages()) return;
        if(--cIndex < 0) cIndex = imageURLs.length - 1;
        loadPreview();
    }//GEN-LAST:event_btnPrevImageActionPerformed

    private void btnNextImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextImageActionPerformed
        if(!hasImages()) return;
        if(++cIndex >= imageURLs.length) cIndex = 0;
        loadPreview();
    }//GEN-LAST:event_btnNextImageActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        if(hasImages()) {
            comicSite = new ComicSite(getComicName(), getComicAuthor(), getComicURL(), cIndex);
            comicSite.setStrip(new ComicStrip(imageURLs[cIndex].toString()));
            this.dispose();
        } else {
            //Tell user that they must enter and load a valid URL
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLoadImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImagesActionPerformed
        if(!hasImages()) loadImages(txtURL.getText(), 0);
        else clearImages();
    }//GEN-LAST:event_btnLoadImagesActionPerformed

    private void txtURLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtURLFocusGained
        this.getRootPane().setDefaultButton(btnLoadImages);
    }//GEN-LAST:event_txtURLFocusGained

    private void txtURLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtURLFocusLost
        this.getRootPane().setDefaultButton(btnAccept);
    }//GEN-LAST:event_txtURLFocusLost

    private void clearImages() {
        imageURLs = null;
        lblPreview.setIcon(null);
        txtURL.setEnabled(true);
        btnLoadImages.setText("Load Website Images");
        lblTitleText.setText("Enter a valid comic URL and press Load");
    }

    private boolean comicIndexOk() {
        return imageURLs != null && cIndex >= 0 && cIndex < imageURLs.length;
    }

    public String getComicAuthor() {
        return txtAuthor.getText();
    }

    public int getComicIndex() {
        return cIndex;
    }

    public String getComicName() {
        return txtName.getText();
    }

    public ComicSite getComicSite() {
        return comicSite;
    }

    public String getComicURL() {
        return hasImages() ? txtURL.getText() : null;
    }

    private boolean hasImages() {
        return imageURLs != null && imageURLs.length > 0;
    }

    private void loadImages(String url, int startIndex) {
        clearImages();
        txtURL.setText(url);
        txtURL.setEnabled(false);
        imageURLs = BaconSystem.getImageURLs(url);
        if(!hasImages()) { //Site issue
            if(imageURLs == null) {
                //Error - Couldn't load page

            } else {
                //Error - No images

            }
            imageURLs = null;
            txtURL.setEnabled(true);
            return;
        }

        //images = new Icon[imageURLs.length];
        cIndex = startIndex;
        if(!comicIndexOk()) {
            //Error - Bad image index given. Say something and set to 0
            cIndex = 0;
        }
        btnLoadImages.setText("Edit Website URL");
        loadPreview();
    }
    
    private void loadPreview()
    {
        if(hasImages()) {
            if(!comicIndexOk()) cIndex = 0;

            URL url = imageURLs[cIndex];
            
            if(url != null) {
                lblTitleText.setText(String.format("Image %d/%d: %s",
                        cIndex + 1, imageURLs.length, url));

                //Icon img = images[cIndex];
                //if(img == null) img = images[cIndex] = new ImageIcon(imageURLs[cIndex]);
                lblPreview.setIcon(new ImageIcon(imageURLs[cIndex]));
            } else {
                lblTitleText.setText(String.format("Image %d/%d: <Invalid Image URL>",
                        cIndex + 1, imageURLs.length));
                lblPreview.setIcon(null);
            }
        } else clearImages();
    }

    public static ComicSite show(ComicSite cs) {
        ComicDialog dialog = new ComicDialog(new javax.swing.JFrame(), true, cs);
        dialog.setVisible(true);
        return dialog.getComicSite();
    }


//    /**
//    * @param args the command line arguments
//    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ComicDialog dialog = new ComicDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLoadImages;
    private javax.swing.JButton btnNextImage;
    private javax.swing.JButton btnPrevImage;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JLabel lblTitleText;
    private javax.swing.JLabel lblWebURL;
    private javax.swing.JPanel panBottom;
    private javax.swing.JScrollPane panPreview;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables

}
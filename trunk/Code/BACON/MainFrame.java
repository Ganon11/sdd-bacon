/**
 * BACON (sdd.bacon@gmail.com)
 *
 * MainFrame - This class displays the main window.
 *
 * Copyright (c) 2010
 * @author David Pizzuto, Seamus Reynolds, Matt Schoen, Michael Stark
 * All Rights Reserved
 *
 * @version 0.1, 04/02/10
 *
 * http://code.google.com/p/bacon/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package BACON;

import java.awt.Image;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame(ComicDatabase db) {
        initComponents();
        database = db;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        mainComicPanel = new javax.swing.JPanel();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        comicPane = new javax.swing.JScrollPane();
        comicDataLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        preferencesMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        sortMenu = new javax.swing.JMenu();
        sortByNameMenuItem = new javax.swing.JMenuItem();
        sortByUpdateMenuItem = new javax.swing.JMenuItem();
        webcomicMenu = new javax.swing.JMenu();
        addWebcomicMenuItem = new javax.swing.JMenuItem();
        editComicMenuItem = new javax.swing.JMenuItem();
        removeComicMenuItem = new javax.swing.JMenuItem();
        databaseMenu = new javax.swing.JMenu();
        loadDatabaseMenuItem = new javax.swing.JMenuItem();
        saveDatabaseMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        prevButton.setText("Previous");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        comicPane.setViewportView(comicDataLabel);

        javax.swing.GroupLayout mainComicPanelLayout = new javax.swing.GroupLayout(mainComicPanel);
        mainComicPanel.setLayout(mainComicPanelLayout);
        mainComicPanelLayout.setHorizontalGroup(
            mainComicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainComicPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(prevButton)
                .addGap(73, 73, 73)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(aboutButton)
                .addContainerGap())
            .addGroup(mainComicPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(comicPane, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(74, 74, 74))
        );
        mainComicPanelLayout.setVerticalGroup(
            mainComicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainComicPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(comicPane, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(mainComicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(prevButton)
                    .addComponent(aboutButton))
                .addContainerGap())
        );

        fileMenu.setText("File");

        preferencesMenuItem.setText("Preferences");
        fileMenu.add(preferencesMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        sortMenu.setText("Sort");

        sortByNameMenuItem.setText("Sort by Name");
        sortByNameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByNameMenuItemActionPerformed(evt);
            }
        });
        sortMenu.add(sortByNameMenuItem);

        sortByUpdateMenuItem.setText("Sort by Latest Update");
        sortByUpdateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortByUpdateMenuItemActionPerformed(evt);
            }
        });
        sortMenu.add(sortByUpdateMenuItem);

        menuBar.add(sortMenu);

        webcomicMenu.setText("Webcomic");

        addWebcomicMenuItem.setText("Add Webcomic");
        addWebcomicMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWebcomicMenuItemActionPerformed(evt);
            }
        });
        webcomicMenu.add(addWebcomicMenuItem);

        editComicMenuItem.setText("Edit Existing Webcomic");
        editComicMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editComicMenuItemActionPerformed(evt);
            }
        });
        webcomicMenu.add(editComicMenuItem);

        removeComicMenuItem.setText("Remove Webcomic");
        removeComicMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeComicMenuItemActionPerformed(evt);
            }
        });
        webcomicMenu.add(removeComicMenuItem);

        menuBar.add(webcomicMenu);

        databaseMenu.setText("Comic List");

        loadDatabaseMenuItem.setText("Load Comic List");
        loadDatabaseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDatabaseMenuItemActionPerformed(evt);
            }
        });
        databaseMenu.add(loadDatabaseMenuItem);

        saveDatabaseMenuItem.setText("Save Comic List");
        saveDatabaseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDatabaseMenuItemActionPerformed(evt);
            }
        });
        databaseMenu.add(saveDatabaseMenuItem);

        menuBar.add(databaseMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainComicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainComicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        displayNextImage(false);
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        displayNextImage(true);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // Displays a window with the license text and a link to the Google code site.
        new AboutFrame().setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void sortByNameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByNameMenuItemActionPerformed
        ComicSite.sortMethod = SortMethod.SORT_BY_ALPHABETICAL;
        database.sortComicList();
    }//GEN-LAST:event_sortByNameMenuItemActionPerformed

    private void sortByUpdateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortByUpdateMenuItemActionPerformed
        ComicSite.sortMethod = SortMethod.SORT_BY_DATE;
        database.sortComicList();
    }//GEN-LAST:event_sortByUpdateMenuItemActionPerformed

    private void addWebcomicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWebcomicMenuItemActionPerformed
        ComicSite cs = ComicDialog.show(null);
        if(cs != null) {
            System.out.println("SANDWICH");
        }
    }//GEN-LAST:event_addWebcomicMenuItemActionPerformed

    private void editComicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editComicMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editComicMenuItemActionPerformed

    private void removeComicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeComicMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeComicMenuItemActionPerformed

    private void loadDatabaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDatabaseMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadDatabaseMenuItemActionPerformed

    private void saveDatabaseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDatabaseMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveDatabaseMenuItemActionPerformed

    /**
     * Displays the next or previous image.
     *
     * @param next If true, the next image is displayed. If false, the previous is.
     */
    public void displayNextImage(boolean next) {
        ComicSite site = (next) ? database.getNextComic() : database.getPreviousComic();
        Image img = site.getStrip().getComicStripImage();
        JLabel lab = new JLabel(site.getInfoString());
        ImageIcon ic = new ImageIcon(img);
        lab.setIcon(ic);
        mainComicPanel.add(lab);
    }

//    /**
//     * We may wish to remove this main...thoughts?
//     *  I think we should ditch it, to be honest.
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        new MainFrame(null).setVisible(true);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JMenuItem addWebcomicMenuItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel comicDataLabel;
    private javax.swing.JScrollPane comicPane;
    private javax.swing.JMenu databaseMenu;
    private javax.swing.JMenuItem editComicMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JMenuItem loadDatabaseMenuItem;
    private javax.swing.JPanel mainComicPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem preferencesMenuItem;
    private javax.swing.JButton prevButton;
    private javax.swing.JMenuItem removeComicMenuItem;
    private javax.swing.JMenuItem saveDatabaseMenuItem;
    private javax.swing.JMenuItem sortByNameMenuItem;
    private javax.swing.JMenuItem sortByUpdateMenuItem;
    private javax.swing.JMenu sortMenu;
    private javax.swing.JMenu webcomicMenu;
    // End of variables declaration//GEN-END:variables
    private ComicDatabase database;

}

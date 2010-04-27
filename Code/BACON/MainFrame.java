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
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.*;

public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame(ComicDatabase db) {
        initComponents();
        database = db;
        //String locDB = dir;
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
        comicPane = new javax.swing.JScrollPane();
        comicLabel = new javax.swing.JLabel();
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
        aboutButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BACON");
        setLocationByPlatform(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        prevButton.setText("Previous");
        prevButton.setFocusable(false);
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setFocusable(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        comicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        comicLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        comicLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comicLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        comicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comicLabelMouseClicked(evt);
            }
        });
        comicPane.setViewportView(comicLabel);

        javax.swing.GroupLayout mainComicPanelLayout = new javax.swing.GroupLayout(mainComicPanel);
        mainComicPanel.setLayout(mainComicPanelLayout);
        mainComicPanelLayout.setHorizontalGroup(
            mainComicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainComicPanelLayout.createSequentialGroup()
                .addComponent(prevButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(425, Short.MAX_VALUE))
            .addComponent(comicPane, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        mainComicPanelLayout.setVerticalGroup(
            mainComicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainComicPanelLayout.createSequentialGroup()
                .addComponent(comicPane, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainComicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevButton)
                    .addComponent(nextButton)))
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

        editComicMenuItem.setText("Edit Current Webcomic");
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

        aboutButton.setText("About");
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutButtonMouseClicked(evt);
            }
        });
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        menuBar.add(aboutButton);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainComicPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainComicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        database.saveDatabase();
        System.exit(0);
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
        ComicSite cs = ComicDialog.show(this, null);
        if(cs == null) {
            //Dialog cancelled, do nothing
            //SwingInput.displayErrorMessage("Comic not created/added.");
            return;
        }
        //cs.getStrip().loadImage();
        
        database.addComic(cs);
        displayCurrentComic();
    }//GEN-LAST:event_addWebcomicMenuItemActionPerformed

    private void editComicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editComicMenuItemActionPerformed
        ComicSite cs = ComicDialog.show(this, database.getCurrentComic());
        if(cs == null) {
            //Dialog cancelled, do nothing
            //SwingInput.displayErrorMessage("Comic not edited.");
            return;
        }
        //cs.getStrip().loadImage();
        database.removeComic();
        database.addComic(cs);
        displayCurrentComic();
    }//GEN-LAST:event_editComicMenuItemActionPerformed

    private void removeComicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeComicMenuItemActionPerformed
        database.removeComic();
        displayCurrentComic();
    }//GEN-LAST:event_removeComicMenuItemActionPerformed

    private void aboutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseClicked
        // Displays a window with the license text and a link to the Google code site.
        new AboutFrame().setVisible(true);
    }//GEN-LAST:event_aboutButtonMouseClicked

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        displayNextComic(true);
}//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        displayNextComic(false);
}//GEN-LAST:event_prevButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //System.out.format("KEY PRESSED: %d\n", evt.getKeyCode());
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                displayNextComic(false);
                break;
            case KeyEvent.VK_RIGHT:
                displayNextComic(true);
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        new AboutFrame().setVisible(true);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void comicLabelMouseClicked(java.awt.event.MouseEvent evt) {
        ComicSite cs = database.getCurrentComic();
        try {
            BrowserLaunch.loadBrowser(cs.getUrl());
        } catch (IOException e) {
            SwingInput.displayErrorMessage("Could not load website: " + e.getMessage());
        }
    }
    /**
     * Displays the current comic in the database.
     */
    public void displayCurrentComic() {
        displayComic(database.getCurrentComic());
    }

    /**
     * Displays the next or previous comic from the database.
     *
     * @param next If true, the next image is displayed. If false, the previous is.
     */
    public void displayNextComic(boolean next) {
        if (next) displayComic(database.getNextComic());
        else displayComic(database.getPreviousComic());
    }

    /**
     * Displays the image and text from the corresponding ComicSite.
     *
     * @param site The ComicSite to display, or null to display nothing
     */
    public void displayComic(ComicSite site) {
        //for (ComicSite cs : database.getAllComics())
        //    System.out.println(cs.getTitle() + ":\t" + cs.getStrip().getFilePath());
        if (site != null) {
            site.getStrip().loadImage();
            setTitle(site.getTitle() + " - BACON");
            comicLabel.setText(site.getInfoString());
            Icon img = site.getStrip().getComicStripImage();
            comicLabel.setIcon(img);
        } else {
            setTitle("BACON");
            comicLabel.setText("");
            comicLabel.setIcon(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutButton;
    private javax.swing.JMenuItem addWebcomicMenuItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel comicLabel;
    private javax.swing.JScrollPane comicPane;
    private javax.swing.JMenuItem editComicMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel mainComicPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton nextButton;
    private javax.swing.JMenuItem preferencesMenuItem;
    private javax.swing.JButton prevButton;
    private javax.swing.JMenuItem removeComicMenuItem;
    private javax.swing.JMenuItem sortByNameMenuItem;
    private javax.swing.JMenuItem sortByUpdateMenuItem;
    private javax.swing.JMenu sortMenu;
    private javax.swing.JMenu webcomicMenu;
    // End of variables declaration//GEN-END:variables
    private ComicDatabase database;

}

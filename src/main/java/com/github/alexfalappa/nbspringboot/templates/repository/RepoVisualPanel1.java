/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.alexfalappa.nbspringboot.templates.repository;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.openide.WizardDescriptor;

import static com.github.alexfalappa.nbspringboot.templates.repository.RepoWizardIterator.WIZ_BASE_INTERF;
import static com.github.alexfalappa.nbspringboot.templates.repository.RepoWizardIterator.WIZ_ENTITY_CLASS;
import static com.github.alexfalappa.nbspringboot.templates.repository.RepoWizardIterator.WIZ_ID_CLASS;

/**
 * Options for new repository file wizard.
 *
 * @author Alessandro Falappa
 */
public final class RepoVisualPanel1 extends JPanel implements DocumentListener {

    private final RepoWizardPanel1 panel;

    @SuppressWarnings("LeakingThisInConstructor")
    public RepoVisualPanel1(RepoWizardPanel1 panel) {
        initComponents();
        this.panel = panel;
        // Register listener on the textFields to make the automatic updates
        txEntityClass.getDocument().addDocumentListener(this);
        txIdClass.getDocument().addDocumentListener(this);
    }

    void store(WizardDescriptor wd) {
        String entityClass = txEntityClass.getText().trim();
        String idClass = txIdClass.getText().trim();
        wd.putProperty(WIZ_BASE_INTERF, cbBaseInterface.getSelectedItem());
        wd.putProperty(WIZ_ENTITY_CLASS, entityClass);
        wd.putProperty(WIZ_ID_CLASS, idClass);
    }

    void read(WizardDescriptor wd) {
        cbBaseInterface.setSelectedItem(wd.getProperty(WIZ_BASE_INTERF));
        txEntityClass.setText((String) wd.getProperty(WIZ_ENTITY_CLASS));
        txIdClass.setText((String) wd.getProperty(WIZ_ID_CLASS));
    }

    /** This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lBaseInterface = new javax.swing.JLabel();
        lEntity = new javax.swing.JLabel();
        lId = new javax.swing.JLabel();
        cbBaseInterface = new javax.swing.JComboBox<>();
        txEntityClass = new javax.swing.JTextField();
        txIdClass = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(lBaseInterface, org.openide.util.NbBundle.getBundle(RepoVisualPanel1.class).getString("RepoVisualPanel1.lBaseInterface.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lEntity, org.openide.util.NbBundle.getBundle(RepoVisualPanel1.class).getString("RepoVisualPanel1.lEntity.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lId, org.openide.util.NbBundle.getBundle(RepoVisualPanel1.class).getString("RepoVisualPanel1.lId.text")); // NOI18N

        cbBaseInterface.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Repository", "CrudRepository", "PagingAndSortingRepository", "JpaRepository" }));
        cbBaseInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBaseInterfaceActionPerformed(evt);
            }
        });

        txEntityClass.setColumns(15);

        txIdClass.setColumns(15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lId)
                    .addComponent(lBaseInterface)
                    .addComponent(lEntity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbBaseInterface, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txEntityClass)
                    .addComponent(txIdClass))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBaseInterface)
                    .addComponent(cbBaseInterface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lEntity)
                    .addComponent(txEntityClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lId)
                    .addComponent(txIdClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbBaseInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBaseInterfaceActionPerformed
        // Notify that the panel changed
        panel.fireChangeEvent();
    }//GEN-LAST:event_cbBaseInterfaceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbBaseInterface;
    private javax.swing.JLabel lBaseInterface;
    private javax.swing.JLabel lEntity;
    private javax.swing.JLabel lId;
    private javax.swing.JTextField txEntityClass;
    private javax.swing.JTextField txIdClass;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateTexts();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateTexts();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateTexts();
    }

    // Handles changes in the base name and profile
    private void updateTexts() {
        // Notify that the panel changed
        panel.fireChangeEvent();
    }

    boolean valid(WizardDescriptor wizardDescriptor) {
        if (txEntityClass.getText().isEmpty()) {
            // entity class not specified
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, "Entity class cannot be empty!");
            return false;
        }
        if (txIdClass.getText().isEmpty()) {
            // id class not specified
            wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, "Id class cannot be empty!");
            return false;
        }
        wizardDescriptor.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, "");
        return true;
    }

}

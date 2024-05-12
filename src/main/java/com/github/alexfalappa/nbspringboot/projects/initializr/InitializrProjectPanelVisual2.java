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
package com.github.alexfalappa.nbspringboot.projects.initializr;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.openide.WizardDescriptor;
import org.openide.WizardValidationException;

import com.fasterxml.jackson.databind.JsonNode;

import static com.github.alexfalappa.nbspringboot.projects.initializr.InitializrProjectProps.WIZ_BOOT_VERSION;
import static com.github.alexfalappa.nbspringboot.projects.initializr.InitializrProjectProps.WIZ_DEPENDENCIES;
import static com.github.alexfalappa.nbspringboot.projects.initializr.InitializrProjectProps.WIZ_METADATA;

/**
 * Options panel for second step in Spring Boot Initializr project wizard.
 *
 * @author Alessandro Falappa
 */
public class InitializrProjectPanelVisual2 extends JPanel {

    private final DefaultComboBoxModel<NamedItem> dcbmBootVersion = new DefaultComboBoxModel<>();
    private boolean initialized = false;

    public InitializrProjectPanelVisual2() {
        initComponents();
        // setup key listener on search field linked to dependencies panel
        FilterFieldListener ffl = new FilterFieldListener(pBootDependencies);
        txFilter.addKeyListener(ffl);
        txFilter.getDocument().addDocumentListener(ffl);
        // fix white area showing when the scroller is wider than the dependencies panel on some LAFs
        // for some reasons setting the UIManager color directly doesn't work it must be copied in a new Color object
        final Color cr = UIManager.getColor("Panel.background");
        scroller.getViewport().setBackground(new Color(cr.getRGB()));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        pBootDependencies.requestFocus();
    }

    /**
     * Trigger explicit initialization from the given JSON metadata.
     * <p>
     * Use the {@link #read(org.openide.WizardDescriptor)} method if inside a wizard.
     *
     * @param meta JSON node for metadata
     */
    public void init(JsonNode meta) {
        pBootDependencies.init(meta);
        // the following will also trigger adaptation of dependencies to default boot version
        fillCombo(meta.path("bootVersion"));
        txFilter.requestFocusInWindow();
        initialized = true;
    }

    /**
     * Fixes the boot version of the dependencies.
     * <p>
     * Does nothing if the panel has not been initialized.
     *
     * @param bootVersion Spring Boot version string
     */
    public void fixBootVersion(String bootVersion) {
        Objects.requireNonNull(bootVersion);
        if (initialized) {
            // substitute combo with label
            javax.swing.GroupLayout layout = (javax.swing.GroupLayout) this.getLayout();
            final JLabel label = new JLabel(bootVersion);
            label.setFont(label.getFont().deriveFont(Font.BOLD));
            layout.replace(cbBootVersion, label);
            // adapt dependencies panel
            pBootDependencies.adaptToBootVersion(bootVersion);
        }
    }

    public List<String> getSelectedDeps() {
        return pBootDependencies.getSelectedDependencies();
    }

    /** This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
     * this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroller = new javax.swing.JScrollPane();
        pBootDependencies = new com.github.alexfalappa.nbspringboot.projects.initializr.BootDependenciesPanel();
        lBootVersion = new javax.swing.JLabel();
        cbBootVersion = new javax.swing.JComboBox<>();
        txFilter = new javax.swing.JTextField();
        lFilter = new javax.swing.JLabel();

        scroller.setMinimumSize(new java.awt.Dimension(200, 100));
        scroller.setViewportView(pBootDependencies);

        org.openide.awt.Mnemonics.setLocalizedText(lBootVersion, org.openide.util.NbBundle.getMessage(InitializrProjectPanelVisual2.class, "InitializrProjectPanelVisual2.lBootVersion.text")); // NOI18N

        cbBootVersion.setModel(dcbmBootVersion);
        cbBootVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBootVersionActionPerformed(evt);
            }
        });

        txFilter.setColumns(8);
        txFilter.setToolTipText(org.openide.util.NbBundle.getMessage(InitializrProjectPanelVisual2.class, "InitializrProjectPanelVisual2.txFilter.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lFilter, org.openide.util.NbBundle.getMessage(InitializrProjectPanelVisual2.class, "InitializrProjectPanelVisual2.lFilter.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lBootVersion)
                        .addGap(6, 6, 6)
                        .addComponent(cbBootVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txFilter)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBootVersion)
                    .addComponent(cbBootVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbBootVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBootVersionActionPerformed
        final NamedItem bootVersionItem = cbBootVersion.getItemAt(cbBootVersion.getSelectedIndex());
        pBootDependencies.adaptToBootVersion(bootVersionItem.getId());
    }//GEN-LAST:event_cbBootVersionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<NamedItem> cbBootVersion;
    private javax.swing.JLabel lBootVersion;
    private javax.swing.JLabel lFilter;
    private com.github.alexfalappa.nbspringboot.projects.initializr.BootDependenciesPanel pBootDependencies;
    private javax.swing.JScrollPane scroller;
    private javax.swing.JTextField txFilter;
    // End of variables declaration//GEN-END:variables

    boolean valid(WizardDescriptor wizardDescriptor) {
        return true;
    }

    void store(WizardDescriptor wd) {
        wd.putProperty(WIZ_BOOT_VERSION, cbBootVersion.getSelectedItem());
        wd.putProperty(WIZ_DEPENDENCIES, pBootDependencies.getSelectedDependenciesString());
    }

    void read(WizardDescriptor wd) {
        if (!initialized) {
            final JsonNode meta = (JsonNode) wd.getProperty(WIZ_METADATA);
            init(meta);
        } else {
            pBootDependencies.setSelectedDependenciesString((String) wd.getProperty(WIZ_DEPENDENCIES));
            cbBootVersion.setSelectedItem(wd.getProperty(WIZ_BOOT_VERSION));
        }
    }

    void validate(WizardDescriptor d) throws WizardValidationException {
        // nothing to validate
    }

    private void fillCombo(JsonNode attrNode) {
        JsonNode valArray = attrNode.path("values");
        dcbmBootVersion.removeAllElements();
        for (JsonNode val : valArray) {
            dcbmBootVersion.addElement(new NamedItem(val.get("id").asText(), val.get("name").asText()));
        }
        cbBootVersion.setSelectedItem(new NamedItem(attrNode.path("default").asText(), ""));
    }

    private void clearFilter() {
        txFilter.setText(null);
    }

    private class FilterFieldListener extends KeyAdapter implements DocumentListener {

        private final BootDependenciesPanel depsPane;

        public FilterFieldListener(BootDependenciesPanel depsPane) {
            this.depsPane = depsPane;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            doFilter();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            doFilter();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            doFilter();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                // if empty let the event bubble up to parent components
                if (!txFilter.getText().isEmpty()) {
                    clearFilter();
                    e.consume();
                }
            }
        }

        private void doFilter() {
            String text = txFilter.getText().toLowerCase();
            if (text.length() > 0) {
                depsPane.filter(text);
            } else {
                depsPane.clearFilter();
            }
        }

    }
}

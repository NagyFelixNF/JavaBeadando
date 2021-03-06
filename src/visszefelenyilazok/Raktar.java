package visszefelenyilazok;

import MartinSource.ApiConnector;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


/*
 * @author MARTIN
 */
public class Raktar extends javax.swing.JFrame {

    private static final ApiConnector connector = new ApiConnector();
    private static Object[][] data;
    private static final String column_names[]= {"Cikkszám", "Polc", "Doboz", 
        "Megnevezés", "Kategória", "Darabszám", "Elhelyezés dátuma", 
        "Módosítás dátuma", "Kezelő személyzet", "Utánrendelés szükséges"};
    
    private void SetRenderer(JTable table)
    {
        TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() 
        {
            SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            //yy MM.dd. HH:mm:ss.S
            @Override
            public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) 
            {
                if( value instanceof Date) {
                    value = f.format(value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected,
                    hasFocus, row, column);
            }
        };

        table.getColumnModel().getColumn(6).setCellRenderer(tableCellRenderer);
        table.getColumnModel().getColumn(7).setCellRenderer(tableCellRenderer);
    }
    
    private void SetUpTable()
    {
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        
        data = connector.getAllItems();
        dtm.setDataVector(data, column_names);
        
        SetRenderer(table);
        SetRenderer(raktarTabla);
        
        table.setModel(dtm);
        raktarTabla.setModel(dtm);
    }
    
    private void ClearDataFields()
    {
        ujButton.setEnabled(false);
        modositButton.setEnabled(false);
        torolButton.setEnabled(false);
        cikkszamField.setText("");
        polcField.setText("");
        dobozField.setText("");
        megnevezesField.setText("");
        kategoriaField.setText("");
        darabField.setText("");
        elhelyezesField.setText("");
        modositasField.setText("");
        kezeloField.setText("");
        utanrendelesCheckBox.setSelected(false);
    }
    
    private void checkSelectedRow()
    {
        int row;
        if((row = raktarTabla.getSelectedRow()) > -1)
        {
            //Új dobozok kezelését is meg kell oldani :)
            ujButton.setEnabled(false);
            modositButton.setEnabled(true);
            torolButton.setEnabled(true);
            
            cikkszamField.setText((String)data[row][0]);
            polcField.setText((String)data[row][1]);
            dobozField.setText((String)data[row][2]);
            megnevezesField.setText((String)data[row][3]);
            kategoriaField.setText((String)data[row][4]);
            darabField.setText(((Integer)data[row][5]).toString());
            
            SimpleDateFormat f = new SimpleDateFormat("yy MM.dd. HH:mm:ss");
            
            elhelyezesField.setText(f.format((Date)data[row][6]));
            modositasField.setText(f.format((Date)data[row][7]));
            
                
            kezeloField.setText((String)data[row][8]);
            
            utanrendelesCheckBox.setSelected((Boolean)data[row][9]);
            
            //(boolean)data[row][8]
            return;
        }
        
        ujButton.setEnabled(true);
        modositButton.setEnabled(false);
        torolButton.setEnabled(false);
    }
    
    //To-do: ApiConnector
    /**
     * Creates new form Raktar
     */
    public Raktar() {
        initComponents();
        
        SetRenderer(table);
        SetRenderer(raktarTabla);
        
        SetUpTable();
        
        //data = Api.getAllItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        keresesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        kereso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        raktarPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        raktarTabla = new javax.swing.JTable();
        cikkszamField = new javax.swing.JTextField();
        darabField = new javax.swing.JTextField();
        megnevezesField = new javax.swing.JTextField();
        kategoriaField = new javax.swing.JTextField();
        elhelyezesField = new javax.swing.JTextField();
        modositasField = new javax.swing.JTextField();
        kezeloField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ujButton = new javax.swing.JButton();
        modositButton = new javax.swing.JButton();
        torolButton = new javax.swing.JButton();
        dobozField = new javax.swing.JTextField();
        polcField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        utanrendelesCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nagy Félix és Hurda Martin - Raktár");
        setMaximumSize(new java.awt.Dimension(1072, 658));
        setName("foAblak"); // NOI18N
        setResizable(false);

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1072, 658));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1072, 658));

        keresesPanel.setMaximumSize(new java.awt.Dimension(1072, 625));
        keresesPanel.setMinimumSize(new java.awt.Dimension(1072, 625));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cikkszám", "Polc", "Doboz", "Megnevezés", "Kategória", "Darabszám", "Elhelyezés dátuma", "Módosítás dátuma", "Kezelő személyzet", "Utánrendelés szükséges"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setMaximumSize(new java.awt.Dimension(750, 100));
        table.setMinimumSize(new java.awt.Dimension(750, 100));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(8).setResizable(false);
            table.getColumnModel().getColumn(9).setResizable(false);
        }

        kereso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kereso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keresoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Keresés:");

        javax.swing.GroupLayout keresesPanelLayout = new javax.swing.GroupLayout(keresesPanel);
        keresesPanel.setLayout(keresesPanelLayout);
        keresesPanelLayout.setHorizontalGroup(
            keresesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keresesPanelLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kereso, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addGap(238, 238, 238))
            .addGroup(keresesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        keresesPanelLayout.setVerticalGroup(
            keresesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keresesPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(keresesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(kereso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Keresés", keresesPanel);

        raktarPanel.setMaximumSize(new java.awt.Dimension(1072, 625));
        raktarPanel.setMinimumSize(new java.awt.Dimension(1072, 625));

        jScrollPane2.setMaximumSize(null);

        raktarTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cikkszám", "Polc", "Doboz", "Megnevezés", "Kategória", "Darabszám", "Elhelyezés dátuma", "Utolsó módosítás dátuma", "Kezelő személyzet", "Utánrendelés szükséges"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        raktarTabla.setMaximumSize(new java.awt.Dimension(750, 100));
        raktarTabla.setMinimumSize(new java.awt.Dimension(750, 100));
        raktarTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        raktarTabla.getTableHeader().setReorderingAllowed(false);
        raktarTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                raktarTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(raktarTabla);
        raktarTabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (raktarTabla.getColumnModel().getColumnCount() > 0) {
            raktarTabla.getColumnModel().getColumn(0).setResizable(false);
            raktarTabla.getColumnModel().getColumn(1).setResizable(false);
            raktarTabla.getColumnModel().getColumn(2).setResizable(false);
            raktarTabla.getColumnModel().getColumn(3).setResizable(false);
            raktarTabla.getColumnModel().getColumn(4).setResizable(false);
            raktarTabla.getColumnModel().getColumn(5).setResizable(false);
            raktarTabla.getColumnModel().getColumn(6).setResizable(false);
            raktarTabla.getColumnModel().getColumn(7).setResizable(false);
            raktarTabla.getColumnModel().getColumn(8).setResizable(false);
            raktarTabla.getColumnModel().getColumn(9).setResizable(false);
        }

        cikkszamField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cikkszamField.setNextFocusableComponent(kategoriaField);
        cikkszamField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cikkszamFieldKeyReleased(evt);
            }
        });

        darabField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        darabField.setText("0");
        darabField.setNextFocusableComponent(kezeloField);

        megnevezesField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        megnevezesField.setNextFocusableComponent(polcField);

        kategoriaField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kategoriaField.setNextFocusableComponent(megnevezesField);

        elhelyezesField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        elhelyezesField.setText("1970.01.01.");
        elhelyezesField.setEnabled(false);
        elhelyezesField.setMaximumSize(new java.awt.Dimension(91, 23));
        elhelyezesField.setMinimumSize(new java.awt.Dimension(91, 23));

        modositasField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modositasField.setText("1970.01.01.");
        modositasField.setEnabled(false);
        modositasField.setMaximumSize(new java.awt.Dimension(91, 23));
        modositasField.setMinimumSize(new java.awt.Dimension(91, 23));

        kezeloField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kezeloField.setNextFocusableComponent(utanrendelesCheckBox);

        jLabel2.setText("Cikkszám:");

        jLabel3.setText("Darabszám:");

        jLabel4.setText("Megnevezés:");

        jLabel5.setText("Utolsó módosítás dátuma:");

        jLabel6.setText("Elhelyezés dátuma:");

        jLabel7.setText("Kategória:");

        jLabel8.setText("Kezelő személy:");

        ujButton.setText("Új");
        ujButton.setEnabled(false);
        ujButton.setNextFocusableComponent(modositButton);
        ujButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ujButtonMouseClicked(evt);
            }
        });

        modositButton.setText("Módosít");
        modositButton.setEnabled(false);
        modositButton.setNextFocusableComponent(torolButton);
        modositButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modositButtonMouseClicked(evt);
            }
        });

        torolButton.setText("Töröl");
        torolButton.setEnabled(false);
        torolButton.setNextFocusableComponent(cikkszamField);
        torolButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                torolButtonMouseClicked(evt);
            }
        });

        dobozField.setNextFocusableComponent(darabField);
        dobozField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cikkszamFieldKeyReleased(evt);
            }
        });

        polcField.setNextFocusableComponent(dobozField);
        polcField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cikkszamFieldKeyReleased(evt);
            }
        });

        jLabel10.setText("Polc:");

        jLabel11.setText("Doboz:");

        utanrendelesCheckBox.setText("Utánrendelés szükséges");
        utanrendelesCheckBox.setNextFocusableComponent(ujButton);

        javax.swing.GroupLayout raktarPanelLayout = new javax.swing.GroupLayout(raktarPanel);
        raktarPanel.setLayout(raktarPanelLayout);
        raktarPanelLayout.setHorizontalGroup(
            raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(raktarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(raktarPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(raktarPanelLayout.createSequentialGroup()
                                .addComponent(cikkszamField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10))
                            .addGroup(raktarPanelLayout.createSequentialGroup()
                                .addComponent(megnevezesField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(raktarPanelLayout.createSequentialGroup()
                                .addComponent(kategoriaField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(raktarPanelLayout.createSequentialGroup()
                                .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(polcField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dobozField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(raktarPanelLayout.createSequentialGroup()
                                .addComponent(darabField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 105, Short.MAX_VALUE))
                            .addComponent(elhelyezesField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modositasField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(raktarPanelLayout.createSequentialGroup()
                                    .addComponent(ujButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(modositButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(torolButton))
                                .addGroup(raktarPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(kezeloField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(utanrendelesCheckBox))
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        raktarPanelLayout.setVerticalGroup(
            raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(raktarPanelLayout.createSequentialGroup()
                .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(raktarPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kezeloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(utanrendelesCheckBox))
                    .addGroup(raktarPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(raktarPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7))
                    .addGroup(raktarPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6))
                    .addGroup(raktarPanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(elhelyezesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(547, 547, 547))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createSequentialGroup()
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(darabField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(cikkszamField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kategoriaField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dobozField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(modositasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ujButton)
                                .addComponent(modositButton)
                                .addComponent(torolButton)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createSequentialGroup()
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(megnevezesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(511, 511, 511))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, raktarPanelLayout.createSequentialGroup()
                        .addGroup(raktarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(polcField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(580, 580, 580))))
        );

        jTabbedPane1.addTab("Raktárkezelés", raktarPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ujButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ujButtonMouseClicked
        // TODO add your handling code here:
        //JOptionPane.showConfirmDialog(this," "," " ,JOptionPane.OK_CANCEL_OPTION);
        
        if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"Biztosan felviszed az új cikket?","Megerősítés" ,JOptionPane.OK_CANCEL_OPTION))
        {
            LocalDateTime now = LocalDateTime.now();
            if(connector.addOrUpdateDB(
                cikkszamField.getText(), 
                polcField.getText(), 
                dobozField.getText(), 
                megnevezesField.getText(),
                kategoriaField.getText(),
                Integer.valueOf(darabField.getText()),
                now,
                now,
                kezeloField.getText(),
                utanrendelesCheckBox.isSelected()
            ))
                ClearDataFields();
            SetUpTable();
        }
    }//GEN-LAST:event_ujButtonMouseClicked

    private void modositButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modositButtonMouseClicked
        // TODO add your handling code here:
        // data[getSelectedRow, 6]
        
        
        LocalDateTime originalCreation = 
                ((Date)data[raktarTabla.getSelectedRow()][6]).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,"Biztosan módosítod a  cikket?","Megerősítés" ,JOptionPane.OK_CANCEL_OPTION))
        {
            LocalDateTime now = LocalDateTime.now();
            if(connector.addOrUpdateDB(
                cikkszamField.getText(), 
                polcField.getText(), 
                dobozField.getText(), 
                megnevezesField.getText(),
                kategoriaField.getText(),
                Integer.valueOf(darabField.getText()),
                originalCreation,
                now,
                kezeloField.getText(),
                utanrendelesCheckBox.isSelected()
            ))
                ClearDataFields();
            SetUpTable();
        }
    }//GEN-LAST:event_modositButtonMouseClicked

    private void torolButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_torolButtonMouseClicked
        // TODO add your handling code here:
        
        if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,
                "Biztosan törlöd a  cikket?","Megerősítés" ,JOptionPane.OK_CANCEL_OPTION))
        {
            if(connector.removeFromDB(cikkszamField.getText()))
                ClearDataFields();
            SetUpTable();
        }
    }//GEN-LAST:event_torolButtonMouseClicked
    
    private void raktarTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raktarTablaMouseClicked
        // TODO add your handling code here:
        
        //If a row is selected, take its components and fill the textfields with their values
        checkSelectedRow();
    }//GEN-LAST:event_raktarTablaMouseClicked

    private void keresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keresoKeyReleased
        // TODO add your handling code here:
        //Csak akkor keres ha legalább 3 karaktert beírt
        if(kereso.getText().length() >= 3)
        {
            DefaultTableModel dtm = (DefaultTableModel)table.getModel();
            
            dtm.setDataVector(connector.getAllItems(kereso.getText()), column_names);
            
            SetRenderer(table);
            table.setModel(dtm);
        }
        if(kereso.getText().isBlank())
        {
            SetUpTable();
        }
    }//GEN-LAST:event_keresoKeyReleased

    private void cikkszamFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cikkszamFieldKeyReleased
        // TODO add your handling code here:
        
        //Ha olyan cikkszám kerül ide, ami már létezik, akkor kitöltjük a többi
        // mezőt (és a gombok elérhetővé válnak)
        //Ha még nincs ilyen cikkszám akkor az új gomb válik elérhetővé
        
        //Ha van ilyen cikkszám de másik dobozban, azt módosítani lehessen
        //count(cikk) > 1 -> módosítás
        
        for(int i = 0; i < raktarTabla.getRowCount(); ++i)
        {
            if(cikkszamField.getText().trim().equalsIgnoreCase((String)data[i][0]) &&
               polcField.getText().trim().equalsIgnoreCase((String)data[i][1]) &&
               dobozField.getText().trim().equalsIgnoreCase((String)data[i][2]))
            {
                raktarTabla.setRowSelectionInterval(i, i);
                
                checkSelectedRow();
                
                return;
            }
        }
        
        ujButton.setEnabled(!cikkszamField.getText().isBlank()&&
                !polcField.getText().isBlank()&&
                !dobozField.getText().isBlank()
        );
        modositButton.setEnabled(false);
        torolButton.setEnabled(false);
    }//GEN-LAST:event_cikkszamFieldKeyReleased

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
            java.util.logging.Logger.getLogger(Raktar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Raktar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Raktar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Raktar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Raktar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cikkszamField;
    private javax.swing.JTextField darabField;
    private javax.swing.JTextField dobozField;
    private javax.swing.JTextField elhelyezesField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField kategoriaField;
    private javax.swing.JPanel keresesPanel;
    private javax.swing.JTextField kereso;
    private javax.swing.JTextField kezeloField;
    private javax.swing.JTextField megnevezesField;
    private javax.swing.JButton modositButton;
    private javax.swing.JTextField modositasField;
    private javax.swing.JTextField polcField;
    private javax.swing.JPanel raktarPanel;
    private javax.swing.JTable raktarTabla;
    private javax.swing.JTable table;
    private javax.swing.JButton torolButton;
    private javax.swing.JButton ujButton;
    private javax.swing.JCheckBox utanrendelesCheckBox;
    // End of variables declaration//GEN-END:variables
}

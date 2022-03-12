//Carlos Alejandro Villa Mendoza 4°B Sistemas 11/03/2002
import javax.swing.*;
import java.awt.event.*;//paquete para controlar los eventos
import java.awt.*;

public class CalculadoraGrafica extends JFrame
{
  JLabel Letrero, lblNumA, lblNumB, lblRes;//Reserva el espacio en memoria
  JButton btnSumar, btnRestar, btnMultiplicar, btnDividir, btnSalir;
  JTextField txtNumA, txtNumB, txtRes;
  JPanel panel;
  private Object objTextField;
  
  public CalculadoraGrafica()
  {
   initComponents();
  }
  
  private void initComponents()
  {
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    txtNumA = new JTextField(10);//instanciaciÃ³n del objeto
    txtNumB = new JTextField(10);
    txtRes = new JTextField(10);
  
    
    Letrero = new JLabel("Calculadora gráfica");
    lblNumA = new JLabel("Primer número: ");
    lblNumB = new JLabel("Segundo número: ");
    lblRes = new JLabel("Resultado: ");
    
    btnSumar = new JButton("+");
    btnSumar.setBounds(-10000, 1000, 144, 20);
    btnSumar.setMnemonic('S');
    btnRestar = new JButton("-");
    btnRestar.setMnemonic('R');
    btnMultiplicar = new JButton("X");
    btnMultiplicar.setMnemonic('X');
    btnDividir = new JButton("/");
    btnDividir.setMnemonic('D');
    btnSalir = new JButton("Salir");
    btnSalir.setMnemonic('A');
    
    
    
    btnSalir.addMouseListener(new MyListener());
    
    panel = new JPanel();
    panel.add(Letrero);
    lblNumA.setBounds(12, 28, 116, 16);
    panel.add(lblNumA);
    txtNumA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    txtNumA.setBounds(132, 28, 144, 20);
    txtNumB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    
    txtRes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    

    panel.add(txtNumA);
    panel.add(lblNumB);
    panel.add(txtNumB);
    panel.add(lblRes);
    panel.add(txtRes);
        
    KeyAdapter kl = new KeyAdapter() //clase anonima
    {
      public void keyTyped(KeyEvent evt)
      {
         OperacionesKeyTyped(evt);
      }
    };
    txtNumA.addKeyListener(kl);
    
   KeyAdapter klF = new KeyAdapter() //clase anonima 2
    {
      public void keyTyped(KeyEvent evt)
      {
         
        OperacionesKeyTyped(evt);
      }
    };
    txtNumB.addKeyListener(klF);
    
    btnSumar.addActionListener(new ActionListener()
    {
      public   void actionPerformed(ActionEvent evt)
       {
         btnSumarActionPerformed(evt);
       }
    });
    btnRestar.addActionListener(new ActionListener()
    {
      public   void actionPerformed(ActionEvent evt)
       {
         btnRestarActionPerformed(evt);
         
       }
    });
    btnMultiplicar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
       {
         
         btnMultiplicarActionPerformed(evt);
         
       }
    });
    btnDividir.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
       {
         btnDividirActionPerformed(evt);
       }
    });
    
    btnSalir.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
       {
         btnSalirActionPerformed(evt);
       }
    });
 
    panel.add(btnSumar);
    panel.add(btnRestar);
    panel.add(btnMultiplicar);
    panel.add(btnDividir);
    panel.add(btnSalir);
    setTitle("Calculadora gráfica");
    setContentPane(panel);
    setVisible(true);
  }
  
  private void OperacionesKeyTyped(KeyEvent evt)
  {
    objTextField = evt.getSource();//objeto que produce el evento
   }
   
   private void btnSumarActionPerformed(ActionEvent evt)
   {
    try{
        double suma = 0.0;
        double numA = 0.0;
        double numB = 0.0;
   
         if(objTextField == txtNumA)
           {
             String c = txtNumA.getText();
             String d = txtNumB.getText();
             numA = Integer.parseInt(c.trim());
             numB = Integer.parseInt(d.trim());
             suma = numB +numA;//Suma de números
             String texto = String.format("%.2f", suma);
             txtNumA.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.
             txtNumB.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.          
           }
  
           if(objTextField == txtNumB)
           {
            String c = txtNumA.getText();
            String d = txtNumB.getText();
            numA = Integer.parseInt(c.trim());
            numB = Integer.parseInt(d.trim());
            suma = numA + numB;
            String texto = String.format("%.2f", suma);
            System.out.println(texto);
            txtNumA.setText(c);
            txtNumB.setText(d);
            txtRes.setText(String.valueOf(suma));
           }
          }
      catch(NumberFormatException e)
      {
        JOptionPane.showMessageDialog(null, "El valor de los numeros no es correcto", 
        "Error", JOptionPane.ERROR_MESSAGE);
        txtNumA.setText(" "); 
        //txtGCent.setText(null);
        txtNumA.requestFocus();
        txtNumB.setText(null);
      }
     }
     
     private void btnRestarActionPerformed(ActionEvent evt)
   {
    try{
        double resta = 0.0;
        double numA = 0.0;
        double numB = 0.0;
   
         if(objTextField == txtNumA)
           {
             String c = txtNumA.getText();
             String d = txtNumB.getText();
             numA = Integer.parseInt(c.trim());
             numB = Integer.parseInt(c.trim());
             resta = numB - numA;//Resta de números
             String texto = String.format("%.2f", resta);
             txtNumA.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.
             txtNumB.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.          
           }
  
           if(objTextField == txtNumB)
           {
            String c = txtNumA.getText();
            String d = txtNumB.getText();
            numA = Integer.parseInt(c.trim());
            numB = Integer.parseInt(d.trim());
            resta = numA - numB;
            String texto = String.format("%.2f", resta);
            System.out.println(texto);
            txtNumA.setText(c);
            txtNumB.setText(d);
            txtRes.setText(String.valueOf(resta));
           }
          }
      catch(NumberFormatException e)
      {
        JOptionPane.showMessageDialog(null, "El valor de los numeros no es correcto", 
        "Error", JOptionPane.ERROR_MESSAGE);
        txtNumA.setText(" "); 
        //txtGCent.setText(null);
        txtNumA.requestFocus();
        txtNumB.setText(null);
      }
     }
     
     private void btnMultiplicarActionPerformed(ActionEvent evt)
   {
    try{
        double multiplicacion = 0.0;
        double numA = 0.0;
        double numB = 0.0;
   
         if(objTextField == txtNumA)
           {
             String c = txtNumA.getText();
             String d = txtNumB.getText();
             numA = Integer.parseInt(c.trim());
             numB = Integer.parseInt(c.trim());
             multiplicacion = numB  * numA;//multiplicación de números
             String texto = String.format("%.2f", multiplicacion);
             txtNumA.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.
             txtNumB.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.          
           }
  
           if(objTextField == txtNumB)
           {
            String c = txtNumA.getText();
            String d = txtNumB.getText();
            numA = Integer.parseInt(c.trim());
            numB = Integer.parseInt(d.trim());
            multiplicacion = numA * numB;
            String texto = String.format("%.2f", multiplicacion);
            System.out.println(texto);
            txtNumA.setText(c);
            txtNumB.setText(d);
            txtRes.setText(String.valueOf(multiplicacion));
           }
          }
      catch(NumberFormatException e)
      {
        JOptionPane.showMessageDialog(null, "El valor de los numeros no es correcto", 
        "Error", JOptionPane.ERROR_MESSAGE);
        txtNumA.setText(" "); 
        //txtGCent.setText(null);
        txtNumA.requestFocus();
        txtNumB.setText(null);
      }
     }
     
     private void btnDividirActionPerformed(ActionEvent evt)
   {
    try{
        double division = 0.0;
        double numA = 0.0;
        double numB = 0.0;
   
         if(objTextField == txtNumA)
           {
             String c = txtNumA.getText();
             String d = txtNumB.getText();
             numA = Integer.parseInt(c.trim());
             numB = Integer.parseInt(c.trim());
             division = numB / numA;//Suma de números
             String texto = String.format("%.2f", division);
             txtNumA.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.
             txtNumB.setText(texto); //Los JTextField solamente pueden recibir y mostrar cadenas.          
           }
  
           if(objTextField == txtNumB)
           {
            String c = txtNumA.getText();
            String d = txtNumB.getText();
            numA = Integer.parseInt(c.trim());
            numB = Integer.parseInt(d.trim());
            division = numA / numB;
            String texto = String.format("%.2f", division);
            System.out.println(texto);
            txtNumA.setText(c);
            txtNumB.setText(d);
            txtRes.setText(String.valueOf(division));
           }
          }
      catch(NumberFormatException e)
      {
        JOptionPane.showMessageDialog(null, "El valor de los numeros no es correcto", 
        "Error", JOptionPane.ERROR_MESSAGE);
        txtNumA.setText(" "); 
        //txtGCent.setText(null);
        txtNumA.requestFocus();
        txtNumB.setText(null);
      }
     }
     
      private void btnSalirActionPerformed(ActionEvent evt)
   { 
   System.exit(0);
   
   }
  
  
  private class MyListener extends MouseAdapter
  {
   public void mouseClicked(MouseEvent event)
   {
      System.exit(0);
   }
  }
}

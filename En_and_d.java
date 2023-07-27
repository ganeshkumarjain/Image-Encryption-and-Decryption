import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class En_and_d{
    public static void operate(int key){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);//place in centre
        File file=fileChooser.getSelectedFile();
        //file input steam(read contents)
        try{
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);//data read and converted into numbers(byte)
            int i=0;
            for (byte b:data){
                System.out.println(b);
                //encryption
                data[i]=(byte)(b^key);//XOR used because when you xor the ans obtained by b^key with key it decrypts
                i++;
            }
            FileOutputStream fos= new FileOutputStream(file);// passing the same file to write in it
            fos.write(data);// changed data will be written and old will be erased
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Done");

        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args){
        JFrame f=new JFrame("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);//gui will be in centre
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("Roboto",Font.BOLD,25);
        //creating button
        JButton button=new JButton();
        button.setText("Open Image");
        button.setFont(font);

        //creating textfield
        JTextField textField=new JTextField(10);
        textField.setFont(font);
        button.addActionListener(e ->{    //e-> = lambda function (replaced by anonymous class
            System.out.println("button clicked");
            String text= textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });//ADD ACTION A BUTTON


        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);  // display gui


    }

}

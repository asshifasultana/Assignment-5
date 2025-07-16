package JavaUI;

import javax.swing.*;
import java.io.*;

public class Assignment05 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form:");
        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon image= new ImageIcon("/C:/Users/asmon/Downloads/362985386_241660188694275_7881118460759794502_n.jpg/");
        frame.setIconImage(image.getImage());

        //name
        JLabel namelabel = new JLabel("Name:");
        namelabel.setBounds(30, 100, 100, 25);
        JTextField namefield = new JTextField();
        namefield.setBounds(150, 100, 300, 25);
        frame.add(namelabel);
        frame.add(namefield);

        //roll
        JLabel rolllabel = new JLabel("Roll number:");
        rolllabel.setBounds(30, 130, 100, 25);
        JTextField rollfield = new JTextField();
        rollfield.setBounds(150, 130, 300, 25);
        frame.add(rolllabel);
        frame.add(rollfield);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 160, 100, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 160, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(230, 160, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);

        //phone number
        JLabel numberlabel = new JLabel("Phone Number:");
        numberlabel.setBounds(30, 190, 100, 25);
        JTextField numberfield = new JTextField();
        numberfield.setBounds(150, 190, 300, 25);
        frame.add(numberlabel);
        frame.add(numberfield);

        //email
        JLabel emaillabel = new JLabel("Email:");
        emaillabel.setBounds(30, 220, 100, 25);
        JTextField emailfield = new JTextField();
        emailfield.setBounds(150, 220, 300, 25);
        frame.add(emaillabel);
        frame.add(emailfield);

        //address
        JLabel addresslabel = new JLabel("Address:");
        addresslabel.setBounds(30, 250, 100, 25);
        JTextField addressfield = new JTextField();
        addressfield.setBounds(150, 250, 300, 25);
        frame.add(addresslabel);
        frame.add(addressfield);

        // DOB
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 280, 100, 25);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2025 - i);

        JComboBox<String> dayBox = new JComboBox<>(days);
        JComboBox<String> monthBox = new JComboBox<>(months);
        JComboBox<String> yearBox = new JComboBox<>(years);
        dayBox.setBounds(150, 280, 70, 25);
        monthBox.setBounds(250, 280, 70, 25);
        yearBox.setBounds(350, 280, 100, 25);
        frame.add(dobLabel);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        //degree
        JLabel degreeLabel = new JLabel("Degree:");
        degreeLabel.setBounds(30, 310, 100, 25);
        String[] degrees = {"BSSE","MSSE","Master of Philosophy in IT","Doctors of Philosophy in IT"};
        JComboBox<String> degreesBox = new JComboBox<>(degrees);
        degreesBox.setBounds(150, 310, 170, 25);
        frame.add(degreeLabel);
        frame.add(degreesBox);

        //prefered position
        JLabel positionLabel = new JLabel("Position:");
        positionLabel.setBounds(30, 340, 100, 25);
        String[] positions = {"Goalkeeper","Centre Back","Left Back","Right Back","Central Defence Mid","Central Attack Mid","Left Wing","Right Wing","Centre Mid","Centre Forward","Striker"};
        JComboBox<String> positionBox = new JComboBox<>(positions);
        positionBox.setBounds(150, 340, 170, 25);
        frame.add(positionLabel);
        frame.add(positionBox);

        //previous experience
        JLabel experienceLabel = new JLabel("Prior Experience?");
        experienceLabel.setBounds(30, 370, 120, 25);
        JRadioButton yes = new JRadioButton("YES");
        yes.setBounds(150, 370, 70, 25);
        JRadioButton no = new JRadioButton("NO");
        no.setBounds(230, 370, 80, 25);
        ButtonGroup experienceGroup = new ButtonGroup();
        experienceGroup.add(yes);
        experienceGroup.add(no);
        frame.add(experienceLabel);
        frame.add(yes);
        frame.add(no);

        //profile picture
        JLabel profileLabel = new JLabel("Profile Picture:");
        profileLabel.setBounds(30, 400, 100, 25);
        JButton profileButton = new JButton("Choose File");
        profileButton.setBounds(150, 400, 150, 25);
        JLabel fileLabel = new JLabel();
        fileLabel.setBounds(300, 400, 100, 25);
        frame.add(profileButton);
        frame.add(profileLabel);
        frame.add(fileLabel);

        final String[] selectedFilePath = {""};
        profileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                selectedFilePath[0] = file.getAbsolutePath();
                fileLabel.setText(file.getName());
            }
        });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(200, 450, 120, 30);
        frame.add(registerButton);

        registerButton.addActionListener(event -> {
            String name = namefield.getText();
            String roll = rollfield.getText();
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Not selected";
            String number = numberfield.getText();
            String email = emailfield.getText();
            String address = addressfield.getText();
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = (String)degreesBox.getSelectedItem();
            String position = (String)positionBox.getSelectedItem();
            String experience = yes.isSelected() ? "Yes" : no.isSelected() ? "No" : "Not selected";
            String photo = selectedFilePath[0].isEmpty() ? "Not selected" : selectedFilePath[0];

            if(name.isEmpty() || roll.isEmpty() || gender.equals("Not Selected") || number.isEmpty() || email.isEmpty() || address.isEmpty() || dob.isEmpty() || degree.isEmpty() || position.isEmpty() || experience.equals("Not selected") || photo.equals("Not selected")) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    FileWriter file = new FileWriter("D:/OOP/src/JavaUI/IIT_FOOTBALL_REGISTRATION.txt",true);
                    file.append("Name: " +name +"\n");
                    file.append("Roll: " +roll + "\n");
                    file.append("Gender: " + gender + "\n");
                    file.append("Mobile Number: " +number + "\n");
                    file.append("Email:" + email + "\n");
                    file.append("Address:" + address + "\n");
                    file.append("DOB:" + dob + "\n");
                    file.append("Degree:" + degree + "\n");
                    file.append("Preferred Position:" + position + "\n");
                    file.append("Prior Experience:" + experience + "\n");
                    file.append("Profile Picture: " + photo + "\n");
                    file.append("---------------------------------------------------- \n");
                    file.close();

                    JOptionPane.showMessageDialog(frame, "You have successfully registered!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    namefield.setText("");
                    rollfield.setText("");
                    genderGroup.clearSelection();
                    numberfield.setText("");
                    emailfield.setText("");
                    addressfield.setText("");
                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    degreesBox.setSelectedIndex(0);
                    positionBox.setSelectedIndex(0);
                    experienceGroup.clearSelection();

                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error writing to file!", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
        frame.setVisible(true);
    }
}

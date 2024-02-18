import javax.swing.*;



public class Main {
    public static void main(String[] args) {


        ScientificCal ScientificCal = new ScientificCal();


        ScientificCal.setTitle("Scientific Calculator");
        ScientificCal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ScientificCal.setLocation(200,50);
        ScientificCal.setSize(500, 400);
        ScientificCal.setVisible(true);
        ScientificCal.setLocationRelativeTo(null);

    }
}


package Trimestre1.Task;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task extends JFrame {
  public Task() {
    JLabel lblGreeting = new JLabel("Hello World. Creating my first example");
    add(lblGreeting);
    this.setSize(400, 200);
    this.setTitle("JFrame");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    Task main = new Task();
  }
}
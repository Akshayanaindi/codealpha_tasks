import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCount extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCount() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Creating components
        textArea = new JTextArea();
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");
        
        // Adding ActionListener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                resultLabel.setText("Word Count: " + wordCount);
            }
        });
        
        // Layout setup
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);
    }

    // Method to count words
    private int countWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WordCount().setVisible(true);
        });
    }
}
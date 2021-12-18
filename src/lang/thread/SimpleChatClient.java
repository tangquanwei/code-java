package lang.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class SimpleChatClient {
    JTextArea incoming;
    JTextField outcoming;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }

    public void go() {
        JFrame frame = new JFrame("Chat by Quanwei");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();

        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outcoming = new JTextField(20);
        JButton sendButton = new JButton("SEND");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(qScroller);
        mainPanel.add(outcoming);
        mainPanel.add(sendButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(650, 500);
        frame.setVisible(true);

        SetUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

    }

    /**
     * SetUpNetworking
     */
    private void SetUpNetworking() {
        try {
            sock = new Socket("192.168.1.141", 5000); // ip , tcp
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("network established !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * SendButtonListener
     */
    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                writer.println(outcoming.getText());
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            outcoming.setText("");
            outcoming.requestFocus();
        }
    }

    /**
     * thread work: IncomingReader
     */
    public class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("user send: " + message);
                    incoming.append(message + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

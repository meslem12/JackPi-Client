package jackpi.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import javax.swing.JTable;

/**
 *
 * @author lmessing
 */
public class JackPiClient
{

  /*
  * --Protokoll--
  * Connection opened
  * Client schickt: "R1-R2" (100-100)
  * Server antwortet "Ergebnis" (50)
  * Connection closed
  *
   */
  public static double getData(double r1, double r2) throws IOException, InterruptedException
  {
    String url = "localhost";
    int port = 9999;

    //System.out.println("Starting Client");
    byte[] rv;
    try (Socket socket = new Socket(url, port))
    {
      System.out.println("Connected");
      InputStream input = socket.getInputStream();
      OutputStream output = socket.getOutputStream();
      byte[] b = String.format("%.2f-%.2f", r1, r2).getBytes();
      output.write(b);
      output.flush();
      System.out.println("  Data sent: " + new String(b));
      Thread.sleep(100);
      rv = new byte[50];
      input.read(rv);
      System.out.println("  Data read: " + new String(rv));
      socket.close();
      System.out.println("Disconnected");
      
    }

    return Double.parseDouble(new String(rv).replace(',', '.'));

  }

}

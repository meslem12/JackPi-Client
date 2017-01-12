package jackpi.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * @author Messing Levin <meslem12@htl-kaindorf.ac.at>
 */
public class JackPiClient
{

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args)
  {
    String url = "jackpi.ddns.net";
    int port = 9999;

    try
    {
      System.out.println("Starting Client");
      Socket socket = new Socket(url,port);
      
      System.out.println("Connected");
      InputStream input = socket.getInputStream();

      
      byte[] b = new byte[9];
      input.read(b, 0, 9);
      String str = new String(b, "UTF-8");
      
      System.out.println(str);
      System.out.println("Disconnected");

    }
    catch (Exception ex)
    {
      System.out.println(ex);
    }
  }

}

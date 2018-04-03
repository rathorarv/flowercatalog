import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CommentReader extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
    File file = new File("data.json");
    FileReader fileReader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    StringBuffer stringBuffer = new StringBuffer();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      stringBuffer.append(line);
      stringBuffer.append("\n");
    }
    fileReader.close();
    res.getWriter().write(stringBuffer.toString());
  }
}

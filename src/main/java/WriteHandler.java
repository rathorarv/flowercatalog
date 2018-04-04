import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteHandler extends HttpServlet {
  public static JSONArray objects = new JSONArray();
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String name = req.getParameter("name");
    String comment = req.getParameter("comment");
    JSONObject userComment = new JSONObject();
    userComment.put("name",name);
    userComment.put("comment",comment);
    objects.put(userComment);
    PrintWriter printWriter = new PrintWriter("data.json", "utf-8");
    printWriter.print(objects.toString(2));
    printWriter.close();
    res.getWriter().write(userComment.toString());
  }
}
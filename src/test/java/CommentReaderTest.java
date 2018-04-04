import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommentReaderTest {
    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Mock
    PrintWriter printWriter;

    @Before
    public void setUp() {
      MockitoAnnotations.initMocks(this);
    }
  @Test
  public void doGet() throws IOException {
    when(response.getWriter()).thenReturn(printWriter);
    CommentReader commentReader = new CommentReader();
    commentReader.doGet(request,response);
    verify(printWriter).write(anyString());
  }
}
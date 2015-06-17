package griffithswaite.email;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

import javax.naming.*;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.logging.Logger;
import java.util.logging.Level;

public class EmailServlet extends HttpServlet {

	private Logger _logger;

	public EmailServlet() {
	
	}

	public void init() throws ServletException {
        _logger = Logger.getLogger(this.getClass().getName());
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().write("<html><body>Hello!</body></html>");
    	
    	try {
    		Context initial = new InitialContext();
			Session session = (Session) initial.lookup("java:/comp/env/mail/Session");

			Message message = new MimeMessage(session);
		   			
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("z@hotmail.co.uk"));
	
	   		message.setSubject("Testing Subject");
	
	    	message.setText("Hello, this is sample for to check send email using JavaMailAPI ");

	   		Transport.send(message);

    	} catch (Exception e) {
    		_logger.log(Level.SEVERE ,"Error occured",e);
    	}
    }
}
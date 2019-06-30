package prometheus_java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;

public class JettyBasedServer {

	  static class TestServlet extends HttpServlet {
		    static final Counter requests = Counter.build()
		        .name("test_prometheus_count1")
		        .help("Number of greetings displayed").register();
		    
		    @Override
		    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
		        throws ServletException, IOException {
		      resp.getWriter().println("Greetings from Jetty!");
		      requests.inc();
		    }
	  }	
	
	
	public static void main(String[] args) throws Exception {

		   Server server = new Server(8082);
		      ServletContextHandler context = new ServletContextHandler();
		      context.setContextPath("/");
		      server.setHandler(context);
		      context.addServlet(new ServletHolder(new TestServlet()), "/");
		      context.addServlet(new ServletHolder(new MetricsServlet()), "/metrics");
		      DefaultExports.initialize();

		      server.start();
		      server.join();		
		
	}

}

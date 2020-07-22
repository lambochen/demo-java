package cn.lambochen.demo.rpc.transport.http;

import cn.lambochen.demo.rpc.transport.RequestHandler;
import cn.lambochen.demo.rpc.transport.TransportServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:48
 * @Description 基于 HTTP 实现服务端
 **/
public class HttpTransportServer implements TransportServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpTransportServer.class);

    private RequestHandler handler;

    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.handler = handler;
        this.server = new Server(port);

        // servlet 接收请求
        ServletContextHandler context = new ServletContextHandler();
        server.setHandler(context);

        ServletHolder holder = new ServletHolder(new RequestServlet());
        context.addServlet(holder, "/*");
    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    class RequestServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            LOGGER.info("client connect...");
            InputStream inputStream = req.getInputStream();
            OutputStream outputStream = resp.getOutputStream();

            if (handler != null) {
                handler.onRequest(inputStream, outputStream);
            }

            outputStream.flush();
        }
    }
}

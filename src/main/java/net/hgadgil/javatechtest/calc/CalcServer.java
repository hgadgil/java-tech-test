package net.hgadgil.javatechtest.calc;

import net.hgadgil.javatechtest.generated.calc.CalcService;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class CalcServer {

	private static int PORT = 7911;

	public static void main(String[] args) {
		CalcServer srv = new CalcServer();
		srv.start();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	void start() {
		try {
			TServerSocket serverTransport = new TServerSocket(PORT);

			CalcService.Processor processor = new CalcService.Processor(
					new CalcServiceImpl());

			TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(
					serverTransport).processor(processor));
			System.out.println("Starting server on port: " + PORT);
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}

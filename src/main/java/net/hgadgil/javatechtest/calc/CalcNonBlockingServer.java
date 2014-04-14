package net.hgadgil.javatechtest.calc;

import net.hgadgil.javatechtest.generated.calc.CalcService;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException;

public class CalcNonBlockingServer {

	private static int PORT = 7911;

	public static void main(String[] args) {
		new CalcNonBlockingServer().start();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void start() {
		try {
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(
					PORT);

			CalcService.Processor processor = new CalcService.Processor(
					new CalcServiceImpl());

			TServer server = new TNonblockingServer(
					new TNonblockingServer.Args(serverTransport)
							.processor(processor));
			System.out.println("Starting server on port: " + PORT);
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}

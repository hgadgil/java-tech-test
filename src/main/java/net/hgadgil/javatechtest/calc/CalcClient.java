package net.hgadgil.javatechtest.calc;

import net.hgadgil.javatechtest.generated.calc.CalcService;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class CalcClient {

	private static int PORT = 7911;

	public static void main(String[] args) {
		new CalcClient().invoke();
	}

	private void invoke() {
		try {
			TTransport transport = new TSocket("127.0.0.1", PORT);
			TProtocol protocol = new TBinaryProtocol(transport);

			CalcService.Client client = new CalcService.Client(protocol);

			transport.open();
			
			System.out.println("Add Result (3 + 4) = " + client.add(3, 4));
			System.out.println("Multiply Result (3 * 4) = "
					+ client.multiply(3, 4));
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}

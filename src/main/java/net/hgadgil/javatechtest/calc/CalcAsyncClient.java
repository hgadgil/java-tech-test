package net.hgadgil.javatechtest.calc;

import java.io.IOException;

import net.hgadgil.javatechtest.generated.calc.CalcService;
import net.hgadgil.javatechtest.generated.calc.CalcService.AsyncClient.add_call;
import net.hgadgil.javatechtest.generated.calc.CalcService.AsyncClient.multiply_call;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TTransportException;

public class CalcAsyncClient {
	private static int PORT = 7911;

	public static void main(String[] args) {
		new CalcAsyncClient().invoke();
	}

	private void invoke() {
		try {
			CalcService.AsyncClient addClient = new CalcService.AsyncClient(
					new TBinaryProtocol.Factory(), new TAsyncClientManager(),
					new TNonblockingSocket("localhost", PORT));

			addClient.add(7, 10, new AddCallback());

			CalcService.AsyncClient multClient = new CalcService.AsyncClient(
					new TBinaryProtocol.Factory(), new TAsyncClientManager(),
					new TNonblockingSocket("localhost", PORT));

			multClient.add(7, 10, new MultCallback());

		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	class AddCallback implements
			AsyncMethodCallback<CalcService.AsyncClient.add_call> {

		@Override
		public void onComplete(add_call arg0) {
			try {
				System.out.println("ADD (7, 10) = " + arg0.getResult());
			} catch (TException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onError(Exception arg0) {
			System.err.println("Failed to add");
			arg0.printStackTrace();
		}

	}

	class MultCallback implements
			AsyncMethodCallback<CalcService.AsyncClient.multiply_call> {

		@Override
		public void onComplete(multiply_call arg0) {
			try {
				System.out.println("MULTIPLY (7, 10) = " + arg0.getResult());
			} catch (TException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onError(Exception arg0) {
			System.err.println("Failed to multiply");
			arg0.printStackTrace();
		}

	}
}

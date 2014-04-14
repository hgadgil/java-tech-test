package net.hgadgil.javatechtest.calc;

import net.hgadgil.javatechtest.generated.calc.CalcService;

import org.apache.thrift.TException;

public class CalcServiceImpl implements CalcService.Iface {
	@Override
	public long multiply(int n1, int n2) throws TException {
		System.out.println("Multiplying: " + n1 +" and " + n2);
		return n1 * n2;
	}

	@Override
	public long add(int n1, int n2) throws TException {
		System.out.println("Adding: " + n1 +" and " + n2);
		return n1 + n2;
	}
}

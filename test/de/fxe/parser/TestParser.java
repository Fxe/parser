package de.fxe.parser;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestParser {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void testSimple() {
		System.out.println("Input:");
		String testCase1 = "K1 K2 K3 K4";
		System.out.println( testCase1);
		InputStream is = new ByteArrayInputStream(testCase1.getBytes());

		Regras parser = new Regras(is);
		try {
			List<List<String>> ret = parser.parseDefinition();
			System.out.println("Output:");
			System.out.println(ret);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		assertEquals(true, true);
	}
	
	@Test
	public void testComplex() {
		System.out.println("Input:");
		String testCase1 = "K1+K2+K3+K4+(K6,K7)+K8+K9";
		System.out.println( testCase1);
		InputStream is = new ByteArrayInputStream(testCase1.getBytes());

		Regras parser = new Regras(is);
		try {
			List<List<String>> ret = parser.parseDefinition();
			System.out.println("Output:");
			System.out.println(ret);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		assertEquals(true, true);
	}
	
	@Test
	public void testGeneralScenario1() {
		System.out.println("Input:");
		String testCase1 = "(K1,K2) ((K001 K002),K9999-K9998) (((K11,K12)+(K21,K22)),K0)";
		System.out.println( testCase1);
		InputStream is = new ByteArrayInputStream(testCase1.getBytes());

		Regras parser = new Regras(is);
		try {
			List<List<String>> ret = parser.parseDefinition();
			System.out.println("Output:");
			System.out.println(ret);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		assertEquals(true, true);
	}

	@Test
	public void testGeneralScenario2() {
		System.out.println("Input:");
		String testCase1 = "(K1,K2) ((K001 K002),K9999+K9998)+K0001 (((K11,K12)+(K21,K22)),K0)+(K1234, K4321)";
		System.out.println( testCase1);
		InputStream is = new ByteArrayInputStream(testCase1.getBytes());

		Regras parser = new Regras(is);
		try {
			List<List<String>> ret = parser.parseDefinition();
			System.out.println("Output:");
			System.out.println(ret);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		assertEquals(true, true);
	}
	
	@Test
	public void testKEGGDefinition() {
		String[] defs = {"(K02777,K02817)+K02818+K02819", // M00270
				         "K01655 K01681 K01705 K05824 (K00825,K00838) (K00143,K14085) K00293 K00290", // M00030
				         "(K01655,K02594,K10977) ((K01681 K01705),K16792+K16793) (K05824,K10978)", // M00433
				         "(K00169+K00170+K00171+K00172,K03737) ((K01007,K01006)+K01595,K01959+K01960,K01958) K00024 (K01676,K01679,K01677+K01678) (K00239+K00240-K00241-K00242,K00244+K00245+K00246+K00247) (K01902+K01903) (K00174+K00175-K00177-K00176) K00031 (K01681,K01682) (K15230+K15231,K15232+K15233+K15234)", //M00173
				         "(K00169+K00170+K00171+K00172,K03737) K01007 K01595 K00024 (K01676,K01679,K01677+K01678) (K00239+K00240-K00241-K00242,K00244+K00245+K00246+K00247) (K01902+K01903) K15038 K14465 (K14466,K14467) K14534 (K15016,K01715+(K01782,K01825,K07516)) K00626" //M00374
		};
		
		for (String testCase1 : defs) {
			
			System.out.println("Input:");
			//String testCase1 = "(K1,K2) ((K001 K002),K9999+K9998)+K0001 (((K11,K12)+(K21,K22)),K0)+(K1234, K4321)";
			System.out.println( testCase1);
			InputStream is = new ByteArrayInputStream(testCase1.getBytes());
			
			Regras parser = new Regras(is);
			try {
				List<List<String>> ret = parser.parseDefinition();
				System.out.println("Output:");
				System.out.println(ret);
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}
		}
		assertEquals(true, true);
		
		

		//String definition = "(K01655,K02594,K10977) ((K01681 K01705),K16792+K16793)+K67+(K565+K676) (K05824,K10978)";
		//((K01007,K01006)+K01595,K01959+K01960,K01958) ((K01007,(K01007,(K01007,(K01007,((K5657 (K767, K898)+K7878, (K01007 K01006)+K01595),K01006)+K01595)+K01595)+K01595)+K01595)+K01595,K01959+K01960,K01958)

		//String definition = 
		//String definition = "(K02777,K02817)+(K02777,K02817)+(K02777,K02817)+(K02777,K02817)+K45454+K454545+(K3434+K3434)";
		//String definition = "(K02777,K02817)+K45454+K454545+(K6,K8)";
		//String definition = "(K02777,K02817)+K02818+K02819 (K4, K7)+K9 (K11,K99)+(K88, K999)";
	}


}

package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalAddress {

		public static void main(String[] args) {

		  InetAddress ip;
		  try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

		  } catch (UnknownHostException e) {

			e.printStackTrace();

		  }

		}

	}


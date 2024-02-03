package training;
//Java program to demonstrate
//Encoding simple String into Basic Base 64 format

import java.util.*;
public class encoDeco {
	public static void main(String[] args)
	{

		// create a sample String to encode
		String sample = "I am Indian";

		// print actual String
		System.out.println("Sample String:\n"
						+ sample);

		// Encode into Base64 format
		String BasicBase64format
			= Base64.getEncoder()
				.encodeToString(sample.getBytes());

		// print encoded String
		System.out.println("\nEncoded String:\n"
						+ BasicBase64format);
		
		// Decoding Basic Base 64 format to String

				// decode into String from encoded format
				byte[] actualByte = Base64.getDecoder()
										.decode(BasicBase64format);

				String actualString = new String(actualByte);

				// print actual String
				System.out.println("\nDecoded String:\n"
								+ actualString);
			}

	}


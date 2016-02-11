package com.louisamoros.cdb.launcher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;

/**
 * Abstraction representing a text input/output device.
 * 
 * @author McDowell
 */
public abstract class TextDevice {
	public abstract TextDevice printf(String fmt, Object... params) throws ConsoleException;

	public abstract String readLine() throws ConsoleException;

	public abstract char[] readPassword() throws ConsoleException;

	public abstract Reader reader() throws ConsoleException;

	public abstract PrintWriter writer() throws ConsoleException;

	private static TextDevice DEFAULT = (System.console() == null) ? streamDevice(System.in, System.out)
			: new ConsoleDevice(System.console());

	public static TextDevice defaultTextDevice() {
		return DEFAULT;
	}

	public static TextDevice streamDevice(InputStream in, OutputStream out) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out, true);
		return new CharacterDevice(reader, writer);
	}
}
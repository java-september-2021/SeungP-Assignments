package com.foof.dojooverflow;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		String a = "asdf, asdf, asdf";
		ArrayList<String> tags = new ArrayList<String>();
		for (int i=0;i<3;i++) {
			tags.add(a.substring(0, a.indexOf(", ")));
			a = a.substring(a.indexOf(", ") + 2);
			if(a.indexOf(", ") == -1) {
				tags.add(a);
				break;
			}
		}
	}
}

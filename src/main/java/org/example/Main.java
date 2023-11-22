
package org.example;

public class Main {

	public static void main(String[] args) {

		Post[] array = Page.get(1);

		for (Post post : array) {
			System.out.println(post.toString());
		}

	}

}

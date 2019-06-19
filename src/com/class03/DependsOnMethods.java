package com.class03;

import org.testng.annotations.Test;

public class DependsOnMethods {
@Test
public void one() {
	System.out.println("one");
	}
@Test (dependsOnMethods="one")
public void Two() {
	System.out.println("two");
}
@Test(dependsOnMethods="two")
public void Three() {
	System.out.println("Three");
}

}

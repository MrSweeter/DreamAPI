package com.mrsweeter.dreamAPI.MessagesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SiderbarDisplayerTest {
	
	@Test
	public void testSetLineText() {
		SimplifiedSiderbarDisplayer sb = new SimplifiedSiderbarDisplayer("test siderbar");
		
		assertEquals(null, sb.getTextLine(1));
		sb.setLineText("abc", 1);
		assertEquals("abc", sb.getTextLine(1));
	}
	
	@Test
	public void testSetMultipleText()	{
		SimplifiedSiderbarDisplayer sb = new SimplifiedSiderbarDisplayer("test siderbar");
		
		sb.setLineText("abc", 1);
		sb.setLineText("def", 2);
		assertEquals("abc", sb.getTextLine(1));
		assertEquals("def", sb.getTextLine(2));
		sb.setLineText("xyz", 1);
		assertEquals("xyz", sb.getTextLine(1));
	}
	
	@Test
	public void testSetTextAnywhere()	{
		SimplifiedSiderbarDisplayer sb = new SimplifiedSiderbarDisplayer("test siderbar");
		
		sb.setLineText("abc", 3);
		assertEquals(" ", sb.getTextLine(1));
		assertEquals("", sb.getTextLine(2));
		assertEquals("abc", sb.getTextLine(3));
	}
	
	@Test
	public void testOverWriteValue()	{
		SimplifiedSiderbarDisplayer sb = new SimplifiedSiderbarDisplayer("test siderbar");
		
		sb.setLineText("abc", 1);
		sb.setLineText("def", 1);
		assertEquals("def", sb.getTextLine(1));
	}
	
	@Test
	public void testInvalidValue()	{
		SimplifiedSiderbarDisplayer sb = new SimplifiedSiderbarDisplayer("test siderbar");
		try {
			sb.setLineText("abc", 0);
			fail();
		} catch (IllegalArgumentException ex)	{
			assertTrue(ex != null);
		}
	}
	
	@Test
	public void testRemoveLine()	{
		SimplifiedSiderbarDisplayer sb = new SimplifiedSiderbarDisplayer("test siderbar");
	
		sb.setLineText("abc", 1);
		sb.setLineText("def", 2);
		sb.setLineText("ghi", 3);
		sb.removeLine(3);
		assertEquals(null, sb.getTextLine(3));
	}
	
	// Change line not, setTextLine if already test for list
}

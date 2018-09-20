package com.game.helpers;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.game.model.Sprite;

public class DragEventListenerTest {

	private Sprite dragSprite;
	private DragEventListener dragEventListener;

	@Before
	public void setUp(){
		dragSprite = new Sprite();
		dragEventListener = mock(DragEventListener.class);
		when(dragEventListener.getDragSprite()).thenReturn(dragSprite);
	}

	@Test
	public void testAction(){
		assertEquals(dragEventListener.getDragSprite(),dragSprite);
	}
}

package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	@Mock
	private ShipwreckRepository sr;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShipwreckGet()
	{
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(sr.findOne(1L)).thenReturn(sw);
		//ShipwreckController sw = new ShipwreckController();
		Shipwreck wreck = sc.get(1L);
		
		verify(sr).findOne(1L);
		
		//assertEquals(1L,wreck.getId().longValue());
		assertThat(wreck.getId(),is(1L));
		
	}
}

/**
 * Copyright (C) 2013 Premium Minds.
 *
 * This file is part of billy platypus (PT Pack).
 *
 * billy platypus (PT Pack) is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * billy platypus (PT Pack) is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy platypus (PT Pack). If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.portugal.test.services.builders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.premiumminds.billy.core.persistence.entities.ContextEntity;
import com.premiumminds.billy.core.services.UID;
import com.premiumminds.billy.portugal.persistence.dao.DAOPTRegionContext;
import com.premiumminds.billy.portugal.services.entities.PTRegionContext;
import com.premiumminds.billy.portugal.test.PTAbstractTest;
import com.premiumminds.billy.portugal.test.fixtures.MockPTRegionContextEntity;

public class TestPTRegionContextBuilder extends PTAbstractTest {

	private static final String PTCONTEXT_YML = "src/test/resources/PTContext.yml";

	@Test
	public void testRegionCode() {
		MockPTRegionContextEntity mockRegionContextEntity = createMockEntity(
				MockPTRegionContextEntity.class, PTCONTEXT_YML);

		Mockito.when(getInstance(DAOPTRegionContext.class).getEntityInstance())
				.thenReturn(new MockPTRegionContextEntity());

		Mockito.when(
				getInstance(DAOPTRegionContext.class).get(
						Matchers.any(UID.class))).thenReturn(
				(ContextEntity) mockRegionContextEntity.getParentContext());

		PTRegionContext.Builder builder = getInstance(PTRegionContext.Builder.class);

		builder.setDescription(mockRegionContextEntity.getDescription())
				.setName(mockRegionContextEntity.getName())
				.setRegionCode(mockRegionContextEntity.getRegionCode())
				.setParentContextUID(
						mockRegionContextEntity.getParentContext().getUID());

		PTRegionContext regionContex = builder.build();

		assertTrue(regionContex != null);
		assertTrue(regionContex.getParentContext() != null);

		assertEquals(regionContex.getRegionCode(),
				mockRegionContextEntity.getRegionCode());
		assertEquals(regionContex.getDescription(),
				mockRegionContextEntity.getDescription());
		assertEquals(regionContex.getName(), mockRegionContextEntity.getName());

		assertEquals(regionContex.getParentContext().getUID(),
				mockRegionContextEntity.getParentContext().getUID());
	}
}
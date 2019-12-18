/*
 * Copyright (C) 2017 Premium Minds.
 *
 * This file is part of billy spain (ES Pack).
 *
 * billy spain (ES Pack) is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * billy spain (ES Pack) is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy spain (ES Pack). If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.spain.persistence.entities.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.premiumminds.billy.core.persistence.entities.jpa.JPAContextEntity;
import com.premiumminds.billy.spain.Config;
import com.premiumminds.billy.spain.persistence.entities.ESRegionContextEntity;
import com.premiumminds.billy.spain.services.entities.ESRegionContext;

@Entity
@Audited
@Table(name = Config.TABLE_PREFIX + "REGION_CONTEXT")
public class JPAESRegionContextEntity extends JPAContextEntity implements ESRegionContextEntity {

    private static final long serialVersionUID = 1L;

    public JPAESRegionContextEntity() {
    }

    @Override
    public ESRegionContext getParentContext() {
        return (ESRegionContext) super.getParentContext();
    }

}
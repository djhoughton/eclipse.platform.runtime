/*******************************************************************************
 * Copyright (c) 2004, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.core.internal.runtime;

import org.eclipse.core.runtime.IProduct;
import org.eclipse.equinox.internal.app.IBranding;
import org.osgi.framework.Bundle;

public class Product implements IProduct {
	IBranding branding;
	public Product(IBranding branding) {
		this.branding = branding;
	}

	@Override
	public String getApplication() {
		return branding.getApplication();
	}

	@Override
	public Bundle getDefiningBundle() {
		return branding.getDefiningBundle();
	}

	@Override
	public String getDescription() {
		return branding.getDescription();
	}

	@Override
	public String getId() {
		return branding.getId();
	}

	@Override
	public String getName() {
		return branding.getName();
	}

	@Override
	public String getProperty(String key) {
		return branding.getProperty(key);
	}
}

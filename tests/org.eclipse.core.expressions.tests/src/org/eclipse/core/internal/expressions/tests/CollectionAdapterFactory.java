/*******************************************************************************
 * Copyright (c) 2007, 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.core.internal.expressions.tests;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.expressions.ICountable;
import org.eclipse.core.expressions.IIterable;

import org.eclipse.core.runtime.IAdapterFactory;


public class CollectionAdapterFactory implements IAdapterFactory {

	@Override
	public <T> T getAdapter(final Object adaptableObject, Class<T> adapterType) {
		if (adapterType.equals(IIterable.class) && adaptableObject instanceof ExpressionTests.CollectionWrapper) {
			return adapterType.cast(new IIterable<String>() {
				@Override
				public Iterator<String> iterator() {
					return ((ExpressionTests.CollectionWrapper)adaptableObject).collection.iterator();
				}
			});
		}
		if (adapterType.equals(ICountable.class) && adaptableObject instanceof ExpressionTests.CollectionWrapper) {
			return adapterType.cast(new ICountable() {
				@Override
				public int count() {
					return ((ExpressionTests.CollectionWrapper)adaptableObject).collection.size();
				}
			});
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] {Collection.class};
	}

}

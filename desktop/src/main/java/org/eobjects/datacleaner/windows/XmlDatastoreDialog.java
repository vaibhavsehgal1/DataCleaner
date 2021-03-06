/**
 * DataCleaner (community edition)
 * Copyright (C) 2013 Human Inference
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.eobjects.datacleaner.windows;

import javax.inject.Inject;

import org.eobjects.analyzer.connection.XmlDatastore;
import org.eobjects.datacleaner.bootstrap.WindowContext;
import org.eobjects.datacleaner.guice.Nullable;
import org.eobjects.datacleaner.user.MutableDatastoreCatalog;
import org.eobjects.datacleaner.user.UserPreferences;
import org.eobjects.datacleaner.util.FileFilters;
import org.eobjects.datacleaner.util.IconUtils;
import org.eobjects.datacleaner.widgets.FilenameTextField;

public final class XmlDatastoreDialog extends AbstractFileBasedDatastoreDialog<XmlDatastore> {

	private static final long serialVersionUID = 1L;

	@Inject
	protected XmlDatastoreDialog(@Nullable XmlDatastore originalDatastore, MutableDatastoreCatalog mutableDatastoreCatalog,
			WindowContext windowContext, UserPreferences userPreferences) {
		super(originalDatastore, mutableDatastoreCatalog, windowContext, userPreferences);
	}

	@Override
	protected void setFileFilters(FilenameTextField filenameField) {
		filenameField.addChoosableFileFilter(FileFilters.XML);
		filenameField.addChoosableFileFilter(FileFilters.ALL);
		filenameField.setSelectedFileFilter(FileFilters.XML);
	}

	@Override
	protected String getBannerTitle() {
		return "XML file";
	}

	@Override
	public String getWindowTitle() {
		return "XML file | Datastore";
	}

	@Override
	protected XmlDatastore createDatastore(String name, String filename) {
		return new XmlDatastore(name, filename);
	}

	@Override
	protected String getDatastoreIconPath() {
		return IconUtils.XML_IMAGEPATH;
	}

}

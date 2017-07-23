/*
 * *************************************************************************
 *  SortableFragment.java
 * **************************************************************************
 *  Copyright © 2017 VLC authors and VideoLAN
 *  Author: Geoffrey Métais
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston MA 02110-1301, USA.
 *  ***************************************************************************
 */

package org.videolan.vlc.gui.browser;


import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import org.videolan.vlc.R;
import org.videolan.vlc.util.MediaLibraryItemComparator;
import org.videolan.vlc.util.Util;

public abstract class SortableFragment extends MediaBrowserFragment {

    public abstract void sortBy(int sortby);
    public abstract int sortDirection(int sortby);

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        Util.updateSortTitles(this, menu);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        menu.findItem(R.id.ml_menu_sortby).setVisible(true);
        return super.onPrepareActionMode(mode, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ml_menu_sortby_name:
                sortBy(MediaLibraryItemComparator.SORT_BY_TITLE);
                onPrepareOptionsMenu(mMenu);
                return true;
            case R.id.ml_menu_sortby_length:
                sortBy(MediaLibraryItemComparator.SORT_BY_LENGTH);
                onPrepareOptionsMenu(mMenu);
                return true;
            case R.id.ml_menu_sortby_date:
                sortBy(MediaLibraryItemComparator.SORT_BY_DATE);
                onPrepareOptionsMenu(mMenu);
                return true;
            case R.id.ml_menu_sortby_number:
                sortBy(MediaLibraryItemComparator.SORT_BY_NUMBER);
                onPrepareOptionsMenu(mMenu);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

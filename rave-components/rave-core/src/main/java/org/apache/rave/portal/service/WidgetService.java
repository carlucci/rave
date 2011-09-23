/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.rave.portal.service;

import org.apache.rave.portal.model.Widget;
import org.apache.rave.portal.model.util.SearchResult;

/**
 * Provides widget operations
 */
public interface WidgetService {

    /**
     * Gets a {@link SearchResult} for {@link Widget}'s that a user can add to their context
     * <p/>
     * May return a very large resultset
     *
     * @return SearchResult
     */
    SearchResult<Widget> getAllWidgets();


    /**
     * Gets a limited {@link SearchResult} for {@link Widget}'s that a user can add to their
     * context.
     *
     * @param offset   start point within the resultset (for paging)
     * @param pageSize maximum number of items to be returned (for paging)
     * @return SearchResult
     */
    SearchResult<Widget> getLimitedListOfWidgets(int offset, int pageSize);

    /**
     * Gets a SearchResult for {@link Widget}'s by performing a free text search
     *
     * @param searchTerm free text search term
     * @param offset     start point within the resultset (for paging)
     * @param pageSize   maximum number of items to be returned (for paging)
     * @return SearchResult
     */
    SearchResult<Widget> getWidgetsByFreeTextSearch(String searchTerm, int offset, int pageSize);

    /**
     * Gets the detailed metadata for a widget
     *
     * @param id the Id of the widget
     * @return a valid widget if one exists for the given id; null otherwise
     */
    Widget getWidget(long id);

    /**
     * Gets a {@link SearchResult} for {@link Widget}'s that are published
     *
     * @param offset   start point within the resultset (for paging)
     * @param pageSize maximum number of items to be returned (for paging)
     * @return SearchResult
     */
    SearchResult<Widget> getPublishedWidgets(int offset, int pageSize);

    /**
     * Gets a SearchResult for published {@link Widget}'s by performing a free text search
     *
     * @param searchTerm free text search term
     * @param offset     start point within the resultset (for paging)
     * @param pageSize   maximum number of items to be returned (for paging)
     * @return SearchResult
     */
    SearchResult<Widget> getPublishedWidgetsByFreeTextSearch(String searchTerm,
                                                             int offset, int pageSize);

    /**
     * Gets a Widget by its (unique) url
     *
     * @param widgetUrl url of the Widget
     * @return {@link Widget} if it exists, otherwise {@literal null}
     */
    Widget getWidgetByUrl(String widgetUrl);


    /**
     * Persists a new {@link Widget} if it is not already present in the store
     *
     * @param widget new Widget to store
     * @return Widget if it is new and can be stored, otherwise {@literal null}
     */
    Widget registerNewWidget(Widget widget);
}
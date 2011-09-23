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
package org.apache.rave.portal.repository;

import java.util.List;

import org.apache.rave.persistence.Repository;
import org.apache.rave.portal.model.Widget;
import org.apache.rave.portal.model.WidgetStatus;

public interface WidgetRepository extends Repository<Widget> {
    /**
     * Gets a list of <strong>all</strong> widgets in the repository
     *
     * @return a valid List
     */
    List<Widget> getAll();

    /**
     * List of Widgets with the same condition as in {@link #getAll()}
     * but with a limited amount of Widgets.
     *
     * @param offset   start point within the total resultset
     * @param pageSize maximum number of items to be returned (for paging)
     * @return a List of widgets with of at most the number of items in pageSize
     */
    List<Widget> getLimitedList(int offset, int pageSize);

    /**
     * @return the total number of {@link Widget}'s in the repository. Useful for paging.
     */
    int getCountAll();

    /**
     * Gets a List of {@link Widget}'s by performing a free text search
     *
     * @param searchTerm free text search term
     * @param offset     start point within the resultset (for paging)
     * @param pageSize   maximum number of items to be returned (for paging)
     * @return valid list of widgets, can be empty
     */
    List<Widget> getByFreeTextSearch(String searchTerm, int offset, int pageSize);

    /**
     * Counts the total number of {@link Widget}'s that match the search term. Useful for paging.
     *
     * @param searchTerm free text search term
     * @return total number of {@link Widget}'s that match the search term
     */
    int getCountFreeTextSearch(String searchTerm);

    /**
     * Gets a List of {@link Widget}'s in the repository by {@link WidgetStatus}
     *
     * @param widgetStatus status of the widget (PREVIEW, PUBLISHED etc)
     * @param offset       start point within the total resultset
     * @param pageSize     maximum number of items to be returned (for paging)
     * @return valid list of widgets, can be empty
     */
    List<Widget> getByStatus(WidgetStatus widgetStatus, int offset, int pageSize);

    /**
     * Counts the total number of {@link Widget}'s filtering on status. Useful for paging.
     *
     * @param widgetStatus status of the widget (PREVIEW, PUBLISHED etc)
     * @return total number of {@link Widget}'s that match the search term
     */
    int getCountByStatus(WidgetStatus widgetStatus);

    /**
     * Gets a List of {@link Widget}'s by performing a free text search filtering on status
     *
     * @param widgetStatus status of the widget (PREVIEW, PUBLISHED etc)
     * @param searchTerm   free text search term
     * @param offset       start point within the resultset (for paging)
     * @param pageSize     maximum number of items to be returned (for paging)
     * @return valid list of widgets, can be empty
     */
    List<Widget> getByStatusAndFreeTextSearch(WidgetStatus widgetStatus, String searchTerm,
                                              int offset, int pageSize);


    /**
     * Counts the total number of {@link Widget}'s by performing a free text search filtering
     * on status. Useful for paging.
     *
     * @param widgetStatus status of the widget (PREVIEW, PUBLISHED etc)
     * @param searchTerm   free text search term
     * @return total number of {@link Widget}'s that match the search criteria
     */
    int getCountByStatusAndFreeText(WidgetStatus widgetStatus, String searchTerm);

    /**
     * Searches for a Widget by its url
     *
     * @param widgetUrl (unique) url of the Widget
     * @return {@link Widget} if it can be found, otherwise {@literal null}
     */
    Widget getByUrl(String widgetUrl);
}
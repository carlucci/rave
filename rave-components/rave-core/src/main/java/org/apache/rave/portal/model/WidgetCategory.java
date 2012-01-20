/*
 * Copyright 2011 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rave.portal.model;

import org.apache.rave.persistence.BasicEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * A category for a widget.
 */
@Entity
@Table(name = "widget_category")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = WidgetCategory.GET_ALL, query = "select wc from WidgetCategory wc order by wc.text")
})
public class WidgetCategory implements BasicEntity, Serializable {
    // constants for JPA query names
    public static final String GET_ALL = "WidgetCategory.getAll";

    @Id
    @Column(name = "entity_id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "widgetCategoryIdGenerator")
    @TableGenerator(name = "widgetCategoryIdGenerator", table = "RAVE_PORTAL_SEQUENCES", pkColumnName = "SEQ_NAME",
                    valueColumnName = "SEQ_COUNT", pkColumnValue = "widget_category",
                    allocationSize = 1, initialValue = 1)
    private Long entityId;

    @Basic
    @Column(name = "text", unique = true)
    private String text;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="created_user_id")
    private User createdUser;

    @Basic
    @Column(name ="created_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate;


    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="last_modified_user_id")
    private User lastModifiedUser;

    @Basic
    @Column(name ="last_modified_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public WidgetCategory() {

    }

    public WidgetCategory(Long entityId, String text, User createdUser, Date createdDate, User lastModifiedUser, Date lastModifiedDate) {
        this.entityId = entityId;
        this.text = text;
        this.createdUser = createdUser;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public Long getEntityId() {
        return entityId;
    }

    @Override
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(User lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WidgetCategory other = (WidgetCategory) obj;
        if (this.entityId != other.entityId && (this.entityId == null || !this.entityId.equals(other.entityId))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.entityId != null ? this.entityId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "WidgetCategory{" +
                "entityId=" + entityId +
                ", text='" + text + '\'' +
                '}';
    }
}

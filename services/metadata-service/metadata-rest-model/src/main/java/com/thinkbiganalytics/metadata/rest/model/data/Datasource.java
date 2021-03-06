/**
 *
 */
package com.thinkbiganalytics.metadata.rest.model.data;

/*-
 * #%L
 * thinkbig-metadata-rest-model
 * %%
 * Copyright (C) 2017 ThinkBig Analytics
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import com.thinkbiganalytics.metadata.rest.model.feed.Feed;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@SuppressWarnings("serial")
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY)
@JsonSubTypes({
                  @JsonSubTypes.Type(value = DirectoryDatasource.class),
                  @JsonSubTypes.Type(value = HiveTableDatasource.class),
                  @JsonSubTypes.Type(value = DerivedDatasource.class)
              }
)
public class Datasource implements Serializable {

    @JsonSerialize(using = DateTimeSerializer.class)
    private DateTime creationTime;

    private String id;
    private String name;
    private String description;
    private String owner;
    private boolean encrypted;
    private boolean compressed;
    private Set<Feed> sourceForFeeds = new HashSet<>();
    private Set<Feed> destinationForFeeds = new HashSet<>();


    public Datasource() {
        super();
    }

    public Datasource(String name) {
        super();
        this.name = name;
    }

    public Datasource(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Set<Feed> getSourceForFeeds() {
        if (sourceForFeeds == null) {
            sourceForFeeds = new HashSet<>();
        }
        return sourceForFeeds;
    }

    public Set<Feed> getDestinationForFeeds() {
        if (destinationForFeeds == null) {
            destinationForFeeds = new HashSet<>();
        }
        return destinationForFeeds;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public boolean isCompressed() {
        return compressed;
    }

    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }

}

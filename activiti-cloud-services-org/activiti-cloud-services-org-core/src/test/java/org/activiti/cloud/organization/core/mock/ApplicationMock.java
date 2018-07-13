/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.organization.core.mock;

import java.util.List;

import org.activiti.cloud.organization.repository.entity.Application;

/**
 * Application mock
 */
public class ApplicationMock extends AuditableMock implements Application<String> {

    private String id;

    private String name;

    private List<ModelMock> models;

    public ApplicationMock() {

    }

    public ApplicationMock(String id,
                             String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public List<ModelMock> getModels() {
        return models;
    }

    public void setModels(List<ModelMock> models) {
        this.models = models;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

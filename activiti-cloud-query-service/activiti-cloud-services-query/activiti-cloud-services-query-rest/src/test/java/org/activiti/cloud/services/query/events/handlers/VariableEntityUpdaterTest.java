/*
 * Copyright 2017-2020 Alfresco Software, Ltd.
 *
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
 */
package org.activiti.cloud.services.query.events.handlers;

import java.util.Date;

import com.querydsl.core.types.Predicate;
import org.activiti.cloud.services.query.model.ProcessVariableEntity;
import org.activiti.cloud.services.query.app.repository.EntityFinder;
import org.activiti.cloud.services.query.app.repository.VariableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.activiti.test.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class VariableEntityUpdaterTest {

    @InjectMocks
    private ProcessVariableUpdater updater;

    @Mock
    private EntityFinder entityFinder;

    @Mock
    private VariableRepository variableRepository;


    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void updateShouldUpdateVariableRetrievedByPredicate() {
        //given
        ProcessVariableEntity currentVariableEntity = new ProcessVariableEntity();

        Predicate predicate = mock(Predicate.class);
        given(entityFinder.findOne(variableRepository, predicate, "error")).willReturn(currentVariableEntity);

        Date now = new Date();
        ProcessVariableEntity updatedVariableEntity = new ProcessVariableEntity();
        updatedVariableEntity.setType("string");
        updatedVariableEntity.setValue("content");
        updatedVariableEntity.setLastUpdatedTime(now);

        //when
        updater.update(updatedVariableEntity,
                       predicate, "error");

        //then
        assertThat(currentVariableEntity)
                .hasType("string")
                .hasValue("content")
                .hasLastUpdatedTime(now);
        verify(variableRepository).save(currentVariableEntity);
    }

}

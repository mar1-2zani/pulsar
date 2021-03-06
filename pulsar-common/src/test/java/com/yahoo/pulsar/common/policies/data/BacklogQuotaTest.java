/**
 * Copyright 2016 Yahoo Inc.
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
package com.yahoo.pulsar.common.policies.data;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yahoo.pulsar.common.policies.data.BacklogQuota.RetentionPolicy;

public class BacklogQuotaTest {
    @Test
    public void testBacklogQuotaIdentity() {
        Assert.assertNotEquals(new BacklogQuota(1, RetentionPolicy.producer_exception),
                new BacklogQuota(2, RetentionPolicy.producer_exception));
        Assert.assertNotEquals(new BacklogQuota(1, RetentionPolicy.producer_exception),
                new BacklogQuota(2, RetentionPolicy.consumer_backlog_eviction));
        Assert.assertNotEquals(new BacklogQuota(2, RetentionPolicy.producer_exception),
                new BacklogQuota(2, RetentionPolicy.consumer_backlog_eviction));
        Assert.assertEquals(new BacklogQuota(10, RetentionPolicy.producer_exception),
                new BacklogQuota(10, RetentionPolicy.producer_exception));
        BacklogQuota quota1 = new BacklogQuota(10, RetentionPolicy.producer_exception);
        BacklogQuota quota2 = new BacklogQuota(10, RetentionPolicy.producer_exception);
        Assert.assertEquals(quota1.hashCode(), quota2.hashCode());
    }
}

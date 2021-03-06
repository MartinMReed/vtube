/**
 * Copyright (c) 2009-2012 Martin M Reed, Metova Inc
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.metova.vtube.widgets.popup;

import com.metova.vtube.model.feed.FeedEntry;
import com.metova.vtube.service.video.Videos;

public class SendVideoPopupScreen extends AbstractSendPopupScreen {

    private FeedEntry feedEntry;

    public SendVideoPopupScreen(FeedEntry feedEntry) {

        setFeedEntry( feedEntry );
    }

    protected String getEmailText() {

        return "Email Video";
    }

    protected void selectedEmail() {

        FeedEntry feedEntry = getFeedEntry();
        Videos.emailVideo( feedEntry );
    }

    protected String getSmsText() {

        return "SMS Video";
    }

    protected void selectedSms() {

        FeedEntry feedEntry = getFeedEntry();
        Videos.smsVideo( feedEntry );
    }

    protected FeedEntry getFeedEntry() {

        return feedEntry;
    }

    private void setFeedEntry( FeedEntry feedEntry ) {

        this.feedEntry = feedEntry;
    }
}

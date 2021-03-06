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
package com.metova.vtube.widgets.page;

import java.io.IOException;

import m.org.apache.log4j.Logger;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Graphics;

import org.metova.bb.widgets.tooltip.TooltipField;
import org.metova.mobile.rt.graphics.MobileImages;
import org.metova.mobile.util.coordinate.Edges;

import com.metova.vtube.widgets.sidebar.SidebarButtonField;

public class PageButtonField extends SidebarButtonField implements TooltipField {

    private static final Logger log = Logger.getLogger( PageButtonField.class );

    private Bitmap arrow;
    private Bitmap arrowHighlight;

    private Object tooltip;

    public PageButtonField(Runnable runnable) {

        super( null, runnable );
    }

    public int getPreferredWidth() {

        Edges padding = getPadding();
        Edges margin = getMargin();
        Bitmap rightArrow = getArrow();
        return ( 2 * rightArrow.getWidth() ) + margin.getWidth() + padding.getWidth();
    }

    public int getPreferredHeight() {

        Edges padding = getPadding();
        Edges margin = getMargin();
        Bitmap arrow = getArrow();
        return arrow.getHeight() + margin.getHeight() + padding.getHeight();
    }

    protected void paint( Graphics graphics, int width, int height ) {

        boolean drawFocus = graphics.isDrawingStyleSet( Graphics.DRAWSTYLE_FOCUS );

        Bitmap arrow = drawFocus ? getArrowHighlight() : getArrow();
        int arrowWidth = arrow.getWidth();
        int arrowHeight = arrow.getHeight();

        graphics.drawBitmap( 0, 0, arrowWidth, arrowHeight, arrow, 0, 0 );
        graphics.drawBitmap( arrowWidth, 0, arrowWidth, arrowHeight, arrow, 0, 0 );
    }

    private Bitmap getArrow() {

        if ( arrow == null ) {

            String imagePath = getStyleManager().getImagePath( "arrow" );

            try {

                setArrow( (Bitmap) MobileImages.instance().getBitmapWithCache( imagePath, getClass() ) );
            }
            catch (IOException ex) {

                log.error( "Unable to load bitmap: " + imagePath );
            }
        }

        return arrow;
    }

    private void setArrow( Bitmap arrow ) {

        this.arrow = arrow;
    }

    private Bitmap getArrowHighlight() {

        if ( arrowHighlight == null ) {

            String imagePath = getStyleManager().getImagePath( "arrow-highlight" );

            try {

                setArrowHighlight( (Bitmap) MobileImages.instance().getBitmapWithCache( imagePath, getClass() ) );
            }
            catch (IOException ex) {

                log.error( "Unable to load bitmap: " + imagePath );
            }
        }

        return arrowHighlight;
    }

    private void setArrowHighlight( Bitmap arrowHighlight ) {

        this.arrowHighlight = arrowHighlight;
    }

    public Object getTooltip() {

        return tooltip;
    }

    public void setTooltip( Object tooltip ) {

        this.tooltip = tooltip;
    }
}

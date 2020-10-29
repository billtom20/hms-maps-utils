/*
 * Copyright 2020 Google Inc.
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
package com.google.maps.android.data.kml;

import org.trd.maps.data.kml.KmlContainer;
import org.trd.maps.data.kml.KmlParser;
import org.trd.maps.data.kml.KmlPlacemark;
import org.trd.maps.data.kml.KmlStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.xmlpull.v1.XmlPullParser;

import android.graphics.Color;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class KmlParserTest {

    @Test
    public void testInlineStyle() throws Exception {
        XmlPullParser parser = KmlTestUtil.createParser("amu_inline_style.kml");
        KmlParser mParser = new KmlParser(parser);
        mParser.parseKml();
        Assert.assertNotNull(mParser.getPlacemarks());
        assertEquals(mParser.getPlacemarks().size(), 1);
        for (KmlPlacemark placemark : mParser.getPlacemarks().keySet()) {
            KmlStyle inlineStyle = placemark.getInlineStyle();
            Assert.assertNotNull(inlineStyle);
            assertEquals(inlineStyle.getPolylineOptions().getColor(), Color.parseColor("#000000"));
            assertEquals(
                    inlineStyle.getPolygonOptions().getFillColor(), Color.parseColor("#ffffff"));
            assertEquals(
                    inlineStyle.getPolylineOptions().getColor(),
                    inlineStyle.getPolygonOptions().getStrokeColor());
            assertEquals(placemark.getGeometry().getGeometryType(), "MultiGeometry");
        }
    }

    @Test
    public void testEmptyHotSpotStyle() throws Exception {
        XmlPullParser parser = KmlTestUtil.createParser("amu_empty_hotspot.kml");
        KmlParser mParser = new KmlParser(parser);
        mParser.parseKml();
        Assert.assertNotNull(mParser.getPlacemarks());
        assertEquals(1, mParser.getPlacemarks().size());
    }

    @Test
    public void testPolyStyleBooleanNumeric() throws Exception {
        XmlPullParser parser =
                KmlTestUtil.createParser("amu_poly_style_boolean_numeric.kml");
        KmlParser mParser = new KmlParser(parser);
        mParser.parseKml();
        Assert.assertNotNull(mParser.getPlacemarks());
        assertEquals(1, mParser.getContainers().size());
        KmlContainer kmlContainer = mParser.getContainers().get(0);
        Assert.assertTrue(kmlContainer.hasPlacemarks());

        HashMap<String, KmlStyle> styles = kmlContainer.getStyles();
        KmlStyle kmlStyle = styles.get("#fireadvisory");
        Assert.assertNotNull(kmlStyle);
        Assert.assertTrue(kmlStyle.hasFill());
        Assert.assertFalse(kmlStyle.hasOutline());
    }

    @Test
    public void testPolyStyleBooleanAlpha() throws Exception {
        XmlPullParser parser =
                KmlTestUtil.createParser("amu_poly_style_boolean_alpha.kml");
        KmlParser mParser = new KmlParser(parser);
        mParser.parseKml();
        Assert.assertNotNull(mParser.getPlacemarks());
        assertEquals(1, mParser.getContainers().size());
        KmlContainer kmlContainer = mParser.getContainers().get(0);
        Assert.assertTrue(kmlContainer.hasPlacemarks());

        Map<String, KmlStyle> styles = kmlContainer.getStyles();
        KmlStyle kmlStyle = styles.get("#fireadvisory");
        Assert.assertNotNull(kmlStyle);
        Assert.assertTrue(kmlStyle.hasFill());
        Assert.assertFalse(kmlStyle.hasOutline());
    }

    @Test
    public void testContainerHeirarchy() throws Exception {
        XmlPullParser parser = KmlTestUtil.createParser("amu_document_nest.kml");
        KmlParser mParser = new KmlParser(parser);
        mParser.parseKml();
        assertEquals(mParser.getContainers().get(0).getContainerId(), "hasId");
        assertEquals(mParser.getContainers().size(), 1);
        Assert.assertTrue(mParser.getContainers().get(0).hasContainers());
    }

    @Test
    public void testPlacemarkParsing() throws Exception {
        XmlPullParser parser = KmlTestUtil.createParser("amu_unsupported.kml");
        KmlParser mParser = new KmlParser(parser);
        mParser.parseKml();
        assertEquals(1, mParser.getPlacemarks().size());
    }
}

/*
 * Copyright 2017 Google Inc.
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

package org.trd.maps.data;

import com.huawei.hms.maps.model.LatLng;

import org.trd.maps.data.geojson.GeoJsonPolygon;
import org.trd.maps.data.kml.KmlPolygon;

import java.util.List;

/**
 * An interface containing the common properties of
 * {@link GeoJsonPolygon GeoJsonPolygon} and
 * {@link KmlPolygon KmlPolygon}
 *
 * @param <T> the type of Polygon - GeoJsonPolygon or KmlPolygon
 */
public interface DataPolygon<T> extends Geometry {

    /**
     * Gets an array of outer boundary coordinates
     *
     * @return array of outer boundary coordinates
     */
    List<LatLng> getOuterBoundaryCoordinates();

    /**
     * Gets an array of arrays of inner boundary coordinates
     *
     * @return array of arrays of inner boundary coordinates
     */
    List<List<LatLng>> getInnerBoundaryCoordinates();

}

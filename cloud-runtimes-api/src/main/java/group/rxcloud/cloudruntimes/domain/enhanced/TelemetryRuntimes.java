/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package group.rxcloud.cloudruntimes.domain.enhanced;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.propagation.ContextPropagators;
import reactor.core.publisher.Mono;

/**
 * Metric/Trace standard API defined.
 */
public interface TelemetryRuntimes {

    /**
     * Build a tracer with specific tracer name.
     *
     * @param tracerName tracer name.
     * @return tracer. mono
     */
    Mono<Tracer> buildTracer(String tracerName);

    /**
     * Build a tracer with specific tracer name, version.
     *
     * @param tracerName tracer name.
     * @param version    version.
     * @return tracer. mono
     * @see io.opentelemetry.api.trace.TracerBuilder#setInstrumentationVersion(String) io.opentelemetry.api.trace.TracerBuilder#setInstrumentationVersion(String)
     */
    Mono<Tracer> buildTracer(String tracerName, String version);

    /**
     * Build a tracer with specific tracer name, version and schemaUrl.
     *
     * @param tracerName tracer name.
     * @param version    version.
     * @param schemaUrl  schemaUrl.
     * @return tracer. mono
     * @see io.opentelemetry.api.trace.TracerBuilder#setInstrumentationVersion(String) io.opentelemetry.api.trace.TracerBuilder#setInstrumentationVersion(String)
     * @see io.opentelemetry.api.trace.TracerBuilder#setSchemaUrl(String) io.opentelemetry.api.trace.TracerBuilder#setSchemaUrl(String)(String)
     */
    Mono<Tracer> buildTracer(String tracerName, String version, String schemaUrl);

    /**
     * Get composited context propagators.
     *
     * @return context propagators.
     */
    Mono<ContextPropagators> getContextPropagators();

    /**
     * Build a meter with specific meter name.
     *
     * @param meterName meter name.
     * @return meter. mono
     */
    Mono<Meter> buildMeter(String meterName);

    /**
     * Build a meter with specific meter name and version.
     *
     * @param meterName meter name.
     * @param version   version.
     * @return meter. mono
     */
    Mono<Meter> buildMeter(String meterName, String version);

    /**
     * Build a meter with specific meter name, version and schemaUrl.
     *
     * @param meterName meter name.
     * @param version   version.
     * @param schemaUrl schemaUrl.
     * @return meter. mono
     */
    Mono<Meter> buildMeter(String meterName, String version, String schemaUrl);
}

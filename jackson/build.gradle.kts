/*
 * Copyright (C) 2021 The Authors of CEL-Java
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
  `java-library`
  signing
  id("org.caffinitas.gradle.aggregatetestresults")
  id("org.caffinitas.gradle.testsummary")
  id("org.caffinitas.gradle.testrerun")
  `cel-conventions`
}

dependencies {
  api(project(":cel-core"))

  compileOnly(platform(rootProject))
  implementation(
    "com.fasterxml.jackson.core:jackson-databind:${rootProject.extra["versionJackson"]}"
  )
  implementation(
    "com.fasterxml.jackson.dataformat:jackson-dataformat-protobuf:${rootProject.extra["versionJackson"]}"
  )
  implementation(
    "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${rootProject.extra["versionJackson"]}"
  )

  testImplementation(platform(rootProject))
  testAnnotationProcessor(platform(rootProject))
  testImplementation(project(":cel-tools"))
  testAnnotationProcessor("org.immutables:value-processor")
  testCompileOnly("org.immutables:value-annotations")
  testImplementation("com.google.code.findbugs:jsr305")
  testImplementation("org.assertj:assertj-core")
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("org.junit.jupiter:junit-jupiter-params")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

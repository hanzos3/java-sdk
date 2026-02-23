/*
 * Hanzo S3 Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2020 Hanzo AI, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.minio.credentials;

/** Credential provider using Hanzo S3 server specific environment variables. */
public class MinioEnvironmentProvider extends EnvironmentProvider {
  @Override
  public Credentials fetch() {
    return new Credentials(
        getProperty("S3_ACCESS_KEY"), getProperty("S3_SECRET_KEY"), null, null);
  }
}

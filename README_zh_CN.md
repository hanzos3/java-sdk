# Hanzo S3 Java SDK - S3 Compatible Cloud Storage

Hanzo S3 Java Client SDK provides a simple API to access any Amazon S3 compatible object storage service.

For a complete list of APIs and examples, please see the [Java Client API Reference](https://github.com/hanzos3/java-sdk/blob/main/docs/API.md).

## Minimum Requirements
Java 1.8 or above:

* [OracleJDK 8.0](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [OpenJDK8.0](https://openjdk.java.net/install/)

## Maven
```xml
<dependency>
    <groupId>io.minio</groupId>
    <artifactId>minio</artifactId>
    <version>3.0.10</version>
</dependency>
```

## Gradle
```
dependencies {
    implementation("io.minio:minio:3.0.10")
}
```

## Direct JAR Download
Download the latest [JAR](https://repo1.maven.org/maven2/io/minio/minio/3.0.10/).

## Quick Start - File Upload
This example connects to an object storage server, creates a bucket, and uploads a file.

You need three parameters to connect:

| Parameter  | Description |
| :------- | :------------ |
| Endpoint | URL to S3 service |
| Access Key    | Access key (user ID) for the account  |
| Secret Key     | Secret key (password) for the account    |

The example below uses Hanzo S3 at [https://s3.hanzo.ai](https://s3.hanzo.ai).

#### FileUploader.java

```java
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class FileUploader {
  public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException {
    try {
      // Create a client with the Hanzo S3 server URL, access key and secret key
      MinioClient minioClient = new MinioClient("https://s3.hanzo.ai", "YOUR-ACCESSKEY", "YOUR-SECRETACCESSKEY");

      // Check if bucket exists
      boolean isExist = minioClient.bucketExists("asiatrip");
      if(isExist) {
        System.out.println("Bucket already exists.");
      } else {
        minioClient.makeBucket("asiatrip");
      }

      // Upload a file
      minioClient.putObject("asiatrip","asiaphotos.zip", "/home/user/Photos/asiaphotos.zip");
      System.out.println("/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.");
    } catch(MinioException e) {
      System.out.println("Error occurred: " + e);
    }
  }
}
```

#### Compile FileUploader
```sh
javac -cp "minio-3.0.9-all.jar"  FileUploader.java
```

#### Run FileUploader
```sh
java -cp "minio-3.0.9-all.jar:." FileUploader
/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.
```

## API Reference

* [Full API Reference](https://github.com/hanzos3/java-sdk/blob/main/docs/API.md)

## Examples

#### Bucket Operations
* [ListBuckets.java](https://github.com/hanzos3/java-sdk/tree/main/examples/ListBuckets.java)
* [ListObjects.java](https://github.com/hanzos3/java-sdk/tree/main/examples/ListObjects.java)
* [BucketExists.java](https://github.com/hanzos3/java-sdk/tree/main/examples/BucketExists.java)
* [MakeBucket.java](https://github.com/hanzos3/java-sdk/tree/main/examples/MakeBucket.java)
* [RemoveBucket.java](https://github.com/hanzos3/java-sdk/tree/main/examples/RemoveBucket.java)

#### Object Operations
* [PutObject.java](https://github.com/hanzos3/java-sdk/tree/main/examples/PutObject.java)
* [GetObject.java](https://github.com/hanzos3/java-sdk/tree/main/examples/GetObject.java)
* [GetPartialObject.java](https://github.com/hanzos3/java-sdk/tree/main/examples/GetPartialObject.java)
* [RemoveObject.java](https://github.com/hanzos3/java-sdk/tree/main/examples/RemoveObject.java)
* [RemoveObjects.java](https://github.com/hanzos3/java-sdk/tree/main/examples/RemoveObjects.java)
* [StatObject.java](https://github.com/hanzos3/java-sdk/tree/main/examples/StatObject.java)

#### Presigned Operations
* [PresignedGetObject.java](https://github.com/hanzos3/java-sdk/tree/main/examples/PresignedGetObject.java)
* [PresignedPutObject.java](https://github.com/hanzos3/java-sdk/tree/main/examples/PresignedPutObject.java)

#### Bucket Policy Operations
* [SetBucketPolicy.java](https://github.com/hanzos3/java-sdk/tree/main/examples/SetBucketPolicy.java)
* [GetBucketPolicy.java](https://github.com/hanzos3/java-sdk/tree/main/examples/GetBucketPolicy.java)

## Learn More
* [Hanzo S3 Server](https://github.com/hanzoai/s3)
* [Hanzo Storage](https://hanzo.space)

## Contribute
[Contributors Guide](https://github.com/hanzos3/java-sdk/blob/main/CONTRIBUTING.md)

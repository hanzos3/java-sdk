# Hanzo S3 Java SDK for Amazon S3 Compatible Cloud Storage

Hanzo S3 Java SDK is a Simple Storage Service (aka S3) client to perform bucket and object operations on any Amazon S3 compatible object storage service.

For a complete list of APIs and examples, please take a look at the [Java Client API Reference](https://github.com/hanzos3/java-sdk/blob/main/docs/API.md) documentation.

## Minimum Requirements
Java 1.8 or above.

## Maven usage
```xml
<dependency>
    <groupId>io.minio</groupId>
    <artifactId>minio</artifactId>
    <version>8.6.0</version>
</dependency>
```

## Gradle usage
```
dependencies {
    implementation("io.minio:minio:8.6.0")
}
```

## JAR download
The latest JAR can be downloaded from [here](https://repo1.maven.org/maven2/io/minio/minio/8.6.0/)

## Quick Start Example - File Uploader
This example program connects to an object storage server, makes a bucket on the server and then uploads a file to the bucket.

You need three items in order to connect to an object storage server.

| Parameters | Description                                                |
|------------|------------------------------------------------------------|
| Endpoint   | URL to S3 service.                                         |
| Access Key | Access key (aka user ID) of an account in the S3 service.  |
| Secret Key | Secret key (aka password) of an account in the S3 service. |

This example uses the Hanzo S3 server at [https://s3.hanzo.ai](https://s3.hanzo.ai). Feel free to use this service for test and development.

### FileUploader.java
```java
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {
  public static void main(String[] args)
      throws IOException, NoSuchAlgorithmException, InvalidKeyException {
    try {
      // Create a client with the Hanzo S3 server, its access key and secret key.
      MinioClient minioClient =
          MinioClient.builder()
              .endpoint("https://s3.hanzo.ai")
              .credentials("YOUR-ACCESSKEY", "YOUR-SECRETACCESSKEY")
              .build();

      // Make 'asiatrip' bucket if not exist.
      boolean found =
          minioClient.bucketExists(BucketExistsArgs.builder().bucket("asiatrip").build());
      if (!found) {
        // Make a new bucket called 'asiatrip'.
        minioClient.makeBucket(MakeBucketArgs.builder().bucket("asiatrip").build());
      } else {
        System.out.println("Bucket 'asiatrip' already exists.");
      }

      // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
      // 'asiatrip'.
      minioClient.uploadObject(
          UploadObjectArgs.builder()
              .bucket("asiatrip")
              .object("asiaphotos-2015.zip")
              .filename("/home/user/Photos/asiaphotos.zip")
              .build());
      System.out.println(
          "'/home/user/Photos/asiaphotos.zip' is successfully uploaded as "
              + "object 'asiaphotos-2015.zip' to bucket 'asiatrip'.");
    } catch (MinioException e) {
      System.out.println("Error occurred: " + e);
      System.out.println("HTTP trace: " + e.httpTrace());
    }
  }
}
```

#### Compile FileUploader
```sh
$ javac -cp minio-8.6.0-all.jar FileUploader.java
```

#### Run FileUploader
```sh
$ java -cp minio-8.6.0-all.jar:. FileUploader
'/home/user/Photos/asiaphotos.zip' is successfully uploaded as object 'asiaphotos-2015.zip' to bucket 'asiatrip'.
```

## More References
* [Java Client API Reference](https://github.com/hanzos3/java-sdk/blob/main/docs/API.md)
* [Examples](https://github.com/hanzos3/java-sdk/tree/main/examples)

## Explore Further
* [Hanzo S3 Server](https://github.com/hanzoai/s3)
* [Hanzo Storage](https://hanzo.space)

## Contribute
Please refer [Contributors Guide](https://github.com/hanzos3/java-sdk/blob/main/CONTRIBUTING.md)

# Overview

This projects is a small java module that converts an image provided as a url into a base64 DataUri.

# How to get it

This project is currently not hosted on any repository-manager so the fastest way to get it is clone this git-repo and run mvn:install
in the root package

## Dependencies

All dependencies are hosted in [Maven Central](http://mvnrepository.com/), so just running mvn:install will download the required dependencies.

# Usage

## 1. Convert Image on disk

```java

String url = "file:///path/to/image" //E.g file:///C:/test.jpg
UrlImgConv img = new UrlImgConv(url);

String imgb64 = img.toB64(); //To get the bare base64 Representation
String imgDataUri = img.toB64DataUri(); //To get the Data Uri Representation
```

## 2. Convert an Image online
```java

String url = "url/to/image" //E.g http://stylonica.com/wp-content/uploads/2014/02/Cute-marshmallow-Wallpapers-HD.jpg
UrlImgConv img = new UrlImgConv(url);

String imgb64 = img.toB64(); //To get the bare base64 Representation
String imgDataUri = img.toB64DataUri(); //To get the Data Uri Representation
```

## Support

The module has been tested with:
- .jpg
- .png
- .gif

If you would wish for support for a different image format, either give me a shout or fork and change :).

# Deta API for Java

🚀 Easily integrate with Deta.sh to communicate with Base or Drive using this Java API.


## Usage Examples

### Inserting data into Base

```java
Deta deta = new Deta("yourDetaProjectKey");
Base base = new Base(deta, "MyBase");

JsonObject json = new JsonObject();
json.addProperty("name", "Jeremy");
json.addProperty("lastname", "Fragrance");
json.addProperty("age", 34);

base.put(json);
```

### Retrieving data from Base

```java
Deta deta = new Deta("yourDetaProjectKey");
Base base = new Base(deta, "MyBase");

JsonObject obj = base.get("key");
```

## Installation

Add the following dependency to your project:

```xml
<dependency>
    <groupId>io.github.cweyy</groupId>
    <artifactId>deta-api</artifactId>
    <version>1.0</version>
</dependency>
```

Or add the following to your Gradle dependencies:

```groovy
implementation 'io.github.cweyy:deta-api:1.0'
```

## License

📄 This project is licensed under the MIT License.

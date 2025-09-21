# Duke Shop Java + Helidon Project

## Overview
Duke Shop is a Java application that demonstrates a simple web server using **Helidon SE**.  
It allows loading clothing items from a file and exposes a REST endpoint to fetch them in JSON format.

---

## Prerequisites
- Java 24 (Temurin recommended)
- Helidon SE 2.0.0-M3 JARs
- Jackson JARs (`jackson-core`, `jackson-annotations`, `jackson-databind`)

---

## Setup & Run

### 1️⃣ Clone the Project
```bash
git clone https://github.com/anhleh33/ShopApp_Exam.git
cd ShopApp
```

### 2️⃣ Compile the Java Project
```bash
mkdir -p out
find . -name "*.java" > sources.txt
javac -d out -cp "libs/*" @sources.txt
```

### 3️⃣ Run the Application
```bash
java -cp "out:libs/*" duke.choice.ShopApp
```
- The server will start on port 8888 and bind to all interfaces.
- You should see output like:
```bash
 Welcome to Duke Shop!
Customer added to clothing: ...
Server started at http://localhost:8888/items
```

### 4️⃣ Test the REST Endpoint
```bash
curl http://localhost:8888/items
```


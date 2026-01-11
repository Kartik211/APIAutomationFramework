![API Automation Tests](https://github.com/Kartik211/APIAutomationFramework/actions/workflows/api-tests.yml/badge.svg)

🚀 API Automation Framework
A scalable, maintainable API Automation Framework built using Java, Rest Assured, TestNG, and GitHub Actions CI.
Designed following industry best practices (SOLID, reusable client layer, data-driven testing, reporting, CI integration).

📌 Tech Stack
Language: Java 8
API Testing: Rest Assured
Test Framework: TestNG
Build Tool: Maven
Reporting: Extent Reports
CI/CD: GitHub Actions
Version Control: Git

📂 Project Structure

api-automation-framework
│
├── .github/workflows
│   └── api-tests.yml        # GitHub Actions CI pipeline
│
├── src
│   └── test
│       ├── java
│       │   └── com.api.framework
│       │       ├── auth          # Auth related logic
│       │       ├── base          # BaseTest (setup & config)
│       │       ├── client        # API client (GET, POST, PUT, DELETE)
│       │       ├── dataprovider  # Data-driven testing
│       │       ├── listeners     # TestNG listeners
│       │       ├── payload       # Request payload builders
│       │       ├── reports       # Extent report manager
│       │       ├── tests         # Test classes
│       │       └── utils         # Utilities (ConfigReader, helpers)
│       │
│       └── resources
│           └── config.properties
│
├── pom.xml
├── testng.xml
└── README.md

🧠 Framework Architecture (High Level)

Test Class
   ↓
ApiClient
   ↓
Rest Assured
   ↓
API Server
   ↓
Response Validation
   ↓
TestNG Assertions
   ↓
Extent Report

🔹 Key Design Principles Used
✅ Separation of Concerns
✅ Reusable API Client Layer
✅ Single Responsibility Principle
✅ Data-Driven Testing
✅ Thread-safe Reporting
✅ CI-ready execution

API Client Layer
- All HTTP methods are centralized inside ApiClient:
ApiClient.post("/posts", payload);
ApiClient.get("/posts/1");
ApiClient.put("/posts/1", payload);
ApiClient.delete("/posts/1");

📌 Benefits:
- No Rest Assured code in test classes
- Easy to maintain and scale
- Clean test methods

🔹 Test Coverage

Implemented test scenarios include:
✅ Create API (POST)
✅ Get API (GET)
✅ Update API (PUT)
✅ Delete API (DELETE)
✅ End-to-End CRUD Flow
✅ JSON Parsing & Validation
✅ Secure API Tests
✅ Data-Driven Tests using TestNG DataProvider

🔹 Data-Driven Testing Example
@Test(dataProvider = "postData")
public void createPostMultipleTimes(PostPayload payload) {
    Response response = ApiClient.post("/posts", payload);
    Assert.assertEquals(response.getStatusCode(), 201);
}

📊 Reporting (Extent Reports)
Automatic HTML report generation
Captures:
- Test start
- Pass / Fail / Skip
- Errors & stack traces
- Stored under:
test-output/

⚙️ TestNG Listener Integration
@Listeners(TestListener.class)
public class CreatePostTest extends BaseTest {
}

Used for:
- Logging
- Reporting
- Test lifecycle tracking

🔁 CI/CD – GitHub Actions

Tests run automatically on:
✔ Push to main
✔ Pull Requests

CI Workflow Steps:
- Checkout code
- Setup Java 8
- Run mvn clean test
- Upload test reports as artifacts

📄 Workflow file:
.github/workflows/api-tests.yml

▶️ How to Run Tests Locally
Using Maven
- mvn clean test

Using TestNG
Right-click testng.xml
Run as TestNG Suite

🧪 Configuration
config.properties
- base.url=https://jsonplaceholder.typicode.com
- content.type=application/json

📈 CI Status
✔ GitHub Actions badge reflects live build status
✔ Ensures framework stability

🎯 What This Project Demonstrates
- Real-world API automation design
- Clean coding standards
- CI/CD readiness
- Production-level framework thinking

👨‍💻 Author
Kartik Tyagi
Senior QA / Automation Engineer
🔗 GitHub: https://github.com/Kartik211

⭐ Final Note
This framework is intentionally designed to reflect enterprise-level API automation standards, making it ideal for interviews, portfolios, and real projects.

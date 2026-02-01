**📌 Task 1: AI-based Customer Interaction Solution
🤖 Iron Lady AI Assistant
🔍 Problem Statement**

Iron Lady receives repeated queries from learners regarding programs, enrollment process, duration, and career support. Handling these queries manually requires significant effort and limits availability outside working hours.

**💡 Solution Overview**

The Iron Lady AI Assistant is a chatbot that provides instant, accurate, and user-friendly responses to learner queries. It enhances the learner journey by offering 24/7 assistance and reducing manual intervention.

⚙️ How the Solution Works

Users interact with a chat-based UI built using HTML, CSS, and JavaScript

Messages are sent to a Spring Boot backend via a REST API (/chat)

The backend attempts to generate responses using an AI language model

If the AI API is unavailable, a smart fallback mechanism responds using predefined logic

Responses are displayed instantly in the chat interface

**🧠 How AI Is Used**

Primary AI: Uses a language model to generate contextual, conversational responses

Fallback AI: Rule-based NLP logic handles common queries such as:

Programs offered

Course duration

Enrollment process

Benefits and career support

This hybrid approach ensures reliability even when external AI services fail.

**🛠️ Technologies Used**

Java, Spring Boot

REST APIs

HTML, CSS, JavaScript

OpenAI API (optional / fallback supported)

**✅ Key Benefits
**
Improves customer experience

Reduces counselor workload

Scalable and cost-effective

Always available support system

**📌 Task 2: Internal Business Automation Solution
📊 Learner Management System
🔍 Problem Statement**

Iron Lady’s internal learner data management involves manual tracking using spreadsheets or documents, leading to inefficiencies, data inconsistency, and increased administrative effort.

💡 Solution Overview

The Learner Management System automates internal operations by providing a centralized platform to manage learner records efficiently.

**⚙️ How the Solution Works**

Admin logs into the system securely

Dashboard displays all learners in a structured table

Admin can:

Add new learners

View learner details

Update learner information

Delete inactive learners

All operations interact with the database in real time

This system implements a complete CRUD workflow.

**🧠 How Automation Is Used**

Eliminates manual data entry

Maintains real-time records

Improves operational efficiency

Reduces human error

Although this task is not AI-based, it provides a strong foundation for future AI analytics and insights.

**🛠️ Technologies Used**

Java, Spring Boot

JSP / HTML

MySQL

JDBC / JPA

Apache Tomcat

**✅ Key Benefits**

Saves time and effort

Improves data accuracy

Centralized learner management

Scalable for future growth

**📁 Project Structure (High Level)**
├── task1-ai-assistant
│   ├── controller
│   ├── service
│   ├── frontend
│
├── task2-learner-management
│   ├── controller
│   ├── service
│   ├── repository
│   ├── database

**🎯 Final Outcome**

These two solutions together demonstrate:

AI-driven customer engagement

Technology-enabled internal efficiency

**Real-world problem-solving using Java and Spring Boot**

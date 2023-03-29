# Enis' Reactive Playground

## Resilience

### Use Cases 1:
**GIVEN** The user has selected picked some items on it basket

**WHEN** The user submits the order items and its email to the system

**THEN** Will system will accept the order and issue an invoice to the user via e-mail

#### Context Diagram

#### Non functional requirements
* Invoicing may happen asynchronously
* Sending out Invoice e-mail should be guaranteed

#### Failure scenarios

#### Solutions with various Tools
* ***Solution 1: Spring Boot - JPA sample***
    * *a) [Simple retry](https://github.com/enisspahi/spring-boot-jpa-resilience-sample)*:  Invoice e-mail delivery retried during mail sending failures, however messages are lost on service restarts.  
    * *b) [Event streaming with at-least-once-delivery](https://github.com/enisspahi/spring-boot-jpa-resilience-sample/tree/alod):* Invoice e-mail delivery retried even after service restarts.
* ***Solution 2: [Spring Boot - MongoDB Change streams with at-least-once-delivery](https://github.com/enisspahi/spring-boot-mongodb-changestreams-sample)***: Invoice e-mail delivery based on MongoDB Change Streams. Invoice e-mail delivery retried even after service restarts.
* ***Solution 3: [Akka - Event Sourcing and CQRS](https://github.com/enisspahi/akka-eventsourcing-cqrs-sample)***: Invoice e-mail delivery based on TODO

**Evaluation:**
* `1.a` has an easy to implement, however retries are not restart-proof. 
* On `1.b` and `2` multiple instance of the service would create multiple `InvoiceProcessor` streams which may cause duplicate e-mails, furthermore inconsistent stream behavior. Application should be adjusted to ensure single instance of this stream.
* 

**Alternative approaches:**

* **Using a message queue:** `OrderService` stores the order to the database and publishes an `OrderReceived` event to Kafka (or an alternative message queue). 
* **Change Data Capture (CDC):**


    DAY 1 — Baseline + “HashMap / Arrays” DSA + Java Fundamentals (Walmart-style)

DSA (2 problems):
- Two Sum / Subarray Sum Equals K / Group Anagrams (HashMap patterns)
- One array problem (stock buy/sell or second-largest)
  Java (must-know):
- HashMap internals, collision handling, equals/hashCode contract
- Big-O reasoning + edge cases
  Hands-on (mini):
- Implement LRU Cache WITHOUT LinkedHashMap (core DS + hashmap + DLL)
  Deliverable:
- 1-page “HashMap patterns” cheat sheet + LRU code snippet

Why this day:
- Walmart interviews often lean heavily on HashMap patterns. (Glassdoor mentions HashMap focus)


    DAY 2 — Sliding Window + Strings + Concurrency Basics

DSA:
- Longest Substring Without Repeating Characters (sliding window)
- One more sliding window variant (min window / max consecutive)
  Java Concurrency:
- synchronized vs Lock; happens-before intuition; thread interruption
- Thread pools: core/max pool size, queue types (what changes latency vs throughput)
  LLD quick drill:
- Thread-safe Singleton (double-checked locking + enum singleton tradeoffs)
  Deliverable:
- Concurrency “talk track”: how you’d answer thread-safety + singleton + why

(LLD + thread-safety gets explicitly asked in Walmart LLD rounds.)


    DAY 3 — Trees/Recursion + LLD (SOLID + Design Patterns)

DSA:
- Zigzag traversal (binary tree BFS)
- One recursion/backtracking medium (word wrap / subsets / combinations)
  LLD:
- SOLID + common patterns: Factory, Builder, Strategy
- Design a “YouTube Ranking System” style component (focus: extensibility + concurrency)
  Deliverable:
- 1 clean LLD design doc: classes/interfaces + concurrency notes + tradeoffs

(Walmart LLD round examples include YouTube ranking + design patterns.)


    DAY 4 — Spring Boot Core (Request Flow + Exceptions + Transactions)

DSA:
- One Tree/Heap medium
- One interval problem (merge intervals)
  Spring Boot (depth expected):
- Request lifecycle: DispatcherServlet, Filters vs Interceptors
- Exception handling (@ControllerAdvice), validation
- Transaction management + isolation levels + dirty read concept
  Hands-on:
- Build “Inventory Service v1” (Spring Boot REST + SQL DB via JPA)
- Add global exception handling + validation + basic paging
  Deliverable:
- “Spring request flow” diagram + Inventory Service skeleton repo

(These exact areas appear in your question bank too — practice them interview-style.) :contentReference[oaicite:14]{index=14}


    DAY 5 — Microservices Reality: Resilience + Observability + Deployment Basics

DSA:
- One graph BFS/DFS medium OR heap/priority queue medium
  Microservices:
- Timeouts, retries, circuit breaker, bulkheads (how they fail, not just “what they are”)
- Idempotency keys for POST APIs (critical for inventory/order/payment)
  Observability:
- Logs/metrics/traces; how you’d debug a latency spike
- “What I’d alert on” (p95/p99 latency, error rate, saturation)
  Hands-on:
- Containerize Inventory Service (Docker)
- Add metrics endpoint + structured logs; run via docker-compose
  Deliverable:
- 1-page “resilience patterns + when NOT to use” + basic runbook

(Walmart expects DevOps + observability + RCA mindset.)


    DAY 6 — Kafka for Microservices (Walmart-relevant)

DSA:
- One medium focused on queues/streams (Find Median from Data Stream)
  Kafka (depth expected):
- Partitions, consumer groups, offset commits (at-least-once realities)
- Ordering guarantees (what is ordered, what is NOT)
- Retries + DLQ strategy
  Hands-on:
- Add Kafka publisher “InventoryReserved” event
- Create a consumer “Order Service v1” that consumes events and updates its DB
  Deliverable:
- Kafka talk track: delivery semantics + idempotent consumer + replay strategy

Why this matters:
- Walmart backend roles explicitly include Kafka.
- Walmart inventory/replenishment is strongly event-driven in public case studies.


    DAY 7 — SQL + Data Modeling + Performance

DSA:
- DP light (1 medium) OR graph topo sort
  SQL (interview depth):
- Indexing trade-offs, query plans (EXPLAIN mindset)
- N+1 problem; pagination pitfalls
- Optimistic vs pessimistic locking (inventory reservation!)
  Hands-on:
- Add optimistic locking to inventory rows (version column)
- Simulate “oversell prevention” scenario + retries + idempotency key
  Deliverable:
- “Inventory reservation concurrency” write-up: failure modes + mitigation

(Walmart interviews often mix algo + SQL; and inventory concurrency is a common design test.)


    DAY 8 — HLD System Design #1: High-Concurrency Inventory Service (Walmart classic)

DSA:
- 1 medium timed (35 minutes) like a real round
  HLD (90 minutes):
- Design Inventory Service: reserve/release stock, prevent oversell, scale reads/writes
- Include: API, data model, caching, partitions, consistency model, failure handling
- Add: “what breaks at 10x traffic?” and “how do you observe it?”
  Mock (30 minutes):
- Explain end-to-end in 10 minutes, then handle interviewer probes for 20
  Deliverable:
- One “ready-to-present” design doc (bullets + diagram + tradeoffs)

(Directly aligned with reported Walmart HLD interviews.)


    DAY 9 — HLD System Design #2: Order → Inventory → Payment (Saga mindset)

DSA:
- 1 medium timed (trees/graphs)
  HLD:
- Design checkout/order pipeline:
  OrderCreated → InventoryReserved → PaymentAuthorized → Fulfillment
- Discuss distributed transaction handling:
    - Saga orchestration vs choreography
    - Outbox pattern for DB+event consistency
- Include incident scenarios:
    - Kafka lag spike, consumer rebalance storm, partial failures
      Behavioral:
- Ownership story: production issue + RCA + prevention
  Deliverable:
- “Order saga” explanation in 2 minutes + deeper 15-minute version

(This maps to microservices patterns + production focus listed in your prep docs.)


    DAY 10 — Full Walmart Loop Simulation (DSA + LLD + HLD + Behavioral)
Simulate like the real loop:
- DSA Round (60 min): 2 problems
- LLD Round (45 min): design + concurrency (e.g., rate limiter / cache / ranking)
- HLD Round (60 min): pick one (Inventory OR Checkout)
- Behavioral (30 min): conflict, ambiguity, mentorship, delivery under pressure
  Final polish:
- 1-page “About Me” + 2 strongest projects + leadership highlights
- 1-page “systems design checklist” (requirements → API → data → scale → failures → observability)
  Deliverable:
- Record yourself explaining HLD (phone recording). Fix clarity + structure.

(Clarity and trade-off discussion are repeatedly highlighted by successful candidates.) 

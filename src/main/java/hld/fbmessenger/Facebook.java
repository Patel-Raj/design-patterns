package hld.fbmessenger;

public class Facebook {
}

/*
Functional req:
Task => fb messenger, which should be able to send and receive messages.
2. messages should persists for 5 years
3. Show online/offline user status.

Non functional req:
1. It should be highly consistent.
2. very low latency as instant messaging service.
3. Low availability is acceptable as we are aiming for consistency.

Capacity estimation:
Lets say we have 500M daily active users. Each user sends 40 messages daily.

Traffic estimation:
500M*40/(24*3600) = 20B/86400 = 20M/ 100 = 0.2M messages/sec

Storage estimation
Assume a single message takes 100 bytes of storage.

100 * 40 * 500M = 20B*100 = 2TB/ day.
So for 5 years = 2TB * 365*5 = 3650TB = 3.65 PB.

Bandwidth estimation:
2TB/day = 25MB/sec

=> High level component design:
A -> chat server - > DB -> B

=> Detail component design:

=> Database choice  and why
=> Data partitioning
=> Caching
=> Load balancers
=> Fault tolerance and replication.

 */